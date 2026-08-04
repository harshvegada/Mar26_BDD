package steps;

import io.cucumber.java.en.And;
import pages.PaymentPage;

public class PaymentSteps {

    PaymentPage paymentPage = new PaymentPage();

    @And("user make payment using {string} payment method")
    public void user_make_payment_using_payment_method(String paymentMethod) {
        paymentPage.makePaymentUsing(paymentMethod);
    }

}
