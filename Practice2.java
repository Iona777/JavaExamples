package com.JobserveTests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Samsung on 11/10/2017.
 */
public class Practice2
{
    static WebDriver myDriver;
    static WebDriverWait myWait;

    @BeforeClass
    public static void setUp()
    {
        myDriver = new ChromeDriver();
        myWait = new WebDriverWait(myDriver,10);
    }

    @Test
    public void Test1()
    {
        String target ="http://compendiumdev.co.uk/selenium/basic_html_form.html";
        String expectedTitle ="HTML Form Elements";
        String myElementLocator="[name='submitbutton'][value='submit']";

        myDriver.navigate().to(target);
        Assert.assertEquals(expectedTitle, myDriver.getTitle());

        //A find element and wait all in one
        WebElement myElement = myWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(myElementLocator)));
        myElement.click();

    }

    @AfterClass
    public static void tearDown()
    {
        myDriver.quit();
    }

    //IF USING PAGE OBJECTS
    //Constructor
//    public HomePage()
//    {
//        PageFactory.initElements(myDriver,this)
//    }
//
//    //Webelements
//    @FindBy(how = How.ID, using = "loginMnu")
//    private WebElement signInRegister;
//

}
