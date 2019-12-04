package net.atos.springjmsrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ManualQueueConsumer {

    private RabbitTemplate rabbitTemplate;

    public ManualQueueConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${queue.name}")
    private String queueName;

    @GetMapping("/receiveMessage")
    public String getMessage() {
        Object message = rabbitTemplate.receiveAndConvert(queueName);
        log.info("Odebraliśmy wiadomość {}", message);
        return message.toString();
    }
}
