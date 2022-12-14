package street.common;


import street.DashBoardApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DashBoardApplication.class })
public class CucumberSpingConfiguration {
    
}
