package com.dora.coverage;

import java.io.File;
import java.io.IOException;

public class Coverage {
    public static void main(String[] args) throws IOException {
        String file_path = "/Users/vincent/Desktop/jacoco/isc-app-market-service/jacoco.exec";

        ToExec toExec = new ToExec();
        toExec.dump(file_path, "10.30.30.77", 38333);



        ToReport toReport = new ToReport(new File("/Users/vincent/Desktop/jacoco/isc-app-market-service"));

        toReport.loadExecutionData();
        toReport.generateReport();
    }
}
