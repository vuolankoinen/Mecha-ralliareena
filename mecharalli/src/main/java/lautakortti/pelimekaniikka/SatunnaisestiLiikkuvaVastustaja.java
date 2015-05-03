package lautakortti.pelimekaniikka;

import java.util.Random;
import lautakortti.pelimekaniikka.Liikkuva;

/**
 * Laudan liikkuva elementti, jonka liikkeet ovat satunnaisia.
 */
public class SatunnaisestiLiikkuvaVastustaja implements Liikkuva {

    private int x;
    private int y;
    private Random arpa;
    private int hiparit;

    /**
     * Konstruktori.
     *
     * @param aloitusX x-koordinaatti
     * @param aloitusY y-koordinaatti
     */
    public SatunnaisestiLiikkuvaVastustaja(int aloitusX, int aloitusY) {
        this.x = aloitusX;
        this.y = aloitusY;
        this.arpa = new Random();
        this.hiparit = 3;
    }

    public int sijaintiSivusuunnassa() {
        return this.x;
    }

    public int sijaintiPystysuunnassa() {
        return this.y;
    }

    /**
     * Palauttaa olion kuva lukukoodin.
     *
     * @return olion kuvan koodi, eli 3
     */
    public int mikaKuva() {
        return 3;
    }

    /**
     * Arpoo seuraavan siirron nappulalle.
     *
     * @return Seuraavaa satunnaista siirtoa vastaava luku.
     */
    public int kerroSeuraavaSiirto() {
        return this.arpa.nextInt(4) + 1;
    }

    /**
     * Liikuttaa nappulaa laudalla, ei mene reunojen yli.
     *
     * @param pystysuoraMuutosSijainnissa Paljonko liikutetaan pystysuunnassa.
     * @param vaakasuoraMuutosSijainnissa Paljonko liikutetaan vaakasuunnassa.
     * @param maxX Laudan oikea reuna.
     * @param maxY Yläreuna.
     */
    public void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa, int maxY, int maxX) {
        if ((this.x + vaakasuoraMuutosSijainnissa) < maxX && 0 < (this.x + vaakasuoraMuutosSijainnissa)) {
            this.x += vaakasuoraMuutosSijainnissa;
        }
        if ((this.y + pystysuoraMuutosSijainnissa) < maxY && (this.y + pystysuoraMuutosSijainnissa) > 0) {     //Samoin tähän.
            this.y += pystysuoraMuutosSijainnissa;
        }
    }

    /**
     * Vähentää kolarin uhrin kestopisteitä.
     *
     * @param kuinkaKovaa int, kuinka paljon pisteitä karisee.
     * @return Palauttaa "true", myös törmäilijä vahingoittuu.
     */
    public boolean vahingoittaakoKolaroidessa(int kuinkaKovaa) {
        kuinkaKovaa = Math.max(0, kuinkaKovaa);
        this.hiparit -= kuinkaKovaa;
        return true;
    }

    /**
     * Tarkistaa, ovatko kestopisteet nollassa tai alle.
     *
     * @return true, jos kestopisteet lopussa, muuten false
     */
    public boolean onkoRikki() {
        if (this.hiparit < 1) {
            return true;
        }
        return false;
    }
}
