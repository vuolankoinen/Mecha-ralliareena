Käyttöliittymä- ja grafiikkaluokkia ei lopullisessa versiossa testata. Projektin aikasemmassa vaiheessa joitakin yksikkötestejä oli grafiikkapakkauksen luokille, mutta pidemmän päälle ne eivät osoittautuneet tarkoituksenmukaisiksi.
Käytöliittymää ja grafiikkaa on sen sijaan testattu ohjelman toistuvalla koeajamisella.

Pelimekaniikkaluokka puolestaan on pyritty yksikkötestauksella kattamaan mahdollisimman hyvin.

Osa yksikkötesteistä testaa satunnaisia elementtejä.  Nämä testit eivät ajoittain, epätodennäköisten satunnaismuuttujajakaumien vuoksi, mene ajettaessa läpi. Tämä on luonnollista. 
Satunnaisia tekijöitä testaavia testejä on useita, jolloin vaikka kukin testeistä menee yleensä läpi niin kuin kuuluukin, saattaa välillä useampia testauskerta putkeen epäonnistua. Tärkeintä kuitenkin, että kukin testi menee läpi voittopuolisesti.
