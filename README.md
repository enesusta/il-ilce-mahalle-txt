### Ne işe yarar?

SQL üzerinden sorgu yapmaya kalkarsa, her bir il,ilçenin ve mahallenin veritabanında kayıtlı olan id'leri hakkında bilgiye sahip olmamız gerekir.
Nitekim referans aldığım veritabanında bu bilgiler girilmiş dahi olsa dağınık haldeydi. Bir noktada kullanımını imkansız hale getirmekteydi.

Tüm id'leri ezberleyip el ile tek tek yazma şansım olmadığı içinde bu basit script ortaya çıktı.

- Kullanımı :
  - city/EDİRNE/MERKEZ.txt

Bu örneğin sonucunda Edirne ilinin Merkez ilçesindeki mahalle isimlerini elde etmiş olacağız. Tek yapmanız gereken kullandığınız dil vasıtası ile
dosyayı okutmak.

`Referans aldığım veritabanı` [Ilgili Veritabani](https://github.com/life/il-ilce-mahalle-sokak-cadde-sql)

 Mahalle bilgisine sahip dosyalar src/main/resources altinda bulunuyor. 

Kullanmak için : 
`git clone https://github.com/enesusta/il-ilce-mahalle-txt`