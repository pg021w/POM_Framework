package interview.PageClasses;

import interview.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends AbstractComponents {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'mb-3')]")
    List<WebElement> getProducts;

    @FindBy(id = "toast-container")
    WebElement toaster;

    By byProduct = By.xpath("//*[contains(@class,'mb-3')]");
    By byToaster = By.id("toast-container");

    public WebElement getProduct(String productName) {
        waitForElementToLoad(byProduct);
        WebElement prod = getProducts.stream().filter(product -> product.findElement(By.xpath(".//b")).getText().
                equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void selectProduct(String productName) {
        getProduct(productName).findElement(By.xpath(".//ancestor::div[@class='card-body']//i[contains(@class,'shopping')]")).click();
        checkToasterMessage();

    }

    public void checkToasterMessage() {
        waitForElementToLoad(byToaster);
        toaster.isDisplayed();
    }
}



