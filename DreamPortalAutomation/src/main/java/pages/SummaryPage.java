package pages;

import java.util.List;

import org.openqa.selenium.*;

public class SummaryPage {

    WebDriver driver;

    public SummaryPage(WebDriver driver){

        this.driver=driver;
    }

   public String stat(String title){

       return driver.findElement(By.xpath("//p[contains(text(),'"+title+"')]")).getText();
    }

}