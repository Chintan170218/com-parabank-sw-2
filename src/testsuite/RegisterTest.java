package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {


    //Declaring URL

    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    //Setting up the browser before each individual test
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }

    @Test
    public void verifyThatSigningUpPageDisplay(){

        //Click on the ‘Register’ link
        WebElement clickRegister = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        clickRegister.click();

        //Verify the text ‘Signing up is easy!’
        //Declaring the text from the requirements
        String expectedMessage = "Signing up is easy!";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualMessage, expectedMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully(){

        //Click on the ‘Register’ link
        WebElement clickRegister = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        clickRegister.click();

        //Enter First name
        WebElement enterFirstName = driver.findElement(By.id("customer.firstName"));
        enterFirstName.sendKeys("Chintu");

        //Enter Last name
        WebElement enterLastName = driver.findElement(By.id("customer.lastName"));
        enterLastName.sendKeys("Ramu");

        //Enter Address
        WebElement enterAddress = driver.findElement(By.id("customer.address.street"));
        enterAddress.sendKeys("123 Plaegrund Stret");

        //Enter City
        WebElement enterCity = driver.findElement(By.id("customer.address.city"));
        enterCity.sendKeys("London");

        //Enter State
        WebElement enterState = driver.findElement(By.id("customer.address.state"));
        enterState.sendKeys("Berkshire");

        //Enter Zip Code
        WebElement enterZipCode = driver.findElement(By.id("customer.address.zipCode"));
        enterZipCode.sendKeys("RG188KU");

        //Enter Phone
        WebElement enterPhoneNo = driver.findElement(By.id("customer.phoneNumber"));
        enterPhoneNo.sendKeys("07896282438");

        //Enter SSN
        WebElement enterSSN = driver.findElement(By.id("customer.ssn"));
        enterSSN.sendKeys("123456789");

        //Enter Username
        WebElement enterUsername = driver.findElement(By.id("customer.username"));
        enterUsername.sendKeys("Chinby1234545");

        //Enter Password
        WebElement enterPassword = driver.findElement(By.id("customer.password"));
        enterPassword.sendKeys("Goodbye123454545");

        //Enter Confirm
        WebElement enterConfirm = driver.findElement(By.id("repeatedPassword"));
        enterConfirm.sendKeys("Goodbye123454545");

        //Click on REGISTER button
        WebElement clickRegisterBtn = driver.findElement(By.xpath("//table[@class='form2']//input[@type='submit']"));
        clickRegisterBtn.click();

        //Verify the text 'Your account was created successfully. You are now logged in.’
        //Declaring the text from the requirements
        String expectedMessage = "Your account was created successfully. You are now logged in.";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualMessage, expectedMessage);
    }


    //Closing the browser after each individual test
    @After
    public void tearDown(){
        closeBrowser();
    }
}
