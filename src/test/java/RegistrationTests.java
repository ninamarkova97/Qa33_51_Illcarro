import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {


    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");

        }
    }

    @Test(dataProvider = "dataRegistrationSuccess", dataProviderClass = DataProviderUser.class)
    public void registrationSuccess(User user) {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("=================");
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);

        logger.info("Start test with name 'registrationSuccess'");
        //User user = new User().setName("Sona").setLastName("Mert").setEmail("mert" + z + "@gmail.com").setPassword("Mert123456!");

      //  logger.info("Test data --> Name: Sona, lastName: Mert, email:'mert" +z+"@gmail.com & password: Mert123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
        logger.info("Assert check is message 'You are logged in success' ");

    }

    @Test (dataProvider = "dataRegistrationEmptyName", dataProviderClass = DataProviderUser.class)
    public void registrationEmptyName(User user) {
     //User user = new User().setName("").setLastName("Mert").setEmail("mert@gmail.com").setPassword("Mert123456!");

       // logger.info("Test data --> Name:, lastName: Mert, email:'mert@gmail.com & password: Mert123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        logger.info("Assert check is message 'Name is required' ");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");
    }
    @Test (dataProvider = "dataRegistrationEmptyLastName", dataProviderClass = DataProviderUser.class)
    public void registrationEmptyLastName(User user) {
      // User user = new User().setName("Sona").setLastName("").setEmail("mert@gmail.com").setPassword("Mert123456!");
        //logger.info("Test data --> Name: Sona, lastName: , email:'mert@gmail.com & password: Mert123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        logger.info("Assert check is message lastName is required' ");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");

    }

    @Test(dataProvider = "dataWrongEmailRegistration",dataProviderClass = DataProviderUser.class)
    public void wrongEmailRegistration(User user) {
      // User user = new User().setName("Sona").setLastName("Mert").setEmail("mertgmail.com").setPassword("Mert123456!");

      //  logger.info("Test data --> Name: Sona, lastName: Mert, email:'mertgmail.com & password: Mert123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        logger.info("Assert check is error text 'Wrong email format' ");

        //Assert.assertTrue(app.getHelperUser().isErrorWrongEmail());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");

    }


    @Test(dataProvider = "dataRegistrationEmptyEmail", dataProviderClass = DataProviderUser.class)
    public void registrationEmptyEmail(User user) {
       // User user = new User().setName("Sona").setLastName("Mert").setEmail("").setPassword("Mert123456!");

        //logger.info("Test data --> Name: Sona, lastName: Mert, email: & password: Mert123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        logger.info("Assert check is message 'Email is required' ");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");
    }

    @Test (dataProvider = "dataRegistrationWrongEmail", dataProviderClass = DataProviderUser.class)
    public void registrationWrongEmail(User user) {
        //User user = new User()
//                .setName("Lisa")
//                .setLastName("Snow")
//                .setEmail("snowgmail.com")
//                .setPassword("Snow123456$");

      // logger.info("Test data --> Name: Lisa, lastName: Snow, email:snowgmail.com & password: Snow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        //Assert.assertEquals(app.getHelperUser().getErrorText(),"Wrong email format \nWrong email format");
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        logger.info("Assert check is error text 'Wrong email format' ");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");
    }

    @Test(dataProvider = "dataRegistrationEmptyPassword", dataProviderClass = DataProviderUser.class)
    public void registrationEmptyPassword(User user) {
       // User user = new User().setName("Sona").setLastName("Mert").setEmail("mert@gmail.com").setPassword("");
       //logger.info("Test data --> Name: Sona, lastName: Mert, email:mert@gmail.com & password: ");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        logger.info("Assert check is message 'Password is required' ");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");
    }


    @Test(dataProvider = "dataWrongPasswordRegistration", dataProviderClass = DataProviderUser.class)
    public void wrongPasswordRegistration(User user ) {
       // User user = new User().setName("Sona").setLastName("Mert").setEmail("mert@gmail.com").setPassword("Mert1!");

        //logger.info("Test data --> Name: Sona, lastName: Mert, email:mert@gmail.com & password: Mert1!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorWrongPassword());

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        logger.info("Assert check is error text 'Password must contain minimum 8 symbols\\n\" +\n" +
                "                \"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]' ");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check Yalla button is active");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
