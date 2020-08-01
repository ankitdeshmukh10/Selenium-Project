package Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;

public class LoginPage {

    ChromeDriver driver;
    By CreateAccoungButton = By.xpath("//a[@title='Create an Account']");
    By FirstName = By.id("firstname");
    By MiddleName = By.id("middlename");
    By LastName = By.id("lastname");
    By EmailID = By.id("email_address");
    By Password = By.id("password");
    By ConfirmPassword = By.id("confirmation");
    By SignUpCheckbox = By.xpath("//input[@type='checkbox']");
    By RegisterButton = By.xpath("//button[@title='Register']");
    By TVMenu = By.xpath("//a[@href='http://live.demoguru99.com/index.php/tv.html']");
    By WishListLink = By.xpath("(//a[@class='link-wishlist'])[1]");
    By ShareLink = By.name("save_and_share");
    By Message = By.id("message");
    By ShareWishlistButton = By.xpath("//button[@title='Share Wishlist']");
    By LoginMail = By.id("email");
    By LoginPassword = By.xpath("//input[@title='Password']");
    By LoginButton = By.xpath("//button[@title='Login']");
   

    public LoginPage(ChromeDriver driver){
        this.driver = driver;
    }

    public WebElement GetFirstName(){
        return driver.findElement(FirstName);
    }
    public WebElement GetMiddleName(){
        return driver.findElement(MiddleName);
    }
    public WebElement GetLastName(){
        return driver.findElement(LastName);
    }
    public WebElement GetEmailID(){
        return driver.findElement(EmailID);
    }
    public WebElement GetPassword(){
        return driver.findElement(Password);
    }
    public WebElement GetConfirmPassword(){
        return driver.findElement(ConfirmPassword);
    }
    public WebElement GetSignUpCheckbox(){
        return driver.findElement(SignUpCheckbox);
    }
    public WebElement GetRegisterButton(){
        return driver.findElement(RegisterButton);
    }
    public WebElement GetLoginMail(){
        return driver.findElement(LoginMail);
    }
    public WebElement GetLoginButton(){
        return driver.findElement(LoginButton);
    }

    public WebElement GetLoginPassword(){
        return driver.findElement(LoginPassword);
    }

    public WebElement GetCreateAccoungButton(){
        return driver.findElement(CreateAccoungButton);
    }

    public WebElement GetTVMenu(){
        return driver.findElement(TVMenu);
    }

    public WebElement GetWishlistLink(){
        return driver.findElement(WishListLink);
    }

    public WebElement GetShareLink(){
        return driver.findElement(ShareLink);
    }

    public WebElement GetMessage(){
        return driver.findElement(Message);
    }

    public WebElement GetShareWishlistButton(){
        return driver.findElement(ShareWishlistButton);
    }



    public void Sleep(int n){
        try{
            Thread.sleep(n);
        }catch(Exception e){
            System.out.println("Timeout...");
        }
    }
}
