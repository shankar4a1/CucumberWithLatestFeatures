package com.demo.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        features = {"src/test/resources/FeatureFiles"},
        glue={"com.scale.stepdefs", "com.scale.context"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json"},

        tags = "@Test1"
)

// dryRun = false




public class TestRunner {
}
 
