package gov.dos.Allscripts.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TestNGReportListener implements IReporter {

	private static final String ROW_TEMPLATE = "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
	{
		String reportTemplate = initReportTemplate();

		String body = suites
				.stream()
				.flatMap(suiteToResults())
				.collect(Collectors.joining());

		String report
		= reportTemplate.replaceFirst("</tbody>", String.format("%s</tbody>", body));
		saveReportTemplate(outputDirectory, report);
	}

	private Function<ISuite, Stream<? extends String>> suiteToResults() 
	{
		return suite -> suite.getResults().entrySet()
				.stream()
				.map(resultToRow(suite));
	}

	private Function<Map.Entry<String, ISuiteResult>, String> resultToRow(ISuite suite) 
	{
		return e -> {
			ITestContext testContext = e.getValue().getTestContext();

			Set<ITestResult> failedTests 
			= testContext.getFailedTests().getAllResults();
			Set<ITestResult> passedTests 
			= testContext.getPassedTests().getAllResults();
			Set<ITestResult> skippedTests 
			= testContext.getSkippedTests().getAllResults();

			String suiteName = suite.getName();

			int passed = passedTests.size();
			int skipped = skippedTests.size();
			int failed = failedTests.size();

			return String.format(ROW_TEMPLATE, suiteName, passed, skipped, failed, skipped + failed == 0 ? "Passed" : "Failed", testContext.getAttribute("event"));
		};
	}

	private String initReportTemplate() 
	{
		String template = null;
		byte[] reportTemplate;
		try {
			reportTemplate = Files.readAllBytes(Paths.get("src/main/resources/custom-emailable-report.html"));
			template = new String(reportTemplate, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}

	private void saveReportTemplate(String outputDirectory, String reportTemplate) 
	{
		new File(outputDirectory).mkdirs();
		try {
			PrintWriter reportWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputDirectory, "custom-emailable-report.html"))));
			reportWriter.println(reportTemplate);
			reportWriter.flush();
			reportWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
