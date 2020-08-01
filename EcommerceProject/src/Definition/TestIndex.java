package Definition;

import Initialization.IndexPage;
import Initialization.MobilePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestIndex {

    public ChromeDriver driver;
    public TestMobilePage testMobilePage;
    public String url = "http://live.demoguru99.com/index.php/";
    public String driverPath="C:\\Users\\ankit.deshmukh\\Downloads\\chromedriver_win32\\chromedriver.exe";


    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        //Passing chrome driver instance to TestMobilePage
        testMobilePage = new TestMobilePage();
        testMobilePage.setChromeDriver(driver);
    }

    @Test(priority = 0)
    public void verifyIndexPageTitle(){

        IndexPage indexPage =  new IndexPage(driver);
        String ActualTitle = indexPage.getIndexTitle();
        String ExpectedTitle = "Home page";

        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title did not Match");
    }

    @Test(priority = 1)
    public void ClickMobileMenuAndVerifyTitle(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.ClickMobileMenu();
        indexPage.Sleep(3000);

        String ActualTitle = indexPage.getIndexTitle();
        String ExpectedTitle = "Mobile";

        Assert.assertEquals(ActualTitle, ExpectedTitle, "Title did not Match");

        System.out.println("Current Url: "+driver.getCurrentUrl());
    }



}
