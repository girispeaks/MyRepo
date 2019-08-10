$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Register.feature");
formatter.feature({
  "line": 1,
  "name": "Registering an user in courseRA",
  "description": "",
  "id": "registering-an-user-in-coursera",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Registering an user",
  "description": "",
  "id": "registering-an-user-in-coursera;registering-an-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I go to \"applicationUrl\" on \"browser\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on \"signUp\" button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I enter \"DemoName\" in \"fullName\" field",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I enter \"demo333@gmail.com\" in \"email\" field",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter \"demo@3e16234\" in \"Password\" field",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on \"SignUp_Submit\" button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I close the browser",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "applicationUrl",
      "offset": 9
    },
    {
      "val": "browser",
      "offset": 29
    }
  ],
  "location": "RegisterUser.i_go_to_screen(String,String)"
});
formatter.result({
  "duration": 16562177163,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "signUp",
      "offset": 12
    }
  ],
  "location": "RegisterUser.i_click_on_button(String)"
});
formatter.result({
  "duration": 1541682129,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DemoName",
      "offset": 9
    },
    {
      "val": "fullName",
      "offset": 23
    }
  ],
  "location": "RegisterUser.i_enter(String,String)"
});
formatter.result({
  "duration": 61814497,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demo333@gmail.com",
      "offset": 9
    },
    {
      "val": "email",
      "offset": 32
    }
  ],
  "location": "RegisterUser.i_enter(String,String)"
});
formatter.result({
  "duration": 57549898,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "demo@3e16234",
      "offset": 9
    },
    {
      "val": "Password",
      "offset": 27
    }
  ],
  "location": "RegisterUser.i_enter(String,String)"
});
formatter.result({
  "duration": 37202513,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SignUp_Submit",
      "offset": 12
    }
  ],
  "location": "RegisterUser.i_click_on_button(String)"
});
formatter.result({
  "duration": 17775710327,
  "status": "passed"
});
formatter.match({
  "location": "RegisterUser.i_close_the_browser()"
});
formatter.result({
  "duration": 4439356927,
  "status": "passed"
});
});