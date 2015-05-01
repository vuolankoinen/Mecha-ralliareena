package lautakortti.pelimekaniikka;

import java.util.ArrayList;

public interface Pelilauta {

    //Tämän rajapinnan toteuttavien luokkien oliot ovat pelattavissa.
    //Ne osaavat tarkistaa voittoehtonsa, suorittaa nappuloiden siirrot ja piirtää laudan.
    
    abstract boolean voittikoPelaaja();
    
    abstract boolean tuhoutuikoPelaaja();
    
    //Siirtojen tekeminen palauttaa tekstikuvauksen tapahtumista.
    abstract String teeSiirrot();
    
    abstract void piirra();
    
    abstract void asetaSiirto(String siirto);  
    
    abstract ArrayList<Integer> seuraavatViisiVaihtoehtoa();
    
    abstract void nollaaSiirrot();
}
