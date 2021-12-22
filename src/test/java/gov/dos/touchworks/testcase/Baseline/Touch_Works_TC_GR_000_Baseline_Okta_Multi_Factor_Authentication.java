package gov.dos.touchworks.testcase.Baseline;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.Allscripts.Utility.OktaBaseTest;
import gov.dos.TouchWorks.Steps.Login_Page.All_Script_Okta_Login_Page_Steps;

public class Touch_Works_TC_GR_000_Baseline_Okta_Multi_Factor_Authentication extends OktaBaseTest {
	protected String PATIENTS_LAST_NAME = "Allscripts";
	protected String PATIENTS_FIRST_NAME = "Douglas";
	protected String TASK_NAME_SIGN_NOTE = "Sign-Note";
	protected String TASK_NAME_CALL_BACK = "Call Back";
	protected String TASK_NAME_DOC_APPT = "Document Appointment";
	protected String TASK_NAME_MEDICAL_COMPLAINT = "Medical Complaint Callback";
	protected String TASK_NAME_NOTIFY_OVERDUE = "Notify Overdue";
	protected String TASK_NAME_NOTIFY_COMPLETE = "Notify Complete";
	 
	@Test()
	public void VerifyUserIsAbleToNavToTouchWorksHomePage() {
		All_Script_Okta_Login_Page_Steps All_Script_Okta_Login_Page_Steps = new All_Script_Okta_Login_Page_Steps(driver);
		OktaBaseTest.WaitUntilVisible(driver, By.xpath("//*[@id=\"okta-signin-username\"]"), 120);
		log.info("Successfully Navigated to " + driver.getCurrentUrl());
		All_Script_Okta_Login_Page_Steps.Login_To_All_Script_Okta_Page(6);
		//All_Script_Okta_Login_Page_Steps.SelectOktaVerificationStateDept();
		All_Script_Okta_Login_Page_Steps.SelectTouchWorksDevPOC();
		BaseTest.WaitUntilVisible(driver, By.xpath("//*[@id=\"shellPage\"]"), 120);
		log.info("Able To Successfully Navigated To: '" + driver.getCurrentUrl() + "': '" + driver.getCurrentUrl().equalsIgnoreCase("https://ehr.tst-dosmed.com/twclient/") + "'");
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"Schedule_AE\"]/div/header/div[2]/div[1]"), 120);
		log.info("Successfully Displayed Schedules Tab: " + driver.findElement(By.xpath("//*[@id=\"Schedule_AE\"]/div/header/div[2]/div[1]")).getText());	
	}
}
