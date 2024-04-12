package testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo extends BaseTest {

	public static String FirstName;
	public static String LastName;
	public static String Email;
	public static String Password;

	@Test
	public void demo() throws InvalidFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		homePage.navigateToHomePage();
		homePage.clickSignIn();
		loginPage.enterRegisteredEmail("asdasd@gmail.com");
		loginPage.enterRegisteredPassword("HELLO@AWE");
		loginPage.clickSignInButton();

		String invalidLoginActual = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		Assert.assertEquals(invalidLoginActual, loginPage.incorrectLoginMethod(), "");
		Assert.assertTrue(invalidLoginActual.equals(loginPage.incorrectLoginMethod()), "");
		;
	}

}
