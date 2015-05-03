**Ohjelma** ei tee muuta kuin käynnistää käyttöliittymän.

**Kayttoliittyma** vuorovaikuttaa käyttäjän kanssa. Se luo käyttäjän haluaman Esterata-luokan ilmentymän ja välittää käyttäjältä sille sen tarvitsemat syötteet.
 **Esterata** näyttäytyy käyttöliittymälle **Pelilauta**-rajapinnan kautta. 

Esterataan liittyy yksi **Kuvaesitys**-luokan olio, jonka se näkee  **Piirrustava**-rajapinnan kautta.
Esteradalla on joukko **Kuvastuva**-rajapinnan täyttäviä olioita, jotka se lähettää kuvaesitykselleen metodikutsun parametreina silloin, kun pelitilanteesta piirretään käyttäjälle kuva.

Esteradalla on myös joukko **Liikkuva**-rajapinnan olioita. Liikkua-oliot ovat aina myös Kuvastuva-olioita, ja tämä laudan liikuvien olioiden joukko onkin sen kuvastuvien olioiden osajoukko.

Esterataan liittyy aina tasan yksi **Pelaajanappula**-luokan ilmentymä, joka kuuluu myös laudan liikkuvien ja kuvastuvien olioiden joukkoihin. 

Huomioita:
Nykyisessä toteutuksessa rajapinnat Pelilauta ja Piirrustava eivät ole merkittävässä käytössä. Jatkokehitykselle rajapinnat kuitenkin antavat mahdollisuuksia: 
-Erilaisilla Piirrustavilla pelin ulkoasua voisi helposti vaihdella vaikkapa teemasta toiseen. Hienompia grafiikoita, hulluttelevia vaihtoehtoisia grafiikoita, mecha-teeman asemesta vaikkapa possuja ja kanoja.
-Erilaisilla Pelilauta-rajapinnan täyttävillä luokilla peliin saisi nopeasti lisää vaihtelua ja sisältöä. Tarkoituksenani olikin alunperin ehtiä toteuttaa mm. "viimeinen mecha jaloillaan"-tyyppinen pelilauta, mikä ei nykyisellä luokkarakenteella olisi työlästä.
