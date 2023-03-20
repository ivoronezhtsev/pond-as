package ru.fciit.pondas.rabbitmq;

import com.rabbitmq.client.Channel;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import ru.fciit.pondas.dto.gen.gate.AdapterMessage;
import ru.fciit.pondas.dto.gen.gate.RequestMessageType;
import ru.fciit.pondas.dto.gen.ipAccount.FormPONDRequestType;
import ru.fciit.pondas.gate.GateMessageBuilder;
import ru.fciit.pondas.model.InheritanceSearchRequest;
import ru.fciit.pondas.service.InheritanceSearchService;

import javax.xml.bind.JAXBElement;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Component
@Slf4j
public class MessageListener {
    private final ConversionService conversionService;
    private final AmqpTemplate toSmevTemplate;
    private final Counter readCounter;
    private final Counter okSendResponseCounter;
    private final Counter badSendResponseCounter;
    private final String itSystem;
    private final String responseQueue;
    private final String replyToQueue;
    private final InheritanceSearchService inheritanceSearchService;


    public MessageListener(ConversionService conversionService,
                           AmqpTemplate toSmevTemplate,
                           MeterRegistry registry,
                           @Value("${itSystem}") String itSystem,
                           @Value("${response.queue}") String responseQueue,
                           @Value("${reply.to.queue}") String replyToQueue,
                           InheritanceSearchService inheritanceSearchService) {
        this.conversionService = conversionService;
        this.toSmevTemplate = toSmevTemplate;
        this.itSystem = itSystem;
        readCounter = Counter.builder("avs-pond-inheritace_search_request_count")
                .register(registry);
        okSendResponseCounter = Counter.builder("avs-pond-inheritance_search_response_ok_count")
                .register(registry);
        badSendResponseCounter = Counter.builder("avs-pond-inheritance_search_response_bad_count")
                .register(registry);
        this.responseQueue = responseQueue;
        this.replyToQueue = replyToQueue;
        this.inheritanceSearchService = inheritanceSearchService;
    }

    @RabbitListener(queues = "${request.queue}", containerFactory = "gateContainerFactory")
    public void listen(Message rabbitMessage, Channel channel) throws IOException {
        log.info("Начало обработки сообщений из очереди...");
        try {
            String strRabbitMessage = new String(rabbitMessage.getBody());
            var gateRequest = Objects.requireNonNull(conversionService.convert(rabbitMessage.getBody(), JAXBElement.class)).getValue();
            readCounter.increment();
            if (gateRequest instanceof AdapterMessage) {
                if (((AdapterMessage) gateRequest).getMessage() instanceof RequestMessageType request) {
                    String clientId = request.getRequestMetadata().getClientId();
                    FormPONDRequestType formPondRequest = (FormPONDRequestType)
                            Objects.requireNonNull(conversionService.convert(request.getRequestContent().getContent().getMessagePrimaryContent().getAny(), JAXBElement.class)).getValue();
                    var inheritanceSearchRequest = conversionService.convert(conversionService.convert(formPondRequest, FormPONDRequestType.class), InheritanceSearchRequest.class);
                    val inheritanceSearchResponse = inheritanceSearchService.find(inheritanceSearchRequest);
                    inheritanceSearchResponse.setOrderId(formPondRequest.getOrderId());
                    val formPondResponse = conversionService.convert(inheritanceSearchResponse, Element.class);
                    val responseXML = new GateMessageBuilder()
                            .setContent(formPondResponse)
                            .setItSystem(itSystem)
                            .setReplyToQueue(replyToQueue)
                            .setClientId(UUID.randomUUID().toString())
                            .setReplyToClientId(clientId)
                            .build();
                    val smevMessage = MessageBuilder.withBody(conversionService.convert(responseXML, byte[].class)).build();
                    log.info("Начало валидации исходящего сообщения с orderId {}", inheritanceSearchResponse.getOrderId());
                    log.info("Исходящее сообщение с orderId {} прошло валидацию", inheritanceSearchResponse.getOrderId());
                    toSmevTemplate.send(
                            responseQueue, smevMessage);
                    if (inheritanceSearchResponse.getCount() > 0) {
                        okSendResponseCounter.increment();
                    } else {
                        badSendResponseCounter.increment();
                    }
                }
            }
        } catch (Exception exception) {
            if (exception instanceof SAXException) {
                channel.basicNack(rabbitMessage.getMessageProperties().getDeliveryTag(), false, false);
                throw new AmqpRejectAndDontRequeueException(exception);
            } else {
                throw new RuntimeException(exception);
            }
        } finally {
            log.info("Конец обработки сообщений из очереди.");
        }
    }
}