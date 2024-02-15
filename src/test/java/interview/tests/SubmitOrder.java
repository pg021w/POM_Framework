package interview.tests;

import interview.PageClasses.CartPage;
import interview.PageClasses.CheckoutPage;
import interview.PageClasses.ConfirmationPage;
import interview.PageClasses.ProductPage;
import interview.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubmitOrder extends BaseTest {

    @Test
    public void submitOrder() {
        String productName = "IPHONE 13 PRO";

        ProductPage productPage = landingPage.loginToApp("prachi321@gmail.com", "Prachi123");

        productPage.selectProduct(productName);

        CartPage cartPage = productPage.goToCart();

        Boolean cartProd = cartPage.verifyCartItems(productName);
        Assert.assertTrue(cartProd);
        CheckoutPage checkoutPage = cartPage.clickOnCheckout();

        checkoutPage.selectCountry("India");

        ConfirmationPage confirmationPage = checkoutPage.clickOnSubmit();

        String s = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(s.equalsIgnoreCase("Thankyou for the order."));
        String order_id = confirmationPage.getConfirmationOrderId();



    }
}
