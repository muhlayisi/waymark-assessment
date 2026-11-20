package com.waymark.assessment.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waymark.assessment.model.VerificationRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonTransformationService {

    private final ObjectMapper objectMapper;

    public JsonTransformationService() {
        this.objectMapper = new ObjectMapper()
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public String transformToJson(String fileContent) {
        String transformedJson = fileContent;

        if (transformedJson.endsWith(";")) {
            transformedJson = transformedJson.substring(0, transformedJson.length() - 1);
        }
        if (!transformedJson.startsWith("[")) {
            transformedJson = "[\n" + transformedJson;
        }
        if (!transformedJson.endsWith("]")) {
            transformedJson = transformedJson + "\n]";
        }

        return transformedJson;
    }

    public List<VerificationRecord> getVerificationRecordsList(String jsonVerificationRecords) {
        List<VerificationRecord> verificationRecordList = null;

        try {
            verificationRecordList = objectMapper.readValue(
                    jsonVerificationRecords,
                    new TypeReference<List<VerificationRecord>>() {
                    }
            );
        } catch (JsonProcessingException e) {
            System.err.println("Error converting JSON verification records to List | Cause: " + e.getMessage());
        }

        return verificationRecordList;
    }

}
