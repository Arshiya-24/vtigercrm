package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateContactTest extends BaseClass {
	@Test
	public void createNewContactTest() throws InterruptedException {
		home.clickContacts();
		soft.assertEquals(contact.getpageHeader(), "Contacts");
		Thread.sleep(3000);
		contact.clickplusButton();
		soft.assertEquals(createContact.getpageHeader(), "Creating New Contact");
		Map<String, String>map=excel.readFromExcel("Create Contact", "ContactsTestData");
		String contactName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(contactName);
		createContact.clickSave();
		soft.assertTrue(newContact.getpageHeader().contains(contactName));
		Thread.sleep(3000);
		newContact.clickContactsLink();
		if(contact.getNewcontactName().equals(contactName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Contact", "Fail", IConstantpath.EXCEL_PATH, "ContactsTestData");
		}
		else
		{
			System.out.println("test fail");
			excel.updateTestStatus("Create Contact", "Fail", IConstantpath.EXCEL_PATH, "ContactsTestData");
		}
		soft.assertTrue(contact.getpageHeader().contains(contactName));
		soft.assertAll();
		
		}
	}


