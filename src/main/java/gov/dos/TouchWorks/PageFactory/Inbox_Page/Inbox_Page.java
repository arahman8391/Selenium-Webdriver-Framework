package gov.dos.TouchWorks.PageFactory.Inbox_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;

public class Inbox_Page {

	WebDriver driver;
	
	public Inbox_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By RefreshButton = By.xpath("//*[@id=\"Refresh\"]"); 
	
	public WebElement RefreshButton() 
	{
		return driver.findElement(RefreshButton);
	}
	
	By TaskingWorkSpaceIFrame = By.xpath("//*[@id=\"iframeTaskingWorkspace\"]");
	
	public WebElement TaskingWorkSpaceIFrame() 
	{
		BaseTest.WaitUntilWebElementVisible(driver, driver.findElement(TaskingWorkSpaceIFrame), 60);
		return driver.findElement(TaskingWorkSpaceIFrame);
	}
	
	By FilterField = By.xpath("//*[@id=\"cardSearch\"]/input[1]");
	By FilterButton = By.xpath("//*[@id=\"cardSearch\"]/input[2]");
	
	public WebElement FilterField() 
	{
		BaseTest.WaitUntilClickable(driver, FilterField, 60);
		BaseTest.MoveToElement(driver, driver.findElement(FilterField));
		BaseTest.Wait(1);
		return driver.findElement(FilterField);
	}
	public WebElement FilterButton() 
	{
		BaseTest.WaitUntilClickable(driver, FilterButton, 60);
		BaseTest.MoveToElement(driver, driver.findElement(FilterButton));
		BaseTest.Wait(1);
		return driver.findElement(FilterButton);
	}
	
	By MailBoxTable = By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul");
	By MailNumber1 = By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul/li/div[2]");
	By MailNumber1PrioritySign = By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul/li/div[2]/div/div[1]/span[3]/img");
	By MailNumber1OverdueSign = By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul/li/div[2]/div/div[1]/span[2]/img");
	
	public WebElement MailBoxTable() 
	{
		BaseTest.WaitUntilVisible(driver, MailBoxTable, 60);
		return driver.findElement(MailBoxTable);
	}
	public WebElement MailNumber1() 
	{
		return driver.findElement(MailNumber1);
	}
	public WebElement MailNumber1PrioritySign() 
	{
		return driver.findElement(MailNumber1PrioritySign);
	}
	public WebElement MailNumber1OverdueSign() 
	{
		return driver.findElement(MailNumber1OverdueSign);
	}
	
	By MailNumber2 = By.xpath("//*[@id=\"tlist-item-193\"]");

	public WebElement MailNumber2() 
	{
		return driver.findElement(MailNumber2);
	}		
	
	By SelectedTaskEditScreenPriorityType = By.xpath("/html/body/app-tasking-container/block-ui/div/div[3]/tw-task-inline-container/div/task-miscellaneous-container/form/div/div[2]/task-details/div/div[2]/div[1]/div[2]/kendo-dropdownlist/span");
	By SelectedTaskEditScreenStatusType = By.xpath("/html/body/app-tasking-container/block-ui/div/div[3]/tw-task-inline-container/div/task-miscellaneous-container/form/div/div[2]/task-details/div/div[2]/div[2]/div[2]/kendo-dropdownlist/span");
	By SelectedTaskEditScreenSaveButton = By.xpath("//*[@id=\'btnSave\']");
	By SelectedTaskEditScreenSendButton = By.xpath("//*[@id=\"btnSend\"]");

	public WebElement SelectedTaskEditScreenPriorityType() 
	{
		return driver.findElement(SelectedTaskEditScreenPriorityType);
	}
	public WebElement SelectedTaskEditScreenStatusType() 
	{
		return driver.findElement(SelectedTaskEditScreenStatusType);
	}
	public WebElement SelectedTaskEditScreenSaveButton() 
	{
		BaseTest.WaitUntilClickable(driver, SelectedTaskEditScreenSaveButton, 60);
		BaseTest.Wait(1);
		BaseTest.MoveToElement(driver, driver.findElement(SelectedTaskEditScreenSaveButton));
		BaseTest.Wait(1);
		return driver.findElement(SelectedTaskEditScreenSaveButton);
	}
	public WebElement SelectedTaskEditScreenSendButton() 
	{
		BaseTest.WaitUntilClickable(driver, SelectedTaskEditScreenSendButton, 60);
		BaseTest.Wait(1);
		BaseTest.MoveToElement(driver, driver.findElement(SelectedTaskEditScreenSendButton));
		BaseTest.Wait(1);
		return driver.findElement(SelectedTaskEditScreenSendButton);
	}
	
