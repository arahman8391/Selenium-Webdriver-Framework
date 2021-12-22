package gov.dos.TouchWorks.Steps.Login_Page;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.Allscripts.Utility.ExcelDriver;
import gov.dos.TouchWorks.PageFactory.Login_Page.All_Script_Okta_Login_Page;

public class All_Script_Okta_Login_Page_Steps extends BaseTest {
	
	public All_Script_Okta_Login_Page_Steps(WebDriver driver)
	{
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}
	protected int USER_NAME_COLUMN = 0;
	protected int PASSWORD_COLUMN = 1;
	
	public void Login_To_All_Script_Okta_Page(int USER_NAME_PASSWORD_ROW) 
	{
		All_Script_Okta_Login_Page h = new All_Script_Okta_Login_Page(driver);
		
		try {
			BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"okta-signin-username\"]"), 120);
			
			if(h.UserNameField().isDisplayed()) {
				log.info("Successfully Selected Main Sign In Button & Displayed User Name And Password....");
				String UserName = ExcelDriver.getCelldata(USER_NAME_PASSWORD_ROW, USER_NAME_COLUMN, LOGIN_INFO_SHEET_NAME, FILE_PATH);
				h.UserNameField().clear();
				BaseTest.Wait(1);
				h.UserNameField().sendKeys(UserName);
				log.info("Successfully Entered UserName: " + UserName);
				String Password = ExcelDriver.getCelldata(USER_NAME_PASSWORD_ROW, PASSWORD_COLUMN, LOGIN_INFO_SHEET_NAME, FILE_PATH);
				h.PasswordField().clear();
				BaseTest.Wait(1);
				h.PasswordField().sendKeys(Password);
				log.info("Successfully Entered Password: " + Password);
			}
			else {
				log.error("Unable To Enter UserName and Password....");
			}
			
			if(h.SignInButton().isDisplayed()) {
				BaseTest.MoveToElement(driver, h.SignInButton());
				BaseTest.Wait(1);
				h.SignInButton().click();
				log.info("Successfully Selected Sign In Button....");
			}
			else {
				log.error("Unable To Select Sign In And Open Patient Portal HomePage....");
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
			log.info("Unable TO Invoke Excel Sheet....");
		}
	}
	
	public void SelectTouchWorksAWSPOC() 
	{
		All_Script_Okta_Home_Page h = new All_Script_Okta_Home_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"main-content\"]/div/div[2]/ul[2]/li/a"), 120);
		if(h.StartTouchWorksButton().isDisplayed()) {
			h.StartTouchWorksButton().click();
			log.info("Successfully Selected Touch Works App Button & Naivgated To Okta Verification....");
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			 driver.switchTo().window(tabs2.get(0));
			 driver.close();
		    driver.switchTo().window(tabs2.get(1));
		    BaseTest.WaitUntilVisible(driver, By.xpath("//*[@value=\"Send Push\"]"), 120);
			h.OktaSendPushButton().click();
			log.info("Successfully Selected OKTA Push Button....");
		}
		else {
				log.error("Unable To Navigate To Touch Works Scheduler Home Page....");
		}
	}
	
	public void SelectOktaVerificationStateDept() 
	{
		All_Script_Okta_Home_Page h = new All_Script_Okta_Home_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@value=\"Send Push\"]"), 120);
		
		if(h.OktaSendPushButton().isDisplayed()) {
			h.OktaSendPushButton().click();
			log.info("Successfully Selected OKTA Push Button....");
		}
		else {
				log.error("Unable To Select OKTA Send Push Button....");
		}		
	}
	
	public void SelectRemindMeLater() 
	{
		All_Script_Okta_Home_Page h = new All_Script_Okta_Home_Page(driver);
		
		try {
			if (h.RemindMeLaterButton().isDisplayed()) {
				h.RemindMeLaterButton().click();
				log.info("Successfully Selected Remind Me Later Push Button....");
			} else {
				log.error("Unable To Select Remind Me Later Push Button....");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Remind Me Later Button Is Not Displayed....");
		}		
	}
	
	public void SelectTouchWorksDevPOC() 
	{
		All_Script_Okta_Home_Page h = new All_Script_Okta_Home_Page(driver);
		if(h.DosTouchWorksDevButton().isDisplayed()) {
			h.DosTouchWorksDevButton().click();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));
			driver.close();
		    driver.switchTo().window(tabs2.get(1));
		    log.info("Successfully Selected DOS Touch Works Dev App Button....");
		}
		else {
				log.error("Unable To Navigate To Touch Works Scheduler Home Page....");
		}
	}

}
