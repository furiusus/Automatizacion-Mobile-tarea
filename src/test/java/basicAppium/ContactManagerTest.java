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

public class ContactManagerTest {

    private AppiumDriver driver;
    @BeforeEach
    public void setup() throws MalformedURLException {
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

    @AfterEach
    public void cleanup(){
        driver.quit();
    }


    @Test
    public void createContactTest() throws InterruptedException {
       // click add contact
        driver.findElement(By.id("com.android.contacts:id/hw_fab")).click();
        // llenar name'
        driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("Borrar2");
        // llenar phone
        driver.findElement(By.xpath("//android.widget.EditText[@text='Phone number']")).sendKeys("23333333");
        // click save
        driver.findElement(By.id("android:id/icon2")).click();

        // verificar
        String expectedResult="Borrar2";
        String actualResult=driver.findElement(By.id("com.android.contacts:id/name")).getText();

         Assertions.assertEquals(expectedResult,actualResult,"ERROR! el contacto no fue creado");

    }
}
