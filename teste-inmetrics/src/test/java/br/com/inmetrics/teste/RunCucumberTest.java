package br.com.inmetrics.teste;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources/features/", plugin = {"summary", "pretty", "html:TestReport.html"},
        glue = "classpath:br/com/inmetrics/teste/steps")
public class RunCucumberTest {


}