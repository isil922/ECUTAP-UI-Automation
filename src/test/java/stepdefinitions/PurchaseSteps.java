package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.Driver;

public class PurchaseSteps {

    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page() throws InterruptedException {
        // configuration.properties dosyasındaki "url" değerini okur ve o siteye gider
        // Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().get("https://saucedemo.com");
        // Site açıldıktan sonra 3 saniye bekle, gözümüzle görelim
        Thread.sleep(3000);
    }


    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() throws InterruptedException {
        // 1. Kullanıcı adını yaz
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        // 2. Şifreyi yaz
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        Thread.sleep(2000); // Yazdıktan sonra 2 saniye bekle

        // 3. Login butonuna tıkla
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='login-button']")).click();

        Thread.sleep(3000); // Giriş yaptıktan sonra içeriyi görmek için 3 saniye bekle

    }

    @When("User adds {string} to the cart")
    public void user_adds_to_the_cart(String productName) throws InterruptedException {
        // "Sauce Labs Backpack" ürününün "Add to cart" butonunu Xpath ile bulur ve tıklar
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000); // İşlemi gözle görmek için bekleme

    }

    @When("User clicks on the shopping cart icon")
    public void user_clicks_on_the_shopping_cart_icon() throws InterruptedException {
        // Sağ üstteki sepet ikonuna tıklar
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);
    }


    @When("User clicks the checkout button")
    public void user_clicks_the_checkout_button() throws InterruptedException {
        //Sepet sayfasındaki "Checkout" butonuna tıklar
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);
    }


    @When("User fills checkout information fields")
    public void user_fills_checkout_information_fields() throws InterruptedException {
        //First Name, Last Name ve Postal Code alanlarını doldurur
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='first-name']")).sendKeys("Junior");
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='last-name']")).sendKeys("Tester");
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='postal-code']")).sendKeys("34000");
        Thread.sleep(2000);

        // "Continue" butonuna tıkla
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='continue']")).click();
        Thread.sleep(2000);
    }

    @When("User clicks the finish button")
    public void user_clicks_the_finish_button() throws InterruptedException {
        //Sipariş onaylamak için "Finish" butonuna tıklar
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//button[@id='finish']")).click();
        Thread.sleep(2000);

    }


    @Then("User should see the order confirmation message {string}")
    public void user_should_see_the_order_confirmation_message(String expectedMessage) throws InterruptedException {

        //Ekrandaki başarı mesajı elementini bul
        org.openqa.selenium.WebElement confirmationElement = Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//h2[@class='complete-header']"));
        String actualMessage = confirmationElement.getText();

        //JUnit Assert ile ekrandaki yazı ile beklenen yazıyı karşılaştır
        org.junit.Assert.assertEquals(expectedMessage, actualMessage);

        System.out.println("Otomasyon Başarılı! Ekrandaki mesaj doğrulandı: " + actualMessage);
        // Tarayıcıyı kapatmadan önce bize 5 saniye izleme süresi verir
        Thread.sleep(3000);

    }




    @When("User logs in with invalid credentials {string} and {string}")
    public void user_logs_in_with_invalid_credentials_and(String username, String password) throws InterruptedException {

            // Hatalı kullanıcı adını ve şifreyi kutulara yazar
            Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='user-name']")).sendKeys(username);
            Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='password']")).sendKeys(password);
            Thread.sleep(1500);

            // Giriş butonuna tıklar
            Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//input[@id='login-button']")).click();
            Thread.sleep(1500);
    }



    @Then("User should see the error message {string}")
    public void user_should_see_the_error_message(String expectedErrorMessage) throws InterruptedException{
        //Ekrandaki kırmızı hata mesajı elementini bulur
        org.openqa.selenium.WebElement errorElement = Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//h3[@data-test='error']"));
        String actualErrorMessage = errorElement.getText();

        //Mesajların uyuşup uyuşmadığını doğrular (Assert)
        org.junit.Assert.assertEquals(expectedErrorMessage, actualErrorMessage );

        System.out.println("Negatif Test Başarılı! Hata mesajı doğrulandı: " + actualErrorMessage );
        Thread.sleep(2000);

    }

}