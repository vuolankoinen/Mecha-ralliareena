package lautakortti.pelitapahtumienGrafiikka;

import lautakortti.pelimekaniikka.Esterata;
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

    @Test
    public void tunnistaakoEsitysLiikkumattomanEsteen() {
        Tekstiesitys esitys = new Tekstiesitys();
        assertEquals("Kivi", esitys.etsiNimi(6));
    }

        @Test
    public void tunnistaakoEsitysHajoavanEsteen() {
        Tekstiesitys esitys = new Tekstiesitys();
        assertEquals("Puulaatikko", esitys.etsiNimi(7));
    }

        @Test
    public void tunnistaakoEsitysVastustajan() {
        Tekstiesitys esitys = new Tekstiesitys();
        assertEquals("Vastustajan mecha", esitys.etsiNimi(3));
    }

        @Test
    public void tuntematonKuvatunnus() {
        Tekstiesitys esitys = new Tekstiesitys();
        assertEquals("Tuntematon", esitys.etsiNimi(3243));
    }

        @Test
    public void tuntematonKuvatunnus2() {
        Tekstiesitys esitys = new Tekstiesitys();
        assertEquals("Tuntematon", esitys.etsiNimi(-3));
    }

}
