package com.dora.coverage;

import org.jacoco.core.tools.ExecDumpClient;
import org.jacoco.core.tools.ExecFileLoader;

import java.io.File;
import java.io.IOException;


public class ToExec {

    /**
     * 从测试服务器中dump出覆盖率信息
     *
     * @param filePath exec文件路径
     * @param address 测试服务器地址
     * @param port 测试服务器端口
     */
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

}
