package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;
import pompages.Contactspage;

public class CreateContactWithExistingOrgTest extends BaseClass{
	
	@Test
public void createContactWithOrgTest() throws InterruptedException {
		home.clickContacts();
		soft.assertEquals(contact.getpageHeader(), "Contacts");
		contact.clickplusButton();
		soft.assertEquals(createContact.getpageHeader(), "Creating New Contact");
		Map<String, String> map=excel.readFromExcel("Create Contact With Organization", "ContactsTestData");
				String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.selectExistingOrg(web, map.get("Organization Name"));
		createContact.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newContact.getpageHeader().contains("contact"));
		newContact.clickContactsLink();
		if(contact.getNewcontactName().equals(lastName)) {
			System.out.println("Test pass");
			excel.updateTestStatus("Create Contact With Organization", "Pass", IConstantpath.EXCEL_PATH, "ContactsTestData");
		}
		else
		{
			System.out.println("Test Fail");
			excel.updateTestStatus("Create Contact With Organization", "Fail", IConstantpath.EXCEL_PATH, "ContactsTestData");
		}
		soft.assertEquals(contact.getNewcontactName(), contact);
		soft.assertAll();
		}
	}

