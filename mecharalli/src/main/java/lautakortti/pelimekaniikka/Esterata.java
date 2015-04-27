package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Piirrustava;
import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;
import java.util.ArrayList;
import java.util.List;

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

    public Esterata(int tyyppi, Piirrustava piirrin) {
        this.piirrin = piirrin;
        if (tyyppi == 1) {      //Erilaisia lautoja voi lisätä eri parametreille.
            this.leveys = 4;
            this.korkeus = 4;
            this.laudanOliot = new ArrayList<Kuvastuva>();
            this.laudanOliot.add(new LiikkumatonEste(2, 2, 6, true));
            this.laudanOliot.add(new HajoavaEste(2, 3, 7, false, 5));
            this.laudanLiikkuvatOliot = new ArrayList<Liikkuva>();
            this.maaliX = 4;
            this.maaliY = 4;
            SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1, 2);
            this.laudanLiikkuvatOliot.add(vastus);
            this.laudanOliot.add(vastus);
        }
        KorteinOhjattavaNappula pelaajanappula = new KorteinOhjattavaNappula(1, 1);
        this.laudanOliot.add(pelaajanappula);
        this.laudanLiikkuvatOliot.add(pelaajanappula);
        this.pelaaja = pelaajanappula;
    }

    public Esterata(Piirrustava piirrin) {
        this(1, piirrin);
    }

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
        return vuororaportti();
    }

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
        //if (uhri == null) {    //En tajua, mistä tämä null-pointeri tulee. :(
        //    return;         //Pitää selvittää, niin pääsee tästä hätäratkaisusta.
        //}
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
     * @param siirto Pelaajan syöte, toivottavasti jokin merkeistä awsz.
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
        if (olio == 1) {
            return "pelaajanappula";
        } else if (olio == 6) {
            return "kivi";
        } else if (olio == 3) {
            return "vastustajan mecha";
        } else if (olio == 7) {
            return "puulaatikko";
        } else {
            return "tuntematon olio";
        }
    }

    public String vuororaportti() {
        return this.vuororaportti;
    }

    public ArrayList<Integer> seuraavatViisiVaihtoehtoa() {
        return this.pelaaja.seuraavatViisiVaihtoehtoa();
    }
}
