package cn.studybigdata.flume;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.StandardCharsets;

public class SendAvro {
    public static void main(String[] args) throws EventDeliveryException {
        RpcClient client = RpcClientFactory.getDefaultInstance("192.168.179.100", 6666);
        Event event = EventBuilder.withBody("Hello Avro ", StandardCharsets.UTF_8);
        client.append(event);
        client.close();
    }
}
