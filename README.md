[![Build Status](https://travis-ci.org/scripnichenko/ryanair.com.svg?branch=master)](https://travis-ci.org/scripnichenko/ryanair.com)
[![Maintainability](https://api.codeclimate.com/v1/badges/f4e5fdb4bc6904484767/maintainability)](https://codeclimate.com/github/scripnichenko/ryanair.com/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f4e5fdb4bc6904484767/test_coverage)](https://codeclimate.com/github/scripnichenko/ryanair.com/test_coverage)
[ ![Codeship Status for scripnichenko/ryanair.com](https://app.codeship.com/projects/7ef47400-1755-0136-132a-62d3e5681ad2/status?branch=master)](https://app.codeship.com/projects/283817)
[![Docker Pulls](https://img.shields.io/docker/pulls/askrypnychenko0808/ryanair.com.svg)](https://hub.docker.com/r/askrypnychenko0808/ryanair.com)

<a href="https://scan.coverity.com/projects/scripnichenko-ryanair-com">
  <img alt="Coverity Scan Build Status"
       src="https://scan.coverity.com/projects/15381/badge.svg"/>
</a>

Docker Hub: 
<a href="https://hub.docker.com/r/askrypnychenko0808/ryanair.com/">https://hub.docker.com/r/askrypnychenko0808/ryanair.com/</a>
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
- Maven 3.3.9
- Selenide 4.10
- Junit 4.12
- Cucumber 1.2.5
- Allure 2.6.0

Classes are organized  according to Page Object design pattern.

