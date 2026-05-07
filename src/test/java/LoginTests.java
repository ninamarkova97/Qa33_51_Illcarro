import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void loginSuccses() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolik@mail.ru", "Lolik123!");
        app.getHelperUser().submitLogin();

//Assert -->if element with text "logged in succses" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccsesModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolik@mail.ru", "Lolik123!");
        app.getHelperUser().submitLogin();

//Assert -->if element with text "logged in succses" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        // app.getHelperUser().clickOkButton();
    }


    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolikmail.ru", "Lolik123!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isButtonDisabledPresent());
    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolik@mail.ru", "Lolik123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));

    }

    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("jhgfccgv@ru", "Lolik123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
    }


    @AfterMethod
    public void postCondition() {
        if (app.getHelperUser()
                .isElementPresent(By.xpath("//button[text()='Ok']"))) {

            app.getHelperUser().clickOkButton();
        }
    }
}