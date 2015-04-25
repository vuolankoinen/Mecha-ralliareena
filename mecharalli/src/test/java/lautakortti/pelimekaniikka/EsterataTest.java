package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Tekstiesitys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsterataTest {

    public EsterataTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lautaTekeeSiirrot() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        lauta.teeSiirrot();
    }

    @Test
    public void lautaTunnistaaVoittoehdot() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        assertEquals(false, lauta.voittikoPelaaja());
    }

    @Test
    public void lautaTunnistaaVoittoehdot2() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
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
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        assertEquals(false, lauta.tuhoutuikoPelaaja());
    }

    @Test
    public void tyhjaanLiikkuessaEiKolaroi() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        assertEquals(null, lauta.tarkistaKolarointi(0, 0));
    }

    @Test
    public void pelaajanKohdalleLiikkuessaKolaroi() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        assertEquals(false, lauta.tarkistaKolarointi(1, 1).equals(null));
    }

    @Test
    public void pelaajaHaviaaLiikaaKolaroituaan() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(1, 1));
        assertEquals(true, lauta.tuhoutuikoPelaaja());
    }
    @Test
    public void pelaajaHaviaaKolaroituaanEsteeseenToistuvasti() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(2, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(2, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(2, 2));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 1),lauta.tarkistaKolarointi(2, 2));
        assertEquals(true, lauta.tuhoutuikoPelaaja());
    }
        @Test
    public void pelaajaHaviaaToistuvanVastustajanKolaroinninJaljilta() {
        Esterata lauta = new Esterata(1, new Tekstiesitys());
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2),lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2),lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2),lauta.tarkistaKolarointi(1, 1));
        lauta.kolaroi(lauta.tarkistaKolarointi(1, 2),lauta.tarkistaKolarointi(1, 1));
        assertEquals(true, lauta.tuhoutuikoPelaaja());
    }


}
