package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.SummaryPage;
import base.BaseDriver;

import org.openqa.selenium.WebDriver;

public class SummaryPageTests {

    WebDriver driver;

    @BeforeMethod

    public void setup(){

        driver=BaseDriver.getDriver();

        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");
        
        
    }

    @Test

    public void verifySummary(){

        SummaryPage page=new SummaryPage(driver);

        Assert.assertTrue(page.stat("Good Dreams").contains("6"));

        Assert.assertTrue(page.stat("Bad Dreams").contains("4"));

        Assert.assertTrue(page.stat("Total Dreams").contains("10"));

        Assert.assertTrue(page.stat("Recurring Dreams").contains("2"));

    }

  
}