package com.dora.coverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Coverage {
    private static final Logger logger = LoggerFactory.getLogger(Coverage.class);

    public static void main(String[] args) throws IOException {
//        dump();
        generate();
    }

    public static void dump(){
        String file_path = "/Users/vincent/Desktop/jacoco/isc-app-market-service/jacoco.exec";

        logger.info("开始获取Exec覆盖率文件");

        ToExec toExec = new ToExec();
        toExec.dump(file_path, "10.30.30.77", 38333);
    }

    public static void generate() throws IOException {
        ToReport toReport = new ToReport(new File("/Users/vincent/Desktop/jacoco/isc-app-market-service"));

        toReport.loadExecutionData();
        toReport.generateReport();
    }
}
