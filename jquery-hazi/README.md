# jQuery-ajax - Feladat leírása:

Az óra végén megnézett jQuery UI segítségével hozzatok létre egy Datatable-t, amely AJAX segítségével tölti a táblázat elemeit egy Servlet-ből. 
A táblázat elemeit a példában látott módon egy Mock-ban tároljátok. Collection statikus változóként. Ezt töltsétek fel dolgozókkal (kb. 15-20db).
A dolgozónak legyen egy azonosítója(int id), neve, életkora, foglalkozása. Ezeket jelenítsétek meg a táblázatban (lásd crudAjax.jsp 60-76. sor, DataServlet 45-48).
Az AJAX hívás a servlet doGet() metódusát hívja meg, itt legyen a felhasználók visszaadását megvalósító logika.

Hozzatok létre egy gombot, amire kattintva megnyílik egy dialógus, amiben a dolgozó adatait tudjuk megadni.
A dialógusban lévő mentés gomb hatására adjátok hozzá a Mock-hoz az új felhasználót,
majd zárjátok be a dialógust, és inicializájátok újra a Datatable-t (lásd crudAjax.jsp 93-122. sor, DataServlet 49-62).
Az AJAX hívás a servlet doPost() metódusát hívja meg, itt legyen a felhasználó mentését megvalósító logika.
Ne felejtsétek el az AJAX hívásnál a type-t POST-ra állítani.

Az órán látott példa többi metódusát (delete, modify stb.) nem kell megcsináljátok, csak a hozzáadást.