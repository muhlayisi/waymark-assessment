package com.waymark.assessment.utils;

import com.waymark.assessment.model.VerificationRecord;
import com.waymark.assessment.service.JsonTransformationService;
import com.waymark.assessment.service.VerificationRecordsService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class VerificationRecordsLoader implements CommandLineRunner {

    private final String filePath;
    private final JsonTransformationService jsonTransformationService;
    private final VerificationRecordsService verificationRecordsService;

    public VerificationRecordsLoader(@Value("${verification.records.file.path}") String filePath,
                                     JsonTransformationService jsonTransformationService,
                                     VerificationRecordsService verificationRecordsService) {
        this.filePath = filePath;
        this.jsonTransformationService = jsonTransformationService;
        this.verificationRecordsService = verificationRecordsService;
    }

    private String getFileContent() {
        try {
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                System.err.println("File does not exist at path: " + filePath);
                return null;
            }
            return Files.readString(path);

        } catch (InvalidPathException e) {
            System.err.println("Invalid path configuration: " + filePath + " | Cause: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file | Cause: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void run(String @NonNull ... args) {
        String fileContent = getFileContent();

        if (fileContent != null) {
            String jsonVerificationRecords = jsonTransformationService.transformToJson(fileContent);
            List<VerificationRecord> verificationRecords = jsonTransformationService.getVerificationRecordsList(jsonVerificationRecords);
            verificationRecordsService.saveAllVerificationRecords(verificationRecords);
            System.out.println("Successfully saved " + verificationRecords.size() + " records to the H2 database!");
        }
    }

}
