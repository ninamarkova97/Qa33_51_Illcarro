import models.User;
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
    public void loginSuccses1() {
        User user = new User().setEmail("lolik@mail.ru").setPassword("Lolik123!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccses() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolik@mail.ru", "Lolik123!");
        app.getHelperUser().submit();

//Assert -->if element with text "logged in succses" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        // app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccsesModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolik@mail.ru", "Lolik123!");
        app.getHelperUser().submit();

//Assert -->if element with text "logged in succses" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        // app.getHelperUser().clickOkButton();
    }


    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolikmail.ru", "Lolik123!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lolik@mail.ru", "Lolik123");
        app.getHelperUser().submit();
        //Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("jhgfccgv@ru", "Ljul!234");
        app.getHelperUser().submit();
        //Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }


    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}