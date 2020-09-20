$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login validation feature",
  "description": "As a registered user\nIn order to validate login\nI want to login check login validation",
  "id": "login-validation-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "duration": 12495467300,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Login test with valid credentials",
  "description": "",
  "id": "login-validation-feature;login-test-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Login-Valid"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "when user is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "user enters valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "when he clicks on login",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "login should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.when_user_is_on_login_page()"
});
formatter.result({
  "duration": 195985200,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_enters_valid_credentials()"
});
formatter.result({
  "duration": 245022600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.when_he_clicks_on_login()"
});
formatter.result({
  "duration": 3109907500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.login_should_be_successful()"
});
formatter.result({
  "duration": 6578500,
  "status": "passed"
});
formatter.after({
  "duration": 1360584100,
  "status": "passed"
});
});