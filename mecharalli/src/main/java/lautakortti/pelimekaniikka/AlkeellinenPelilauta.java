package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Piirrustava;
import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;
import java.util.ArrayList;

public class AlkeellinenPelilauta implements Pelilauta {

    private Piirrustava piirrin;
    private int leveys;
    private int korkeus;
    private Nappula pelaaja;
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
            this.laudanOliot.add(new LiikkumatonEste(2,2));
            this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
            this.maaliX = 4;
            this.maaliY = 4;
            SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1,2);
            this.laudanLiikkuvatOliot.add(vastus);
            this.laudanOliot.add(vastus);
        }
        Nappula pelaajanappula = new Nappula(1, 1);
        this.laudanOliot.add(pelaajanappula);
        this.laudanLiikkuvatOliot.add(pelaajanappula);
        this.pelaaja = pelaajanappula;
    }

    public AlkeellinenPelilauta(Piirrustava piirrin) {
        this(1, piirrin);
    }

    public void piirra() {
        piirrin.piirra(leveys, korkeus, laudanOliot);
    }

    /**
     * Käy läpi kaikki laudan liikkuvat elementit, joilta pyytää niiden
     * seuraavan siirron, jonka sitten toteuttaa.
     */
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

    /**
     * Tarkistaa, onko pelaajanappula päässyt maaliin.
     *
     * @return Palauttaa true, jos pelaaja on voittanut, muuten false.
     */
    public boolean voittikoPelaaja() {
        if (this.maaliX == this.pelaaja.sijaintiSivusuunnassa() && this.maaliY == this.pelaaja.sijaintiPystysuunnassa()) {
            return true;
        }
        return false;
    }
    
    public void asetaSiirto(String siirto){
        if (siirto.equals("w")){
            this.pelaaja.asetaSeuraavaSiirto(1);
        } else if (siirto.equals("s")){
            this.pelaaja.asetaSeuraavaSiirto(2);
        }
    }
}
