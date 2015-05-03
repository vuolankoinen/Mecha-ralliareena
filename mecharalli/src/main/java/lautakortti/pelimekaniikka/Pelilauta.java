package lautakortti.pelimekaniikka;

import java.util.ArrayList;

/**
 * Rajapinta, jonka toteuttavien luokkien oliot ovat pelattavissa.
 * <p>
 * Ne osaavat tarkistaa pelin loppuehdot, suorittaa nappuloiden siirrot, piirtää
 * laudan ja välittää siirtoihin liittyvää tietoa pelaajan ja pelinappulan
 * välillä.
 */
public interface Pelilauta {

    /**
     * Tarkistaa, voittiko pelaaja pelin.
     *
     * @return true, jos voittoehto täyttyy, muuten false
     */
    abstract boolean voittikoPelaaja();

    /**
     * Tarkistaa, hävisikö pelaaja pelin.
     *
     * @return true, jos pelaaja on hävinnyt, muuten false
     */
    abstract boolean tuhoutuikoPelaaja();

    /**
     * Toteuttaa pelilaudan yhden kierroksen siirrot.
     *
     * @return tekstikuvaus siirtoihin liittyvistä tapahtumista
     */
    abstract String teeSiirrot();

    /**
     * Piirtää pelilaudan pelaajan nähtäväksi.
     */
    abstract void piirra();

    /**
     * Asettaa parametria vastaavan siirron pelaajan seuraavaksi siirroksi.
     *
     * @param siirto String-koodi seuraavalle siirrolle
     */
    abstract void asetaSiirto(String siirto);

    /**
     * Palauttaa listan viidestä seuraavasta siirtovaihtoehdosta.
     *
     * @return ArrayList, jossa viiden seuraavan siirtovaihtoehdon lukukoodit
     */
    abstract ArrayList<Integer> seuraavatViisiVaihtoehtoa();

    /**
     * Nollaa asetetut siirrot.
     */
    abstract void nollaaSiirrot();
}
