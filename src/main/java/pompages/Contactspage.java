package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {
	// Declaration
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement pageHeader;

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement plusButton;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td[4]/a")
	private WebElement newContactLink;

	// Initialization
	public Contactspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}

	public void clickplusButton() {
		plusButton.click();
	}

	public String getNewcontactName() {
		return newContactLink.getText();

	}

	

}
