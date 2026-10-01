package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;
    //Singleton Pattern: Başka sınıflardan new Driver() denmesini engeller
    private Driver() {
    }

    public static WebDriver getDriver() {

        if (driver == null){
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

            org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

            // Chrome'un Google şifre kontrolü ve güvenlik taramalarını tamamen kapatan kurumsal argümanlar
            options.addArguments("--incognito"); // Gizli sekmede açar (Pop-up'ları büyük oranda engeller)
            options.addArguments("--disable-blink-features=AutomationControlled"); // Otomasyon algılamasını kapatır
            options.addArguments("--disable-popup-blocking"); // Pop-up engelleme
            options.addArguments("--disable-extensions"); // Eklentileri kapatır
            options.addArguments("--password-store=basic"); // Şifre havuzunu devre dışı bırakır

            //Şifre yöneticisi uyarılarını engelleme profili
            java.util.Map<String, Object> prefs = new java.util.HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            //Ayarlanmış seçeneklerle Chrome'u ayağa kaldır
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null){
            driver.quit();
            driver =null;
        }
    }



}
