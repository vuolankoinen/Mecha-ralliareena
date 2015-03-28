package lautakortti.pelitapahtumienGrafiikka;

import java.util.List;

public interface Piirrustava {
//Rajapinnan toteuttavien luokkien oliot osaavat piirtää pelilaudan.

    abstract void piirra(int laudanLeveys, int laudanKorkeus, List<Kuvastuva> laudanElementit); 
    
}
