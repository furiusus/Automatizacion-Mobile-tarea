package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyStepCalculadora {
    private AppiumDriver driver;
    @Given("que mi aplicacion calculadora esta abierto")
    public void queMiAplicacionCalculadoraEstaAbierto() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Galaxy A12");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("platformName","Android");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @When("presiono el boton {int}")
    public void presionoElBoton(int boton) {
        if (boton == 8)
          driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        else
          driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
    }

    @And("presiono el boton suma")
    public void presionoElBotonSuma() {
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
    }

    @And("presiono el boton igual")
    public void presionoElBotonIgual() {
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
    }

    @Then("la suma deberia ser {word}")
    public void laSumaDeberiaSer(String expectedResult) {
        String resultadoActual=driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        String resultadoEsperado=expectedResult;
        Assertions.assertEquals(resultadoEsperado,resultadoActual,"ERROR!!! la suma es incorrecta");
    }
}
