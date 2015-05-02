package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Kuvaesitys;
import lautakortti.pelimekaniikka.LiikkumatonEste;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsterataTest {

    Esterata lauta;

    public EsterataTest() {
    }

    @Before
    public void setUp() {
        lauta = new Esterata(1, new Kuvaesitys());
    }

    @Test
    public void eiSiirraYliReunan() {
        lauta.asetaSiirto("z");
        lauta.teeSiirrot();
        lauta.asetaSiirto("a");
        lauta.teeSiirrot();
        assertEquals(false, lauta.tarkistaKolarointi(1, 1).equals(null));
    }

    @Test
    public void lautaTunnistaaVoittoehdot() {
        assertEquals(false, lauta.voittikoPelaaja());
    }

    @Test
    public void lautaTunnistaaVoittoehdot2() {
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(1, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(1, 2));
        lauta.asetaSiirto("s");
        lauta.teeSiirrot();
        lauta.asetaSiirto("s");
        lauta.teeSiirrot();
        lauta.asetaSiirto("s");
        lauta.teeSiirrot();
        lauta.asetaSiirto("w");
        lauta.teeSiirrot();
        lauta.asetaSiirto("w");
        lauta.teeSiirrot();
        lauta.asetaSiirto("w");
        lauta.teeSiirrot();
        assertEquals(true, lauta.voittikoPelaaja());
    }

    @Test
    public void pelaajaEiHaviaSuoraan() {
        assertEquals(false, lauta.tuhoutuikoPelaaja());
    }

    @Test
    public void tyhjaanLiikkuessaEiKolaroi() {
        assertEquals(null, lauta.tarkistaKolarointi(0, 0));
    }

    @Test
    public void pelaajanKohdalleLiikkuessaKolaroi() {
        assertEquals(false, lauta.tarkistaKolarointi(1, 1).equals(null));
    }

    @Test
    public void pelaajaHaviaaLiikaaKolaroituaan() {
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(1, 1));
        assertEquals(true, lauta.tuhoutuikoPelaaja());
    }

    @Test
    public void pelaajaHaviaaKolaroituaanEsteeseenToistuvasti() {
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(2, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(2, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(2, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(2, 2));
        assertEquals(true, lauta.tuhoutuikoPelaaja());
    }

    @Test
    public void pelaajaHaviaaToistuvanVastustajanKolaroinninJaljilta() {
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(1, 1));
        assertEquals(true, lauta.tuhoutuikoPelaaja());
    }

    @Test
    public void konstruktorinOletusparametri() {
        Esterata lauta2 = new Esterata(5, new Kuvaesitys());
        boolean apu = lauta2.tarkistaKolarointi(2, 3) != null;
        apu = apu && lauta2.tarkistaKolarointi(7, 1) != null;
        assertEquals(true, apu && lauta2.tarkistaKolarointi(6, 5) != null);
    }

    @Test
    public void konstruktoriParametrilla3() {
        Esterata lauta2 = new Esterata(3, new Kuvaesitys());
        boolean apu = lauta2.tarkistaKolarointi(2, 7) != null;
        apu = apu && lauta2.tarkistaKolarointi(5, 2) != null;
        assertEquals(true, apu && lauta2.tarkistaKolarointi(7, 8) != null);
    }

    @Test
    public void konstruktoriParametrilla4() {
        Esterata lauta2 = new Esterata(4, new Kuvaesitys());
        int apu = 0;
        for (int i = 0; i < 13; i++) {
            for (int u = 0; u < 13; u++) {
                if (lauta2.tarkistaKolarointi(i, u) != null) {
                    apu++;
                }
            }
        }
        assertEquals(true, apu < 26 && apu > 12);
    }

    @Test
    public void vuororaporttiEiOleTyhja() {
        assertEquals(false, lauta.teeSiirrot().equals(""));
    }

    @Test
    public void parametrilla4MaaliEiTukossa() {
        Esterata lauta2 = new Esterata(4, new Kuvaesitys());
        int apu = 2;
        if (lauta2.tarkistaKolarointi(12, 12) != null) {
            apu = lauta2.tarkistaKolarointi(12, 12).mikaKuva();
        }
        assertEquals(false, apu == 6);
    }

    @Test
    public void parametrilla4LahdossaPelaajanappula() {
        Esterata lauta2 = new Esterata(4, new Kuvaesitys());
        assertEquals(1, lauta2.tarkistaKolarointi(1, 1).mikaKuva());
    }

    @Test
    public void siivoaaRikkoutuneet() {
        for (int i = 0; i < 4; i++) {
            lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(2, 2));
        }
        lauta.siivoaRikkoutuneetLaudalta();
        assertEquals(true, lauta.tarkistaKolarointi(1, 2) == null);
    }

    @Test
    public void siivoaaRikkoutuneen() {
        for (int i = 0; i < 4; i++) {
            lauta.kolaroi(lauta.tarkistaKolarointi(1, 2), lauta.tarkistaKolarointi(2, 2));
        }
        assertEquals(true, lauta.poistaRikkoutunut(lauta.tarkistaKolarointi(1, 2)));
    }

    @Test
    public void nollattuNappulaEiLiiku() {
        lauta.asetaSiirto("s");
        lauta.nollaaSiirrot();
        lauta.teeSiirrot();
        assertEquals(1, lauta.tarkistaKolarointi(1, 1).mikaKuva());
    }

    @Test
    public void nappulaLiikkuu() {
        for (int i = 0; i < 5; i++) {
            lauta.asetaSiirto("w");
            lauta.teeSiirrot();
        }
        for (int i = 0; i < 2; i++) {
            lauta.asetaSiirto("s");
            lauta.teeSiirrot();
        }
        for (int i = 0; i < 2; i++) {
            lauta.asetaSiirto("a");
            lauta.teeSiirrot();
        }
        assertEquals(1, Math.max(-lauta.tarkistaKolarointi(1, 4).mikaKuva(), lauta.tarkistaKolarointi(1, 4).mikaKuva()));
    }

    @Test
    public void nappulaLiikkuu2() {
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(1, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(1, 2));
        lauta.asetaSiirto("s");
        lauta.teeSiirrot();
        lauta.asetaSiirto("s");
        lauta.teeSiirrot();
        lauta.asetaSiirto("w");
        lauta.teeSiirrot();
        lauta.asetaSiirto("z");
        lauta.teeSiirrot();
        lauta.asetaSiirto("a");
        lauta.teeSiirrot();
        assertEquals(1, Math.max(-lauta.tarkistaKolarointi(2, 1).mikaKuva(), lauta.tarkistaKolarointi(2, 1).mikaKuva()));
    }

    @Test
    public void nappulaLiikkuu3() {
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(1, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1), lauta.tarkistaKolarointi(1, 2));
        lauta.asetaSiirto("s");
        lauta.teeSiirrot();
        lauta.asetaSiirto("w");
        lauta.teeSiirrot();
        lauta.asetaSiirto("a");
        lauta.teeSiirrot();
        lauta.asetaSiirto("a");
        lauta.teeSiirrot();
        assertEquals(-1, lauta.tarkistaKolarointi(1, 1).mikaKuva());
    }

    @Test
    public void eiPoistaEhjia() {
        assertEquals(false, lauta.poistaRikkoutunut(lauta.tarkistaKolarointi(1, 1)));
    }

    @Test
    public void avaaKuvakooditSanoiksi1() {
        String apu = lauta.tunnistaOlioTekstiesitykseen(lauta.tarkistaKolarointi(1, 1));
        apu += lauta.tunnistaOlioTekstiesitykseen(lauta.tarkistaKolarointi(1, 2));
        apu += lauta.tunnistaOlioTekstiesitykseen(lauta.tarkistaKolarointi(2, 2));
        apu += lauta.tunnistaOlioTekstiesitykseen(lauta.tarkistaKolarointi(2, 3));
        assertEquals("pelaajanappulavastustajan mechakivipuulaatikko", apu);
    }

    @Test
    public void avaaKuvakooditSanoiksi2() {
        Esterata lauta2 = new Esterata(3, new Kuvaesitys());
        assertEquals("nyrkkitorni", lauta2.tunnistaOlioTekstiesitykseen(lauta2.tarkistaKolarointi(2, 4)));
    }
}
