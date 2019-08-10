$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/qtpselenium/app/salesforce/login/login.feature");
formatter.feature({
  "line": 1,
  "name": "Logging into Salesforce",
  "description": "\nIn order to work \nAs a sales person\nI want to login",
  "id": "logging-into-salesforce",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 7,
  "name": "Loggin in salesforce",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Runmode is \"\u003cRunmode\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I go to \"LoginURL\" on \"\u003cBrowser\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginusername\" as \"\u003cUsername\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter \"loginpassword\" as \"\u003cPassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on \"loginButton\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "login should be \"\u003cExpectedResult\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce;",
  "rows": [
    {
      "cells": [
        "Runmode",
        "Browser",
        "Username",
        "Password",
        "ExpectedResult"
      ],
      "line": 17,
      "id": "logging-into-salesforce;loggin-in-salesforce;;1"
    },
    {
      "cells": [
        "N",
        "Mozilla",
        "xxxxxxx",
        "yyyyyy",
        "Fail"
      ],
      "line": 18,
      "id": "logging-into-salesforce;loggin-in-salesforce;;2"
    },
    {
      "cells": [
        "N",
        "Mozilla",
        "girispeaks@gmail.com",
        "Wed@1234",
        "Success"
      ],
      "line": 19,
      "id": "logging-into-salesforce;loggin-in-salesforce;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 18,
  "name": "Loggin in salesforce",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Runmode is \"N\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I go to \"LoginURL\" on \"Mozilla\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginusername\" as \"xxxxxxx\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter \"loginpassword\" as \"yyyyyy\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on \"loginButton\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "login should be \"Fail\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "LoginURL",
      "offset": 9
    },
    {
      "val": "Mozilla",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "Fail",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_Login_Should_Be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 19,
  "name": "Loggin in salesforce",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Runmode is \"N\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I go to \"LoginURL\" on \"Mozilla\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginusername\" as \"girispeaks@gmail.com\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter \"loginpassword\" as \"Wed@1234\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on \"loginButton\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "login should be \"Success\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "LoginURL",
      "offset": 9
    },
    {
      "val": "Mozilla",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "Success",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_Login_Should_Be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("com/qtpselenium/app/salesforce/login/login.feature");
formatter.feature({
  "line": 1,
  "name": "Logging into Salesforce",
  "description": "\nIn order to work \nAs a sales person\nI want to login",
  "id": "logging-into-salesforce",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 7,
  "name": "Loggin in salesforce",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I go to \"LoginURL\" on \"\u003cBrowser\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter \"loginusername\" as \"\u003cUsername\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginpassword\" as \"\u003cPassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"loginButton\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "login should be \"\u003cExpectedResult\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce;",
  "rows": [
    {
      "cells": [
        "Browser",
        "Username",
        "Password",
        "ExpectedResult"
      ],
      "line": 16,
      "id": "logging-into-salesforce;loggin-in-salesforce;;1"
    },
    {
      "cells": [
        "Mozilla",
        "xxxxxxx",
        "yyyyyy",
        "Fail"
      ],
      "line": 17,
      "id": "logging-into-salesforce;loggin-in-salesforce;;2"
    },
    {
      "cells": [
        "Mozilla",
        "girispeaks@gmail.com",
        "Wed@1234",
        "Success"
      ],
      "line": 18,
      "id": "logging-into-salesforce;loggin-in-salesforce;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 17,
  "name": "Loggin in salesforce",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I go to \"LoginURL\" on \"Mozilla\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter \"loginusername\" as \"xxxxxxx\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginpassword\" as \"yyyyyy\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"loginButton\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "login should be \"Fail\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LoginURL",
      "offset": 9
    },
    {
      "val": "Mozilla",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "duration": 9351176037,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "Fail",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_Login_Should_Be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 18,
  "name": "Loggin in salesforce",
  "description": "",
  "id": "logging-into-salesforce;loggin-in-salesforce;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I go to \"LoginURL\" on \"Mozilla\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter \"loginusername\" as \"girispeaks@gmail.com\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I enter \"loginpassword\" as \"Wed@1234\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"loginButton\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "login should be \"Success\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LoginURL",
      "offset": 9
    },
    {
      "val": "Mozilla",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "duration": 410822935,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "Success",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_Login_Should_Be(String)"
});
formatter.result({
  "status": "skipped"
});
});