	By SelectedTaskEditScreenCommentBox = By.xpath("//*[@id=\"inboxDetail\"]/div[2]/task-comments/div/div[2]");
	By SelectedTaskEditScreenEditCommentBox = By.xpath("//*[@id=\"inboxDetail\"]/div[2]/task-comments/div/div[2]/div/div[1]/textarea");
	By SelectedTaskEditScreenInProgressButton = By.xpath("//*[@id=\"btnInProgess\"]");
	By SelectedTaskEditScreenDoneButton = By.xpath("//*[@id=\"btnComplete\"]");
	By SelectedTaskEditScreenReactivateButton = By.xpath("//*[@id=\"btnReactivate\"]");
	By SelectedTaskEditScreenReassignButton = By.xpath("//*[@id=\"lnkReassign\"]");
	
	public WebElement SelectedTaskEditScreenCommentBox() 
	{
		return driver.findElement(SelectedTaskEditScreenCommentBox);
	}
	public WebElement SelectedTaskEditScreenEditCommentBox() 
	{
		return driver.findElement(SelectedTaskEditScreenEditCommentBox);
	}
	public WebElement SelectedTaskEditScreenInProgressButton() 
	{
		return driver.findElement(SelectedTaskEditScreenInProgressButton);
	}
	public WebElement SelectedTaskEditScreenDoneButton() 
	{
		return driver.findElement(SelectedTaskEditScreenDoneButton);
	}
	public WebElement SelectedTaskEditScreenReactivateButton() 
	{
		return driver.findElement(SelectedTaskEditScreenReactivateButton);
	}
	public WebElement SelectedTaskEditScreenReassignButton() 
	{
		return driver.findElement(SelectedTaskEditScreenReassignButton);
	}
	
	By SelectedTaskEditScreenAssignToUserRadioButton = By.xpath("//*[@for=\"optUser\"]");
	By SelectedTaskEditScreenAssingToUserDropDown = By.xpath("/html/body/app-tasking-container/block-ui/div/div[3]/tw-task-inline-container/div/task-miscellaneous-container/form/div/div[2]/task-details/div/div[2]/div[2]/div[1]/span[1]/kendo-dropdownlist/span");
	
	public WebElement SelectedTaskEditScreenAssignToUserRadioButton() 
	{
		BaseTest.WaitUntilClickable(driver, SelectedTaskEditScreenAssignToUserRadioButton, 60);
		BaseTest.MoveToElement(driver, driver.findElement(SelectedTaskEditScreenAssignToUserRadioButton));
		BaseTest.Wait(2);
		return driver.findElement(SelectedTaskEditScreenAssignToUserRadioButton);
	}
	public WebElement SelectedTaskEditScreenAssingToUserDropDown() 
	{
		BaseTest.WaitUntilClickable(driver, SelectedTaskEditScreenAssingToUserDropDown, 60);
		BaseTest.MoveToElement(driver, driver.findElement(SelectedTaskEditScreenAssingToUserDropDown));
		BaseTest.Wait(2);
		return driver.findElement(SelectedTaskEditScreenAssingToUserDropDown);
	}
	
	By SelectedTaskEditScreenAssignToTeamRadioButton = By.xpath("//*[@for=\"optTeam\"]");
	By SelectedTaskEditScreenAssingToTeamDropDown = By.xpath("/html/body/app-tasking-container/block-ui/div/div[3]/tw-task-inline-container/div/task-miscellaneous-container/form/div/div[2]/task-details/div/div[2]/div[2]/div[1]/span[2]/kendo-dropdownlist/span");
	By SelectedTaskEditScreenAssingToTeamSearchIcon = By.xpath("//*[@id=\"btnSearchUser\"]");
	
