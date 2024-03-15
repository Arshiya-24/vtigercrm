package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateOrgTest extends BaseClass{
@Test
public void createNewOrgTest() throws InterruptedException 
{
	home.clickOrganizations();
	//soft.assertEquals(org.getpageHeader(), "Organizations");
	org.clickplusButton();
	soft.assertEquals(createOrg.getpageHeader(), "Creating New Organization");
	Map<String,String>map=excel.readFromExcel("Create Organization", "OrganizationsTestData");
	String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
	createOrg.setOrgName(orgName);
	createOrg.clickSave();
	Thread.sleep(3000);
	soft.assertTrue(newOrg.getpageHeader().contains(orgName));
	newOrg.clickOrgLink();
	
	
	if(org.getNewOrgName().equals(orgName)) {
		System.out.println("test pass");
		excel.updateTestStatus("Create Organization", "pass",IConstantpath.EXCEL_PATH,"OrganizationsTestData");
	}
	else {
	
		System.out.println("test fail");
		excel.updateTestStatus("Create Organization", "Fail",IConstantpath.EXCEL_PATH,"OrganizationsTestData");
	}
	soft.assertEquals(org.getNewOrgName(), orgName);
	soft.assertAll();
}
}





	
	

