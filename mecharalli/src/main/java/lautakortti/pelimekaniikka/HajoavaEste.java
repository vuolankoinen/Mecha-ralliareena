package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;


public class HajoavaEste implements Kuvastuva {

    private int x;
    private int y;
    private int kuva;
    private boolean vahingoittaaKolaroidessa;
    private int hiparit;

    public HajoavaEste(int x, int y, int kuva, boolean vahingoittava, int alkuHP) {
        this.x = x;
        this.y = y;
        this.kuva = kuva;
        this.vahingoittaaKolaroidessa = vahingoittava;
        this.hiparit = alkuHP;
    }

    public HajoavaEste(int x, int y, int kuva) {
        this(x, y, kuva, false, 3);
    }

    public HajoavaEste(int x, int y) {
        this(x, y, 7, false, 3);
    }

    public int sijaintiSivusuunnassa() {
        return this.x;
    }

    public int sijaintiPystysuunnassa() {
        return this.y;
    }

    public int mikaKuva() {
        return this.kuva;
    }

    public boolean vahingoittaakoKolaroidessa(int kuinkaKovaa) {
        kuinkaKovaa = Math.max(kuinkaKovaa, 0);
        this.hiparit -= kuinkaKovaa;
        return this.vahingoittaaKolaroidessa;
    }

    public boolean onkoRikki() {
        if (this.hiparit < 1) {
            return true;
        }
        return false;
    }

}
