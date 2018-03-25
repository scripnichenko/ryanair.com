package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Start {

    private SelenideElement airportSelectorFrom = $("input[aria-labelledby='label-airport-selector-from']");
    private SelenideElement airportSelectorTo = $("input[aria-labelledby='label-airport-selector-to']");
    private SelenideElement oneWayFlightOption = $("[for='flight-search-type-option-one-way']");
    private SelenideElement inputFlightOutYear = $("input[aria-label='Fly out: - YYYY']");
    private SelenideElement inputFlightOutMonth = $("input[aria-label='Fly out: - MM']");
    private SelenideElement inputFlightOutDay = $("input[aria-label='Fly out: - DD']");
    private SelenideElement passengerQuantitySelector = $("[value-label='1 Adult (age 16+)'] .dropdown-handle");
    private SelenideElement addOneAdultPassenger = $$("button.core-btn.inc.core-btn-wrap").first();
    private SelenideElement addOneChild = $$("button.core-btn.inc.core-btn-wrap").get(2);
    private SelenideElement buttonLetsGo = $("button[ng-keypress='searchFlights()']");

    @Step
    public Start setAirportFrom(String flightFrom) {
        airportSelectorFrom.shouldBe(enabled, visible).click();
        airportSelectorFrom.setValue(flightFrom);
        airportSelectorFrom.pressEnter();
        return this;
    }

    @Step
    public Start setAirportTo(String flightTo) {
        airportSelectorTo.shouldBe(enabled, visible).setValue(flightTo);
        airportSelectorTo.pressEnter();
        return this;
    }

    @Step
    public Start setOneWayFlightOption() {
        oneWayFlightOption.click();
        return this;
    }

    @Step
    public Start setFlightOutDate(String flightYear, String flightMonth, String flightDay) {
        inputFlightOutYear.shouldBe(visible).click();
        inputFlightOutYear.setValue(flightYear);
        inputFlightOutDay.setValue(flightDay);
        inputFlightOutMonth.setValue(flightMonth);
        return this;
    }

    @Step
    public Start setPassengersQuantity() {
        passengerQuantitySelector.shouldBe(visible, enabled).click();
        addOneAdultPassenger.scrollTo().shouldBe(visible, enabled).click();
        addOneChild.scrollTo().shouldBe(visible, enabled).click();
        return this;
    }

    @Step
    public Start submitFlightOptions() {
        buttonLetsGo.shouldBe(visible, enabled).doubleClick();
        return this;
    }
}
