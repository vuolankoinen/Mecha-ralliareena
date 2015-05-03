**Mecharalli-ohjelman käyttöohjeet**  3.5.2015

Mecharallissa pelaaja pääsee ohjastamaan valtavaa kaksijalkaista robottiaan halki erilaisilla esteillä täytetyn tulevaisuuden ralliareenan. Seuraavassa kuvataan pelin toimintaa.

**1** Mecharallin käynnistettyäsi ohjelma avaa ikkunan, jonka oikealla puolella näet tervehdystekstin ja muutamia painikkeita. Näillä painikkeilla voit valita pelattavan pelilaudan.
**2** Laudan valittuasi peli alkaa. Ikkunan vasemmalla puolella näet pelilaudan pelinappuloineen. 
**3** Ikkunan oikealla puolella pääset valitsemaan siirtosi. Peli arpoo tarjolle viisi mahdollista siirtoa, joista valitset kolme. 
**4** Valitut siirrot toteutetaan yksi kerrallaan, siinä järjestyksessä kuin ne valitsit. Samalla laudan muutkin pelinappulat liikkuvat.
**5** Peli loppuu, kun saat mechasi ohjattua maaliin tai kun mechasi tuhoutuu. Siihen saakka toistetaan vuorotellen kohtia **3** ja **4**.

Tarkempia tietoja:
**1:**
-Lautojen koot ovat 1: 4x4, 2: 7x7, 3: 8x8 ja 4: 12x12. 
-Kolmen ensimmäisen laudan asettelu on ennalta määrätty, laudan 4 nappulat arvotaan pelin käynnistyessä.

**2:**
-Omaa mechaasi kuvaava pelinappula on vaaleanpunainen koje laudan vasemmassa yläkulmassa. 
-Maalia kuvaa vaaleanpunainen neliö laudan oikeassa alakulmassa. 
-Muut laudan oliot ovat erilaisia esteitä. Katso niiden tarkemmat kuvaukset kohdasta **4**.

**3:**
-Siirrot **^, v, <, >** vastaavat yhden askeleen ottamista ylös, alas, vasemmalle tai oikealle.
-Siirto **?** arpoo suunnan, johon otetaan askel.
-Siirto **0** on tyhjä siirto, mecha seisoo kierroksen toimettomana.
-Mahdolliset siirrot tulevat pakasta, jossa on neljä kutakin liikutusiirtoa ja kaksi satunnaista siirtoa. Pakasta nostetaan aina viisi seuraavaa siirtoa pelaajan valittaviksi. Pakan loppuessa kesken tulee tarjolle myös tyhjiä siirtoja, ennen kuin pakka taas sekoitetaan seuraavalle kierrokselle uudestaan. Valitsematta jääneet siirrot eivät jää tarjolle seuraavalle kierrokselle, kullekin kierrokselle nostetaan uudet viisi vaihtoehtoa.

**4:**
-Tietokoneen ohjaamat pelinappulat liikkuvat ennen pelaajan mechaa.
-Törmäykset pelilaudan reunoihin eivät johda mihinkään, törmäävä nappula vain seisoo paikoillaan.
-Pelilaudan elementit suhtautuvat likkumiseen seuraavasti:
**Vastustajan mechat**, siniset kojeet, liikkuvat askeleen satunnaiseen suuntaan. Vastustajan mechat menevät rikki, kun niihin törmää pari kertaa, mutta myös törmääjä vahingoittuu hiukan.
**Kivet**, mustat epäsäännölliset möhkäleet, eivät liiku lainkaan. Ne eivät mene rikki, mutta niihin törmääminen vahingoittaa törmääjää.
**Puulaatikot**, kellertävästä laudasta kootut laatikot, eivät liiku. Ne menevät rikki kolmesta törmäyksestä eivätkä vahingoita törmääjää.
**Nyrkkitornit**, mustat pylväät, joissa on sinisevä hehkuva huippu, eivät liiku sijoiltaan. Liikkumisvaiheessa ne kuitenkin vahingoittavat satunnaisessa suunnassa vieressään olevaa pelinappulaa. Tornit kaatuvat törmäyksen voimasta eivätkä vahingoita törmääjää.
Pelaajan mechan päästyä **maaliin**, vaaleanpunaisella neliöllä merkittyyn laudan ruutuun, pelaaja voittaa ja peli päättyy. Vaikka tämä tapahtuisi ensimmäisellä tai toisella siirrolla, vuoron jäljelle jääneitä siirtoja ei enää tehdä.

**5:**
-Pelaaja voittaa, kun hänen mechansa saapuu maaliin.
-Pelaaja kärsii tappion, jos hänen mechansa romuttuu ennen maaliin pääsemistään. Pelaajan mecha saattaa rikkoutua kolaroituaan kivien ja vastustajien kanssa liikaa. Mechalla on pelin aluksi 4 kestopistettä, kolari vie kohteelta 2 pistettä, törmääjältä yhden.
