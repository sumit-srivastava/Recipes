package com.java.se7.rabbitmq.recipes.consume;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ActualConsumer extends DefaultConsumer {

    public ActualConsumer(Channel channel) {
        super(channel);
    }

    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws java.io.IOException {
        String message = new String(body);
        System.out.println("Received: " + message);
    }
}
