package Definition;

import Initialization.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCartPage{


    public static ChromeDriver driver;

    // this method holds state of driver received from TestMobilePage Class
    public void setChromeDriver(ChromeDriver driver){

        TestCartPage.driver=driver;

    }

    @Test(priority = 4)
    public void UpdateCartForXperiaMobileAndVerifyErrorMessage(){

        CartPage cartPage = new CartPage(driver);
        cartPage.UpdateQuantity();

        String ExpectedErrorMessage = "* The maximum quantity allowed for purchase is 500.";
        String ActualErrorMessage = cartPage.VerifyErrorMessage();

        Assert.assertEquals(ExpectedErrorMessage,ActualErrorMessage,"Error Message did not match...");


    }

    @Test(priority = 5)
    public void EmptyCartAndVerifyMessage(){

        CartPage cartPage = new CartPage(driver);
        WebElement element = driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        cartPage.Sleep(2000);
        cartPage.ClickEmptyCartText();
        //cartPage.Sleep(2000);
        String ExpectedMessage="SHOPPING CART IS EMPTY";
        String ActualMessage=cartPage.GetEmptyCartMessage();

        Assert.assertEquals(ActualMessage,ExpectedMessage,"Message did not match...");
    }


}
