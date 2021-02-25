$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/UserRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": " I want to check that the user can register in our shopping website.",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the user in the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I Create an account with the mandatory fields then click on Register",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "The user should Registered successfully",
  "keyword": "Then "
});
});