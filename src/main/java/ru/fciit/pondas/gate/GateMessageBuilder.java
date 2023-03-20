package ru.fciit.pondas.gate;

import org.w3c.dom.Element;
import ru.fciit.pondas.dto.gen.gate.*;

import javax.xml.bind.JAXBElement;

public class GateMessageBuilder {
    private Element content;
    private String itSystem = null;
    private String replyToQueue = null;
    private String clientId = null;
    private String replyToClientId = null;


    public JAXBElement<?> build() {
        MessagePrimaryContent messagePrimaryContent = new MessagePrimaryContent();
        messagePrimaryContent.setAny(content);
        Content content = new Content();
        content.setMessagePrimaryContent(messagePrimaryContent);
        var responseContentType = new ResponseContentType();
        responseContentType.setContent(content);
        var responseMetadata = new ResponseMetadataType();
        responseMetadata.setClientId(clientId);
        responseMetadata.setReplyToClientId(replyToClientId);

        var responseMessage = new ResponseMessageType();
        responseMessage.setResponseContent(responseContentType);
        responseMessage.setResponseMetadata(responseMetadata);
        var clientMessage = new ClientMessage();
        clientMessage.setItSystem(itSystem);
        clientMessage.setReplyToQueue(replyToQueue);
        clientMessage.setResponseMessage(responseMessage);
        var objectFactory = new ObjectFactory();
        return objectFactory.createClientMessage(clientMessage);
    }


    public GateMessageBuilder setContent(Element content) {
        this.content = content;
        return this;
    }

    public GateMessageBuilder setItSystem(String itSystem) {
        this.itSystem = itSystem;
        return this;
    }

    public GateMessageBuilder setReplyToQueue(String replyToQueue) {
        this.replyToQueue = replyToQueue;
        return this;
    }

    public GateMessageBuilder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public GateMessageBuilder setReplyToClientId(String replyToClientId) {
        this.replyToClientId = replyToClientId;
        return this;
    }
}
