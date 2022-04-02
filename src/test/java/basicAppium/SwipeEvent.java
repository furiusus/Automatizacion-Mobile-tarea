package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwipeEvent {

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
    public void swipeExample() throws InterruptedException {
        TouchAction actions = new TouchAction((PerformsTouchActions) driver);
         WebElement firstControl=driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup[3]"));
         WebElement secondControl=driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup[1]"));


        int firstX=firstControl.getLocation().getX();
         int firstY=firstControl.getLocation().getY();
         int secondX=secondControl.getLocation().getX();
         int secondY=secondControl.getLocation().getY();



          //scroll

        actions.press(PointOption.point(firstX,firstY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(secondX,secondY))
                .release().perform();
         Thread.sleep(5000);
    }
}
