package data;

import org.testng.annotations.DataProvider;

public class AutomationPracticeData {

    @DataProvider(name = "login")
    public static Object[][] login() {
        return new Object[][]{
                {"test@gmail.com", "password1", "Authentication failed."},
                {"", "password1", "An email address required."},
                {"test@gmail.com", "", "Password is required."}
        };
    }
}