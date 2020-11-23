package com.dora.coverage;

import java.io.File;

public class Coverage {
    public static void main(String[] args) {
        ToExec toExec = new ToExec();
//        toExec.dump("./jacoco.exec", "10.30.30.77", 38333);


        ToReport toReport = new ToReport(new File("/Users/vincent/Desktop/isc-app-market-service"));
    }
}
