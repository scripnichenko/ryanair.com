package flow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Attachment;
import pages.Booking;
import pages.Start;
import pages.Payment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class DeclinedPaymentFlow {

    private Start startPage;
    private Booking bookingPage;
    private Payment paymentPage;

    @Before
    public void setUp() {
        Configuration.timeout = 5000;
        Configuration.collectionsTimeout = 8000;
        Configuration.baseUrl = "https://www.ryanair.com/ie/en";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.browserSize = "1024x768";
//        Configuration.headless=true;
        open("/");
    }

    @Given("^I make a booking from \"([^\"]*)\" to \"([^\"]*)\" on (.*)/(.*)/(.*) for 2 adults and 1 child$")
    public void iMakeABookingFromDublinToWroclawOnForAdultsAndChild(String flightFrom, String flightTo, String flightDay, String flightMonth, String flightYear) {
        startPage = new Start();
        bookingPage = new Booking();

        startPage.setAirportFrom(flightFrom)
                .setAirportTo(flightTo)
                .setOneWayFlightOption()
                .setFlightOutDate(flightYear, flightMonth, flightDay)
                .setPassengersQuantity()
                .submitFlightOptions();

        bookingPage.selectFirstProposedFlight()
                .selectFlexiPlusPrice()
                .submitPrice()
                .selectSeats()
                .submitSeats()
                .checkout();
    }

    @When("^I pay for booking with card details \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPayForBookingWithCardDetails(String cardNumber, String validityDate, String CVV) throws Throwable {
        paymentPage = new Payment();
        paymentPage.login()
                .enterFirstAdultPassengerData()
                .enterSecondAdultPassengerData()
                .enterChildPassengerData()
                .enterCardDetails(cardNumber, validityDate, CVV)
                .enterAddressDetails()
                .pay();
    }

    @Then("^I should get payment declined message$")
    public void iShouldGetPaymentDeclinedMessage() {
        paymentPage = new Payment();
        paymentPage.checkMessageWithDeclinedPayment();
    }


    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    private byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

}
