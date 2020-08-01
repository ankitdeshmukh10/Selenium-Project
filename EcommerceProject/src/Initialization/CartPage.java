package Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverPropertyInfo;

public class CartPage {

    ChromeDriver driver;
    By Quantity = By.xpath("//input[@title='Qty']");
    By UpdateButton = By.xpath("//button[@title='Update']");
    By ErrorMessage = By.xpath("//p[@class='item-msg error']");
    By EmptyCartText = By.id("empty_cart_button");
    By EmptyCartMessage = By.xpath("//div[@class='page-title']");
    By ClosePopUpButton = By.xpath("//div[@id='closeBtn']");
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");

    public CartPage(ChromeDriver driver){
            this.driver=driver;
    }

    public void UpdateQuantity(){

        WebElement quantitytext = driver.findElement(Quantity);
        quantitytext.click();
        quantitytext.clear();
        quantitytext.sendKeys("1000");
        Sleep(2000);
        driver.findElement(UpdateButton).click();
    }

    public String VerifyErrorMessage(){

        return  driver.findElement(ErrorMessage).getText();
    }

    public void ClickEmptyCartText(){
        driver.findElement(EmptyCartText).click();
    }

    public String GetEmptyCartMessage(){
        return driver.findElement(EmptyCartMessage).getText();
    }

    public void ClosePopUp(){
        driver.findElement(ClosePopUpButton).click();
    }

    public WebElement FindMobileMenu(){

        return driver.findElement(MobileMenu);
    }

    public void Sleep(int n){
        try{
            Thread.sleep(n);
        }catch(Exception e){
            System.out.println("Timeout...");
        }
    }

}
