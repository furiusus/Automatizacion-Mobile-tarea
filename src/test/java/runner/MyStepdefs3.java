package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.Map;

public class MyStepdefs3 {
    @When("realizo el login con")
    public void realizoElLoginCon(Map<String,String> credentials) {
        for (String key:credentials.keySet()
             ) {
            System.out.println(key+": "+credentials.get(key));
        }

    }

    @And("las opciones habilitadas son")
    public void lasOpcionesHabilitadasSon(Map<String,String> opcionMenu) {
        for (String key:opcionMenu.keySet()
        ) {
            System.out.println(key+": "+opcionMenu.get(key));
        }
    }
}
