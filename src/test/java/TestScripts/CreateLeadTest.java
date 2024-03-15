package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateLeadTest extends BaseClass {
@Test
public void createNewLeadTest() throws InterruptedException {
	home.clickLeads();
	leads.clickplusButton();
	soft.assertEquals(createLead.getpageHeader(), "Creating New Lead");
	Map<String, String> map=excel.readFromExcel("Create lead", "LeadsTestData");
	String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
	createLead.setLastName(lastName);
	createLead.setCompany(map.get("Company"));
	createLead.clickSave();
	Thread.sleep(3000);
	soft.assertTrue(newLead.getpageHeader().contains(lastName));
	newLead.clickLeadsLink();
	if(leads.getNewLeadName().equals(lastName)) {
		System.out.println("Test pass");
		excel.updateTestStatus("Create lead", "pass", IConstantpath.EXCEL_PATH, "LeadsTestData");
	}
	else
	{
		System.out.println("Test Fail");
		excel.updateTestStatus("Create lead", "Fail", IConstantpath.EXCEL_PATH, "LeadsTestData");
		
	}
	soft.assertEquals(leads.getNewLeadName(), leads);
	soft.assertAll();
}
}
	
	
	



