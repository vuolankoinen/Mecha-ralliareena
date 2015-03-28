package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumienGrafiikka.Tekstiesitys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlkeellinenPelilautaTest {

    public AlkeellinenPelilautaTest() {
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
        AlkeellinenPelilauta lauta = new AlkeellinenPelilauta(1, new Tekstiesitys());
        lauta.teeSiirrot();
    }

    @Test
    public void lautaTunnistaaVoittoehdot() {
        AlkeellinenPelilauta lauta = new AlkeellinenPelilauta(1, new Tekstiesitys());
        assertEquals(false, lauta.voittikoPelaaja());
    }
}
