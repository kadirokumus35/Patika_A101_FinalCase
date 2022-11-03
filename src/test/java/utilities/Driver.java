package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver(){

    }
    static WebDriver driver;

    public  static WebDriver getDriver(){

        if(driver==null) {
            switch(ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "headless-edge": //
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(new EdgeOptions().setHeadless(true));
                    break;
                default:
                   ChromeOptions options=new ChromeOptions();
                   options.addArguments("--disable-blink-features");
                   options.addArguments("--disable-blink-features=AutomationControlled");
                   options.addArguments("--disable-extensions");
                   options.addArguments("--disable-notifications");
                   WebDriverManager.chromedriver().setup();
                   driver=new ChromeDriver(options);

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {//driver a deger atanmis
            //driver.close();
            driver = null;
        }
    }
}