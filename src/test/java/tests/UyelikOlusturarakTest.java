package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HepsiBuradaPage;
import utilities.*;
import java.util.Set;


public class UyelikOlusturarakTest extends TestBaseRapor {

    HepsiBuradaPage hepsiBurada;
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
       SecilenUrunlerinDogruEklendigiDogrulanir();

    }



    private void kullaniciHepsiburadaSitesiniZiyaretEder() {
        hepsiBurada = new HepsiBuradaPage();

        Driver.getDriver().get(ConfigReader.getProperty("anasayfa"));
        hepsiBurada.cookies.click();
    }


    private void kullaniciGirisIslemiYapar() throws InterruptedException {

        hepsiBurada.girisYap.click();
        hepsiBurada.login.click();

        Thread.sleep(2000);
        hepsiBurada.kullaniciMailAdresi.sendKeys(ConfigReader.getProperty("email"));
        hepsiBurada.kullaniciMailSonrasiGirisYap.click();
        hepsiBurada.kullaniciSifre.sendKeys(ConfigReader.getProperty("sifre"));
        hepsiBurada.sifreSonrasiGirisYap.click();

    }
    private void kullaniciGirisIslemininYapildiginiDogrular() {
        String actualHesap = hepsiBurada.hesabım.getText();
        String expectedHesap = "kadir OKUMUS";
        Assert.assertTrue(actualHesap.contains(expectedHesap));
    }
    private void kullaniciAlmakIstedigiUrünüAratir() {
        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
        hepsiBurada.aramaButonu.click();
    }


    private void kullaniciIkiFarkliSaticidanUrünSecer() throws InterruptedException {
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

    private void kullaniciSepetineGider() throws InterruptedException {
        hepsiBurada.sepeteGit.click();
        Thread.sleep(2000);
    }

    private void IkiFarkliSaticidanUrünAldıgınıDogrular() {
        System.out.println(Driver.getDriver().getTitle());
        String sepetimSayfasindayiz=Driver.getDriver().getTitle();
        String istenenSayfa="Sepetim";
        Assert.assertTrue(sepetimSayfasindayiz.equals(istenenSayfa));

        String saticiBir=hepsiBurada.saticiCocukIcinHersey.getText();
        System.out.println(saticiBir);
        String saticiIki=hepsiBurada.saticiHappycomtr.getText();
        System.out.println(saticiIki);
        Assert.assertFalse(saticiBir.equals(saticiIki));


    }

    private void SecilenUrunlerinDogruEklendigiDogrulanir() {
        Assert.assertTrue(hepsiBurada.urunEklendi.isSelected());
        Assert.assertTrue(hepsiBurada.ikinciUrunEklendi.isSelected());
    }

}


