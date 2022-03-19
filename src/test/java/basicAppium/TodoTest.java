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

public class TodoTest {

    private AppiumDriver driver;
    @BeforeEach
    public void setup() throws MalformedURLException {
        // Configuración del celular "Apium"
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Galaxy A12");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }
    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void TodoManagerTest() throws InterruptedException {
       //Agregar lista
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
       //seleccionar opciones
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/note_item_reminder")).click();
       //Seleccionar limite
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/due_date")).click();
       //Fijar limite de fecha
        driver.findElement(By.xpath("//android.view.View[@text='20']")).click();
        //Boton aceptar limite
        driver.findElement(By.id("android:id/button1")).click();
        //Seleccionar Hora
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/time")).click();
        //Fijar hora
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='9']")).click();
        Thread.sleep(1000);
        //Boton aceptar Hora
        driver.findElement(By.id("android:id/button1")).click();
        //Seleccionar recordatorio
        //driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/reminder']")).click();
        // Fijar recordatorio
       // Thread.sleep(3000);
       // driver.findElement(By.xpath("//android.widget.RadioButton[@text='A Tiempo']")).click();
        //Thread.sleep(3000);
        //Seleccionar Repetir
        //driver.findElement(By.id("com.vrproductiveapps.whendo:id/repeat")).click();
        // Fijar repetir
        //driver.findElement(By.xpath("//android.widget.RadioButton[@text='Diariamente']")).click();
        // llenar titulo
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("Hola");
        // llenar notas
        driver.findElement(By.xpath("//android.widget.EditText[@text='Notas']")).sendKeys("Como estas");
        // click save
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Guardar']")).click();
        Thread.sleep(1000);

        String expectedResult="Keilita";
        String actualResult=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text']")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la nota no fue creado");


    }
}
