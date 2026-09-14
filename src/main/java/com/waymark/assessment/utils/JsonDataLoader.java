package com.waymark.assessment.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;

public class JsonDataLoader implements CommandLineRunner {

    @Value("${APP_STOTAGE_DIR:C:\\\\Users\\\\20161067\\\\Downloads\\verification-records.txt}")
    private Resource resource;

    private final ObjectMapper objectMapper;

    public JsonDataLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
