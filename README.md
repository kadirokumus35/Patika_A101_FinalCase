# Patika_A101_FinalCase
<hr/>

Patika.dev A101 Practium projesinde yer aldigim icin cok mutluyum.
Harika bir deneyim ve birçok kazanim elde ederek Patikali olmanin gururunu her daim yasayacagim.
Final Case olarak : 

Gereksinimler<br/>

#Proje Java programlama dilinde yazılmalıdır. Maven repo kullanılmalıdır<br/>
#Kodlar github üzerinden paylaşılması gereklidir<br/>
#Yazılacak senaryo için Selenium ve JUnit/Testng kullaılmalıdır<br/>
#Assertions kullanarak senaryonun doğru çalışırlıgı kontrol edilmelidir<br/>
#Log kullanılmalıdır<br/>
#Page object model uygulanmalıdır<br/>
#OOP prensiplerine uygun geliştirilmelidir<br/>

simdi de bu gereksinimler isiginda projeyi nasil ayaga kaldirdigimi anlatmaya calisacagim

```

1. Kullanıcı girişi yapılarak sepete ürün eklenmesi 
# Kullanıcı Hepsiburada.com sitesini ziyaret eder.
# Kullanıcı giriş işlemi yapılır.
# Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
# Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
# Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
# Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
# Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

```


<br/>

```

2. Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme
# Kullanıcı Hepsiburada.com sitesini ziyaret eder.
# Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
# Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
# Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

```
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
<a href="https://www.intelj.com" target="_blank" rel="noreferrer"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQak-N8W03mK25slV1lwM80i0y1obRPPJOaLA&usqp=CAU" alt="intelj" width="80" height="40"/> </a>
<a href="https://www.maven.com" target="_blank" rel="noreferrer"> <img src="https://koraypeker.com/wp-content/uploads/2018/06/1_xsrKVt69q3JsZzLD-ldekQ.jpeg" alt="git" width="100" height="40"/> </a>
<br/>

test case sonunda almis oldugum raporlar ve log kayitlari da asagida eklenmistir


![uye olmadan test](https://user-images.githubusercontent.com/100091154/200200695-fc2f2f24-86d5-40b4-9051-013b4d921d4f.png)


![uye olarak test](https://user-images.githubusercontent.com/100091154/200200701-1af30cdb-7d1b-468c-9279-e36b3e5796f5.png)


![log uye olmadan](https://user-images.githubusercontent.com/100091154/200200839-725a05df-190b-47c5-98f8-726d79c9b96d.png)


![log a101](https://user-images.githubusercontent.com/100091154/200279385-f9151c9b-a512-4dc5-b60f-ecff630c64a0.png)

