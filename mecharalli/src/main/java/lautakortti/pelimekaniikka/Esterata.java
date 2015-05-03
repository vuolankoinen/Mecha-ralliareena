package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Piirrustava;
import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;
import java.util.ArrayList;
import java.util.Random;

/**
 * Pelilauta, jolla pelatessa voittoehtona on päästä tiettyyn laudan ruutuun.
 *
 * @author Matti Palomäki
 */
public class Esterata implements Pelilauta {

    private Piirrustava piirrin;
    private int leveys;
    private int korkeus;
    private KorteinOhjattavaNappula pelaaja;
    private ArrayList<Kuvastuva> laudanOliot;
    private ArrayList<Liikkuva> laudanLiikkuvatOliot;
    private int maaliX;
    private int maaliY;
    private String vuororaportti;

    /**
     * Luo pelilaudan parametrin mukaan.
     *
     * @param tyyppi Halutun laudan kokonaislukutunnus.
     * @param piirrin Piirrustava-rajapinnan toteuttava olio, joka visualisoi
     * pelilaudan tapahtumat.
     */
    public Esterata(int tyyppi, Piirrustava piirrin) {
        this.piirrin = piirrin;
        if (tyyppi == 1) {      //Erilaisia lautoja voi lisätä eri parametreille.
            luoLauta1();
        } else if (tyyppi == 3) {
            luoLauta3();
        } else if (tyyppi == 4) {
            luoLauta4();
        } else {
            luoLauta2();
        }
        KorteinOhjattavaNappula pelaajanappula = new KorteinOhjattavaNappula(1, 1);
        this.laudanLiikkuvatOliot.add(pelaajanappula);
        this.pelaaja = pelaajanappula;
        this.laudanOliot.addAll(this.laudanLiikkuvatOliot);
    }

