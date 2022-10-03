package br.com.examplehexa.app.infra.rest;

import br.com.examplehexa.app.infra.producer.QueueProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestSQSController {

    private QueueProducer queueProducer;

    @PostMapping
    public String producerMessageSqs(@RequestBody String message) {
        queueProducer.sendMessage(message);
        return "ok";
    }
}
