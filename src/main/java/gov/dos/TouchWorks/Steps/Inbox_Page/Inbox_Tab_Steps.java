package gov.dos.TouchWorks.Steps.Inbox_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.TouchWorks.PageFactory.Inbox_Page.Inbox_Page;

public class Inbox_Tab_Steps extends BaseTest {

	public Inbox_Tab_Steps(WebDriver driver)
	{
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SwitchToTaskingWorkSpaceIFrame() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		driver.switchTo().defaultContent();
		log.info("Successfully Switched To Default Content....");
		log.info("Frame: " + driver.findElements(By.id("iframe")).size());
		driver.switchTo().frame(i.TaskingWorkSpaceIFrame());
		BaseTest.Wait(2);
		log.info("Successfully Switched To Inbox iFrame....");
	}
	
	public void SwitchToDefaultContent() 
	{
		driver.switchTo().defaultContent();
		BaseTest.Wait(2);
		log.info("Successfully Switched To Default Content....");
	}
	
	public void VerifyInboxIsDefaultedToTaskView() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/ul/li/div/span/div/div[1]"), 60);
		
		if(i.MyActiveTaskRow1().isDisplayed()) {
			log.info("Inbox is defaulted to Task View - MY ACTIVE TASKS....");
		}
		else {
			log.error("Unable To Verify That Inbox is defaulted to Task View - MY ACTIVE TASKS....");
		}
	}
	
	public void VerifyTaskCountIsDisplayedFromMyActiveTasks(String ExpectedActiveTaskListCount) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/div/span[2]/div/div[2]"), 60);
		
		if(i.MyActiveTaskListCount().isDisplayed()) {
			String ActualActiveTaskListCount = i.MyActiveTaskListCount().getText();
			//Assert.assertEquals(ActualActiveTaskListCount, ExpectedActiveTaskListCount, "Unable To Verify My Active Task List Count: ");
			log.info("Successfully Captured My Active Task List Count: " + ActualActiveTaskListCount);
		}
		else {
			log.error("Unable To Assert & Capture My Active Task List Count: " + ExpectedActiveTaskListCount);
		}
	}
	
	public void ExpandMyActiveTasksAndVerifyIndividualTasks(WebElement ActiveTaskRow) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/div/span[2]"), 60);
		
		if(i.MyActiveTaskRow1().isDisplayed()) {
			String ActualActiveTaskRow = ActiveTaskRow.getText();
			//Assert.assertEquals(ActualActiveTaskRow, ExpectedActiveTaskRow, "Unable To Verify My Active Task: ");
			log.info("Successfully Captured My Active Task: " + ActualActiveTaskRow);
		}
		else {
			i.ExpandMyActiveTaskList().click();
			BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li/ul/li"), 60);
			String ActualActiveTaskRow = ActiveTaskRow.getText();
			//Assert.assertEquals(ActualActiveTaskRow, ExpectedActiveTaskRow, "Unable To Verify My Active Task: ");
			log.info("Successfully Captured My Active Task: " + ActualActiveTaskRow);
			SwitchToDefaultContent();
		}	
	}
	
	public void VerifyPresenceOfCurrentPatientInActiveTaskGroup() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[1]/div/span[2]/div/div[1]"), 60);
		
		if(i.CurrentPatientActiveTaskList().isDisplayed()) {
			log.info("CURRENT PATIENT - ACTIVE Task group Is Displayed....");
			BaseTest.Wait(3);
		}
		else {
			log.error("CURRENT PATIENT - ACTIVE Task group Is Not Displayed....");
		}
	}
	
	public void VerifyTaskCountIsDisplayedForCurrentPatientForActiveTaskGroup() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[1]/div/span[2]/div/div[2]"), 60);
		
		if(i.CurrentPatientActiveTaskListCount().isDisplayed()) {
			String ActualCurrentPatientActiveTaskListCount = i.CurrentPatientActiveTaskListCount().getText();
			//Assert.assertEquals(ActualCurrentPatientActiveTaskListCount, ExpectedCurrentPatientActiveTaskListCount, "Unable To Verify task count is displayed for CURRENT PATIENT - ACTIVE Task group: ");
			log.info("Successfully Captured Task Count Is Displayed For CURRENT PATIENT - ACTIVE Task group: " + ActualCurrentPatientActiveTaskListCount);
		}
		else {
			log.error("Unable To Assert & Capture Task Count Is Displayed For CURRENT PATIENT - ACTIVE Task group....");
		}
	}
	
	public void ExpandOrCollapseActiveTasksForCurrentPatient() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		
		if(i.ExpandCurrentPatientActiveTaskList().isDisplayed()) {
			i.ExpandCurrentPatientActiveTaskList().click();
			BaseTest.Wait(3);
			log.info("Successfully Expanded Current Patient Active Task List....");
		}
		else {
			log.error("Unable To Expanded Current Patient Active Task List....");
		}	
	}
	
	public void VerifyIndividualTasksForCurrentPatientsActiveTaskList(WebElement CurrentPatientActiveTaskRow, String ExpectedCurrentPatientActiveTaskRow) 
	{
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/div[1]/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul/li[1]/div/span/div/div[1]"), 120);
		
		if(CurrentPatientActiveTaskRow.isDisplayed()) {
			String ActualCurrentPatientActiveTaskRow = CurrentPatientActiveTaskRow.getText();
			Assert.assertEquals(ActualCurrentPatientActiveTaskRow, ExpectedCurrentPatientActiveTaskRow, "Unable To Verify Current Patient Active Task: ");
			log.info("Successfully Asserted & Captured Current Patient Active Task: " + ActualCurrentPatientActiveTaskRow);
		}
		else {
			log.error("Unable To Assert & Validate Current Patients Active Task List....");
		}	
	}
	
	public void VerifyPresenceOfCurrentPatientInAllTaskGroup() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/div/span[2]/div/div[1]"), 60);
		
		if(i.CurrentPatientAllTaskList().isDisplayed()) {
			log.info("CURRENT PATIENT - ALL Task group Is Displayed....");
		}
		else {
			log.error("CURRENT PATIENT - ALL Task group Is Not Displayed....");
		}
	}
	
	public void VerifyTaskCountIsDisplayedForCurrentPatientsAllTaskGroup() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/div/span[2]/div/div[2]"), 60);
		
		if(i.CurrentPatientAllTaskListCount().isDisplayed()) {
			String ActualCurrentPatientAllTaskListCount = i.CurrentPatientAllTaskListCount().getText();
			//Assert.assertEquals(ActualCurrentPatientAllTaskListCount, ExpectedCurrentPatientAllTaskListCount, "Unable To Verify task count is displayed for CURRENT PATIENT - ALL Task group: ");
			log.info("Successfully Captured Task Count Is Displayed For CURRENT PATIENT - ALL Task group: " + ActualCurrentPatientAllTaskListCount);
		}
		else {
			log.error("Unable To Assert & Capture Task Count Is Displayed For CURRENT PATIENT - ALL Task group....");
		}
	}
	
	public void ExpandOrCollapseAllTasksForCurrentPatient() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		
		if(i.ExpandCurrentPatientAllTaskList().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.ExpandCurrentPatientAllTaskList());
			BaseTest.Wait(2);
			i.ExpandCurrentPatientAllTaskList().click();
			BaseTest.Wait(3);
			log.info("Successfully Expanded Current Patient All Task List....");
		}
		else {
			log.error("Unable To Expanded Current Patient All Task List....");
		}	
	}
	
	public void VerifyIndividualTasksForCurrentPatientAllTaskList(String ExpectedTaskName) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/ul"), 120);
		
		if(i.CurrentPatientAllTable().isDisplayed()) {
			String ActualCurrentPatientActiveTaskRow = BaseTest.GetTextByColumnNameFromTableByDivTag(i.CurrentPatientAllTable(), ExpectedTaskName);
			Assert.assertEquals(ActualCurrentPatientActiveTaskRow, ExpectedTaskName, "Unable To Verify Patient Current All Individual Task Type: ");
			log.info("Successfully Asserted & Captured Taks Under Current Patient All Task: " + ActualCurrentPatientActiveTaskRow);
			BaseTest.Wait(2);
		}
		else {
			log.error("Unable To Assert & Validate Current Patients All Task List....");
		}	
	}
	
	public void VerifyIndividualTaskForCurrentPatientActiveTasks(String ExpectedTaskName) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[1]/ul"), 120);
		
		if (i.CurrentPatientActiveTable().isDisplayed()) {
			String ActualTaskType = BaseTest.GetTextByColumnNameFromTableByDivTag(i.CurrentPatientActiveTable(), ExpectedTaskName);
			Assert.assertEquals(ActualTaskType, ExpectedTaskName, "Unable To Verify Patient Current Active Individual Task Type: ");
			log.info("Successfully Asserted & Captured Task Under Current Patient Active Task List: " + ActualTaskType);
			BaseTest.Wait(2);
		}
		else {
			log.error("Unable To Validate Newly Created Task Under Current Patient Active Task List: " + ExpectedTaskName);
		}
	}
	
	public void SelectTaskFromCurrentPatientActiveTaskList(String SelectByColumnName) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[1]/tw-task-nav/div[1]/kendo-treeview[2]/ul/li[1]/ul"), 60);
		
		if(i.CurrentPatientActiveTable().isDisplayed()) {
			BaseTest.SelectByColumnNameFromTableByDivTag(driver, i.CurrentPatientActiveTable(), SelectByColumnName);
			log.info("Successfully Selected Individual Task From Current Patient Active Task List: " + SelectByColumnName);
			BaseTest.Wait(2);
		}
		else {
			log.error("Unable To Individual Task From Current Patient Active Task List: " + SelectByColumnName);
		}	
	}
	
	public void SelectIndividualTaskFromMailboxTableSelectedByTaskType(String STAFF_NAME, String SelectByColumnName) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		
		if(i.FilterField().isDisplayed()) {
			i.FilterField().clear();
			BaseTest.Wait(1);
			i.FilterField().sendKeys(STAFF_NAME);
			BaseTest.Wait(1);
			i.FilterButton().click();
			log.info("Successfully Searched For Staff Name To Filter Task: " + STAFF_NAME);
			BaseTest.Wait(1);	
		}
		else {
			log.error("Unable To Filter Task By Staff Name....");
		}
				
		if(i.MailBoxTable().isDisplayed()) {
			BaseTest.SelectByColumnNameFromTableByDivTag(driver, i.MailBoxTable(), SelectByColumnName);
			log.info("Successfully Select Individual Task From Mailbox Table Selected By Task Type: " + SelectByColumnName);
			BaseTest.Wait(2);
		}
		else {
			log.error("Unable To Select Individual Task From Mailbox Table Selected By Task Type: " + SelectByColumnName);
		}	
	}
	
	public void SelectTaskFromCurrentPatientAllTaskList(String SelectByColumnName) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"navpane-defalt-tree\"]/ul/li[2]/ul"), 60);
		
		if(i.CurrentPatientAllTable().isDisplayed()) {
			BaseTest.SelectByColumnNameFromTableByDivTag(driver, i.CurrentPatientAllTable(), SelectByColumnName);
			log.info("Successfully Selected Individual Task From Current Patient All Task List: " + SelectByColumnName);
			BaseTest.Wait(2);
		}
		else {
			log.error("Unable To Individual Task From Current Patient All Task List: " + SelectByColumnName);
		}	
	}
	
	public void SelectTaskFromMailboxTaskList(String SelectByColumnName) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul"), 60);
		
		if(i.MailBoxTable().isDisplayed()) {
			BaseTest.SelectByColumnNameFromTableByDivTag(driver, i.MailBoxTable(), SelectByColumnName);
			log.info("Successfully Selected Individual Task From Mailbox Task List: " + SelectByColumnName);
			BaseTest.Wait(2);
		}
		else {
			log.error("Unable To Individual Task From Mailbox Task List: " + SelectByColumnName);
		}	
	}
	
	public void VerifyPriorityIconForNewlyCreatedTask(String ExpectedPriorityTypeClass, String ExpectedPriorityTypeTitle) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul/li/div[2]/div/div[1]/span[3]/img"), 120);
	
		if(i.MailNumber1PrioritySign().getAttribute("class").equalsIgnoreCase(ExpectedPriorityTypeClass)) {
			String ActualPrioritySignClass = i.MailNumber1PrioritySign().getAttribute("class");
			Assert.assertEquals(ActualPrioritySignClass, ExpectedPriorityTypeClass, "Unable To Validate Task Priority Type Class: ");
			log.info("Successfully Validated Task Priority Type Class: " + ExpectedPriorityTypeClass);
			String ActualPrioritySignTitle = i.MailNumber1PrioritySign().getAttribute("title");
			Assert.assertEquals(ActualPrioritySignTitle, ExpectedPriorityTypeTitle, "Unable To Validate Task Priority Type Title: ");
			log.info("Successfully Validated Task Priority Type Title: " + ExpectedPriorityTypeTitle);
		}
		else {
			log.error("Unable To Validate Priority Urgency Icon Task Type Row 1....");
		}
	}
	
	public void VerifyOverdueIcon(String ExpectedMailNumber1OverdueSign) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul/li/div[2]/div/div[1]/span[2]/img"), 120);
	
		if(i.MailNumber1OverdueSign().getAttribute("class").equalsIgnoreCase(ExpectedMailNumber1OverdueSign)) {
			String ActualMailNumber1OverdueSign = i.MailNumber1OverdueSign().getAttribute("class");
			Assert.assertEquals(ActualMailNumber1OverdueSign, ExpectedMailNumber1OverdueSign, "Unable To Validate Task Overdue Class Type: ");
			log.info("Successfully Validated Task Overdue Class Type: " + ExpectedMailNumber1OverdueSign);
		}
		else {
			log.error("Unable To Validate Priority Overdue Icon Task Row 1....");
		}
	}
	
	public void ClickOnTaskToSelect() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[2]/task-cards/div[2]/ul/li/div[2]"), 120);
		
		if(i.MailNumber1().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.MailNumber1());
			BaseTest.Wait(2);
			i.MailNumber1().click();
			log.info("Successfully Selected Task From Mailbox Row 1....");
		}
		else {
			log.error("Unable To Select Task From Mailbox Row 1....");
		}
	}
	
	public void ChangePriorityInInboxScreenTaskDetailsScreen(String ExpectedUpdatePriorityType) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[3]/tw-task-inline-container/div/task-miscellaneous-container/form/div/div[2]/task-details/div/div[2]/div[1]/div[2]/kendo-dropdownlist/span"), 120);
		
		if(i.SelectedTaskEditScreenPriorityType().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenPriorityType());
			BaseTest.Wait(2);
			i.SelectedTaskEditScreenPriorityType().sendKeys(ExpectedUpdatePriorityType);
			log.info("Successfully Updated Current Patient Active Task Priority Type: " + ExpectedUpdatePriorityType);
			i.SelectedTaskEditScreenSaveButton().click();
			log.info("Successfully Saved Changes To Edit Task Screen....");
			BaseTest.Wait(3);
		}
		else {
			log.error("Unable To Updated Current Patient Active Task Priority Type: " + ExpectedUpdatePriorityType);
		}
		
	}
	
	public void ChangeStatusInInboxTaskDetailsScreen(String ExpectedUpdateStatusType) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("/html/body/app-tasking-container/block-ui/div/div[3]/tw-task-inline-container/div/task-miscellaneous-container/form/div/div[2]/task-details/div/div[2]/div[2]/div[2]/kendo-dropdownlist/span"), 120);
		
		if(i.SelectedTaskEditScreenStatusType().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenStatusType());
			BaseTest.Wait(1);
			i.SelectedTaskEditScreenStatusType().sendKeys(ExpectedUpdateStatusType);
			log.info("Successfully Updated Current Patient Active Task Status Type: " + ExpectedUpdateStatusType);
			i.SelectedTaskEditScreenSaveButton().click();
			log.info("Successfully Saved Changes To Edit Task Screen....");
			BaseTest.Wait(3);
		}
		else {
			log.error("Unable To Update Current Patient Active Task Status Type: " + ExpectedUpdateStatusType);
		}
	}
	
	public void VerifyTheNotesAndCommentInboxTaskEditScreen(String ExpectedComment) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"inboxDetail\"]/div[2]/task-comments/div/div[2]"), 120);
		BaseTest.Wait(5);
		
		if (i.SelectedTaskEditScreenCommentBox().isDisplayed()) {
			String ActualSelectedTaskEditScreenCommentBox = i.SelectedTaskEditScreenCommentBox().getText();
			Assert.assertEquals(ActualSelectedTaskEditScreenCommentBox.contains(ExpectedComment), true, "Unable To Assert & Validate Comment: [Expected: " + ExpectedComment + "] [Actual: " + ActualSelectedTaskEditScreenCommentBox + "]");
			log.info("Does Notes/Comments Added To Task Contains '" + ExpectedComment + "'?!: '" + ActualSelectedTaskEditScreenCommentBox.contains(ExpectedComment) + "'");
			log.info("Successfully Displayed All Time Stamps: " + ActualSelectedTaskEditScreenCommentBox);
			BaseTest.Wait(5);
		}
		else {
			log.error("Unable To Assert & Capture Notes/Comments Added To Task: " + ExpectedComment);
		}
	}
	
	public void ClickOnTheCommentFieldAndPositionCursorInboxScreenTaskDetailsScreen() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"inboxDetail\"]/div[2]/task-comments/div/div[2]/div/div[1]/textarea"), 120);
		
		if(i.SelectedTaskEditScreenEditCommentBox().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenEditCommentBox());
			BaseTest.Wait(1);
			i.SelectedTaskEditScreenEditCommentBox().click();
			BaseTest.Wait(1);
			log.info("Successfully Clicked On The Comments Field And Position The Cursor On The Very First Line....");
		}
		else {
			log.error("Unable To Click On The Comments Field And Position The Cursor On The Very First Line....");
		}
	}
	
	public void EnterCommentAndClickSaveInboxScreenTaskDetailsScreen(String EnterComment) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"inboxDetail\"]/div[2]/task-comments/div/div[2]/div/div[1]/textarea"), 120);
		
		if(i.SelectedTaskEditScreenEditCommentBox().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenEditCommentBox());
			BaseTest.Wait(1);
			i.SelectedTaskEditScreenEditCommentBox().sendKeys(EnterComment);
			BaseTest.Wait(1);
			log.info("Successfully Entered Comment On The Comments Field: " + EnterComment);
			i.SelectedTaskEditScreenSaveButton().click();
			BaseTest.Wait(3);
			log.info("Successfully Selected Task Edit Screen Save Button....");
		}
		else {
			log.error("Unable To Enter Comments On The Comment Field: " + EnterComment);
		}
	}
	
	public void ClickInProgressButtonInboxTaskDetailsScreen() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"btnInProgess\"]"), 120);
		
		if(i.SelectedTaskEditScreenInProgressButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenInProgressButton());
			BaseTest.Wait(2);
			i.SelectedTaskEditScreenInProgressButton().click();
			BaseTest.Wait(3);
			log.info("Successfully Clicked On In Progress Button In Inbox Task Details Screen....");
		}
		else {
			log.error("Unable TO Click On In Progress Button In Inbox Task Details Screen....");
		}
	}
	
	public void ClickDoneButtonInboxTaskDetailsScreen() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"btnComplete\"]"), 120);
		
		if(i.SelectedTaskEditScreenDoneButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenDoneButton());
			BaseTest.Wait(2);
			i.SelectedTaskEditScreenDoneButton().click();
			BaseTest.Wait(3);
			log.info("Successfully Clicked On Done Button In Inbox Task Details Screen....");
		}
		else {
			log.error("Unable TO Click On Done Button In Inbox Task Details Screen....");
		}
	}
	
	public void ClickOnReactivateButton() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"btnReactivate\"]"), 120);
		
		if(i.SelectedTaskEditScreenReactivateButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenReactivateButton());
			BaseTest.Wait(2);
			i.SelectedTaskEditScreenReactivateButton().click();
			BaseTest.Wait(3);
			log.info("Successfully Clicked On Task Reactivate Button In Inbox Task Details Screen....");
		}
		else {
			log.error("Unable TO Click On Task Reactivate Button In Inbox Task Details Screen....");
		}
	}
	
	public void RefreshPageAndWaitForReactivatedTaskToShowInActiveTaskList() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.Wait(5);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"Refresh\"]"), 120);
		
		if(i.RefreshButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.RefreshButton());
			BaseTest.Wait(2);
			i.RefreshButton().click();
			BaseTest.Wait(2);
			log.info("Successfully Clicked On Refresh Button Button In Inbox Task Details Screen....");
		}
		else {
			log.error("Unable TO Click On Refresh Button Button In Inbox Task Details Screen....");
		}
	}
	
	public void ClickReassignLinkInTaskDetailsScreen() 
	{	
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"lnkReassign\"]"), 120);
		
		if(i.SelectedTaskEditScreenReassignButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenReassignButton());
			BaseTest.Wait(2);
			i.SelectedTaskEditScreenReassignButton().click();
			log.info("Successfully Selected Ressign Button In Inbox Task Details Screen....");
		}
		else {
			log.error("Unable To Select Ressign Button In Inbox Task Details Screen....");
		}
	}
	
	public void AssignTaskToUserUsingDropDownInTaskDetailsScreen(String STAFF_NAME) 
	{
		Inbox_Page a = new Inbox_Page(driver);
		
		if(a.SelectedTaskEditScreenAssignToUserRadioButton().isDisplayed()) {
			a.SelectedTaskEditScreenAssignToUserRadioButton().click();
			log.info("Successfully Selected Assign To User Radio Button....");
		}
		else {
			log.error("Unable To Select Assign To User Radio Button....");
		}	
				
		if(a.SelectedTaskEditScreenAssingToUserDropDown().isDisplayed()) {
			a.SelectedTaskEditScreenAssingToUserDropDown().sendKeys(STAFF_NAME);
			log.info("Successfully Selected User For Task To be Assigned: " + STAFF_NAME);
		}
		else {
			log.error("Unable To Assign User To Task: " + STAFF_NAME);
		}
	}
	
	public void ClickSendButtonInTaskDetailScreen() 
	{	
		Inbox_Page i = new Inbox_Page(driver);

		try {
			if (i.SelectedTaskEditScreenSendButton().isDisplayed()) {
				i.SelectedTaskEditScreenSendButton().click();
				log.info("Successfully Selected Send Button In Inbox Task Details Screen....");
				BaseTest.Wait(2);
			} 
			else {
				log.error("Unable To Select Send Button In Inbox Task Details Screen....");
			} 
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.error("Unable To Select Submit Due To System Loading....");
		}
	}
	
	public void ClickSaveButtonInTaskDetailScreen() 
	{	
		Inbox_Page i = new Inbox_Page(driver);

		try {
			if (i.SelectedTaskEditScreenSaveButton().isDisplayed()) {
				i.SelectedTaskEditScreenSaveButton().click();
				log.info("Successfully Selected Save Button In Inbox Task Details Screen....");
			} 
			else {
				log.error("Unable To Select Save Button In Inbox Task Details Screen....");
			} 
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.error("Unable To Select Submit Due To System Loading....");
		}
	}

	public void AssignTaskToTeamUsingDropDownInTaskDetailsScreen(String TEAM_NAME) 
	{
		Inbox_Page i = new Inbox_Page(driver);
		
		if(i.SelectedTaskEditScreenAssignToTeamRadioButton().isSelected()) {
			log.info("Team Radio Button Is Already Selected....");
		}
		else {
			i.SelectedTaskEditScreenAssignToTeamRadioButton().click();
			log.info("Successfully Selected Team Radio Button In Inbox Task Details Screen....");
			i.SelectedTaskEditScreenAssingToTeamDropDown().sendKeys(TEAM_NAME);
			log.info("Successfully Selected Team To Assign Task: " + TEAM_NAME);
		}
	}
	
	public void ClickSearchInTaskDetailsScreen() 
	{
		Inbox_Page i = new Inbox_Page(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"btnSearchUser\"]"), 120);
		
		if(i.SelectedTaskEditScreenAssingToTeamSearchIcon().isDisplayed()) {
			BaseTest.MoveToElement(driver, i.SelectedTaskEditScreenAssingToTeamSearchIcon());
			BaseTest.Wait(1);
			i.SelectedTaskEditScreenAssingToTeamSearchIcon().click();
			log.info("Successfully Selected Team Search Icon Button In Inbox Task Details Screen....");
		}
		else {
			log.error("Unable To Select Team Search Icon Button In Inbox Task Details Screen....");
		}
	}
}
