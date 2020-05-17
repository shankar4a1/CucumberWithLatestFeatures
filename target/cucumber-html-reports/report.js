$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/FeatureFiles/SFC-69_Back_Search_Results_Table.feature");
formatter.feature({
  "name": "SFC-69 related test cases.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "As a buyer I want to be given a CTA button to return to the search result page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Test"
    },
    {
      "name": "@SFC-65"
    },
    {
      "name": "@SFC-118"
    },
    {
      "name": "@Table"
    }
  ]
});
formatter.step({
  "name": "user logs in to the CCS application",
  "keyword": "Given ",
  "rows": [
    {
      "cells": [
        "ScenarioID"
      ]
    },
    {
      "cells": [
        "\u003cScenarioID\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "User is navigated to CCS home page",
  "keyword": "And "
});
formatter.step({
  "name": "User enters details",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "framework"
      ]
    },
    {
      "cells": [
        "\u003cframework\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "User clicks on the \"Help me find the right framework\" button",
  "keyword": "And "
});
formatter.step({
  "name": "User is displayed with GM landing page",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks \"Search Frameworks\" CTA from the page",
  "keyword": "And "
});
formatter.step({
  "name": "User should be redirected to Search Framework page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "ScenarioID",
        "framework"
      ]
    },
    {
      "cells": [
        "Scenario 2",
        "Linen"
      ]
    }
  ]
});
formatter.scenario({
  "name": "As a buyer I want to be given a CTA button to return to the search result page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Test"
    },
    {
      "name": "@SFC-65"
    },
    {
      "name": "@SFC-118"
    },
    {
      "name": "@Table"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user logs in to the CCS application",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "com.demo.stepdefs.HomeSteps.user_logs_in_to_the_CCS_application(java.util.List\u003ccom.demo.datahandlers.SampleData\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is navigated to CCS home page",
  "keyword": "And "
});
formatter.match({
  "location": "com.demo.stepdefs.HomeSteps.user_is_navigated_to_CCS_home_page()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//a[@class\u003d\u0027logo\u0027]//img\"}\n  (Session info: chrome\u003d81.0.4044.138)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-BKM2109\u0027, ip: \u0027192.168.0.11\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_191\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 81.0.4044.138, chrome: {chromedriverVersion: 81.0.4044.138 (8c6c7ba89cc9..., userDataDir: C:\\Users\\shank\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:51884}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 109c72e442971d4bf05cd4bbe482f564\n*** Element info: {Using\u003dxpath, value\u003d//a[@class\u003d\u0027logo\u0027]//img}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat com.demo.businessPages.HomePage.homePage1(HomePage.java:42)\r\n\tat com.demo.stepdefs.HomeSteps.user_is_navigated_to_CCS_home_page(HomeSteps.java:48)\r\n\tat ✽.User is navigated to CCS home page(file:///C:/Users/Shankar/Automation/git/CucumberWithLatestFeatures/src/test/resources/FeatureFiles/SFC-69_Back_Search_Results_Table.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User enters details",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.demo.stepdefs.HomeSteps.user_enters_details(java.util.List\u003ccom.demo.datahandlers.SampleData\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks on the \"Help me find the right framework\" button",
  "keyword": "And "
});
formatter.match({
  "location": "com.demo.stepdefs.HomeSteps.user_clicks_on_the_button(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User is displayed with GM landing page",
  "keyword": "And "
});
formatter.match({
  "location": "com.demo.stepdefs.GMPageSteps.user_is_displayed_with_GM_landing_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks \"Search Frameworks\" CTA from the page",
  "keyword": "And "
});
formatter.match({
  "location": "com.demo.stepdefs.GMPageSteps.user_selects_second_found_element_from_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should be redirected to Search Framework page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.demo.stepdefs.SearchFrameworksPageSteps.user_should_be_redirected_to_search_framework_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("URL - data:,");
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});