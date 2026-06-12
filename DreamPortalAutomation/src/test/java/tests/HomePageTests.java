package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import base.BaseDriver;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class HomePageTests {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver=BaseDriver.getDriver();
    }

    @Test

    public void verifyHomePage(){

        HomePage home=new HomePage(driver);

        home.open();

        Assert.assertTrue(home.loaderDisplayed());

        home.waitLoaderDisappear();

        Assert.assertTrue(home.buttonVisible());

        home.clickDreams();

        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());

        Assert.assertEquals(tabs.size(),3);

    }


   

}