package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\HP\\eclipse-workspace-new\\SportyShoes-Cucumber-Rest_Assured-APITest\\src\\test\\java\\features\\sportyshoes.feature",
				 glue= {"steps"},
				 plugin= {"html:target/Cucumberreport.html",
						 "pretty",
						"timeline:test-output-thread/"		
				}
			)
public class TestRunner {

}
