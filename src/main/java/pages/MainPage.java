package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "My Store";
        this.PAGE_URL = "http://automationpractice.com/index.php";
    }

    @FindBy(xpath = "//a[@class = 'login']")
    WebElement signInButton;

    public void clickSignInButton() {
        clickElement(signInButton);
    }
}
