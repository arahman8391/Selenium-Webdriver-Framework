package gov.dos.TouchWorks.Steps.Inbox_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.TouchWorks.PageFactory.Inbox_Page.Teams_Screen;

public class Teams_Screen_Steps extends BaseTest {
	
	public Teams_Screen_Steps(WebDriver driver)
	{
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SelectSearchInTeamsPopUpWindow() 
	{
		Teams_Screen t = new Teams_Screen(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"btnSearch1\"]"), 120);
		
		if(t.TeamsSearchButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, t.TeamsSearchButton());
			BaseTest.Wait(2);
			t.TeamsSearchButton().click();
			BaseTest.Wait(2);
			log.info("Successfully Selected Search Button In Teams Search Screen....");
		}
		else {
			log.error("Unable To Select Search Button In Teams Search Screen....");
		}
	}
	
	public void SwitchToTeamsIFrame() 
	{
		Teams_Screen t = new Teams_Screen(driver);
		BaseTest.WaitUntilVisible(driver, By.xpath("//*[@id=\"dialog0\"]/iframe"), 120);
		driver.switchTo().frame(t.TeamsIFrame());
		BaseTest.Wait(2);
		log.info("Successfully Switched To Teams IFrame....");
		
	}
	
	public void SwitchToDefaultContent() 
	{
		BaseTest.Wait(5);
		driver.switchTo().defaultContent();
		BaseTest.Wait(5);
		log.info("Successfully Switched To Default Content....");
	}
	
	public void SelectTeamAndClickOk(String SelectByColumnName) 
	{
		Teams_Screen t = new Teams_Screen(driver);
		
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"divSearchResults\"]/div[2]/table/tbody"), 60);
		
		if(t.TeamsSearchResultParent().isDisplayed()) {
			BaseTest.SelectTeamByTd(driver, t.TeamsSearchResultParent(), SelectByColumnName);
			log.info("Successfully Selected Team From Teams Search Screen: " + SelectByColumnName);
			BaseTest.Wait(2);
			BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"btnOk\"]"), 60);
			BaseTest.MoveToElement(driver, t.TeamsOkButton());
			BaseTest.Wait(2);
			t.TeamsOkButton().click();
			log.info("Successfully Selected Teams Screen Ok Button....");
		}
		else {
			log.error("Unable To Select Team From Teams Search Screen: " + SelectByColumnName);
		}	
	}
}
