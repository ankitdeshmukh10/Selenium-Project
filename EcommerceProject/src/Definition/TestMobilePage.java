package Definition;

import Initialization.CartPage;
import Initialization.IndexPage;
import Initialization.LoginPage;
import Initialization.MobilePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;
import java.util.Iterator;
import java.util.Set;

public class TestMobilePage {

    public static ChromeDriver driver;
    // this method holds state of driver received from TestIndex Class
    public void setChromeDriver(ChromeDriver driver){

        TestMobilePage.driver=driver;

        //Passing chrome driver instance to TestCartPage
        TestCartPage testCartPage = new TestCartPage();
        testCartPage.setChromeDriver(driver);

        //Passing chrome driver instance to TestLoginPage
        TestLoginPage testLoginPage = new TestLoginPage();
        testLoginPage.setChromeDriver(driver);
    }

    @Test(priority = 2)
    public void Sortbyname(){

        MobilePage mobilePage=new MobilePage(driver);
        mobilePage.ClickDropdownList();
        mobilePage.Sleep(3000);
    }

    @Test
    public void CompareValueWithDetailsPage(){

        MobilePage mobilePage=new MobilePage(driver);

        //get value
        String XperiaValue = mobilePage.getXperiaPriceValue();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Xperia Value:"+ XperiaValue);

        //click Xperia icon
        mobilePage.ClickXperiaIcon();
        mobilePage.Sleep(3000);

        //get value on current Page
        String XperiaValueLatest = mobilePage.getXperiaPriceValue();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Xperia Latest Value:"+ XperiaValue);

        //compare both values
        Assert.assertEquals(XperiaValue,XperiaValueLatest,"Values are not matching");
    }

    @Test(priority = 3)
    public void AddXperiaMobileToCart(){
        MobilePage mobilePage = new MobilePage(driver);
        mobilePage.CLickAddToCartXperia();
        mobilePage.Sleep(3000);
    }

    @Test(priority = 6)
    public void CompareMobiles(){

        MobilePage mobilePage = new MobilePage(driver);

        //WebElement Mobile = driver.findElementByXPath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
        WebElement Mobile = mobilePage.GetMobileMenu();
        Mobile.click();

        //Scroll Down Page so that Compare link is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div[@class='page-title category-title']")));
        mobilePage.Sleep(1000);

        mobilePage.GetCompareLink_1().click();

        mobilePage.GetCompareLink_2().click();
        mobilePage.Sleep(1000);

        //pop up page will open
        mobilePage.ClickCompareButton();
        mobilePage.Sleep(2000);


        String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        System.out.println(driver.getCurrentUrl());


    }

    @Test(priority = 7)
    public void AccountRegistration(){

        MobilePage mobilePage = new MobilePage(driver);
        mobilePage.ClickAccount();
        mobilePage.ClickMyAccount();

        LoginPage loginPage = new LoginPage(driver);

        //This is for Login
        WebElement loginmail = loginPage.GetLoginMail();
        loginmail.click();
        loginmail.sendKeys("ankitdeshmukh@gmail.com");

        WebElement loginpassword = loginPage.GetLoginPassword();
        loginpassword.click();
        loginpassword.sendKeys("123456");

        WebElement loginbutton = loginPage.GetLoginButton();
        loginbutton.click();

        loginPage.Sleep(2000);
        //Following code is for registration
        //WebElement CreateAccBtn = loginPage.GetCreateAccoungButton();
        //CreateAccBtn.click();

        /*//Scroll Down Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//p[@class='form-instructions']")));
        loginPage.Sleep(1000);

        WebElement firstname = loginPage.GetFirstName();
        WebElement middlename = loginPage.GetMiddleName();
        WebElement lastname = loginPage.GetLastName();
        WebElement emailid = loginPage.GetEmailID();
        WebElement password = loginPage.GetPassword();
        WebElement confirmpassword = loginPage.GetConfirmPassword();
        WebElement signupcheckbox = loginPage.GetSignUpCheckbox();
        WebElement register = loginPage.GetRegisterButton();

        firstname.click();
        firstname.sendKeys("Ankit");
        middlename.click();
        middlename.sendKeys("Anant");
        lastname.click();
        lastname.sendKeys("Deshmukh");
        emailid.click();
        emailid.sendKeys("ankitdeshmukh@gmail.com");
        password.click();
        password.sendKeys("123456");
        confirmpassword.click();
        confirmpassword.sendKeys("123456");
        signupcheckbox.click();
        register.click();

        loginPage.Sleep(2000);

        String ExpectedMessage = "Thank you for registering with Main Website Store.";
        String ActualMessage = driver.findElementByXPath("//li[@class='success-msg']").getText();

        Assert.assertEquals(ExpectedMessage,ActualMessage,"Message did not match...");*/
    }


    @AfterSuite
    public void quit(){

        driver.quit();
    }
}
