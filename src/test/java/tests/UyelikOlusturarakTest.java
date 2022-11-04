package tests;

import Logs.Log;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;

import java.util.Set;

public class UyelikOlusturarakTest extends TestBaseRapor {

HepsiBuradaPage hepsiBurada;
Log log;
    ReusableMethod rs;

    @Test
    public void test01() throws InterruptedException {
        hepsiBurada = new HepsiBuradaPage();

        Driver.getDriver().get(ConfigReader.getProperty("anasayfa"));
        hepsiBurada.cookies.click();


        hepsiBurada.girisYap.click();

        hepsiBurada.login.click();

        Thread.sleep(1000);
        hepsiBurada.kullaniciMailAdresi.sendKeys(ConfigReader.getProperty("email"));
        hepsiBurada.kullaniciMailSonrasiGirisYap.click();
        hepsiBurada.kullaniciSifre.sendKeys(ConfigReader.getProperty("sifre"));
        hepsiBurada.sifreSonrasiGirisYap.click();
        String actualHesap = hepsiBurada.hesabım.getText();
        System.out.println(actualHesap);
        String expectedHesap = "kadir OKUMUS";
        Assert.assertTrue(actualHesap.contains(expectedHesap));

        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
        hepsiBurada.aramaButonu.click();

        Thread.sleep(1000);
        hepsiBurada.MotorolaBebekTelsizi.click();
        Thread.sleep(1000);

       String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
       Set<String> windowHandleSeti=Driver.getDriver().getWindowHandles();

       String ikinciSayfaWHDegeri="";
       for (String each:windowHandleSeti
       ) {
           if(!each.equals(ilkSayfaWindowHandle)){
               ikinciSayfaWHDegeri=each;
           }
       }
       Driver.getDriver().switchTo().window(ikinciSayfaWHDegeri);

        Thread.sleep(1000);


            hepsiBurada.sepeteEkle.click();
            Thread.sleep(1000);

            hepsiBurada.alisveriseDevamEt.click();

           hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
            hepsiBurada.aramaButonu.click();

        }
    }


