package lautakortti.pelimekaniikka;

import java.util.Random;
import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

public class SatunnaisestiLiikkuvaVastustaja implements Kuvastuva, Liikkuva {

//Laudan liikkuva elementti, jonka liikkeet ovat satunnaisia.
    private int x;
    private int y;
    private Random arpa;

    public SatunnaisestiLiikkuvaVastustaja(int aloitusX, int aloitusY) {
        this.x = aloitusX;
        this.y = aloitusY;
        this.arpa = new Random();
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
        return this.arpa.nextInt(8) + 1;
    }
/**
 * Liikuttaa nappulaa laudalla.
 * 
 * @param pystysuoraMuutosSijainnissa Paljonko liikutetaan pystysuunnassa.
 * @param vaakasuoraMuutosSijainnissa Paljonko liikutetaan vaakasuunnassa.
 */
    public void liiku(int pystysuoraMuutosSijainnissa, int vaakasuoraMuutosSijainnissa) {
        if (true) {      //Tähän testi siirron laillisuudesta!
            this.x += vaakasuoraMuutosSijainnissa;
        }
        if (true) {     //Samoin tähän.
            this.y += pystysuoraMuutosSijainnissa;
        }
    }

}
