package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

/**
 * Rajapinta, jonka toteuttavat pelilaudan oliot osaavat kertoa, mihin ne
 * seuraavaksi liikkuvat, ja muuttaa sijaintiaan.
 * <p>
 * Laajentaa rajapintaa Kuvastuva, joten oliot osaavat myös kertoa, missä ovat,
 * miltä näyttävät, //ja mitä törmäillessä niiden kanssa tapahtuu.
 */
public interface Liikkuva extends Kuvastuva {

    /**
     * Kertoo olion seuraavan siirron.
     *
     * @return Seuraavan siiirron lukukoodi.
     */
    abstract int kerroSeuraavaSiirto();

    /**
     * Muuttaa olion sijaintia laudalla.
     *
     * @param pystysuoraMuutosSijainnissa
     * @param vaakasuoraMuutosSijainnissa
     * @param ylareuna laudan korkeus siirron laillisuuden tarkistamista varten
     * @param alareuna laudan leveys, siirron laillisuuden tarkistamista varten
     */
    abstract void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa, int ylareuna, int alareuna);
}