	public WebElement SelectedTaskEditScreenAssignToTeamRadioButton() 
	{
		BaseTest.WaitUntilClickable(driver, SelectedTaskEditScreenAssignToTeamRadioButton, 60);
		BaseTest.MoveToElement(driver, driver.findElement(SelectedTaskEditScreenAssignToTeamRadioButton));
		BaseTest.Wait(1);
		return driver.findElement(SelectedTaskEditScreenAssignToTeamRadioButton);
	}
	public WebElement SelectedTaskEditScreenAssingToTeamDropDown() 
	{
		BaseTest.WaitUntilClickable(driver, SelectedTaskEditScreenAssingToTeamDropDown, 60);
		BaseTest.MoveToElement(driver, driver.findElement(SelectedTaskEditScreenAssingToTeamDropDown));
		BaseTest.Wait(1);
		return driver.findElement(SelectedTaskEditScreenAssingToTeamDropDown);
	}
	public WebElement SelectedTaskEditScreenAssingToTeamSearchIcon() 
	{
		return driver.findElement(SelectedTaskEditScreenAssingToTeamSearchIcon);
	}
	
	By ExpandMyActiveTaskList = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/div/span[1]");
	By MyActiveTaskList = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/div/span[2]/div/div[1]");
	By MyActiveTaskListCount = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/div/span[2]/div/div[2]");
	
	public WebElement ExpandMyActiveTaskList() 
	{
		return driver.findElement(ExpandMyActiveTaskList);
	}	
	public WebElement MyActiveTaskList() 
	{
		return driver.findElement(MyActiveTaskList);
	}	
	public WebElement MyActiveTaskListCount() 
	{
		return driver.findElement(MyActiveTaskListCount);
	}	
	
	By MyActiveTaskRow1 = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/ul/li/div/span/div/div[1]");
	By MyActiveTaskRow1Count = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/ul/li/div/span/div/div[2]");
	
	public WebElement MyActiveTaskRow1() 
	{
		return driver.findElement(MyActiveTaskRow1);
	}	
	public WebElement MyActiveTaskRow1Count() 
	{
		return driver.findElement(MyActiveTaskRow1Count);
	}	
	
	By CurrentPatientActiveTable = By.xpath("/html/body/app-tasking-container/block-ui/div/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul");
	By ExpandCurrentPatientActiveTaskList = By.xpath("/html/body/app-tasking-container/block-ui/div/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/div/span[1]");
	By CurrentPatientActiveTaskList = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[1]/div/span[2]/div/div[1]");
	By CurrentPatientActiveTaskListCount = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[1]/div/span[2]/div/div[2]");
	
