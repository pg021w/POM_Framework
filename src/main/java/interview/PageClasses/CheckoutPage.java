package interview.PageClasses;

import interview.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponents {
     WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    By byCountries = By.xpath("//*[contains(@class,'results')]//span");

    @FindBy(xpath = "//*[@placeholder='Select Country']")
    WebElement select_Country;

    @FindBy(xpath = "//*[contains(@class,'results')]//span")
    List<WebElement> countryDropdown;

    @FindBy(xpath = "//a[contains(@class,'submit')]")
    WebElement submit;


    public void selectCountry (String country) {
        Actions actions = new Actions(driver);
        actions.sendKeys(select_Country, "ind").build().perform();
        waitForElementToLoad(byCountries);
        List<WebElement> countries = countryDropdown;
        for (int i = 0; i < countries.size(); i++) {
            String s = countries.get(i).getText();
//            System.out.println(s);
            if (s.equalsIgnoreCase(country)) {
                countries.get(i).click();
                break;
            }
        }
//        boolean current_country=select_Country.getTextxt().equalsIgnoreCase(country);
//        return current_country;

    }

    public ConfirmationPage clickOnSubmit()
    {
        submit.click();
        return new ConfirmationPage (driver);
    }
}
