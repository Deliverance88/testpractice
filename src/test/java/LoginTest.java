import data.AutomationPracticeData;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import utilities.DriverFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    public WebDriver driver;
    DriverFactory.BrowserType type = DriverFactory.BrowserType.CHROME;
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp () throws Exception {
        this.driver = DriverFactory.getDriver(type, true);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Parameters({"language", "browser"})
    @Test(groups = {"homePage"}, enabled = false)
    public void loadPage(@Optional("en") String language, @Optional("Firefox") String browser) {
        System.out.println("Language: " + language);
        System.out.println("Browser: " + browser);
        mainPage.getPageUrl();
    }

    @Test(dependsOnMethods = "loadPage", groups = {"homePage"},enabled = false)
    public void clickSigninButton() {
        mainPage.clickSignInButton();
    }

    @Test(dependsOnMethods = "clickSigninButton", groups = {"homePage"}, enabled = false)
    public void fillEmail() {
        loginPage.fillEmail("test@gmail.com");
    }

    @Test(dependsOnMethods = "fillEmail", groups = {"homePage"}, enabled = false)
    public void fillPassword() {
        loginPage.fillPassword("password1");
    }

    @Test(dependsOnMethods = "fillPassword", groups = {"homePage"}, enabled = false)
    public void clickSubmitButton() {
        loginPage.clickSubmitButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProviderClass = AutomationPracticeData.class, dataProvider = "login")
    public void invalidLoginTest(String email, String password, String errormessage) {
        mainPage.loadPage();
        mainPage.clickSignInButton();
        assertEquals(driver.getTitle(), loginPage.PAGE_TITLE);
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickSubmitButton();
        loginPage.checkErrorMessage(errormessage);
    }
}