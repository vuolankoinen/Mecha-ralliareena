package lautakortti.pelimekaniikka;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HajoavaEsteTest {

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
    public void esteRikkoutuuToistuvastiKolaroidessa() {
        HajoavaEste este = new HajoavaEste(1, 1);
        este.vahingoittaakoKolaroidessa(1);
        este.vahingoittaakoKolaroidessa(1);
        este.vahingoittaakoKolaroidessa(6);
        assertEquals(true, este.onkoRikki());
    }

    @Test
    public void esteEiMeneHetiRikkiHiukanKolaroidessa() {
        HajoavaEste este = new HajoavaEste(1, 1);
        este.vahingoittaakoKolaroidessa(2);
        assertEquals(false, este.onkoRikki());
    }

    @Test
    public void esteOnRikkiTasanNollassaKestossa() {
        HajoavaEste este = new HajoavaEste(1, 1, 7, true, 10);
        este.vahingoittaakoKolaroidessa(10);
        assertEquals(true, este.onkoRikki());
    }
    @Test
    public void negatiivinenKolarointiEiKorjaa() {
        HajoavaEste este = new HajoavaEste(1, 1);
        este.vahingoittaakoKolaroidessa(4);
        este.vahingoittaakoKolaroidessa(-5);
        assertEquals(true, este.onkoRikki());
    }

}
