package Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class MobilePage {

    ChromeDriver driver;

    By drplist = By.xpath("//select[@title='Sort By']");
    By SonyXperiaPrice = By.xpath("//span[@id='product-price-1']//span[@class='price']");
    By SonyXperiaIcon = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile/sony-xperia.html']");
    By AddToCartXperia = By.xpath("(//button[@type='button'])[3]");
    By MobileText = By.xpath("//div[@class='page-title category-title']");
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");
    By CompareLink_1 = By.xpath("(//a[@class='link-compare'])[1]");
    By CompareLink_2 = By.xpath("(//a[@class='link-compare'])[3]");
    By CompareButton = By.xpath("//button[@title='Compare']");
    By Account  = By.xpath("//a[@href='http://live.demoguru99.com/index.php/customer/account/']");
    By MyAccount = By.xpath("(//a[@title='My Account'])[1]");


    public MobilePage(ChromeDriver driver){
          this.driver= driver;
    }

    public void ClickDropdownList(){
        System.out.println("ClickDropdownList: "+driver.getCurrentUrl());
        WebElement NameDropDown = driver.findElement(drplist);
        Select drplist = new Select(NameDropDown);
        drplist.selectByVisibleText("Name");
    }

    public String getXperiaPriceValue(){
        return driver.findElement(SonyXperiaPrice).getText();
    }

    public void ClickXperiaIcon(){
        driver.findElement(SonyXperiaIcon).click();
    }

    public void CLickAddToCartXperia(){
        driver.findElement(AddToCartXperia).click();
    }

    public void GetMobileText(){
        driver.findElement(MobileText);
    }

    public WebElement GetCompareLink_1(){
        return driver.findElement(CompareLink_1);
    }

    public WebElement GetCompareLink_2(){
        return driver.findElement(CompareLink_2);
    }

    public WebElement GetMobileMenu(){
        return driver.findElement(MobileMenu);
    }

    public void ClickCompareButton(){
        driver.findElement(CompareButton).click();
    }

    public void ClickAccount(){
        driver.findElement(Account).click();
    }

    public void ClickMyAccount(){
        driver.findElement(MyAccount).click();
    }

    public void Sleep(int n){
        try{
            Thread.sleep(n);
        }catch(Exception e){
            System.out.println("Timeout...");
        }
    }

}
