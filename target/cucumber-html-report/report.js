$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("End2End_Tests.feature");
formatter.feature({
  "line": 1,
  "name": "RegisterAndMakeOrder",
  "description": " I want to register new user then login with it then \n navigates to women page and wants to return the all items are “In Stock”",
  "id": "registerandmakeorder",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "RegisterAndMakeOrder",
  "description": "",
  "id": "registerandmakeorder;registerandmakeorder",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Open home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Create an account with the mandatory fields then click on Register",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "log out",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "log on with the registered User",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Select Category Women",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Select Items which In Stock Only in women grid and Added them in Shopping Cart",
  "keyword": "Then "
});
formatter.match({
  "location": "E2ETests.the_user_in_the_home_page()"
});
formatter.result({
  "duration": 7025085500,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.CreateAnAccountNew()"
});
formatter.result({
  "duration": 21878047100,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.usershouldloginOut()"
});
formatter.result({
  "duration": 5049092900,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.usershouldlogin()"
});
formatter.result({
  "duration": 10455175800,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.SelectCategoryWomen()"
});
formatter.result({
  "duration": 18949339900,
  "status": "passed"
});
formatter.match({
  "location": "E2ETests.OpenShoppingCartAndAssert()"
});
formatter.result({
  "duration": 41589954200,
  "status": "passed"
});
});