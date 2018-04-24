A hu.schonherz.blog.service.api.user.service.UserService interfészt egészítsük ki a következő metódussal: 	

Implementáljuk azt úgy, hogy egy listába szúrja be a felhasználót, a már meglévő felhasználók mellé.

 

Készítsünk egy felületet ahol a felhasználó be tud regisztrálni, a következő adatok segítségével. A bevitt adatokat validáljuk kliens és szerver oldalon is.

felhasználó név , max 30 karakter
vezeték név , max 30 karakter
kereszt név , max 30 karakter
email, csak formailag helyes emailcím
telefonszám, formátum +36-30/1234-567
profilkép (elég egy url, a user.picture.large ba kell menteni)
jelszó (legalább 8 karakter, minimum 1 szám)
jelszó ismétlés, meg kell egyeznie a fenti jelszóval
 

A kliens oldali validáció Ajax-ot használjon.

 

Módosítsuk a  hu.schonherz.blog.service.UserServiceImpl, hogy a beregisztrált felhasználó be tudjon jelentkezni.