package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class basicJunit {
    @BeforeEach
    public void setup(){
        System.out.println("setup");
    }

    @AfterEach
    public void cleanup(){
        System.out.println("clean");
    }

    @Test
    public void thisIsMyTest(){
        System.out.println("this is my test");
    }

    @Test
    public void thisIsMyTest2(){
        System.out.println("this is my test2");
    }

}