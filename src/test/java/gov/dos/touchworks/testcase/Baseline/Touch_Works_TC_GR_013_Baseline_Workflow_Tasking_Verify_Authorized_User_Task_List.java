package gov.dos.touchworks.testcase.Baseline;

import org.testng.annotations.Test;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.TouchWorks.PageFactory.Inbox_Page.Inbox_Page;
import gov.dos.TouchWorks.Steps.Inbox_Page.Inbox_Tab_Steps;
import gov.dos.TouchWorks.Steps.Main_Menu_Page.Touch_Works_Main_Menu_Steps;
import gov.dos.TouchWorks.Steps.Patient_Search_Screen.Touch_Works_Patient_Seach_Screen_Steps;

public class Touch_Works_TC_GR_013_Baseline_Workflow_Tasking_Verify_Authorized_User_Task_List extends BaseTest {
	protected String PATIENTS_LAST_NAME = "Allscripts";
	protected String PATIENTS_FIRST_NAME = "Douglas";
	protected String TASK_NAME_SIGN_NOTE = "Sign-Note";
	protected String TASK_NAME_CALL_BACK = "Call Back";
	protected String TASK_NAME_DOC_APPT = "Document Appointment";
	protected String TASK_NAME_MEDICAL_COMPLAINT = "Medical Complaint Callback";
	protected String TASK_NAME_NOTIFY_OVERDUE = "Notify Overdue";
	protected String TASK_NAME_NOTIFY_COMPLETE = "Notify Complete";
	
	@Test()
	public void VerifyAuthorizedUserTaskList() {
		Touch_Works_Patient_Seach_Screen_Steps Touch_Works_Patient_Seach_Screen_Steps = new Touch_Works_Patient_Seach_Screen_Steps(driver);
		Touch_Works_Main_Menu_Steps Touch_Works_Main_Menu_Steps = new Touch_Works_Main_Menu_Steps(driver);
		Inbox_Tab_Steps Inbox_Tab_Steps = new Inbox_Tab_Steps(driver);
		Inbox_Page Inbox_Page = new Inbox_Page(driver);
		
		Touch_Works_Patient_Seach_Screen_Steps.SearchForPatient();
		Touch_Works_Patient_Seach_Screen_Steps.EnterPatientSearchKeyword(PATIENTS_LAST_NAME);
		Touch_Works_Patient_Seach_Screen_Steps.SelectPatientAndSelectOKButton();
		Touch_Works_Main_Menu_Steps.NavigateToInbox();
		Inbox_Tab_Steps.SwitchToTaskingWorkSpaceIFrame();
		Inbox_Tab_Steps.VerifyInboxIsDefaultedToTaskView();
		Inbox_Tab_Steps.VerifyTaskCountIsDisplayedFromMyActiveTasks(TASK_LIST_COUNT_2);
		Inbox_Tab_Steps.ExpandMyActiveTasksAndVerifyIndividualTasks(Inbox_Page.MyActiveTaskRow1());
		Inbox_Tab_Steps.ExpandMyActiveTasksAndVerifyIndividualTasks(Inbox_Page.MyActiveTaskRow1Count());
		Inbox_Tab_Steps.VerifyPresenceOfCurrentPatientInActiveTaskGroup();
		Inbox_Tab_Steps.VerifyTaskCountIsDisplayedForCurrentPatientForActiveTaskGroup();
		Inbox_Tab_Steps.ExpandOrCollapseActiveTasksForCurrentPatient();
		Inbox_Tab_Steps.VerifyIndividualTaskForCurrentPatientActiveTasks(TASK_NAME_CALL_BACK);
		Inbox_Tab_Steps.VerifyIndividualTaskForCurrentPatientActiveTasks(TASK_NAME_DOC_APPT);
		Inbox_Tab_Steps.VerifyIndividualTaskForCurrentPatientActiveTasks(TASK_NAME_MEDICAL_COMPLAINT);
		Inbox_Tab_Steps.VerifyIndividualTaskForCurrentPatientActiveTasks(TASK_NAME_NOTIFY_OVERDUE);
		Inbox_Tab_Steps.ExpandOrCollapseActiveTasksForCurrentPatient();
		Inbox_Tab_Steps.VerifyPresenceOfCurrentPatientInAllTaskGroup();
		Inbox_Tab_Steps.VerifyTaskCountIsDisplayedForCurrentPatientsAllTaskGroup();
		Inbox_Tab_Steps.ExpandOrCollapseAllTasksForCurrentPatient();
		Inbox_Tab_Steps.VerifyIndividualTasksForCurrentPatientAllTaskList(TASK_NAME_CALL_BACK);
		Inbox_Tab_Steps.VerifyIndividualTasksForCurrentPatientAllTaskList(TASK_NAME_DOC_APPT);
		Inbox_Tab_Steps.VerifyIndividualTasksForCurrentPatientAllTaskList(TASK_NAME_MEDICAL_COMPLAINT);
		Inbox_Tab_Steps.VerifyIndividualTasksForCurrentPatientAllTaskList(TASK_NAME_NOTIFY_COMPLETE);
		Inbox_Tab_Steps.VerifyIndividualTasksForCurrentPatientAllTaskList(TASK_NAME_NOTIFY_OVERDUE);
		Inbox_Tab_Steps.ExpandOrCollapseAllTasksForCurrentPatient();
	}
}
