package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class createOrgWithTypeAndIndustryTest extends BaseClass {
	@Test
	public void createorgwithtype() throws InterruptedException {
	
		home.clickOrganizations();
		soft.assertEquals(org.getpageHeader(), "Organizations");
		org.clickplusButton();
		soft.assertEquals(createOrg.getpageHeader(), "Creating New Organization");
		Map<String, String>map=excel.readFromExcel("Create Organization With Industry", "OrganizationsTestData");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.selectIndustry(web, map.get("Industry"));
		createOrg.selectType(web, map.get("Type"));
		createOrg.clickSave();
		Thread.sleep(3000);
		newOrg.clickOrgLink();
		soft.assertTrue(newOrg.getpageHeader().contains(orgName));
		newOrg.clickOrgLink();
		if(org.getNewOrgName().equals(orgName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Organization With Industry","Pass", IConstantpath.EXCEL_PATH, "OrganizationsTestData");
		}
		else
		{
			System.out.println("test fail");
			excel.updateTestStatus("Create Organization With Industry And Type","Fail",IConstantpath.EXCEL_PATH, "OrganizationsTestData");
		}
		

		soft.assertTrue(org.getNewOrgName().contains(orgName));
	soft.assertAll();
		}
}

		
	
	
	

	
	
		
	
		
		
	


