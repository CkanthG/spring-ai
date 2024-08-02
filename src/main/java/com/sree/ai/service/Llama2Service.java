package com.sree.ai.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Llama2Service {

    private final OllamaChatModel chatModel;

    @Value("${spring.ai.ollama.model:llama2}")
    private String modelName;

    public Llama2Service(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateResult(String queryPrompt) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        queryPrompt,
                        OllamaOptions.create().withModel(modelName)
                )
        );
        return response.getResult().getOutput().getContent();
    }
}
