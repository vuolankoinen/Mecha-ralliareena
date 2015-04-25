package lautakortti.pelimekaniikka;

import java.util.Random;

public class SatunnaisestiLiikkuvaVastustaja implements Liikkuva {

//Laudan liikkuva elementti, jonka liikkeet ovat satunnaisia.
    private int x;
    private int y;
    private Random arpa;
    private int hiparit;

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
     * Liikuttaa nappulaa laudalla.
     *
     * @param pystysuoraMuutosSijainnissa Paljonko liikutetaan pystysuunnassa.
     * @param vaakasuoraMuutosSijainnissa Paljonko liikutetaan vaakasuunnassa.
     */
    public void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa) {
        if ((this.x + vaakasuoraMuutosSijainnissa) < 6 && 0 < (this.x + vaakasuoraMuutosSijainnissa)) {
            this.x += vaakasuoraMuutosSijainnissa;
        }
        if ((this.y + pystysuoraMuutosSijainnissa)<6 && (this.y + pystysuoraMuutosSijainnissa)>0) {     //Samoin tähän.
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

    public boolean onkoRikki() {
        if (this.hiparit < 1) {
            return true;
        }
        return false;
    }
}
