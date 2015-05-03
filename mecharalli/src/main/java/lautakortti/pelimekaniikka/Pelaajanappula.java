package lautakortti.pelimekaniikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Pelaajan nappula, jota ohjataan sen siirtovaihtoehtopakan avulla.
 */
public class Pelaajanappula implements Liikkuva {

    private int x;
    private int y;
    private ArrayList<Integer> seuraavaSiirto;
    private ArrayList<Integer> kaikkiTarjollaOlevatSiirrot;
    private ArrayList<Integer> konkreettinenSiirtopakka;
    private int hiparit;

    /**
     * Konstruktori.
     *
     * @param alkusijaintiX x-koordinaatti
     * @param alkusijaintiY y-koordinaatti
     * @param alkuHP Montako kestopistettä nappulalla on aluksi.
     */
    Pelaajanappula(int alkusijaintiX, int alkusijaintiY, int alkuHP) {
        this.x = alkusijaintiX;
        this.y = alkusijaintiY;
        this.hiparit = alkuHP;
        this.seuraavaSiirto = new ArrayList<Integer>();
        this.kaikkiTarjollaOlevatSiirrot = new ArrayList<Integer>();
        for (int i = 1; i < 5; i++) {
            for (int u = 0; u < 4; u++) {
                this.kaikkiTarjollaOlevatSiirrot.add(i);
            }
        }
        this.kaikkiTarjollaOlevatSiirrot.add(5); //jokerit
        this.kaikkiTarjollaOlevatSiirrot.add(5);
        this.konkreettinenSiirtopakka = new ArrayList<Integer>();
        this.konkreettinenSiirtopakka.addAll(this.kaikkiTarjollaOlevatSiirrot);
        Collections.shuffle(this.konkreettinenSiirtopakka);
    }

    /**
     * Kuormittaa konstruktoria.
     *
     * @param alkusijaintiX
     * @param alkusijaintiY
     */
    Pelaajanappula(int alkusijaintiX, int alkusijaintiY) {
        this(alkusijaintiX, alkusijaintiY, 4);
    }

    /**
     * Kertoo seuraavan siirron ja poistaa sen seuraavien siirtojen listasta.
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
     * @return kestopisteet
     */
    public int hiparit() {
        return this.hiparit;
    }

    /**
     * Lisää parametrin seuraavien siirtojen listaan.
     *
     * @param siirto Nappulan seuraavan siirron kertova koodi
     */
    public void asetaSeuraavaSiirto(int siirto) {
        this.seuraavaSiirto.add(siirto);
    }

    /**
     * Palauttaa pelaajanappulan kuvan lukukoodin.
     *
     * @return Pelaajalle näytettävässä tulosteessa elementtiä vastaavan
     * kuvauksen lukukoodi.
     */
    public int mikaKuva() {
        if (this.hiparit < 3) {
            return -1;  //Vahingoittunut mecha.
        }
        return 1;       //Ehjä mecha.
    }

    /**
     * Metodi muuttaa nappulan sijaintia laudalla, ei mene reunan yli.
     *
     * @param y Kuinka paljon liikutettavan nappulan pystysijainti muuttuu
     * @param x Kuinka paljon liikutettavan nappulan sivusijainti muuttuu.
     * @param maxY Laudan yläreuna
     * @param maxX Laudan oikea reuna.
     */
    public void liiku(int y, int x, int maxY, int maxX) {
        if ((this.x + x) < maxX && (this.x + x) > 0) {   //Eihän mene reunan yli?
            this.x += x;
        }

        if ((this.y + y) < maxY && (this.y + y) > 0) {   //Ei ulos laudalta.
            this.y += y;
        }
    }

    /**
     * Vähentää kestopisteitä parametrin verran.
     *
     * @param paljon Kuinka paljon kestopisteitä vähennetään.
     * @return palauttaa true: törmääjä vahingoittuu
     */
    public boolean vahingoittaakoKolaroidessa(int paljon) {
        paljon = Math.max(paljon, 0);
        this.hiparit -= paljon;     //Kolaroidessa nappula vahingoittuu.
        return true;                //Samoin kolaroija.
    }

    /**
     * Kertoo, onko nappulan kestopisteet tippuneet nollaan tai alle.
     *
     * @return true, jos kestopisteet lopussa, muuten false
     */
    public boolean onkoRikki() {
        if (this.hiparit < 1) {
            return true;
        }
        return false;
    }

    /**
     * Poimii siirtopakasta viisi seuraavaa siirtoa tarjolle.
     *
     * @return Viiden seuraavan mahdollisen siirron kokonaislukukoodit
     * ArrayListinä
     */
    public ArrayList<Integer> seuraavatViisiVaihtoehtoa() {
        ArrayList<Integer> seuraavat = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            if (this.konkreettinenSiirtopakka.size() == 0) {
                seuraavat.add(0);   //Jos pakka on loppu, tulee vain tyhjiä siirtoja tarjolle.
                continue;
            }
            seuraavat.add(this.konkreettinenSiirtopakka.get(0));
            this.konkreettinenSiirtopakka.remove(0);
        }
        if (this.konkreettinenSiirtopakka.size() == 0) {
            sekoitaPakka();     //Tuleville kierroksille uudet kortit pakkaan, jos se on loppunut kesken.
        }
        return seuraavat;
    }

    /**
     * Lisää koskemattoman pakallisen uusia siirtoja siirtopakkaan ja sekoittaa
     * sen.
     */
    public void sekoitaPakka() {
        this.konkreettinenSiirtopakka.addAll(this.kaikkiTarjollaOlevatSiirrot);
        Collections.shuffle(this.konkreettinenSiirtopakka);
    }

    /**
     * Tyhjentää seuraavien siirtojen listan.
     */
    public void nollaaSiirrot() {
        this.seuraavaSiirto.clear();
    }

}
