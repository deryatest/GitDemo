Feature: Search an Place the order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on GreenCart Landing Page
    When user searched with Shortname <Name> and extracted actual name of product
    And added "3" items of the selected product to cart
    Then user proceeds to Checkout and validate <Name> items in checkout page
    And verify user has ability to enter promo code and place the order


    Examples:
    | Name  |
    | Tom   |