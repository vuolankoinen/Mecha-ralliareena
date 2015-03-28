package lautakortti.pelimekaniikka;

public interface Pelilauta {

    //Tämän rajapinnan toteuttavien luokkien oliot ovat pelattavissa.
    //Ne osaavat tarkistaa voittoehtonsa, suorittaa nappuloiden siirrot ja piirtää laudan.
    
    abstract boolean voittikoPelaaja();
    
    abstract void teeSiirrot();
    
    abstract void piirra();
}
