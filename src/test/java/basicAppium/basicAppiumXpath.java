package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class basicAppiumXpath {

    private AppiumDriver driver;
    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Galaxy A12");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }


    @Test
    public void calculatorTest() throws InterruptedException {
        // button 8
        driver.findElement(By.xpath("//android.widget.Button[@text='8']")).click();
        //  button +
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Menos']")).click();
        // button 1
        driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
        // button =
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Igual']")).click();
        // verificacion de resultado
        Thread.sleep(5000);

        String resultadoActual=driver.findElement(By.xpath("//android.view.View[@resource-id='com.sec.android.app.popupcalculator:id/calc_edt_formula']")).getText();
        String resultadoEsperado="7";
        Assertions.assertEquals(resultadoEsperado,resultadoActual,"ERROR!!! la resta es incorrecta");
    }
}