package runner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
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

public class MyStepWendo {
    private AppiumDriver driver;

    @Given("abro el aplicativo Whendo")
    public void abroElAplicativoWhendo() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy A12");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

    @And("presiono la opcion para agregar tarea")
    public void presionoLaOpcionParaAgregarTarea() {

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }

    @And("presiono mas opciones para tarea")
    public void presionoMasOpcionesParaTarea() {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/note_item_reminder")).click();
    }

    @And("Agrego los siguientes datos a la tarea")
    public void agregoLosSiguientesDatosALaTarea(Wendo  wendo) throws InterruptedException {

        System.out.println("tarea Duedate: "+wendo.getDuedate());
        System.out.println("tarea time: "+wendo.gettime());
        System.out.println("tarea title: "+wendo.gettitle());
        System.out.println("tarea notes: "+wendo.getnotes());


        //Seleccionar limite
       // driver.findElement(By.id("com.vrproductiveapps.whendo:id/due_date")).click();
        //Fijar limite de fecha
        //driver.findElement(By.xpath("//android.view.View[@content-desc='18 april 2022']]")).click();
        //Boton aceptar limite
        //driver.findElement(By.id("android:id/button1")).click();

        //Seleccionar Hora
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/time")).click();
        //Fijar hora
        Thread.sleep(1000);
        String xpathTime = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='" + wendo.gettime() + "']";
        driver.findElement(By.xpath(xpathTime)).click();
        Thread.sleep(1000);
        //Boton aceptar Hora
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(" "+ wendo.gettitle());
        // llenar notas
        driver.findElement(By.xpath("//android.widget.EditText[@text='Notas']")).sendKeys(" "+ wendo.getnotes());

    }

    @When("guardo la tarea")
    public void guardoLaTarea() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Guardar']")).click();
        Thread.sleep(1000);
    }

    @Then("valido los siguientes datos")
    public void validoLosSiguientesDatos(Wendoresultado wendoresultado) {

        String resultadoTitle=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text']")).getText();
        String resultadoNotes=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text2']")).getText();

        String resultadoTitulo=wendoresultado.getTitle();
        String resultadoNotas=wendoresultado.getNotes();

        Assertions.assertEquals(resultadoTitle,resultadoTitle,"ERROR! el titulo no fue creado");
        Assertions.assertEquals(resultadoNotes,resultadoNotes,"ERROR! la nota no fue creado");

    }
    @DataTableType
    public Wendo convert(Map<String,String> entity) {
        Wendo wendo = new Wendo();
        wendo.setDuedate(entity.get("Duedate"))
                .setLastname(entity.get("time"))
                .settitle(entity.get("title"))
                .setnotes(entity.get("notes"));
        return wendo;
    }

    @DataTableType
    public Wendoresultado convert2(Map<String,String> entity) {
        Wendoresultado wendoresultado = new Wendoresultado(entity.get("title"),entity.get("notes"));
        return wendoresultado;
    }

    }