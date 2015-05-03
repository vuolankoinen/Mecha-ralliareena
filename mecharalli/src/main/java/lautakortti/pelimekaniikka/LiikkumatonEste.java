package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

/**
 * Pelilaudan elementti, joka ei liiku eikä rikkoudu.
 */
public class LiikkumatonEste implements Kuvastuva {

    private int x;
    private int y;
    private int kuva;
    private boolean vahingoittaaKolaroidessa;

    /**
     * Konstruktori.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param kuva Kuvaesityksen lukukoodi
     * @param vahingoittava Vahingoittaako törmääjää?
     */
    public LiikkumatonEste(int x, int y, int kuva, boolean vahingoittava) {
        this.x = x;
        this.y = y;
        this.kuva = kuva;
        this.vahingoittaaKolaroidessa = vahingoittava;
    }

    /**
     * Kuormittaa konstruktoria.
     *
     * @param x
     * @param y
     * @param kuva
     */
    public LiikkumatonEste(int x, int y, int kuva) {
        this(x, y, kuva, false);
    }

    /**
     * Kuormittaa konstruktoria.
     *
     * @param x
     * @param y
     */
    public LiikkumatonEste(int x, int y) {
        this(x, y, 6, false);
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
     * @return Kuvan lukukoodi.
     */
    public int mikaKuva() {
        return this.kuva;
    }

    /**
     * Kertoo, vahingoittaako olio törmääjää.
     *
     * @param ei Rajapinnan edellyttämä tässä turha parametri.
     * @return Palauttaa true, jos olio vahingoittaa törmääjää, muuten false.
     */
    public boolean vahingoittaakoKolaroidessa(int ei) {
        return this.vahingoittaaKolaroidessa;
    }

    /**
     * Kertoo, onko olion kestopisteet tippuneet nollaan tai alle.
     *
     * @return true, jos kestopisteet lopussa, muuten false
     */
    public boolean onkoRikki() {
//        if (this.hiparit<1){
//            return true;
//        }
        return false;
    }

}
