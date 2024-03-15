package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Event;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateEventTest extends BaseClass {
	@Test
	public void createNewEventTest() throws InterruptedException {
		Map<String, String> map=excel.readFromExcel("Create New Event", "EventsTestData");
		home.selectFromQuickCreate(web, map.get("Quick Create"));
		soft.assertEquals(createEvent.getpageHeader(), "Create To Do");
		String subject=map.get("Subject")+jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.setStartDate(map.get("Start Date"));
		createEvent.setenddate(map.get("Due Date"));
		Thread.sleep(2000);
		createEvent.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newEvent.getpageHeader().contains(subject));

		
	if(newEvent.getpageHeader().contains(subject)) {
			System.out.println("Test pass");
			excel.updateTestStatus("Create New Event", "pass", IConstantpath.EXCEL_PATH, "EventsTestData");
		}
		else
		{
			System.out.println("Test Fail");
			excel.updateTestStatus("Create New Event", "pass", IConstantpath.EXCEL_PATH, "EventsTestData");
		}
	
	}
	}
