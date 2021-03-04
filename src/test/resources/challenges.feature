Feature: GET all challenges

  @wip
  Scenario: GET all challenges
    Given User enters the "challenges" with url
    Then User should see all challenges

  @Challenge1
  Scenario: POST Challenger
    Given User enters the "challenger" with url
    Then User should see the X-CHALLENGER in the response header

  @Challenge3
  Scenario: GET TODOs
    Given User enters the "todos" with url
    Then Status code should be 200