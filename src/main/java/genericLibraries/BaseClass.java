package genericLibraries;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pompages.Contactspage;
import pompages.CreateNewContactpage;
import pompages.CreateNewEventPage;
import pompages.CreateNewLeadPage;
import pompages.CreateNewOrganizationpage;
import pompages.DuplicatingLeadpage;
import pompages.Homepage;
import pompages.Leadspage;
import pompages.Loginpage;
import pompages.NewContactDetailspage;
import pompages.NewEventDetailsPage;
import pompages.NewLeadDetailsPage;
import pompages.NewOrgDetailspage;
import pompages.Organizationspage;

public class BaseClass {
	//@BeforeSuite
	//@BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;
	
	protected WebDriver driver;
	protected SoftAssert soft;
	protected Loginpage login;
	protected Homepage  home;
	protected Organizationspage org;
	protected Contactspage contact;
	protected Leadspage leads;
	protected CreateNewOrganizationpage createOrg;
	protected CreateNewContactpage createContact;
	protected CreateNewLeadPage createLead;
	protected CreateNewEventPage createEvent;
	protected DuplicatingLeadpage duplicateLead;
	protected NewOrgDetailspage newOrg;
	protected NewContactDetailspage newContact;
	protected NewLeadDetailsPage newLead;
	protected NewEventDetailsPage newEvent;
	
	
	
	@BeforeClass
	public void classSetup() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		web=new WebDriverUtility();
		jutil=new JavaUtility();
		
		property.propertiesInit(IConstantpath.PROPERTIES_PATH);
		driver=web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
	
	
	}
	@BeforeMethod
	public void methodsetup() {
		login=new Loginpage(driver);
		home=new Homepage(driver);
		org=new Organizationspage(driver);
		contact=new Contactspage(driver);
		leads=new Leadspage(driver);
		createOrg=new CreateNewOrganizationpage(driver);
		createContact=new CreateNewContactpage(driver);
		createLead=new CreateNewLeadPage(driver);
		createEvent=new CreateNewEventPage(driver);
		newOrg=new NewOrgDetailspage(driver);
		newContact=new NewContactDetailspage(driver);
		newLead=new NewLeadDetailsPage(driver);
		newEvent=new NewEventDetailsPage(driver);
				
		duplicateLead=new DuplicatingLeadpage(driver);
		soft=new SoftAssert();
		
		excel.excelInit(IConstantpath.EXCEL_PATH);
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "vtiger");
		login.loginToVtiger(property.readFromProperties("username"),
		                    property.readFromProperties("password"));
		Assert.assertTrue(home.getpageHeader().contains("Home"));
		
	}
	
		//@AfterMethod	
		//@AfterClass
		public void classTearDown()
		{
			home.signOutOfApp(web);
			excel.closeExcel();
		}
		//@AfterSuite
		//@AfterTest
		}

	
		


		
		
		
		

		
	
	
	
		
		
	


