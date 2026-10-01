package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp() {
        // Test başlamadan önce yapılacak işlemler (Giriş seviyesinde boş kalabilir)
        System.out.println("Hooks: Test senaryosu tetiklendi.");
    }

    @After
    public void tearDown() {
        System.out.println("Hooks: Test bitti, tarayıcı güvenli bir şekilde kapatılıyor.");
        // Test nasıl biterse bitsin, tarayıcıyı kesinlikle hafızadan siler ve kapatır
        Driver.closeDriver();
    }
}
