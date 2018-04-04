package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class RegisterPage extends PageBase{
	
	@FindBy(name = "FirstName")
	public WebElement firstNameField;
	
	@FindBy(name = "LastName")
	public WebElement lastNameField;
	
	@FindBy(name = "Gender")
	public WebElement genderDropDownList;
	
	@FindBy(name = "DateOfBirth")
	public WebElement dateOfBirthField;
	
	@FindBy(name = "PhoneNo")
	public WebElement phoneNoField;
	
	@FindBy(name = "UserType")
	public WebElement userTypeField;
	
	@FindBy(id = "error")
	public List<WebElement> errorElementList;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	// supporting method
	public void WriteDataAndSubmit(WebElement element,String value){
		element.clear();
		element.sendKeys(value);
		
		submitButton.click();
	}

}
