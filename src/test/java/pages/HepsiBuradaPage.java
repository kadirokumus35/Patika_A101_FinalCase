package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class HepsiBuradaPage {

    public HepsiBuradaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookies;

    @FindBy (xpath = "//*[@data-test-id='account']")
    public WebElement girisYap;

    @FindBy (xpath = "//*[@id='login']")
    public WebElement login;

    @FindBy (xpath = "//input[@id='txtUserName']")
    public WebElement kullaniciMailAdresi;

    @FindBy (xpath = "//button[@id='btnLogin']")
    public WebElement kullaniciMailSonrasiGirisYap;

    @FindBy (xpath = "//input[@id='txtPassword']")
    public WebElement kullaniciSifre;

    @FindBy (xpath = "//button[@id='btnEmailSelect']")
    public WebElement sifreSonrasiGirisYap;

    @FindBy (xpath = "//input[@aria-controls='react-autowhatever-1']")
    public WebElement aramaCubugu;

    @FindBy (xpath = "//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement aramaButonu;

    @FindBy (xpath = "(//*[@data-test-id='product-card-image-container'])[1]")
    public WebElement bebekTelsizi;

    @FindBy (xpath = "//*[@id='addToCart']")
    public WebElement sepeteEkle;

    @FindBy (xpath = "//button[text()='Sepete git']")
    public WebElement sepeteGit;

    @FindBy (xpath = "//button[text()='Alışverişe devam et']")
    public WebElement alisveriseDevamEt;

    @FindBy (xpath = "//span[text()='kadir OKUMUS']")
    public WebElement hesabım;

    @FindBy (xpath = "(//div[@class='_3vX07w_kqpZqSEOOjOvSyI'])[1]")
    public WebElement googleDevam;

    @FindBy (xpath = "//input[@class='whsOnd zHQkBf']")
    public WebElement googleSonrasiEmail;

    @FindBy (xpath = "(//*[@jsname='V67aGc'])[2]")
    public WebElement ileri;

    @FindBy (xpath = "(//*[@data-test-id='product-card-image-container'])[2]")
    public WebElement motorolaBebekTelsizi2;

    @FindBy (xpath = "//*[text()='rammar']")
    public WebElement rammar;

    @FindBy (xpath = "//*[text()='happycomtr']")
    public WebElement saticiHappycomtr;

    @FindBy (xpath = "(//*[@id='selectedCheckBox'])[1]")
    public WebElement urunEklendi;

    @FindBy (xpath = "(//*[@id='selectedCheckBox'])[2]")
    public WebElement ikinciUrunEklendi;

    @FindBy (xpath = "//*[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement ekraniKapat;

    @FindBy (xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement digerSaticidanUrunEkle;

    @FindBy (xpath = "//*[@class='otherBuyOptions']")
    public WebElement saticilar;

    @FindBy (xpath = "//*[@data-test-class='modal_overflow']")
    public WebElement basSayfa;



}
