package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class CreateAndDeleteLeadTest extends BaseClass {
	@Test
	public void createAndDeleteLeadTest() throws InterruptedException {
		home.clickLeads();
		soft.assertEquals(leads.getpageHeader(), "Leads");
		leads.clickplusButton();
		soft.assertEquals(createLead.getpageHeader(), "Creating New Lead");
		Map<String, String>map=excel.readFromExcel("Dlete lead", "LeadsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newLead.getpageHeader().contains(lastName));
		newLead.clickLeadsLink();
		Thread.sleep(2000);
		leads.deleteLead(web, lastName);
		web.handleAlert("OK");
		Thread.sleep(2000);
		soft.assertFalse(leads.searchLeadName(lastName));
		soft.assertAll();
	}
	

}
