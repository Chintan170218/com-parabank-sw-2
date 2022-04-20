package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    //Declaring URL

    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    //Setting up the browser before each individual test
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter valid username
        WebElement enterUsername = driver.findElement(By.xpath("//input[@name='username']"));
        enterUsername.sendKeys("Chin123");

        //Enter valid password
        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='password']"));
        enterPassword.sendKeys("Chin123");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        clickLoginBtn.click();

        //Verify the ‘Accounts Overview’ text is display
        String expectedMessage = "Accounts Overview";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Text does not match expected text",actualMessage,expectedMessage);

    }

    @Test
    public void verifyTheErrorMessage(){

        //Enter invalid username
        WebElement enterUsername = driver.findElement(By.xpath("//input[@name='username']"));
        enterUsername.sendKeys("Chin123456");

        //Enter invalid password
        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='password']"));
        enterPassword.sendKeys("Chin123456");

        //Click on Login button
        WebElement clickLoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        clickLoginBtn.click();

        //Verify the error message ‘The username and password could not be verified.’
        String expectedMessage = "The username and password could not be verified.";

        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Text does not match expected text",actualMessage,expectedMessage);

    }

    @Test
    public void userShouldLogOutSuccessfully(){

        //Enter valid username
        WebElement enterUsername = driver.findElement(By.xpath("//input[@name='username']"));
        enterUsername.sendKeys("Chin123");

        //Enter valid password
        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='password']"));
        enterPassword.sendKeys("Chin123");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        clickLoginBtn.click();

        //Click on ‘Log Out’ link
        WebElement clickLogOutBtn = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        clickLogOutBtn.click();

        //Verify the text ‘Customer Login’
        String expectedMessage = "Customer Login";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Text does not match expected text",actualMessage,expectedMessage);

    }

    //Closing the browser after each individual test
    @After
    public void tearDown(){
        closeBrowser();
    }

}
