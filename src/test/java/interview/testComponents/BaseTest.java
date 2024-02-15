package interview.testComponents;

import interview.PageClasses.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    public  LandingPage landingPage;

    public void initializeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    @BeforeTest
    public LandingPage getLandingPage()
    {
        initializeBrowser();
        goTo();
         landingPage= new LandingPage(driver);
        return landingPage;
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
