package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.DriverSetup;
import pages.BasePage;
import pages.CreateAccountPage;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.CredentialsGenerator;

public class BaseTest {

	// Declaring WebDriver, WebDriverWait, and Actions for browser and user
	// interaction
	protected WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	DriverSetup driverSetup;
	private final String browserName = "chrome";

	// Page Objects representing various pages in the application.
	BasePage basePage;
	HomePage homePage;
	CreateAccountPage createAccountPage;
	MyAccountPage myAccountPage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;

	// Variables to store generated data for testing.
	public String getRandomEmail;
	public String getRandomPassword;
	public String getRandomFirstName;
	public String getRandomLastName;

	public BaseTest() {
		// Generate random data once for the entire test class.

		getRandomPassword = CredentialsGenerator.getRandomPassword1();
		getRandomFirstName = CredentialsGenerator.generateRandomFirstName(5);
		getRandomLastName = CredentialsGenerator.generateRandomLastName(7);
		getRandomEmail = CredentialsGenerator.getRandomEmail();
	}

	@BeforeMethod
	public void setUp() {
		driverSetup = new DriverSetup();
		// Initiate the WebDriver, WebDriverWait and Actions
		driver = driverSetup.initiateDriver(browserName);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		actions = new Actions(driver);

		// Initialize Page Objects
		basePage = new BasePage(driver, wait, actions);
		homePage = new HomePage(driver, wait);
		createAccountPage = new CreateAccountPage(driver, wait);
		myAccountPage = new MyAccountPage(driver, wait);
		loginPage = new LoginPage(driver, wait);
		forgotPasswordPage = new ForgotPasswordPage(driver, wait);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}