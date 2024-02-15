package interview.PageClasses;

import interview.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cartSection']")
    List<WebElement> cartItems;

    @FindBy(xpath = "//*[@class='btn btn-primary' and text()='Checkout']")
    WebElement checkout;

    public boolean verifyCartItems(String productName) {
        List<WebElement> cart_Items = cartItems;
        Boolean cartProd = cartItems.stream().anyMatch(product -> product.findElement(By.xpath(".//h3"))
                .getText().equals(productName));
        return cartProd;
    }

    public CheckoutPage clickOnCheckout()
    {
        checkout.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}



