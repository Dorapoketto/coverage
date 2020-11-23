package com.dora.coverage;

import org.jacoco.core.tools.ExecDumpClient;
import org.jacoco.core.tools.ExecFileLoader;

import java.io.File;
import java.io.IOException;


public class ToExec {

    public void dump(String filePath, String address, int port){

        ExecDumpClient execDumpClient = new ExecDumpClient();
        execDumpClient.setDump(true);

        ExecFileLoader execFileLoader = null;
        try {
            execFileLoader = execDumpClient.dump(address, port);
            execFileLoader.save(new File(filePath), false);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        ToExec toExec = new ToExec();

        toExec.dump("./jacoco.exec", "10.30.30.77", 38333);
    }

}
