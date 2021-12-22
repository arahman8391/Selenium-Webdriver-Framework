package gov.dos.TouchWorks.Steps.Login_Page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;

public class All_Script_Okta_Home_Page_Steps extends BaseTest {
	
	public All_Script_Okta_Home_Page_Steps(WebDriver driver)
	{
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SelectTouchWorksAWSPOC() 
	{
		All_Script_Okta_Home_Page h = new All_Script_Okta_Home_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"main-content\"]/div/div[2]/ul[2]/li/a"), 60);
		if(h.StartTouchWorksButton().isDisplayed()) {
			h.StartTouchWorksButton().click();
			log.info("Successfully Selected Touch Works App Button & Naivgated To Okta Verification....");
			driver.close();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    BaseTest.WaitUntilVisible(driver, By.xpath("//*[@value=\"Send Push\"]"), 60);
			h.OktaSendPushButton().click();
			log.info("Successfully Selected OKTA Push Button....");
		}
		else {
				log.error("Unable To Navigate To Touch Works Scheduler Home Page....");
			}
	
	}

}
