package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

import static browser.Config.BROWSER_TYPE;
import static browser.Config.WAIT;

/**
 * Класс создан для упрощения объявления драйвера в тестах
 */
public class Browser {
    public static WebDriver driver;
    /**
     * Инициализируется (необходимо для работы драйвера, иначе ошибка) драйвер, устанавливается разрешение экрана
     * и неявное ожидания
     * Переменная BROWSER_TYPE отвечает за открытие необходимого браузера
     * @return - возвращает экземпляр класса WebDriver
     */
    public static WebDriver createDriver(){

        switch (BROWSER_TYPE){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                driver = new FirefoxDriver(fOptions);
                break;
            default:
                System.out.println("Некорректное имя браузера: " + BROWSER_TYPE);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));

        return driver;
    }

}
