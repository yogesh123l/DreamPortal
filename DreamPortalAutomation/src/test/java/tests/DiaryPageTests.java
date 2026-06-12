package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.DiaryPage;
import base.BaseDriver;

import org.openqa.selenium.WebDriver;

public class DiaryPageTests {

    WebDriver driver;

    @BeforeMethod

    public void setup(){

        driver=BaseDriver.getDriver();

        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
    }

    @Test

    public void verifyDiary(){

        DiaryPage page=new DiaryPage(driver);

        Assert.assertEquals(page.totalRows(),10);

        Assert.assertTrue(page.verifyDreamTypes());

        Assert.assertTrue(page.verifyColumns());

        Assert.assertEquals(page.recurringDreams(),2);

    }


}