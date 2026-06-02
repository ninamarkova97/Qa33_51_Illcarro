package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void click(By locator) {
       // WebElement element = wd.findElement(locator);
      //  element.click();
        //wd.findElement(locator).click();
        new WebDriverWait(wd, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if(text!=null){
            element.sendKeys(text);
        }
    }

    public void clearNew(WebElement element){
        String os = System.getProperty("os.name");
        System.out.println(os);
        element.sendKeys(" ");
        //element.sendKeys(Keys.BACK_SPACE);
        if(os.startsWith("Win")){
            element.sendKeys(Keys.CONTROL,"a");
        } else {
            element.sendKeys(Keys.COMMAND,"a");
        }
        element.sendKeys(Keys.DELETE);
    }



public void pause(int time){
    try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    public boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }
    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void clickWait(WebElement element) {
        try {
            new WebDriverWait(wd, Duration.ofSeconds(5))
                    .until(ExpectedConditions
                            .elementToBeClickable(element)).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("created exception");
        }
    }
}
