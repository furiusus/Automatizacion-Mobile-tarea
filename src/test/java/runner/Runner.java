package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Runner {
    @Before
    public void hookBefore(){
        System.out.println("Este es mi hook before");
    }
    @After
    public void hookAfter(){
        System.out.println("Este es mi hook after");
    }
}
