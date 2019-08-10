package com.selcukesfw.stepimplementations;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, format = {"json:target/json_report/cucumber.json"})
public class RunCukesTest {
	

}