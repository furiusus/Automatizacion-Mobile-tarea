package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    /*
     * {} --> reemplaza cualquier palabra/s
     * {string} --> remplaza una palabras/s que esten entre comillas dobles "palabra palabra"
     * {word} ---> no necisita comillas , si debe ser una sola palabra
     * {int} ---> para aceptar valores numericos enteros
     * {float} ---> valores flotantes
     *  */

    @Given("que tengo acceso a {} app")
    public void queTengoAccesoAFacebookApp(String nameApp) {
        System.out.println(" argumemnto: " + nameApp);
    }

    @When("yo ingreso mi usuario: {string}")
    public void yoIngresoMiUsuario(String usuario) {
        System.out.println(" usuaruio: " + usuario);
    }

    @And("ingreso mi password: {word}")
    public void ingresoMiPassword(String pwd) {
        System.out.println(" pwd: " + pwd);
    }

    @And("click en el boton ingresar")
    public void clickEnElBotonIngresar() {
    }

    @Then("deberia de ingresar a la app {int} vez")
    public void deberiaDeIngresarALaApp(int cantidad) {
    }

    @Then("no deberia de ingresar a la app")
    public void noDeberiaDeIngresarALaApp() {
    }
}
