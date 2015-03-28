package lautakortti.pelitapahtumienGrafiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TekstiesitysTest {

    public TekstiesitysTest() {
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
    public void tunnistaakoEsitysPelaajanappulat() {
        Tekstiesitys esitys = new Tekstiesitys();
        assertEquals("Pelaajanappula", esitys.etsiNimi(1));
    }
}
