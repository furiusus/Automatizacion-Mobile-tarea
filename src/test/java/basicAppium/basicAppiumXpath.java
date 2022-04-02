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

public class BasicAppiumXpath {

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
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

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
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='plus']")).click();
        // button 1
        driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
        // button =
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='equals']")).click();
        // verificacion de resultado
        Thread.sleep(5000);

        String resultadoActual=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.calculator2:id/formula']")).getText();
        String resultadoEsperado="9";
        Assertions.assertEquals(resultadoEsperado,resultadoActual,"ERROR!!! la suma es incorrecta");
    }
}
