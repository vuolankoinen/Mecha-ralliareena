package lautakortti.grafiikka;

import java.util.List;

/**
 * Rajapinnan toteuttavien luokkien oliot osaavat piirtää pelilaudan.
 */
public interface Piirrustava {

    abstract void piirra(int laudanLeveys, int laudanKorkeus, List<Kuvastuva> laudanElementit);

}
