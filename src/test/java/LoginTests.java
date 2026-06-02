import manager.DataProviderUser;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");
        }
    }


    @Test(dataProvider = "loginSuccess1", dataProviderClass = DataProviderUser.class)
    public void loginSuccess1(String email, String password){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email,password);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
        //app.getHelperUser().clickOkButton();
        logger.info("Assert check is message 'Logged in success' ");
    }

    @Test (dataProvider = "loginSuccess", dataProviderClass = DataProviderUser.class)
    public void loginSuccses(String email, String password) {
        logger.info("Start test with name succses");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email,password);
        app.getHelperUser().submit();

//Assert -->if element with text "logged in succses" is present
      // Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
         //app.getHelperUser().clickOkButton();
        logger.info("Assert check is message 'Logged in success' ");
    }

    @Test(dataProvider = "loginModelSuccess", dataProviderClass = DataProviderUser.class)
    public void loginSuccsesModel(String email, String password) {
        //logger.info("Test data --> email:lolik@mail.ru & password: 'Lolik123!'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();

//Assert -->if element with text "logged in succses" is present
        Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
     //   Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        // app.getHelperUser().clickOkButton();
        logger.info("Assert check is message 'Logged in success' ");

    }


    @Test(dataProvider = "wrongEmail", dataProviderClass = DataProviderUser.class)
    public void loginWrongEmail(String email, String password) {
       // logger.info("Test data --> email:lolikmail.ru & password: 'Lolik123!'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email,password);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        logger.info("Assert check is error text 'It'snot look like email' ");

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");
    }

    @Test (dataProvider = "wrongPassword", dataProviderClass = DataProviderUser.class)
    public void loginWrongPassword(String email, String password) {
        //logger.info("Test data --> email:lolik@mail.ru & password: 'Lolik123'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email,password);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
       // Assert.assertEquals(app.getHelperUser().getMessage(), "Login or Password incorrect");
        logger.info("Assert check is message 'Login or Password incorrect' ");

    }

    @Test (dataProvider = "loginUnregisteredUser", dataProviderClass = DataProviderUser.class)
    public void loginUnregisteredUser(String email, String password) {
        //logger.info("Test data --> email:'jhgfccgv@ru && password: Ljul!234'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email,password);
        app.getHelperUser().submit();
        //Assert.assertTrue(app.getHelperUser().getMessageWrong().contains("Login or Password incorrect"));
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is message 'Login or Password incorrect' ");
    }


    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}