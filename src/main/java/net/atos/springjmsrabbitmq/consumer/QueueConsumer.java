package net.atos.springjmsrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueConsumer {

    @RabbitListener(queues = "${queue.name}")
    public void reader(String message){
        log.info("Read message from queue: {}", message);
    }
}