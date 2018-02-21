package com.byon8.recruitment.marielaroldan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Mocked Data Base to handle three questions for a patient
 */

public class MockedPatientDataBase {

    private static final Path PATH = Paths.get("patient_data_base.txt");

    public void add(Patient patient) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(PATH, StandardCharsets.UTF_8, StandardOpenOption.APPEND,StandardOpenOption.CREATE);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(patient.toJson());
        }
    }
}
