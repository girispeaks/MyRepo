$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/com/zoho/bdd/feature/home.feature");
formatter.feature({
  "line": 2,
  "name": "Validating the features of Home screen",
  "description": "\n\nGiven I am logged into the application using \"browser\"",
  "id": "validating-the-features-of-home-screen",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Check the contents of home page",
  "description": "",
  "id": "validating-the-features-of-home-screen;check-the-contents-of-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Home"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I am logged into the application using \"browser\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I verify the \"cliq_link\" and \"crm_link\" and \"salesiq_link\" of home page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "browser",
      "offset": 40
    }
  ],
  "location": "Home.login(String)"
});
formatter.result({
  "duration": 66493416283,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cliq_link",
      "offset": 14
    },
    {
      "val": "crm_link",
      "offset": 30
    },
    {
      "val": "salesiq_link",
      "offset": 45
    }
  ],
  "location": "Home.vfyHome(String,String,String)"
});
formatter.result({
  "duration": 30194923649,
  "status": "passed"
});
});