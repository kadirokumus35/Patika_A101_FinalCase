package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class HepsiBuradaTest extends TestBaseRapor {

HepsiBuradaPage hepsiBurada;
Log log;

    @Test
    public void test01(){
    hepsiBurada=new HepsiBuradaPage();

        Driver.getDriver().get(ConfigReader.getProperty("anasayfa"));
        hepsiBurada.cookies.click();


        hepsiBurada.girisYap.click();

        hepsiBurada.login.click();

        hepsiBurada.kullaniciMailAdresi.sendKeys(ConfigReader.getProperty("email"));

        hepsiBurada.kullaniciMailSonrasiGirisYap.click();

        hepsiBurada.kullaniciSifre.sendKeys(ConfigReader.getProperty("sifre"));

        hepsiBurada.sifreSonrasiGirisYap.click();

        String actualHesap=hepsiBurada.hesabım.getText();
        String expectedHesap="kadir OKUMUS";
        Assert.assertTrue(actualHesap.contains(expectedHesap));

        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));

        hepsiBurada.aramaButonu.click();

        hepsiBurada.KiwiBebekTelsizi.click();


        hepsiBurada.sepeteEkle.click();




}


}
