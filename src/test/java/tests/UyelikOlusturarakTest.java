package tests;

import Logs.Log;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
       kullaniciHepsiburadaSitesiniZiyaretEder();
       kullaniciGirisIslemiYapar();
       kullaniciGirisIslemininYapildiginiDogrular();
       kullaniciAlmakIstedigiUrünüAratir();
       kullaniciIkiFarkliSaticidanUrünSecer();
       kullaniciSepetineGider();
       IkiFarkliSaticidanUrünAldıgınıDogrular();

    }
















    public void kullaniciHepsiburadaSitesiniZiyaretEder() {
        hepsiBurada = new HepsiBuradaPage();

        Driver.getDriver().get(ConfigReader.getProperty("anasayfa"));
        hepsiBurada.cookies.click();
    }


    public void kullaniciGirisIslemiYapar() throws InterruptedException {

        hepsiBurada.girisYap.click();
        hepsiBurada.login.click();

        Thread.sleep(2000);
        hepsiBurada.kullaniciMailAdresi.sendKeys(ConfigReader.getProperty("email"));
        hepsiBurada.kullaniciMailSonrasiGirisYap.click();
        hepsiBurada.kullaniciSifre.sendKeys(ConfigReader.getProperty("sifre"));
        hepsiBurada.sifreSonrasiGirisYap.click();

    }
    public void kullaniciGirisIslemininYapildiginiDogrular() {
        String actualHesap = hepsiBurada.hesabım.getText();
        System.out.println(actualHesap);
        String expectedHesap = "kadir OKUMUS";
        Assert.assertTrue(actualHesap.contains(expectedHesap));
    }
    public void kullaniciAlmakIstedigiUrünüAratir() {
        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
        hepsiBurada.aramaButonu.click();
    }


    public void kullaniciIkiFarkliSaticidanUrünSecer() throws InterruptedException {
        Thread.sleep(2000);
        hepsiBurada.motorolaBebekTelsizi.click();
        Thread.sleep(2000);

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

        Thread.sleep(2000);


        hepsiBurada.sepeteEkle.click();
        Thread.sleep(2000);

        hepsiBurada.alisveriseDevamEt.click();

        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
        hepsiBurada.aramaButonu.click();
        Thread.sleep(2000);
        hepsiBurada.motorolaBebekTelsizi2.click();
        Thread.sleep(2000);
        String yeniSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        Set<String> yeniwindowHandleSeti=Driver.getDriver().getWindowHandles();

        String yeniikinciSayfaWHDegeri="";
        for (String each:yeniwindowHandleSeti
        ) {
            if(!each.equals(ilkSayfaWindowHandle)){
                yeniikinciSayfaWHDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(yeniikinciSayfaWHDegeri);

        Thread.sleep(2000);
        hepsiBurada.sepeteEkle.click();
        Thread.sleep(2000);
    }

    public void kullaniciSepetineGider() throws InterruptedException {
        hepsiBurada.sepeteGit.click();
        Thread.sleep(2000);
    }

    public void IkiFarkliSaticidanUrünAldıgınıDogrular() {
        System.out.println(Driver.getDriver().getTitle());
        String sepetimSayfasindayiz=Driver.getDriver().getTitle();
        String istenenSayfa="Sepetim";
        Assert.assertTrue(sepetimSayfasindayiz.equals(istenenSayfa));

        String saticiBir=hepsiBurada.saticiCocukIcinHersey.getText();
        System.out.println(saticiBir);
        String saticiIki=hepsiBurada.saticiHappycomtr.getText();
        System.out.println(saticiIki);
        Assert.assertFalse(saticiBir.equals(saticiIki));
        System.out.println(saticiBir.equals(saticiIki));
    }
}


