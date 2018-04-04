package tests;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestSignin extends TestBase{
	
	@BeforeClass
	public void classSetUpu(){
		menuBar.siginLink.click();
	}
	
	@Test
	public void testSigninWithValidEmailAndPassword(){
		signinPage.Signin("shakil_ipe@yahoo.com", "365827");
		
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertTrue(currentUrl.contains("/profile"));
		
		menuBar.logoutLink.click();
		menuBar.siginLink.click();
	}
	
	@Test
	public void testSigninWithEmptyEmailAndEmptyPassword(){
		signinPage.Signin("", "");
		
		String errorEmail = signinPage.errorElementList.get(0).getText();
		String errorPassword = signinPage.errorElementList.get(1).getText();
		
		Assert.assertEquals(errorEmail, "* Email can not be empty.");
		Assert.assertEquals(errorPassword, "* Password can not be empty.");
	}
	@Test
	public void testSigninWithInvalidEmailAndValidPAssword(){
		signinPage.Signin("shakil_ip@yahoo.com", "365827");
		
		String errorEmail = signinPage.errorElementList.get(0).getText();
		
		Assert.assertEquals(errorEmail, "* Email or Password is incorrect.");
	}
	@Test
	public void testWithValidEmailAndInvalidPassword(){
		signinPage.Signin("shakil_ipe@yahoo.com", "36582");
		
		String errorPassword = signinPage.errorElementList.get(1).getText();
		
		Assert.assertEquals(errorPassword, "*");
	}
	@Test
	public void testWithInvalidEmailAndInvalidPassowd(){
		signinPage.Signin("shakil_ip@yahoo.com", "36582");
		
		String errorEmail = signinPage.errorElementList.get(0).getText();
		String errorPasswod = signinPage.errorElementList.get(1).getText();
		
		Assert.assertEquals(errorEmail, "* Email or Password is incorrect.");
		Assert.assertEquals(errorPasswod, "*");
	}
}
