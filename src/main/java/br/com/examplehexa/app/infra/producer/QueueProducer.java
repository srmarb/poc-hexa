package br.com.examplehexa.app.infra.producer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class QueueProducer {

    private AmazonSQS amazonSQS;

    public void sendMessage(String message) {
        log.info("Sending message: {}", message);
        SendMessageRequest sendMessageRequest = null;
        try {
            sendMessageRequest = new SendMessageRequest().withQueueUrl("http://localhost:4566/000000000000/test-queue")
                    .withMessageBody(message)
                    .withMessageGroupId("test message")
                    .withMessageDeduplicationId(UUID.randomUUID().toString());
            amazonSQS.sendMessage(sendMessageRequest);
            log.info("Message was sended to SQS.");
        } catch (Exception e) {
            log.error("Exception ocurred while sending event to sqs: {} stack {}", e.getMessage(), e);
        }

    }

}
