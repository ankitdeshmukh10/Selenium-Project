package Definition;

import Initialization.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestLoginPage{

    public static ChromeDriver driver;

    // this method holds state of driver received from TestMobilePage Class
    public void setChromeDriver(ChromeDriver driver){
        TestLoginPage.driver = driver;
    }

    @Test(priority = 8)
    public void ShareWishList(){

        System.out.println(driver.getCurrentUrl());
        LoginPage loginPage = new LoginPage(driver);
        WebElement TVMenu = loginPage.GetTVMenu();
        TVMenu.click();
        System.out.println(driver.getCurrentUrl());
        loginPage.GetWishlistLink().click();
        loginPage.Sleep(1000);
        loginPage.GetShareLink().click();
        loginPage.Sleep(1000);
        WebElement EmailID = loginPage.GetEmailID();
        EmailID.click();
        EmailID.sendKeys("ankitdeshmukh10@gmail.com");

        WebElement Message = loginPage.GetMessage();
        Message.click();
        Message.sendKeys("TV Wishlist");

        //Scroll Down Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div[@class='page-title']")));
        loginPage.Sleep(1000);

        loginPage.GetShareWishlistButton().click();

        loginPage.Sleep(2000);

    }

    @Test(priority = 9)
    public void SaveOrderToPdfFile(){






    }

}
