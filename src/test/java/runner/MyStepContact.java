package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class MyStepContact {
    private AppiumDriver driver;

    @Given("mi contact manager esta abierto")
    public void miContactManagerEstaAbierto() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","EynarH");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.android.contacts");
        capabilities.setCapability("appActivity",".activities.PeopleActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @When("yo registro un nuevo contacto")
    public void yoRegistroUnNuevoContacto(Map<String,String> values) {
        driver.findElement(By.id("com.android.contacts:id/hw_fab")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys(values.get("name"));
        driver.findElement(By.xpath("//android.widget.EditText[@text='Phone number']")).sendKeys(values.get("phone"));
        driver.findElement(By.id("android:id/icon2")).click();
    }

    @Then("el contacto {string} deberia ser creado")
    public void elContactoDeberiaSerCreado(String expectedResult) {
        String actualResult=driver.findElement(By.id("com.android.contacts:id/name")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! el contacto no fue creado");
    }
}
