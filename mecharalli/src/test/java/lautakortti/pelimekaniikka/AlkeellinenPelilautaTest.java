package lautakortti.pelimekaniikka;

import lautakortti.pelitapahtumien_grafiikka.Tekstiesitys;
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
        AlkeellinenPelilauta lauta = new AlkeellinenPelilauta(1, new Tekstiesitys);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lautaTekeeSiirrot() {
        lauta.teeSiirrot();
    }
    
    @Test
    public void lautaTunnistaaVoittoehdot() {
        assertEquals(false,lauta.voittikoPelaaja());
    }
}
