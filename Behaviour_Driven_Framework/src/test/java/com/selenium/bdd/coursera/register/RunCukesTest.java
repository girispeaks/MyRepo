package com.selenium.bdd.coursera.register;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resource/com/selenium/bdd/coursera/register"}, plugin={"html:output"})
public class RunCukesTest {
	

}