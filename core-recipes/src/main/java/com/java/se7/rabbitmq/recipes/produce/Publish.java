package com.java.se7.rabbitmq.recipes.produce;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Publish {

	/**
     * @param args
	 *            [0] RabbitmqHost
	 */
	public static void main(String[] args) {
		String RECIPE_NR="2";
		System.out.println(" ** RabbitmqCookBook - Recipe number "+RECIPE_NR+". Buffering data using messaging **");
		String hostname = "localhost";
		//if (args.length > 0) {
		//	hostname = args[0];
		//}
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
	

		try {
			Connection connection = factory.newConnection();


			System.out.println("Connected: " + hostname);
			Channel channel = connection.createChannel();
			
			String myQueue="myFirstQueue";
			boolean isDurable = true;
			boolean isExclusive = false;
			boolean isAutoDelete = false;
            // All the operations that need interactions with the broker are carried out through channels.
            // let's create our first queue
            // The method call does nothing if the queue already exists, otherwise it creates the queue itself.
            // If the queue already exists but has been created with different parameters, queueDeclare() will raise an exception.
            // queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String,Object> arguments)
            // queue: This is just the name of the queue where we will be storing the messages.
            /**
             * durable: This specifies whether the queue will survive server restarts. Note that it
             * is required for a queue to be declared as durable if you want persistent messages to
             * survive a server restart.
             */
            // exclusive: This specifies whether the queue is restricted to only this connection.
            /**
             * autoDelete: This specifies whether the queue will be automatically deleted by the
             * RabbitMQ broker as soon as it is not in use.
             */
            // arguments: This is an optional map of queue construction arguments.
            channel.queueDeclare(myQueue, isDurable, isExclusive, isAutoDelete, null);
			
			String message;
            // actually sending a message to the RabbitMQ broker.
            /**
             * void basicPublish(String exchange, String routingKey, AMQP.BasicProperties props, byte[] message)
             */
            /**
             * In the example below:
             * exchange = ""; ==> i.e. the default exchange
             * routingKey argument to the name of the queue
             * In this case the message is directly sent to the queue specified as routingKey.
             * The props argument is set to null as a default; these are the message properties.
             */
            message = "My NOT persistent message to myfirstqueue";
			channel.basicPublish("",myQueue, null ,message.getBytes());
			System.out.println("Message sent: " + message);

			message = "My persistent message to myfirstqueue";
			channel.basicPublish("",myQueue, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
			System.out.println("Message sent: " + message);

            /**
             * Both the messages have been dispatched to the RabbitMQ broker, logically queued in the
             * myFirstQueue queue. The messages will stay buffered there until a client, (typically, a
             * different client) gets it.
             */

            /**
             * If the queue has been declared with the durable flag set to true and the message has
             * been marked as persistent, it is stored on the disk by the broker. If one of the two conditions
             * is missing, the message is stored in the memory. In the latter case the buffered messages
             * won't survive a RabbitMQ restart, but the message delivery and retrieval will be much faster.
             */

			channel.close();
			System.out.println("Finished.");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
