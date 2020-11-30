package com.dora.coverage;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ToExecTest {

    ToExec toExec = new ToExec();

    @Test
    void dump() {
        toExec.dump("/Users/vincent/IdeaProjects/spring-exercise/jacoco.exec", "127.0.0.1", 6300);
    }

    @Test
    void checkConnect() throws Exception {
        if (ToExec.CheckConnect("10.30.30.77", 38333)) {
            System.out.println("Successed!");
        } else {
            System.out.println("Error!");
        }
    }
}