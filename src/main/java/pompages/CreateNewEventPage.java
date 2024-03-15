package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewEventPage {
	
	//Declaration
	@FindBy(xpath="//b[text()='Create To Do']")
	private WebElement 	pageHeader;
	@FindBy(name="subject")
	private WebElement subjectTF;
	@FindBy(id="jscal-field-date-start")
	private WebElement startDateTF;
	@FindBy(id="jscal-field-due-date")
	private WebElement endDateTF;
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveButton;
	//Initialization
	public CreateNewEventPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}
	public void setSubject(String subject) {
		subjectTF.sendKeys(subject);
	}
	public void setStartDate(String date) {
		startDateTF.sendKeys(date);
		
	}
	public void setenddate(String date) {
		endDateTF.sendKeys(date);
		
}
	
	public void clickSave() {
		saveButton.click();
		
	}
}
	


