package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

/**
 * Pelilaudan elementti, joka ei liiku mutta vahingoittuu jos siihen
 * törmäillään.
 */
public class HajoavaEste implements Kuvastuva {

    private int x;
    private int y;
    private int kuva;
    private boolean vahingoittaaKolaroidessa;
    private int hiparit;

    /**
     * Konstruktori.
     *
     * @param x Sijaintikoordinaatti sivusuunnassa.
     * @param y Sijaintikoordinaatti pystysuunnassa.
     * @param kuva Halutun kuvan kokonaislukutunnus.
     * @param vahingoittava Vahingoittuvatko tähän törmäävät.
     * @param alkuHP Kuinka monta kestopistettä on aluksi.
     */
    public HajoavaEste(int x, int y, int kuva, boolean vahingoittava, int alkuHP) {
        this.x = x;
        this.y = y;
        this.kuva = kuva;
        this.vahingoittaaKolaroidessa = vahingoittava;
        this.hiparit = alkuHP;
    }

    /**
     * Kuormittaa konstruktoria.
     *
     * @param x
     * @param y
     * @param kuva
     */
    public HajoavaEste(int x, int y, int kuva) {
        this(x, y, kuva, false, 3);
    }

    /**
     * Kuormittaa konstruktoria.
     *
     * @param x
     * @param y
     */
    public HajoavaEste(int x, int y) {
        this(x, y, 7, true, 2);
    }

    /**
     * getteri
     *
     * @return x-koordinaatti
     */
    public int sijaintiSivusuunnassa() {
        return this.x;
    }

    /**
     * getteri
     *
     * @return y-koordinaatti
     */
    public int sijaintiPystysuunnassa() {
        return this.y;
    }

    /**
     * getteri
     *
     * @return kuvan kokonaislukukoodi
     */
    public int mikaKuva() {
        return this.kuva;
    }

    /**
     * Vähentää kestopisteitä parametrin mukaan. Palauttaa
     * vahingoittaakoKolaroidessa.
     *
     * @param kuinkaKovaa Monta kestopistettä vähennetään?
     * @return Vahingoittuuko kolaroija?
     */
    public boolean vahingoittaakoKolaroidessa(int kuinkaKovaa) {
        this.hiparit -= Math.max(kuinkaKovaa, 2);
        return this.vahingoittaaKolaroidessa;
    }

    /**
     * Kertoo, onko olion kestopisteet vähennetty nollaan.
     *
     * @return true, jos kestopisteet lopussa, muuten false
     */
    public boolean onkoRikki() {
        if (this.hiparit > 0) {
            return false;
        }
        return true;
    }

}
