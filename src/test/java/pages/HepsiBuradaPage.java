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

    @FindBy (xpath = "(//*[text()='Kiwi Bebek Telsizi'])[1]")
    public WebElement KiwiBebekTelsizi;

    @FindBy (xpath = "//button[@class='button big with-icon']")
    public WebElement sepeteEkle;

    @FindBy (xpath = "//button[text()='Sepete git']")
    public WebElement sepeteGit;

    @FindBy (xpath = "//button[text()='Alışverişe devam et']")
    public WebElement alisveriseDevamEt;

    @FindBy (xpath = "//span[text()='kadir OKUMUS']")
    public WebElement hesabım;


}