	public WebElement CurrentPatientActiveTable() 
	{
		BaseTest.WaitUntilClickable(driver, CurrentPatientActiveTable, 60);
		return driver.findElement(CurrentPatientActiveTable);
	}	
	public WebElement ExpandCurrentPatientActiveTaskList() 
	{
		BaseTest.WaitUntilClickable(driver, ExpandCurrentPatientActiveTaskList, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ExpandCurrentPatientActiveTaskList));
		return driver.findElement(ExpandCurrentPatientActiveTaskList);
	}	
	public WebElement CurrentPatientActiveTaskList() 
	{
		return driver.findElement(CurrentPatientActiveTaskList);
	}	
	public WebElement CurrentPatientActiveTaskListCount() 
	{
		return driver.findElement(CurrentPatientActiveTaskListCount);
	}	
	
	By CurrentPatientActiveTaskRow1 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[1]/div/span/div/div[1]");
	By CurrentPatientActiveTaskRow1Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[1]/div/span/div/div[2]");
	
	public WebElement CurrentPatientActiveTaskRow1() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow1);
	}	
	public WebElement CurrentPatientActiveTaskRow1Count() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow1Count);
	}	
	
	By CurrentPatientActiveTaskRow2 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[2]/div/span/div/div[1]");
	By CurrentPatientActiveTaskRow2Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[2]/div/span/div/div[2]");
	
	public WebElement CurrentPatientActiveTaskRow2() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow2);
	}	
	public WebElement CurrentPatientActiveTaskRow2Count() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow2Count);
	}	
	
	By CurrentPatientActiveTaskRow3 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[3]/div/span/div/div[1]");
	By CurrentPatientActiveTaskRow3Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[3]/div/span/div/div[2]");
	
	public WebElement CurrentPatientActiveTaskRow3() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow3);
	}	
	public WebElement CurrentPatientActiveTaskRow3Count() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow3Count);
	}	
	
	By CurrentPatientActiveTaskRow4 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[4]/div/span/div/div[1]");
	By CurrentPatientActiveTaskRow4Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[4]/div/span/div/div[2]");
	
	public WebElement CurrentPatientActiveTaskRow4() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow4);
	}	
	public WebElement CurrentPatientActiveTaskRow4Count() 
	{
		return driver.findElement(CurrentPatientActiveTaskRow4Count);
	}	
	
	By ExpandCurrentPatientAllTaskList = By.xpath("/html/body/app-tasking-container/block-ui/div/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/div/span[1]");
	By CurrentPatientAllTable = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/ul");
	By CurrentPatientAllTaskList = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/div/span[2]/div/div[1]");
	By CurrentPatientAllTaskListCount = By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/div/span[2]/div/div[2]");
	
	public WebElement ExpandCurrentPatientAllTaskList() 
	{
		BaseTest.WaitUntilClickable(driver, ExpandCurrentPatientAllTaskList, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ExpandCurrentPatientAllTaskList));
		return driver.findElement(ExpandCurrentPatientAllTaskList);
	}	
	public WebElement CurrentPatientAllTable() 
	{
		return driver.findElement(CurrentPatientAllTable);
	}	
	public WebElement CurrentPatientAllTaskList() 
	{
		return driver.findElement(CurrentPatientAllTaskList);
	}	
	public WebElement CurrentPatientAllTaskListCount() 
	{
		return driver.findElement(CurrentPatientAllTaskListCount);
	}	
	
	By CurrentPatientAllTaskRow1 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[1]/div/span/div/div[1]");
	By CurrentPatientAllTaskRow1Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[1]/div/span/div/div[2]");
	
	public WebElement CurrentPatientAllTaskRow1() 
	{
		return driver.findElement(CurrentPatientAllTaskRow1);
	}	
	public WebElement CurrentPatientAllTaskRow1Count() 
	{
		return driver.findElement(CurrentPatientAllTaskRow1Count);
	}	
	
	By CurrentPatientAllTaskRow2 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[2]/div/span/div/div[1]");
	By CurrentPatientAllTaskRow2Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[2]/div/span/div/div[2]");
	
	public WebElement CurrentPatientAllTaskRow2() 
	{
		return driver.findElement(CurrentPatientAllTaskRow2);
	}	
	public WebElement CurrentPatientAllTaskRow2Count() 
	{
		return driver.findElement(CurrentPatientAllTaskRow2Count);
	}	
	
	By CurrentPatientAllTaskRow3 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[3]/div/span/div/div[1]");
	By CurrentPatientAllTaskRow3Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[3]/div/span/div/div[2]");
	
	public WebElement CurrentPatientAllTaskRow3() 
	{
		return driver.findElement(CurrentPatientAllTaskRow3);
	}	
	public WebElement CurrentPatientAllTaskRow3Count() 
	{
		return driver.findElement(CurrentPatientAllTaskRow3Count);
	}	
	
	By CurrentPatientAllTaskRow4 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[4]/div/span/div/div[1]");
	By CurrentPatientAllTaskRow4Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[4]/div/span/div/div[2]");
	
	public WebElement CurrentPatientAllTaskRow4() 
	{
		return driver.findElement(CurrentPatientAllTaskRow4);
	}	
	public WebElement CurrentPatientAllTaskRow4Count() 
	{
		return driver.findElement(CurrentPatientAllTaskRow4Count);
	}	
	
	By CurrentPatientAllTaskRow5 = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[5]/div/span/div/div[1]");
	By CurrentPatientAllTaskRow5Count = By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[2]/ul/li[5]/div/span/div/div[2]");
	
	public WebElement CurrentPatientAllTaskRow5() 
	{
		return driver.findElement(CurrentPatientAllTaskRow5);
	}	
	public WebElement CurrentPatientAllTaskRow5Count() 
	{
		return driver.findElement(CurrentPatientAllTaskRow5Count);
	}	
}
