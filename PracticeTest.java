package com.JobserveTests;
import org.openqa.selenium.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Samsung on 11/10/2017.
 */
public class PracticeTest
{
    public static WebDriver myDriver;
    public static WebDriverWait myWait;

    @BeforeClass
    public static void setUp()
    {
        myDriver = new ChromeDriver();
        myWait = new WebDriverWait(myDriver,10);
    }


    @Test
    public void test1()
    {
        String targetURL = "http://compendiumdev.co.uk/selenium/basic_html_form.html";
        String headerName = "comments"; //Or Id, depends what is available
        String expectedTitle ="HTML Form Elements";
        String elementLocator = "[name='submitbutton'][value='submit']";

        myDriver.navigate().to(targetURL);
        //Wait for header to load
        myWait.until(ExpectedConditions.elementToBeClickable(By.name(headerName)));

        //Assert page title is correct
        Assert.assertEquals(myDriver.getTitle(),expectedTitle);

        //Can only find element once on the page
        WebElement element =
                myWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementLocator)));

        //WebElement element = myDriver.findElement(By.cssSelector(elementLocator));
        element.click();
    }


    @AfterClass
    public static void tearDown()
    {
        myDriver.quit();
    }


}
