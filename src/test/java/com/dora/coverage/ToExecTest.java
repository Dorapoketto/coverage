package com.dora.coverage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToExecTest {

    @Test
    void dump() {
        ToExec toExec = new ToExec();

        toExec.dump("/Users/vincent/IdeaProjects/spring-exercise/jacoco.exec", "127.0.0.1", 6300);
    }
}