package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

public class Hooks {
    public static RequestSpecification spec;

    @Before(value="@UI")
    public void before(Scenario scenario) {
        System.out.println(scenario.getName() + " has been started");
    }
    @Before(value ="@Api")
    public void setUp(Scenario scenario){
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("")).build();
        System.out.println(scenario.getName() + " has been started");
    }
    @After(value="@UI")
    public void tearDown(Scenario scenario){  final byte[] screenshot=((TakesScreenshot)
            Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
            System.out.println(scenario.getName() + " : " + scenario.getStatus());

            if (scenario.getStatus().toString() == "FAILED") {
                ReusableMethods.screenShot(scenario);
            }

            ExcelUtil.writeScenarioToExcel(scenario);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Driver.closeDriver();
    }

    @After(value ="@Api")
    public void after(Scenario scenario) {
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        ExcelUtil.writeScenarioToExcel(scenario);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Driver.closeDriver();


    }


}