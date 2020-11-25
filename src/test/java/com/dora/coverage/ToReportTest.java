package com.dora.coverage;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ToReportTest {

    @Test
    void generate() throws IOException {
        ToReport toReport = new ToReport(new File("/Users/vincent/IdeaProjects/spring-exercise"));

        toReport.loadExecutionData();
        toReport.generateReport();
    }

}