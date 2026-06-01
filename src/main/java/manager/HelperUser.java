package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        //type(By.id("password"), password);
        type(By.cssSelector("[formcontrolname = 'password']"), password);

        //type(By.cssSelector("[formcontrolname = 'passwooord']"), password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        //type(By.id("password"), password);
        type(By.cssSelector("[formcontrolname = 'password']"), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
        //click(By.xpath("//button[text()='Y’alla!']"));
    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
        //pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public boolean isYallaButtonNotActive() {
        //return wd.findElements(By.xpath("//button[@disabled]")).size() > 0;
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));
//var2
        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled();
        return res&& !result;
    }

    public String getMessageWrong() {
            return wd.findElement(By.xpath("//h2[@class='message']"))
                    .getText();
    }

    //**************************** Registration ******************************

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));

    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //var1
        // click(By.id("terms-of-use"));

        //var2
        //click(By.cssSelector("label[for='terms-of-use']"));

        //var 3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript( "document.querySelector('#terms-of-use').click()");

    }
    public void checkPolicyXY() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rectangle = label.getRect();
            int w = rectangle.getWidth();

            //Dimension size = wd.manage().window().getSize();


            int xOffset = -w / 2;
            Actions actions = new Actions(wd);

            actions.moveToElement(label, xOffset, 0).click().release().perform();
        }
    }
    public boolean isErrorWrongEmail() {
        return isElementPresent(By.xpath("//*[text()='Wrong email format']"));

    }
    public boolean isErrorWrongPassword() {

        return isElementPresent(By.xpath("//div[contains(text(),'Password must contain')]"))
                ||
                isElementPresent(By.xpath("//div[contains(text(),'Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]')]"));
    }


    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOkButton();
    }
}


