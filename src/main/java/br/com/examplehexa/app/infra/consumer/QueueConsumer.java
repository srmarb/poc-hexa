package br.com.examplehexa.app.infra.consumer;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class QueueConsumer {

    @SqsListener("${cloud.aws.queue.name}")
    public void receiveMessage(Map<String, Object> message) {
        log.info("Message received from sqs: {}", message);
    }

}
