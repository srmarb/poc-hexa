package br.com.examplehexa.app.infra.rest;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestSQSController {


    @PostMapping
    public String producerMessageSqs() {
        return "ok";
    }
}
