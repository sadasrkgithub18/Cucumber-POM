package com.naveen.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)


@CucumberOptions(features={"src/test/java/com/naveen/features"},
                 glue={"com/naveen/stepDefinitions"},
                 plugin={"pretty","html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 dryRun=false,
                 monochrome=true,
                 strict=false)
public class TestRunner 
{

}
