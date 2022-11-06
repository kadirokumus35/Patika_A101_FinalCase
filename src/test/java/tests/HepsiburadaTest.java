package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.*;

import java.util.Set;

public class HepsiburadaTest extends TestBaseRapor {

    HepsiBuradaPage hepsiBurada;
    ReusableMethod rs;
    JavascriptExecutor js;
    Actions actions;

    @Test(priority = 2)
    public void UyelikOlusturarakTest() throws InterruptedException {
        Log.startTestCase(" *** UYE OLUSTURARAK TEST BASLADİ *** ");
        kullaniciHepsiburadaSitesiniZiyaretEder();
        Log.info(" Hepsiburada sitesine gidildi ");
        kullaniciGirisIslemiYapar();
        Log.info(" giris islemi yapildi ");
        kullaniciGirisIslemininYapildiginiDogrular();
        Log.info(" giris isleminin yapildigi dogrulandi ");
        kullaniciAlmakIstedigiUrünüAratirVeBirUrunSecer();
        Log.info(" almak istedigi urun aratildi ");
        kullaniciFarkliSaticidanUrünSecer();
        Log.info(" farkli bir saticidan da aynı urun secildi ");
        kullaniciSepetineGider();
        Log.info(" sepete gidildi");
        IkiFarkliSaticidanUrünAldıgınıDogrular();
        Log.info(" iki farkli saticidan urun alindigi dogrulandi ");
        SecilenUrunlerinDogruEklendigiDogrulanir();
        Log.info(" secilen urunlerin eklendigini dogrulandi ");
        Log.endTestCase(" *** UYE OLUSTURARAK TEST BİTTİ *** ");

    }
    @Test(priority = 1)
    public void UyeOlmadanTest() throws InterruptedException {
        Log.startTestCase(" *** UYE OLMADAN TEST BASLADİ *** ");
        kullaniciHepsiburadaSitesiniZiyaretEder();
        Log.info(" Hepsiburada sitesine gidildi ");
        UyeOlmadanAlmakIstedigiUrünüAratirVeBirUrunSecer();
        Log.info(" Uye olmadan istedigi urun aratildi ");
        UyeOlmadanFarkliSaticidanUrünSecer();
        Log.info(" farkli bir saticidan da aynı urun secildi ");
        UyeOlmadanSepetineGider();
        Log.info(" sepete gidildi");
        IkiFarkliSaticidanUrünAldıgınıDogrular();
        Log.info(" iki farkli saticidan urun alindigi dogrulandi ");
        SecilenUrunlerinDogruEklendigiDogrulanir();
        Log.endTestCase(" *** UYE OLMADAN TEST BİTTİ *** ");

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
    private void kullaniciAlmakIstedigiUrünüAratirVeBirUrunSecer() {
        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
        rs.waitFor(2);
        hepsiBurada.aramaButonu.click();
        rs.waitFor(2);
        hepsiBurada.bebekTelsizi.click();
        rs.waitFor(2);

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

        rs.waitFor(2);
        hepsiBurada.sepeteEkle.click();
        rs.waitFor(2);

    }


    private void kullaniciFarkliSaticidanUrünSecer() {
        hepsiBurada.ekraniKapat.click();
        rs.waitFor(2);
        Driver.getDriver().navigate().refresh();
        rs.waitFor(2);
        hepsiBurada.digerSaticidanUrunEkle.click();

    }

    private void kullaniciSepetineGider() {
        rs.waitForVisibility(hepsiBurada.sepeteGit,2000);
        hepsiBurada.sepeteGit.click();

    }

    private void IkiFarkliSaticidanUrünAldıgınıDogrular() {
        System.out.println(Driver.getDriver().getTitle());
        String sepetimSayfasindayiz=Driver.getDriver().getTitle();
        String istenenSayfa="Sepetim";
        Assert.assertTrue(sepetimSayfasindayiz.equals(istenenSayfa));

        String saticiBir=hepsiBurada.saticiHappycomtr.getText();
        System.out.println(saticiBir);
        String saticiIki=hepsiBurada.rammar.getText();
        System.out.println(saticiIki);
        Assert.assertFalse(saticiBir.equals(saticiIki));


    }

    private void SecilenUrunlerinDogruEklendigiDogrulanir() {
        Assert.assertTrue(hepsiBurada.urunEklendi.isSelected());
        Assert.assertTrue(hepsiBurada.ikinciUrunEklendi.isSelected());
    }

    public void UyeOlmadanAlmakIstedigiUrünüAratirVeBirUrunSecer() {
        rs.waitForVisibility(hepsiBurada.aramaCubugu,2000);
        hepsiBurada.aramaCubugu.sendKeys(ConfigReader.getProperty("arananUrun"));
        hepsiBurada.aramaButonu.click();
        rs.waitFor(2);
        hepsiBurada.bebekTelsizi.click();
        rs.waitFor(2);

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

        ReusableMethod.waitForVisibility(hepsiBurada.sepeteEkle,2000);
        hepsiBurada.sepeteEkle.click();
        ReusableMethod.waitFor(2);
    }

    private void UyeOlmadanFarkliSaticidanUrünSecer() throws InterruptedException {
        hepsiBurada.ekraniKapat.click();
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        hepsiBurada.digerSaticidanUrunEkle.click();
    }

    private void UyeOlmadanSepetineGider() {
        hepsiBurada.sepeteGit.click();
        rs.waitFor(2);
    }

}

