package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegister extends TestBase{
	
	@BeforeClass
	public void classSetUp(){
		menuBar.registerLink.click();
	}
	@Test
	public void TestFirstNameWitTwoChar(){
		registerPage.WriteDataAndSubmit(registerPage.firstNameField, "as");
		
		String errorMessage = registerPage.errorElementList.get(0).getText();
		
		Assert.assertEquals(errorMessage, "*");
		
	}
	@Test
	public void testFirstNameWithOneChar(){
		registerPage.WriteDataAndSubmit(registerPage.firstNameField, "a");
		
		String errorMessage = registerPage.errorElementList.get(0).getText();
		
		Assert.assertEquals(errorMessage, "* FirstName can not be less than 2 character.");
	}
	@Test
	public void testFirstNameValidDataWithThirtyChar(){
		registerPage.WriteDataAndSubmit(registerPage.firstNameField, "qwertyuiopasdfghjklzxcvbnmqwer");
		
		String errorMessage = registerPage.errorElementList.get(0).getText();
		
		Assert.assertEquals(errorMessage, "*");
	}
	

}
