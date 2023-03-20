package ru.fciit.pondas;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public RabbitListenerContainerFactory<?> gateContainerFactory(ConnectionFactory connectionFactory) {
        var simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setChannelTransacted(true);
        simpleRabbitListenerContainerFactory.setAutoStartup(true);
        simpleRabbitListenerContainerFactory.setMissingQueuesFatal(true);
        simpleRabbitListenerContainerFactory.setMaxConcurrentConsumers(12);
        simpleRabbitListenerContainerFactory.setErrorHandler(new ConditionalRejectingErrorHandler());
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public ConnectionFactory connectionFactory(RabbitProperties properties) {
        return createConnectionFactory(properties);
    }

    private static CachingConnectionFactory createConnectionFactory(@Qualifier("toSmevConnectionProperties")RabbitProperties properties) {
        var cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(properties.getHost());
        cachingConnectionFactory.setPort(properties.getPort());
        cachingConnectionFactory.setVirtualHost(properties.getVirtualHost());
        cachingConnectionFactory.setUsername(properties.getUsername());
        cachingConnectionFactory.setPassword(properties.getPassword());
        cachingConnectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitTemplate toSmevTemplate(@Qualifier("gateConnectionFactory")ConnectionFactory cf) {
        return new RabbitTemplate(cf);
    }

    @Bean
    ConnectionFactory gateConnectionFactory(@Autowired @Qualifier("toSmevConnectionProperties")RabbitProperties properties) {
        return createConnectionFactory(properties);
    }

    @Bean
    @ConfigurationProperties(prefix = "gate.rabbitmq")
    @Primary
    public RabbitProperties toSmevConnectionProperties() {
        return new RabbitProperties();
    }
}
