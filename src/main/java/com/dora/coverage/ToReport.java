package com.dora.coverage;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.tools.ExecFileLoader;
import org.jacoco.report.DirectorySourceFileLocator;
import org.jacoco.report.FileMultiReportOutput;
import org.jacoco.report.IReportVisitor;
import org.jacoco.report.html.HTMLFormatter;

import java.io.File;
import java.io.IOException;

public class ToReport {

    /**
     * 覆盖率文件地址
     */
    private final File executionDataFile;

    /**
     * 代码编译后jar包所在位置
     */
    private final File classesDirectory;

    /**
     * 源代码路径
     */
    private final File sourceDirectory;

    /**
     * report 生成路径
     */
    private final File reportDirectory;

    private ExecFileLoader execFileLoader;


    /**
     * Create a new generator based for the given project.
     *
     * @param projectDirectory 项目路径
     */
    public ToReport(final File projectDirectory) {
        this.executionDataFile = new File(projectDirectory, "jacoco.exec");
        this.classesDirectory = new File(projectDirectory, "target");
        this.sourceDirectory = new File(projectDirectory, "src");
        this.reportDirectory = new File(projectDirectory, "coveragereport");
    }

    public void generateReport() throws IOException {

        final HTMLFormatter htmlFormatter = new HTMLFormatter();
        final IReportVisitor iReportVisitor = htmlFormatter.createVisitor(new FileMultiReportOutput(reportDirectory));

        final IBundleCoverage iBundleCoverage = analyzeStructure();

        iReportVisitor.visitInfo(execFileLoader.getSessionInfoStore().getInfos(),
                execFileLoader.getExecutionDataStore().getContents());

        iReportVisitor.visitBundle(iBundleCoverage,
                new DirectorySourceFileLocator(sourceDirectory, "utf-8", 4));

        iReportVisitor.visitEnd();
    }


    /**
     * 加载exec文件
     *
     * @throws IOException 文件异常
     */
    public void loadExecutionData() throws IOException {
        execFileLoader = new ExecFileLoader();
        execFileLoader.load(executionDataFile);
    }

    /**
     *
     * @return coverageBuilder
     * @throws IOException 文件异常
     */
    private IBundleCoverage analyzeStructure() throws IOException {
        final CoverageBuilder coverageBuilder = new CoverageBuilder();
        final Analyzer analyzer = new Analyzer(
                execFileLoader.getExecutionDataStore(), coverageBuilder);

        analyzer.analyzeAll(classesDirectory);

        return coverageBuilder.getBundle("app-market");
    }
}
