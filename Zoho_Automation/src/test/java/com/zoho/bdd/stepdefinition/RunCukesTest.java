package com.zoho.bdd.stepdefinition;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resource/com/zoho/bdd/feature/home.feature"},dryRun=false,plugin={"html:output"})
public class RunCukesTest {

}
