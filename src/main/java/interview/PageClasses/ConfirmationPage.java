package interview.PageClasses;

import interview.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponents {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By byConfirmation = By.xpath("//h1[contains(@class,'hero-primary')]");

    @FindBy(xpath = "//h1[contains(@class,'hero-primary')]")
    WebElement confirmationMsg;

    @FindBy(xpath = "//label[@class='ng-star-inserted']")
    WebElement order_id;

    public String getConfirmationMessage() {
        waitForElementToLoad(byConfirmation);
        return confirmationMsg.getText();
    }

    public String getConfirmationOrderId() {

        return order_id.getText().split(" ")[1];
    }
}