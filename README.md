# Quick Start
--------------
Clone/Download repository and execute next commands under the _ryanair.com_ package.

To run local test with local Chrome browser:

```mvn clean test -Dselenide.browser=chrome site```

To generate Allure report and start a server:

```mvn allure:serve```

To run from IDE:

Run [src/test/java/runner/DeclinedPaymentTest.java](src/test/java/runner/DeclinedPaymentTest.java) as Maven test

# Declined Payment Test 
Cucumber Feature story available here [src/test/resources/features/checkDeclinedPaymentErrorMessage.feature](src/test/resources/features/checkDeclinedPaymentErrorMessage.feature)
**Test steps:**
 - select From/To airports (from Feature Story)
 - set One Way option
 - set the Date (from Feature Story)
 - set Passengers Quantity
 - select first Proposed flight
 - select flight fare
 - select available seats
 - login
 - set payment details (from Feature Story)
 - **Check message after payment decline** 

# Tech Stack
Test was implemented using BDD approach based on next technologies:
- Maven
- Selenide
- Junit
- Cucumber
- Allure

Classes are organized  according to Page Object design pattern.

