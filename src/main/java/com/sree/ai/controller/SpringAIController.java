package com.sree.ai.controller;

import com.sree.ai.service.Llama2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/v1")
public class SpringAIController {

    @Autowired
    Llama2Service llama2Service;

    @GetMapping("/generate")
    public String callLlmModelToGenerateResponse(@RequestParam(value = "query") String query) {
        return llama2Service.generateResult(query);
    }
}
