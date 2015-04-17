package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

public interface Liikkuva extends Kuvastuva {

//Tämän rajapinnan toteuttavat oliot osaavat kertoa, mihin ne seuraavaksi liikkuvat.    
    abstract int kerroSeuraavaSiirto();

//Niiden sijaintia voi myös muuttaa metodikutsulla.
    abstract void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa);
}

//Lisäksi kuvastuvina nämä oliot osaavat kertoa, missä ovat, miltä näyttävät, 
//ja mitä törmäillessä niiden kanssa tapahtuu.