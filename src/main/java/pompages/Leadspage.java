package pompages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class Leadspage {
	//Declaration
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//img[@alt='Create Lead...']")
	private WebElement plusButton;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement newLeadLink;
	
	private String leadCheckboxpath="//a[text()='%s']/ancestor::tr[@class='lvtColData']/descendant::input";
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButton;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr/td[3]/a")
	private List<WebElement> leadNames;

//Initialization
public Leadspage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Utilization
public String getpageHeader() {
	return pageHeader.getText();
}
public void clickplusButton() {
	plusButton.click();
}
public String getNewLeadName() {
	return newLeadLink.getText();
}
public void deleteLead(WebDriverUtility web, String leadName) {
	web.convertPathToWebelement(leadCheckboxpath, leadName).click();
	deleteButton.click();
}
public boolean searchLeadName(String leadname)
{
	boolean status=false;
	for(WebElement name:leadNames)
	{
		if(name.getText().equals(leadname))
		{
			status=true;
			break;
		}
	}
	return status;
}

	
}
	
	

	
	


