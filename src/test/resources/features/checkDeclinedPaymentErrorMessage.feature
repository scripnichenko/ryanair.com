# decline feature
# Tags: optional
Feature: Payment decline

Scenario: Not valid card being used to pay for a ticket

Given I make a booking from "Dublin" to "Bremen" on 26/05/2018 for 2 adults and 1 child
When I pay for booking with card details "5555 5555 5555 5557", "10/18" and "265"
Then I should get payment declined message