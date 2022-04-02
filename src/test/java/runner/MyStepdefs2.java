package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;


public class MyStepdefs2 {
    @When("realizo el login")
    public void realizoElLogin(List<String> credentials) {

        for (String key:credentials
             ) {
            System.out.println("credencial: "+key);
        }

    }

    @Then("ingreso a la aplicacion")
    public void ingresoALaAplicacion() {
    }

    @And("las opciones habilitadas deberian ser")
    public void lasOpcionesHabilitadasDeberianSer(List<String> menuOptions) {
        for (String option:menuOptions
             ) {
            System.out.println("opciones: "+option);
        }
    }
}
