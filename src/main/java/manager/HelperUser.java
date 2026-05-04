package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
click(By.xpath("//a[text() = 'Log in']"));
    }
    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.cssSelector("[formcontrolname = 'password']"), password);
    }
    public void submitYalla(){
        click(By.xpath("//button[text()='Y’alla!']"));
    }
    public void submitOk(){
        click(By.xpath("//button[text()='Ok']"));

    }
}
