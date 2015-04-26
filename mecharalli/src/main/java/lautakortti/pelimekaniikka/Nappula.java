package lautakortti.pelimekaniikka;

import java.util.ArrayList;

public class Nappula implements Liikkuva {

    private int x;
    private int y;
    private ArrayList<Integer> seuraavaSiirto;
    private int hiparit;

    Nappula(int alkusijaintiX, int alkusijaintiY, int alkuHP) {
        this.x = alkusijaintiX;
        this.y = alkusijaintiY;
        this.hiparit = alkuHP;
        this.seuraavaSiirto = new ArrayList<Integer>();
    }

    Nappula(int alkusijaintiX, int alkusijaintiY) {
        this(alkusijaintiX, alkusijaintiY, 4);
    }

    Nappula() {
        this(1, 1, 4);
    }

    /**
     *
     * @return Nappulan seuraavaa siirtoa vastaava kokonaisluku.
     */
    public int kerroSeuraavaSiirto() {
        if (this.seuraavaSiirto.size() == 0) {
            return 0;
        }
        int siirto = this.seuraavaSiirto.get(0);
        this.seuraavaSiirto.remove(0);
        return siirto;
    }

    public int sijaintiSivusuunnassa() {
        return this.x;
    }

    public int sijaintiPystysuunnassa() {
        return this.y;
    }

    public int hiparit() {
        return this.hiparit;
    }

    /**
     *
     * @param siirto Nappulan seuraavan siirron kertova koodi
     */
    public void asetaSeuraavaSiirto(int siirto) {
        this.seuraavaSiirto.add(siirto);
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
     * Metodi muuttaa nappulan sijaintia laudalla, ei siirrä reunojen yli.
     *
     * @param y Kuinka paljon liikutettavan nappulan pystysijainti muuttuu
     * @param x Kuinka paljon liikutettavan nappulan sivusijainti muuttuu
     * @param maxY Laudan yläreuna
     * @param maxX Laudan oikea reuna
     */
    public void liiku(int y, int x, int maxY, int maxX) {
        if ((this.x+x)<maxX&&(this.x+x)>0) {   //Meneekö reunan yli?
            this.x += x;
        }

        if ((this.y+y)<maxY&&(this.y+y)>0) {   //Meneekö reunan yli?
            this.y += y;
        }
    }

    public boolean vahingoittaakoKolaroidessa(int paljon) {
        paljon = Math.max(paljon, 0);
        this.hiparit -= paljon;     //Kolaroidessa nappula vahingoittuu.
        return true;                //Samoin kolaroija.
    }

    public boolean onkoRikki() {
        if (this.hiparit < 1) {
            return true;
        }
        return false;
    }

}
