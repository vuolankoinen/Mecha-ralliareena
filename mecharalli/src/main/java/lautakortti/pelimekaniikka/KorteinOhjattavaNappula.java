package lautakortti.pelimekaniikka;

import java.util.ArrayList;
import java.util.Collections;

public class KorteinOhjattavaNappula implements Liikkuva {

    private int x;
    private int y;
    private ArrayList<Integer> seuraavaSiirto;
    private ArrayList<Integer> kaikkiTarjollaOlevatSiirrot;
    private ArrayList<Integer> konkreettinenSiirtopakka;
    private int hiparit;

    KorteinOhjattavaNappula(int alkusijaintiX, int alkusijaintiY, int alkuHP) {
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

    KorteinOhjattavaNappula(int alkusijaintiX, int alkusijaintiY) {
        this(alkusijaintiX, alkusijaintiY, 4);
    }

    KorteinOhjattavaNappula() {
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
        if (this.hiparit < 3) {
            return 1; //Tähän vahingoittuneen mechan kuva, jahka kehitän sen. XX
        }
        return 1;       //Ehjö mecha.
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

    public void nollaaSiirrot(){
        this.seuraavaSiirto.clear();
    }
    
}
