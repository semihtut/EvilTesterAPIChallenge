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

  @Challenge4
  Scenario: GET TODOs
    Given User enters the "todo" with url
    Then Status code should be 404

  @Challenge5
  Scenario: GET TODOs/id
    Given User enters the "todos/" with url and id number 66
    Then Status code should be 200


