package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static jdk.nashorn.internal.objects.NativeString.trim;

public class Payment {

    private final String accountEmail = "flytowro@zoho.eu";
    private final String accountPass = "MyRyanair2018";
    private final String cardType = "MasterCard";
    private final String cardHolderName = "Xero Xero";
    private final String billingAddress1 = "Wallonia, 25 ";
    private final String billingAddress2 = "Wallonia, 26 ";
    private final String billingCity = "Amougies";
    private final String billingPostcode = "5369965";


    private SelenideElement blockLoginRegister = $("div.checkout-compact");
    private SelenideElement btnLogin = $("button.core-btn-secondary");
    private SelenideElement popupSignupLogin = $("signup-home-form");
    private SelenideElement inputEmail = $("input[type='email']");
    private SelenideElement inputPassword = $("input[type='password']");
    private SelenideElement btnSubmitLogin = $("button-spinner > button.core-btn-primary");
    private SelenideElement formPassengersDetails = $("div.passengers-form");
    private SelenideElement inputFirstAdultPassengerName = $$("input[placeholder='e.g. John']").first();
    private SelenideElement inputSecondAdultPassengerName = $$("input[placeholder='e.g. John']").get(1);
    private SelenideElement inputChildPassengerName = $$("input[placeholder='e.g. John']").get(2);

    private SelenideElement titlePaymentMethod = $("h4.payment-methods-title");

    private SelenideElement inputCardNumber = $(By.name("cardNumber"));

    private SelenideElement selectCardType = $(By.name("cardType"));
    private SelenideElement selectExpiryMonth = $(By.name("expiryMonth"));
    private SelenideElement selectExpiryYear = $(By.name("expiryYear"));
    private SelenideElement inputSecurityCode = $(By.name("securityCode"));
    private SelenideElement inputCardHolderName = $(By.name("cardHolderName"));

    private SelenideElement formBillingAddress = $("address-form");
    private SelenideElement inputAddressLine1 = $("#billingAddressAddressLine1");
    private SelenideElement inputAddressLine2 = $("#billingAddressAddressLine2");
    private SelenideElement inputCity = $("#billingAddressCity");
    private SelenideElement inputPostCode = $("#billingAddressPostcode");

    private SelenideElement checkboxAcceptPolicy = $("#checkout > div > form > div.main-area > div.core-card.available-step.after-pax-validation-step > div.body > div.cta > div > label > span");
    private SelenideElement btnPayNow = $("button[translate='common.components.payment_forms.pay_now']");

    private SelenideElement messagePaymentDeclinedError = $("prompt.error.prompt-text[text='common.components.payment_forms.error_explain_declined']");
    private SelenideElement titleErrorMessage = $("div.info-title");
    private final String textMessagePaymentDeclinedError = "As your payment was not authorised we could not complete your reservation. Please ensure that the information was correct or use a new payment to try again";
    private final String textTitleErrorMessage = "Oh. There was a problem";


    @Step
    public Payment login() {
        System.out.println(url());
        blockLoginRegister.shouldBe(visible);
        btnLogin.shouldBe(visible).click();
        popupSignupLogin.shouldBe(visible);
        inputEmail.shouldBe(visible, enabled).click();
        inputEmail.setValue(accountEmail);
        inputPassword.shouldBe(visible, enabled).click();
        inputPassword.setValue(accountPass);
        btnSubmitLogin.shouldBe(visible, enabled);
        btnSubmitLogin.shouldBe(visible, enabled);
        btnSubmitLogin.click();
        return this;
    }

    @Step
    public Payment enterFirstAdultPassengerData() {
        formPassengersDetails.shouldBe(visible);
        inputFirstAdultPassengerName.shouldBe(visible).click();
        inputFirstAdultPassengerName.sendKeys(Keys.ARROW_DOWN);
        inputFirstAdultPassengerName.pressEnter();
        return this;
    }
    @Step
    public Payment enterSecondAdultPassengerData() {
        inputSecondAdultPassengerName.shouldBe(visible, enabled).click();
        inputSecondAdultPassengerName.pressEnter();
        return this;
    }
    @Step
    public Payment enterChildPassengerData() {
        inputChildPassengerName.shouldBe(visible, enabled).click();
        inputChildPassengerName.pressEnter();
        return this;
    }
    @Step
    public Payment enterCardDetails(String cardNumber, String validityDate, String CVV) {

        String first4DigitsCardNumber = trim(cardNumber.substring(0, cardNumber.length() - 15));
        String second4DigitsCardNumber = trim(cardNumber.substring(5, cardNumber.length() - 10));
        String third4DigitsCardNumber = trim(cardNumber.substring(10, cardNumber.length() - 5));
        String fourth4DigitsCardNumber = (trim(cardNumber.substring(cardNumber.length() - 5)));
        String textValidityMonth = validityDate.substring(0, validityDate.length() - 3);
        String textValidityYear = "20".concat(validityDate.substring(3));

        titlePaymentMethod.shouldBe(visible).scrollTo();

        inputCardNumber.shouldBe(visible, enabled).click();
        inputCardNumber.clear();
        inputCardNumber.sendKeys(first4DigitsCardNumber);
        inputCardNumber.sendKeys(second4DigitsCardNumber);
        inputCardNumber.sendKeys(third4DigitsCardNumber);
        inputCardNumber.sendKeys(fourth4DigitsCardNumber);

        selectCardType.shouldBe(visible, enabled).click();
        selectCardType.selectOptionContainingText(cardType);

        selectExpiryMonth.shouldBe(visible, enabled).click();
        selectExpiryMonth.selectOptionContainingText(textValidityMonth);

        selectExpiryYear.shouldBe(visible, enabled).click();
        selectExpiryYear.selectOptionContainingText(textValidityYear);

        inputSecurityCode.shouldBe(visible, enabled).click();
        inputSecurityCode.setValue(CVV);

        inputCardHolderName.shouldBe(visible, enabled).click();
        inputCardHolderName.setValue(cardHolderName);
        return this;

    }
    @Step
    public Payment enterAddressDetails() {
        formBillingAddress.shouldBe(visible).scrollTo();

        inputAddressLine1.shouldBe(enabled).click();
        inputAddressLine1.setValue(billingAddress1);

        inputAddressLine2.shouldBe(enabled).click();
        inputAddressLine2.setValue(billingAddress2);

        inputCity.shouldBe(enabled).click();
        inputCity.setValue(billingCity);

        inputPostCode.shouldBe(enabled).click();
        inputPostCode.setValue(billingPostcode);
        return this;

    }
    @Step
    public Payment pay() {
        checkboxAcceptPolicy.shouldBe(visible, enabled).click();
        btnPayNow.shouldBe(enabled).click();
        return this;

    }
    @Step
    public Payment checkMessageWithDeclinedPayment() {
        titlePaymentMethod.shouldBe(visible).scrollTo();
        titleErrorMessage.shouldBe(visible).shouldHave(text(textTitleErrorMessage));
        messagePaymentDeclinedError.shouldBe(visible).shouldHave(text(textMessagePaymentDeclinedError));
        return this;
    }

}
