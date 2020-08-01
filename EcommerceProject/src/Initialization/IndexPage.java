package Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndexPage {

    ChromeDriver driver;
    By MobileMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']");

    public IndexPage(ChromeDriver driver){
        this.driver=driver;
    }

    public String getIndexTitle(){

        return driver.getTitle();

    }

    public void ClickMobileMenu(){

        driver.findElement(MobileMenu).click();
    }


    public void Sleep(int n){
        try{
            Thread.sleep(n);
        }catch(Exception e){
            System.out.println("Timeout...");
        }
    }

}
