package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {

	// Declaration
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement pageHeader;

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusButton;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement neworgLink;

	// Initialization
	public Organizationspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}

	public void clickplusButton() {
		plusButton.click();
	}

	public String getNewOrgName() {
		return neworgLink.getText();
	}
}
