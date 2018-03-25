package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Booking {

    private SelenideElement buttonFirstProposedFlightPrice = $(".flight-header__min-price .flights-table-price__price");
    private SelenideElement buttonFlexiPlusPrice = $(".business-plus .flights-table-fares__fare-price");
    private SelenideElement buttonContinue = $("span[translate='trips.summary.buttons.btn_continue']");
    private SelenideElement seatMap = $("div.seat-map-plane");
    private SelenideElement flightOptionsTable = $(By.name("flightList"));
    private SelenideElement setAdultFirstSeat = $$("span.seat-click").get(16);
    private SelenideElement setAdultSecondSeat = $$("span.seat-click").get(17);
    private SelenideElement setChildSeat = $$("span.seat-click").get(18);
    private SelenideElement buttonNext = $(".core-btn-primary.dialog-overlay-footer__ok-button");
    private SelenideElement confirmSeatsGrid = $("confirm-seats");
    private SelenideElement buttonCheckOut = $("button[data-ref='header-checkout-btn']");

    @Step
    public Booking selectFirstProposedFlight() {
        flightOptionsTable.shouldBe(visible);
        buttonFirstProposedFlightPrice.shouldBe(visible, enabled).click();
        return this;
    }

    @Step
    public Booking selectFlexiPlusPrice() {
        buttonFlexiPlusPrice.shouldBe(visible).scrollTo().shouldBe(visible, enabled).hover().click();
        return this;
    }

    @Step
    public Booking submitPrice() {
        buttonContinue.shouldBe(visible, enabled).click();
        return this;
    }

    @Step
    public Booking selectSeats() {
        setAdultFirstSeat.scrollTo().shouldBe(visible, enabled).hover().click();
        setAdultSecondSeat.scrollTo().shouldBe(visible, enabled).hover().click();
        setChildSeat.scrollTo().shouldBe(visible, enabled).hover().click();
        buttonNext.shouldBe(visible).click();
        return this;
    }

    @Step
    public Booking submitSeats() {
        confirmSeatsGrid.shouldBe(visible);
        buttonNext.shouldBe(visible, enabled).click();
        return this;
    }

    @Step
    public Booking checkout() {
        buttonCheckOut.shouldBe(visible, enabled).hover().click();
        return this;
    }
}