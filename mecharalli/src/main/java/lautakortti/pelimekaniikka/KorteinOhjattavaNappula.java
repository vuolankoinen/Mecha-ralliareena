/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lautakortti.pelimekaniikka;

import java.util.ArrayList;

/**
 *
 * @author user
 */
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
        for (int i=1;i<5;i++){
            for (int u = 0;u<4;u++){
                this.kaikkiTarjollaOlevatSiirrot.add(i);
            }
        }
        this.konkreettinenSiirtopakka = this.kaikkiTarjollaOlevatSiirrot;
        //this.konkreettinenSiirtopakka.randomize();
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
        if (this.seuraavaSiirto.size()==0){
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

    public boolean vahingoittaakoKolaroidessa(int paljon) {
        paljon = Math.max(paljon, 0);
        this.hiparit -= paljon;     //Kolaroidessa nappula vahingoittuu.
        return true;                //Samoin kolaroija.
    }
    
    public boolean onkoRikki(){
        if (this.hiparit<1){
            return true;
        }
        return false;
    }
    
    public ArrayList<Integer> seuraavatViisiVaihtoehtoa(){
        ArrayList<Integer> seuraavat = new ArrayList<Integer>();
        for (int i=0;i<5;i++){
            if (this.konkreettinenSiirtopakka.size()<i+1){
                seuraavat.add(0);
                continue;
            }
            seuraavat.add(this.konkreettinenSiirtopakka.get(i));
        }
        return seuraavat;
    }

}
