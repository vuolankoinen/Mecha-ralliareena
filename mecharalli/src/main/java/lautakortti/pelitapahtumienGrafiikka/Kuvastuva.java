package lautakortti.pelitapahtumienGrafiikka;

/**
 * Tämän rajapinnan täyttävät oliot piirtyvät pelilaudalle. Ne osaavat ilmoittaa
 * sijaintinsa laudalla ja miltä ne näyttävät. Ne myös kertovat käyttäytymisensä
 * kolareissa ja tarkistavat, ovatko rikki.
 */
public interface Kuvastuva {

    /**
     * getteri
     *
     * @return x-koordinaatti
     */
    abstract int sijaintiSivusuunnassa();

    /**
     * getteri
     *
     * @return y-koordinaatti
     */
    abstract int sijaintiPystysuunnassa();

    /**
     * getteri
     *
     * @return kuvan lukukoodi
     */
    abstract int mikaKuva();

    /**
     * Toteuttaa kolaroinnin uhrin puolelta, kertoo, vahingoittuuko kolaroija.
     *
     * @param kolaroinninRajuus Kuinka raju törmäys on kyseessä.
     * @return true, jos törmääjä vahingoittuu, muuten false
     */
    abstract boolean vahingoittaakoKolaroidessa(int kolaroinninRajuus);

    /**
     * Tarkistaa, onko olio rikkoutunut.
     *
     * @return true, jos olio on rikki, muuten false
     */
    abstract boolean onkoRikki();
}
