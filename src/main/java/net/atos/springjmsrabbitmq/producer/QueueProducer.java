package net.atos.springjmsrabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class QueueProducer {

    private RabbitTemplate rabbitTemplate;

    public QueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${queue.name}")
    private String queueName;

    @GetMapping("/addMessage")
    public String sentToQueue(@RequestParam String message) {
        log.info("Message to send: {}", message);

        rabbitTemplate.convertAndSend(queueName, message);

        return String.format("Message %s sent! See logs ...", message);
    }

}
