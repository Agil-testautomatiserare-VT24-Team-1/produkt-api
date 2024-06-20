package com.example.produktapi.resources.features;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

//import org.springframework.boot.test.context.SpringBootTest;
@CucumberContextConfiguration
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/produktapi/resources/features")
public class RunCucumberTest {

}