    private void luoLauta1() {
        this.leveys = 4;
        this.korkeus = 4;
        this.maaliX = 4;
        this.maaliY = 4;
        this.laudanOliot = new ArrayList<Kuvastuva>();
        this.laudanOliot.add(new LiikkumatonEste(2, 2, 6, true));
        this.laudanOliot.add(new HajoavaEste(2, 3, 7, false, 5));
        this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(1, 2));
    }

    private void luoLauta2() {
        this.leveys = 7;
        this.korkeus = 7;
        this.maaliX = 7;
        this.maaliY = 7;
        this.laudanOliot = new ArrayList<Kuvastuva>();
        this.laudanOliot.add(new LiikkumatonEste(2, 2, 6, true));
        this.laudanOliot.add(new LiikkumatonEste(5, 2, 6, true));
        this.laudanOliot.add(new LiikkumatonEste(2, 4, 6, true));
        this.laudanOliot.add(new HajoavaEste(2, 3, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(6, 5, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(4, 3, 7, false, 5));
        this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(1, 7));
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(7, 1));
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(2, 1));
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(6, 6));
    }

    private void luoLauta3() {
        this.leveys = 8;
        this.korkeus = 8;
        this.maaliX = 8;
        this.maaliY = 8;
        this.laudanOliot = new ArrayList<Kuvastuva>();
        this.laudanOliot.add(new LiikkumatonEste(2, 2, 6, true));
        this.laudanOliot.add(new HajoavaEste(7, 7, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(7, 1, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(7, 2, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(8, 2, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(1, 7, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(2, 7, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(2, 8, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(8, 7, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(7, 8, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(5, 1, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(2, 5, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(5, 5, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(6, 5, 7, false, 5));
        this.laudanOliot.add(new HajoavaEste(5, 6, 7, false, 5));
        this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(8, 1));
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(1, 8));
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(6, 6));
        this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(3, 3));
        this.laudanLiikkuvatOliot.add(new LiikkumatonTuuppivaVastustaja(4, 4));
        this.laudanLiikkuvatOliot.add(new LiikkumatonTuuppivaVastustaja(5, 2));
        this.laudanLiikkuvatOliot.add(new LiikkumatonTuuppivaVastustaja(2, 4));
        this.laudanLiikkuvatOliot.add(new LiikkumatonTuuppivaVastustaja(4, 8));
    }

    /**
     * Luo satunnaisella hässäkällä kansoitetun ison laudan.
     */
    private void luoLauta4() {
        this.leveys = 12;
        this.korkeus = 12;
        this.maaliX = 12;
        this.maaliY = 12;
        this.laudanOliot = new ArrayList<Kuvastuva>();
        this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
        ArrayList<String> apu = new ArrayList<String>();
        for (int i = 0; i < 13; i++) {
            apu.add("");
        }
        Random arpa = new Random();
        for (int u = 0; u < 24; u++) {
            int x = arpa.nextInt(12) + 1;
            int y = arpa.nextInt(12) + 1;
            if (apu.get(x - 1).contains("" + y) || x + y == 2) {  //Onko ruutu jo varattu?
                continue;
            }
            apu.set(x - 1, apu.get(x - 1) + y);
            int laatu = arpa.nextInt(4) + 1;
            if (laatu == 1 && (x != 12 || y != 12)) { //Ei kiviä maalin päälle.
                this.laudanOliot.add(new LiikkumatonEste(x, y, 6, true));
            } else if (laatu == 2) {
                this.laudanOliot.add(new HajoavaEste(x, y, 7, false, 5));
            } else if (laatu == 3) {
                this.laudanLiikkuvatOliot.add(new SatunnaisestiLiikkuvaVastustaja(x, y));
            } else {
                this.laudanLiikkuvatOliot.add(new LiikkumatonTuuppivaVastustaja(x, y));
            }
        }
    }

    /**
     * Välittää piirtopyynnön laudan piirtimelle. Tällä laudalla pyynnön mukaan
     * liitetään maaliruudun sijainti.
     */
    public void piirra() {
        ArrayList<Kuvastuva> kuvastuvatJaMaali = new ArrayList<Kuvastuva>();
        kuvastuvatJaMaali.addAll(laudanOliot);
        kuvastuvatJaMaali.add(new LiikkumatonEste(this.maaliX, this.maaliY, 10));
        piirrin.piirra(leveys, korkeus, kuvastuvatJaMaali);
    }

    /**
     * Käy läpi kaikki laudan liikkuvat elementit, joilta pyytää niiden
     * seuraavan siirron, jonka sitten toteuttaa. Siirtojen jälkeen poistetaan
     * laudalta kolarien rikkomat oliot.
     */
    public String teeSiirrot() {
        this.vuororaportti = "";
        for (Liikkuva mecha : this.laudanLiikkuvatOliot) {
            int siirto = mecha.kerroSeuraavaSiirto();
            if (siirto > 0 && siirto < 5) { //Jokin neljästä yksinkertaisesta siirrosta.
                this.perussiirto(mecha, siirto);
                continue;
            }    //jne: Tähän myöhemmin toteutettavat muut siirrot.
        }
        siivoaRikkoutuneetLaudalta();
        if (this.vuororaportti.equals("")) {
            return "Siirrot sujuivat kolareitta.";
        }
        return vuororaportti();
    }

    /**
     * Käy läpi laudan oliot, kysyy niiltä ovatko ne rikkoutuneet, ja poistaa
     * rikkinäiset.
     */
    public void siivoaRikkoutuneetLaudalta() {
        ArrayList<Kuvastuva> kopio = new ArrayList<Kuvastuva>();
        kopio.addAll(this.laudanOliot);
        for (Kuvastuva tarkistettava : kopio) {
            if (this.poistaRikkoutunut(tarkistettava)) {
                vuororaportti += "-" + this.tunnistaOlioTekstiesitykseen(tarkistettava) + " rikkoutui\n";
            }
        }
    }

    /**
     * Selkeyden vuoksi eroteltua siirtojen tekemistä. Yhden askeleen pituiset
     * liikkeet pysty- ja vaakasuunnassa.
     *
     * @param mecha Siirrettävä elementti, toteuttaa rajapinnan Liikkuva.
     * @param siirto Suoritettavan siirron int-numerokoodi.
     */
    public void perussiirto(Liikkuva mecha, int siirto) {
        if (siirto == 1) {           //Ylös
            if (this.tarkistaKolarointi(mecha.sijaintiSivusuunnassa(), mecha.sijaintiPystysuunnassa() + 1) != null) {
                this.kolaroi(mecha, tarkistaKolarointi(mecha.sijaintiSivusuunnassa(), mecha.sijaintiPystysuunnassa() + 1));
                this.vuororaportti += "-" + tunnistaOlioTekstiesitykseen(mecha) + " törmäsi olioon " + tunnistaOlioTekstiesitykseen(tarkistaKolarointi(mecha.sijaintiSivusuunnassa(), mecha.sijaintiPystysuunnassa() + 1)) + "\n";
                return;
            }
            mecha.liiku(1, 0, this.korkeus + 1, this.leveys + 1);

        } else if (siirto == 2) {    //Oikealle
            if (this.tarkistaKolarointi(mecha.sijaintiSivusuunnassa() + 1, mecha.sijaintiPystysuunnassa()) != null) {
                this.kolaroi(mecha, tarkistaKolarointi(mecha.sijaintiSivusuunnassa() + 1, mecha.sijaintiPystysuunnassa()));
                this.vuororaportti += "-" + tunnistaOlioTekstiesitykseen(mecha) + " törmäsi olioon " + tunnistaOlioTekstiesitykseen(tarkistaKolarointi(mecha.sijaintiSivusuunnassa() + 1, mecha.sijaintiPystysuunnassa())) + "\n";
                return;
            }
            mecha.liiku(0, 1, this.korkeus + 1, this.leveys + 1);

        } else if (siirto == 3) {    //Alas
            if (this.tarkistaKolarointi(mecha.sijaintiSivusuunnassa(), mecha.sijaintiPystysuunnassa() - 1) != null) {
                this.kolaroi(mecha, tarkistaKolarointi(mecha.sijaintiSivusuunnassa(), mecha.sijaintiPystysuunnassa() - 1));
                this.vuororaportti += "-" + tunnistaOlioTekstiesitykseen(mecha) + " törmäsi olioon " + tunnistaOlioTekstiesitykseen(tarkistaKolarointi(mecha.sijaintiSivusuunnassa(), mecha.sijaintiPystysuunnassa() - 1)) + "\n";
                return;
            }
            mecha.liiku(-1, 0, this.korkeus + 1, this.leveys + 1);
        } else if (siirto == 4) {    //Vasemmalle
            if (this.tarkistaKolarointi(mecha.sijaintiSivusuunnassa() - 1, mecha.sijaintiPystysuunnassa()) != null) {
                this.kolaroi(mecha, tarkistaKolarointi(mecha.sijaintiSivusuunnassa() - 1, mecha.sijaintiPystysuunnassa()));
                this.vuororaportti += "-" + tunnistaOlioTekstiesitykseen(mecha) + " törmäsi olioon " + tunnistaOlioTekstiesitykseen(tarkistaKolarointi(mecha.sijaintiSivusuunnassa() - 1, mecha.sijaintiPystysuunnassa())) + "\n";
                return;
            }
            mecha.liiku(0, -1, this.korkeus + 1, this.leveys + 1);

        }
    }

    /**
     * Välittää pelaajanappulalle pyynnön tyhjentää sille välitetyt siirrot
     * muistista.
     */
    public void nollaaSiirrot() {
        this.pelaaja.nollaaSiirrot();
    }

    /**
     * Tarkistaa, mikä laudan olio ruudusta löytyy.
     *
     * @param x Tarkistettavan ruudun x-koordinaatti, int.
     * @param y Tarkistettavan ruudun y-koordinaatti, int.
     * @return Palauttaa ruudusta löytyneen Kuvastuva-rajapinnan toteuttavan
     * olion, tai null jos sellaista ei ole.
     */
    public Kuvastuva tarkistaKolarointi(int x, int y) {
        for (Kuvastuva este : this.laudanOliot) {
            if (este.sijaintiSivusuunnassa() == x && este.sijaintiPystysuunnassa() == y) {
                return este;
            }
        }
        return null;
    }

    /**
     * Vahingoittaa törmäyksen kohdetta, ja törmääjää sikäli mikäli uhri oli
     * kova.
     *
     * @param liikkuva Törmäyksen aikaansaattaja, Kuvastuva olio.
     * @param uhri Kolarin liikkumaton osapuoli, Kuvastuva olio.
     */
    public void kolaroi(Kuvastuva liikkuva, Kuvastuva uhri) {
        boolean onkoKova = uhri.vahingoittaakoKolaroidessa(2);
        if (onkoKova) {
            liikkuva.vahingoittaakoKolaroidessa(1);
        }
    }

    /**
     * Tarkistaa, ovatko olion kestopisteet loppuneet, ja poistaa sen laudalta
     * jos on.
     *
     * @param rikottu Mahdollisesti poistettava Kuvastuva laudan olio.
     * @return Palauttaa "true", jos olio poistettiin, muuten "false".
     */
    public boolean poistaRikkoutunut(Kuvastuva rikottu) {
        if (!rikottu.onkoRikki()) {
            return false;
        }
        this.laudanOliot.remove(rikottu);
        this.laudanLiikkuvatOliot.remove(rikottu);
        return true;
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

    /**
     * Tarkistaa, onko pelaajan nappula tuhoutunut.
     *
     * @return Palauttaa "true", jos pelaava on hävinnyt, muuten "false".
     */
    public boolean tuhoutuikoPelaaja() {
        if (this.pelaaja.hiparit() < 1) {
            return true;
        }
        return false;
    }

    /**
     * Asettaa pelaajanappulan seuraavan siirron pelaajan syötteen perusteella.
     *
     * @param siirto Asetettavan siirron kirjainkoodi Stringinä.
     */
    public void asetaSiirto(String siirto) {
        if (siirto.equals("w")) {
            this.pelaaja.asetaSeuraavaSiirto(1);
        } else if (siirto.equals("s")) {
            this.pelaaja.asetaSeuraavaSiirto(2);
        } else if (siirto.equals("a")) {
            this.pelaaja.asetaSeuraavaSiirto(4);
        } else if (siirto.equals("z")) {
            this.pelaaja.asetaSeuraavaSiirto(3);
        }
    }

    /**
     * Antaa oliota vastaavan tekstikuvauksen vuororaporttia varten.
     *
     * @param tunnistettava Kuvastuva laudan olio
     * @return tunnistettavan sanamuotoinen kuvaus
     */
    public String tunnistaOlioTekstiesitykseen(Kuvastuva tunnistettava) {
        int olio = tunnistettava.mikaKuva();
        if (olio == 1 || olio == -1) {
            return "pelaajanappula";
        } else if (olio == 6) {
            return "kivi";
        } else if (olio == 3) {
            return "vastustajan mecha";
        } else if (olio == 7) {
            return "puulaatikko";
        } else if (olio == 4) {
            return "nyrkkitorni";
        } else {
            return "tuntematon olio";
        }
    }

    /**
     * getteri
     *
     * @return vuororaportti
     */
    public String vuororaportti() {
        return this.vuororaportti;
    }

    /**
     * Välittää pelaajanappulalta seuraavat viisi siirtovaihtoehtoa.
     *
     * @return Laudan pelaajanappulan viiden seuraavan siirron
     * kokonaislukukoodit ArrayListinä.
     */
    public ArrayList<Integer> seuraavatViisiVaihtoehtoa() {
        return this.pelaaja.seuraavatViisiVaihtoehtoa();
    }
}
