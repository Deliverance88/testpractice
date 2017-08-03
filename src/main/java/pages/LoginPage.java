package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Login - My Store";
        this.PAGE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailFiled;

    @FindBy(xpath = "//input[@id = 'passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id = 'SubmitLogin']")
    WebElement submitButton;

    @FindBy(xpath = "//p[text() = 'There is 1 error']/following::li[1]")
    WebElement authenticationFailedMessage;

    public void fillEmail(String email) {
        setElementText(emailFiled, email);
    }

    public void fillPassword(String password) {
        setElementText(passwordField, password);
    }

    public void clickSubmitButton() {
        clickElement(submitButton);
    }

    public void checkErrorMessage(String errorMessage) {
        wait.until(ExpectedConditions.elementToBeClickable(authenticationFailedMessage));
        checkMessage(authenticationFailedMessage, errorMessage);
    }
}