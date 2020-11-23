package com.dora.coverage;

import org.jacoco.core.tools.ExecFileLoader;
import org.jacoco.report.IReportVisitor;
import org.jacoco.report.html.HTMLFormatter;

import java.io.File;
import java.io.IOException;

public class ToReport {

    private final File executionDataFile;
    private final File classesDirectory;
    private final File sourceDirectory;
    private final File reportDirectory;
    private ExecFileLoader execFileLoader;


    /**
     * Create a new generator based for the given project.
     *
     * @param projectDirectory 项目路径
     */
    public ToReport(final File projectDirectory) {
        this.executionDataFile = new File(projectDirectory, "jacoco.exec");
        this.classesDirectory = new File(projectDirectory, "bin");
        this.sourceDirectory = new File(projectDirectory, "src");
        this.reportDirectory = new File(projectDirectory, "coveragereport");
    }

    public static void generateReport(){

        final HTMLFormatter htmlFormatter = new HTMLFormatter();
        final IReportVisitor iReportVisitor = null;



    }


    private void loadExecutionData() throws IOException {
        execFileLoader = new ExecFileLoader();
        execFileLoader.load(executionDataFile);
    }
}
