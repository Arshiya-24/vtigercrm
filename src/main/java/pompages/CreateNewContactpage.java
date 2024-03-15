package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class CreateNewContactpage {
	
	// Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name = "lastname")
	private WebElement lastNameTF;
	@FindBy(xpath = "//img[contains(@onclick, 'Accounts')]")
	private WebElement orgPlusButton;
	@FindBy(xpath = "//input[normalize-space(@value)='Save']")
	private WebElement saveButton;

	private String orgpath = "//a[text()='%s']";

	// Initialization
	public CreateNewContactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}
	public void setLastName(String contactName) {
		lastNameTF.sendKeys(contactName);
	}
public void selectExistingOrg(WebDriverUtility web, String orgName) {
	orgPlusButton.click();
	web.switchToChildBrowser();
	web.convertPathToWebelement(orgpath, orgName).click();
	web.switchToWindow(web.getParentWindow());
}
public void clickSave() {
	saveButton.click();
}
}



	
	

