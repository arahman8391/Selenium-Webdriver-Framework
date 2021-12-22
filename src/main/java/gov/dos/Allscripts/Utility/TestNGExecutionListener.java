package gov.dos.Allscripts.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.IExecutionListener;

public class TestNGExecutionListener implements IExecutionListener {

	@Override
	public void onExecutionFinish() 
	{
		try {
			byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/custom-emailable-report.html"));
			StringBuilder strBuffer = new StringBuilder();
			strBuffer.append(new String(bytes, "UTF-8"));
			SendHtmlEmail s = new SendHtmlEmail();
			//SendHtmlEmail a = new SendHtmlEmail();
			s.send("no-reply@dos.dod.gov", "", "atareque@plan-sys.com", "TouchWorks Automation Test Report", strBuffer.toString().toUpperCase());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub

	}
}
