package interview.PageClasses;

import interview.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;


    @FindBy(id = "userEmail")
    WebElement userEmail  ;

    @FindBy(id = "userPassword")
    WebElement userPassword ;

    @FindBy(id = "login")
    WebElement submitButton  ;

    public ProductPage loginToApp(String username, String password)
    {
        userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        submitButton.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }

}
