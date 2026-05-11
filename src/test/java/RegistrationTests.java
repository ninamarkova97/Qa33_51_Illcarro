import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {


    int z = (int) ((System.currentTimeMillis() / 1000) % 3600);


    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("=================");


        User user = new User().setName("Sona").setLastName("Mert").setEmail("mert" + z + "@gmail.com").setPassword("Mert123456!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    public void requiredNameRegistration() {
        User user = new User().setName("").setLastName("Mert").setEmail("mert" + z + "@gmail.com").setPassword("Mert123456!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");

    }
    @Test
    public void requiredLastNameRegistration() {
        User user = new User().setName("Sona").setLastName("").setEmail("mert" + z + "@gmail.com").setPassword("Mert123456!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");

    }
    @Test
    public void requiredEmailRegistration() {
        User user = new User().setName("Sona").setLastName("Mert").setEmail("").setPassword("Mert123456!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");

    }
    @Test
    public void requiredPasswordRegistration() {
        User user = new User().setName("Sona").setLastName("Mert").setEmail("mert" + z + "@gmail.com").setPassword("");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");

    }
    @Test
    public void wrongEmailRegistration() {
        User user = new User().setName("Sona").setLastName("Mert").setEmail("mert" + z + "gmail.com").setPassword("Mert123456!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorWrongEmail());

    }

    @Test
    public void wrongPasswordRegistration() {
        User user = new User().setName("Sona").setLastName("Mert").setEmail("mert" + z + "gmail.com").setPassword("Mert1!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isErrorWrongPassword());

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
