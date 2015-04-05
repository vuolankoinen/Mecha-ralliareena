package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;

public class Nappula implements Liikkuva, Kuvastuva {

    private int x;
    private int y;
    private int seuraavaSiirto;

    Nappula(int alkusijaintiX, int alkusijaintiY) {
        this.x = alkusijaintiX;
        this.y = alkusijaintiY;
    }

    /**
     *
     * @return Nappulan seuraavaa siirtoa vastaava kokonaisluku.
     */
    public int kerroSeuraavaSiirto() {
        int siirto = this.seuraavaSiirto;
        this.seuraavaSiirto = 0;
        return siirto;
    }

    public int sijaintiSivusuunnassa() {
        return this.x;
    }

    public int sijaintiPystysuunnassa() {
        return this.y;
    }

    /**
     *
     * @param siirto Nappulan seuraavan siirron kertova koodi
     */
    public void asetaSeuraavaSiirto(int siirto) {
        this.seuraavaSiirto = siirto;
    }

    /**
     *
     * @return Pelaajalle näytettävässä tulosteessa elementtiä vastaavan
     * kuvauksen lukukoodi.
     */
    public int mikaKuva() {
        return 1;
    }

    /**
     * Metodi muuttaa nappulan sijaintia laudalla
     *
     * @param y Kuinka paljon liikutettavan nappulan pystysijainti muuttuu
     * @param x Kuinka paljon liikutettavan nappulan sivusijainti muuttuu
     */
    public void liiku(int y, int x) {
        if (true) {   //Tässä testataan, onko siirto laillinen! XX
            this.x += x;
        }

        if (true) {   //Tässä testataan, onko siirto laillinen! XX
            this.y += y;
        }
    }

}
