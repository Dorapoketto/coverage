package com.dora.coverage;

import org.jacoco.core.tools.ExecDumpClient;
import org.jacoco.core.tools.ExecFileLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class ToExec {
    private static final Logger logger = LoggerFactory.getLogger(ToExec.class);

    /**
     * 从测试服务器中dump出覆盖率信息
     *
     * @param filePath exec生成文件路径
     * @param address  测试服务器地址
     * @param port     测试服务器端口
     */
    public void dump(String filePath, String address, int port) {

        ExecDumpClient execDumpClient = new ExecDumpClient();
        execDumpClient.setDump(true);

        ExecFileLoader execFileLoader;

        logger.info("开始从测试服务器中获取覆盖率文件");

        try {
            execFileLoader = execDumpClient.dump(address, port);
            // 将覆盖率数据文件保存至本地
            execFileLoader.save(new File(filePath), false);
            logger.info("数据获取成功");
        } catch (IOException e) {
            logger.warn("错误日志{}", e.getMessage());
        }
    }

    /**
     * @param address 测试服务器地址
     * @param port    测试服务器端口
     * @return true or false
     * @throws IOException
     */
    public static boolean CheckConnect(String address, int port) throws Exception {
        try {
            ExecDumpClient dumpClient = new ExecDumpClient();
            dumpClient.dump(address, port);
            return true;
        } catch (Exception e) {
            logger.error("tcp服务连接不上，请检查配置:{}", e.getMessage());
        }
        return false;
    }

}
