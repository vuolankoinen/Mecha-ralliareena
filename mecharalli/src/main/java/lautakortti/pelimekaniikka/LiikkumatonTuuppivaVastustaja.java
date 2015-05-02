package lautakortti.pelimekaniikka;

import java.util.Random;

public class LiikkumatonTuuppivaVastustaja implements Liikkuva {

//Laudan elementti, jonka "liikkeet" lyövät, mutta eivät liikuta.
    private int x;
    private int y;
    private Random arpa;
    private int hiparit;

    public LiikkumatonTuuppivaVastustaja(int aloitusX, int aloitusY) {
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

    public int mikaKuva() {
        return 4;
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
     * Tyhjä abstraktin metodin toteutus. Parametrit ovat turhia.
     *
     * @param pystysuoraMuutosSijainnissa Paljonko liikutetaan pystysuunnassa.
     * @param vaakasuoraMuutosSijainnissa Paljonko liikutetaan vaakasuunnassa.
     * @param maxX Laudan oikea reuna.
     * @param maxY Yläreuna.
     */
    public void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa, int maxY, int maxX) {
    }

    /**
     * Vähentää kolarin uhrin kestopisteitä.
     *
     * @param kuinkaKovaa int, kuinka paljon pisteitä karisee.
     * @return Palauttaa "false", törmäilijä ei vahingoitu.
     */
    public boolean vahingoittaakoKolaroidessa(int kuinkaKovaa) {
        kuinkaKovaa = Math.max(0, kuinkaKovaa);
        this.hiparit -= kuinkaKovaa;
        return false;
    }

    public boolean onkoRikki() {
        if (this.hiparit < 1) {
            return true;
        }
        return false;
    }
}
