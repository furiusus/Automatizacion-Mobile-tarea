package runner;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class MyStepdefs4 {
    @When("yo me registro")
    public void yoMeRegistro(Registro registro) {
        System.out.println("registro name: "+registro.getName());
        System.out.println("registro lastname: "+registro.getLastname());
        System.out.println("registro email: "+registro.getEmail());
        System.out.println("registro phone: "+registro.getPhone());
        System.out.println("registro language: "+registro.getLanguage());
        System.out.println("registro address: "+registro.getAddress());

    }

    @Then("la nueva cuenta deberia habilitarse")
    public void laNuevaCuentaDeberiaHabilitarse() {
    }

    @DataTableType
    public Registro convert(Map<String,String> entity){
        Registro registro= new Registro();
        registro.setEmail(entity.get("email"))
                .setPhone(entity.get("phone"))
                .setAddress(entity.get("address"))
                .setLanguage(entity.get("language"))
                .setLastname(entity.get("lastname"))
                .setName(entity.get("name"));
        return registro;

    }
}