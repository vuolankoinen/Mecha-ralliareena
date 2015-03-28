package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumien_grafiikka.Piirrustava;
import lautakortti.pelitapahtumien_grafiikka.Kuvastuva;
import java.util.ArrayList;

public class AlkeellinenPelilauta implements Pelilauta {

    private Piirrustava piirrin;
    private int leveys;
    private int korkeus;
    private ArrayList<Kuvastuva> laudanOliot;
    private ArrayList<Liikkuva> laudanLiikkuvatOliot;
    private int maaliX;
    private int maaliY;

    public AlkeellinenPelilauta(int tyyppi, Piirrustava piirrin) {
        this.piirrin = piirrin;
        if (tyyppi == 1) {      //Erilaisia lautoja voi lisätä eri parametreille.
            this.leveys = 4;
            this.korkeus = 4;
            this.laudanOliot = new ArrayList<Kuvastuva>();
            this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
            this.maaliX = 4;
            this.maaliY = 4;
        }
        Nappula pelaajanappula = new Nappula(1, 1);
        this.laudanOliot.add(pelaajanappula);
        this.laudanLiikkuvatOliot.add(pelaajanappula);
    }

    public AlkeellinenPelilauta(Piirrustava piirrin) {
        this(1, piirrin);
    }

    public void piirra() {
        piirrin.piirra(leveys, korkeus, laudanOliot);
    }

    public void teeSiirrot() {
        for (Liikkuva mecha : this.laudanLiikkuvatOliot) {
            int siirto = mecha.kerroSeuraavaSiirto();
            if (siirto == 1) {           //Ylös
                mecha.liiku(1, 0);
            } else if (siirto == 2) {    //Oikealle
                mecha.liiku(0, 1);
            }   //jne.
        }
    }

    public boolean voittikoPelaaja() {
        return false;  //Tähän tulee oikea testi
    }

}
