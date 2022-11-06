# Patika_A101_FinalCase
<hr/>

Patika.dev A101 Practium projesinde yer aldigim icin cok mutluyum.
Harika bir deneyim ve birçok kazanim elde ederek Patikali olmanin gururunu her daim yasayacagim.
Final Case olarak : 

Gereksinimler
# Proje Java programlama dilinde yazılmalıdır. Maven repo kullanılmalıdır.
# Kodlar github üzerinden paylaşılması gereklidir. 
# Yazılacak senaryo için Selenium ve JUnit/Testng kullanılmalıdır.
# Assertions kullanarak senaryonun doğru çalışırlığı kontrol edilmelidir.
# Log kullanılmalıdır.
# Page object model uygulanmalıdır.
# OOP prensiplerine uygun geliştirilmelidir.

simdi de bu gereksinimler isiginda projeyi nasil ayaga kaldirdigimi anlatmaya calisacagim


<br/>

### pages dosyasi <br/>
bu dosyamda benden istenen sitenin testlerini gerceklestirecegim elementlerin locatelerini sakladigim classim yer almakta
İstedigim locate almak icin olusturdugum classin adinda constructar olusturdum ve icine <b> PageFactory </b> classini cagirip
olusturdugum driveri cagirip burada olduğunu belli ettigim <b> this </b> key'i kullandim. 
Locatelerimi cagirabilinmek için de <b> FindBy </b> notasyonu ile locatelerimi sirayla aldim

### tests dosyasi <br/>
tests classimda HepsiburadaTest isimli classimi olustururken TestNG'de rapor almak icin TestBaseRapor class ile extends yaparak parent-child iliskisi kurdum.
Boylelikle her aksiyon sonrasi yaptigim islemleri raporladim. 
Log alabilmek icinde gerekli kurulum, eklenti ve ayarlamalari yapip ayni class icinde <b> priority </b> ile testlerim arasinda oncelik belirledim. 
Once hedef alisveris sitesine uye olmadan urun aratip farkli saticidan da ayni urunu alarak dogrulamalari yaptim.
Ardindan test case gerekliliklerine bagli kalarak hedef siteye gidip giris yaptim. 
Login olma sonrasi urun aratip ayni urunu farkli saticidan da sepetime ekledim.
Secili urunlerin sepetim icinde yer aldigini dogrulayarak testlerimi bitirdim.
 
### utilities dosyası <br/>
yardimci classimiz. Bu dosyamda sürekli lazim olan classlarimiz ve methodlarimiz bulunmaktadir. İcerisinde  projemi daha anlasilir hale getirecek classlarim ve methodlarim var bunlar
<b> Driver.class </b> , <b> Log.class </b> , <b> ConfigReader.class </b> , <b> ReusableMehod.class </b> , <b> TestBaseRapor.class </b> dosyalarim bulunmaktadir. 


### <b> Driver.class </b>
Selenium webDriver ayarlarini yaparak bilhassa bu projede karsilasmis oldugum web sitesini test etme engelini 
ChromeOptions classindan obje olusturup gerekli eklemeleri yaparak istedigim tarayicida testlerimi kosmayi sagladim


### <b> Log.class </b>
Test Case de yer alan Log kullanilmali gerekliliginden oturu olusturulmus bir class. 
Hazir ve olusturulmus metotlar cercevesinde Log almayi sagladim

### <b> ConfigReader.class </b>
getProperty() methodu ile testlerimde lazim olan adimlarda ve yerlerde properties dosyalarimi kullanmami sagladi

### <b> ReusableMethod.class </b>
Tekrar tekrar kullanmam gereken wait ve windowshandle gibi metotlari olusturup istedigim zaman istedigim yerde cagirarak bu metotlari kullandim

### <b> TestBaseRapor.class </b>
test package icinde yer alan testlerime extends ile parent/child iliskisi kurdum. 
Boylelikle TestNG de rapor almayi sagladim

## pom.xml
Maven'in kalbi denen pom.xml dosyasi ile istedigim kodlarin kutuphanesini  <b> dependencies </b> taginin icerisine yerlestirip guncel bilgileri sürekli olarak kullanmayi amacladim. Burası sayesinde tum kodlara erisim sagladim

### <b> configuration.properties </b>
properties dosyamda sürekli kullandigim variablelarim bulunmakta ,
bu veriabları kullanmak için properties dosyası <b> Key  =  value </b> olarak oluşturulmakta 
ornek vermek gerekirse istenen ana sayfa ve url , login olma icin gerekli mail ve sifreler vb.
buradaki bilgileri baska classlara cagirabilmek icin utilities dosyasindan
<b> ConfigReader </b> classi cagirilarak icindeki method sayesinde bu dosyada bulunan bilgileri istediğim yere cagirabildim ve kullandim.

### <b> log4j.properties </b>
Belirlemis oldugum yerde log.txt dosyasi olusturarak Log kaydi almayi sagladigim properties dosyasi
<hr/>

# Selenium Testi

<br/>

Java11  ve Maven projesi olusturulup TestNG framework kullanilarak olusturulmustur

<br/>
<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a>
<a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a>
<a href="https://www.selenium.com" target="_blank" rel="noreferrer"> <img src="https://camo.githubusercontent.com/4b95df4d6ca7a01afc25d27159804dc5a7d0df41d8131aaf50c9f84847dfda21/68747470733a2f2f73656c656e69756d2e6465762f696d616765732f73656c656e69756d5f6c6f676f5f7371756172655f677265656e2e706e67" alt="Selenium" width="50" height="50"/> </a>

<img alt="testng ile ilgili görsel sonucu" id="dimg_5" src="data:image/jpeg;base64,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" data-atf="1" data-frt="0" style="width: 186px; height: 186px; margin-left: 0px; margin-right: 0px; margin-top: 0px;">

<a href="https://www.intelj.com" target="_blank" rel="noreferrer"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQak-N8W03mK25slV1lwM80i0y1obRPPJOaLA&usqp=CAU" alt="intelj" width="80" height="40"/> </a>
<a href="https://www.maven.com" target="_blank" rel="noreferrer"> <img src="https://koraypeker.com/wp-content/uploads/2018/06/1_xsrKVt69q3JsZzLD-ldekQ.jpeg" alt="git" width="100" height="40"/> </a>
<br/>
