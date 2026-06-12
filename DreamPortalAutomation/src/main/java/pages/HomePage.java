package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver=driver;
    }

    By loader=By.id("loadingAnimation");
   // By myDreams=By.linkText("My Dreams");
    By myDreams=By.xpath("//button[@id='dreamButton']");

    public void open(){

        driver.get("https://arjitnigam.github.io/myDreams/");
    }

    public boolean loaderDisplayed(){

    	
    	return driver.findElement(loader).isDisplayed();
    	 //driver.findElement(By.xpath("//div[@class='loading-animation hidden']"); 
      }
   

    public void waitLoaderDisappear(){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    public boolean buttonVisible(){

        return driver.findElement(myDreams).isDisplayed();
    }

    public void clickDreams(){

        driver.findElement(myDreams).click();
    }

}