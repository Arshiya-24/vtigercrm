package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateAndDuplicateLeadTest extends BaseClass {
	@Test
	public void createAndDuplicateLeadTest() throws InterruptedException {
		home.clickLeads();
		soft.assertEquals(leads.getpageHeader(), "Leads");
		leads.clickplusButton();
		soft.assertEquals(createLead.getpageHeader(), "Creating New Lead");
		Map<String, String>map=excel.readFromExcel("Create and Duplicate Lead", "LeadTest");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newLead.getpageHeader().contains(lastName));
		newLead.clickDuplicate();
		soft.assertTrue(duplicateLead.getpageHeader().contains("Duplicating"));
		String newLastName=map.get("New LastName")+jutil.generateRandomNum(100);
		duplicateLead.setNewLastName(newLastName);
		duplicateLead.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newLead.getpageHeader().contains(newLastName));
		newLead.clickLeadsLink();
		if(leads.getNewLeadName().equals(newLastName)) {
			System.out.println("Test pass");
			excel.updateTestStatus("Create and Duplicate Lead", "pass", IConstantpath.EXCEL_PATH, "DuplicateLeadsTestData");
		}
	}
}
		
	
