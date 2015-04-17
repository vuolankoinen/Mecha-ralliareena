package lautakortti.pelimekaniikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class KorteinOhjattavaNappulaTest {

    public KorteinOhjattavaNappulaTest() {
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
    public void kertooOikeanKuvan() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        assertEquals(1, nappula.mikaKuva());
    }

    @Test
    public void liikkuuYhdenYlos() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(1, 0);
        assertEquals(2,nappula.sijaintiPystysuunnassa());
    }
    
        @Test
    public void liikkuuYhdenAlas() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(-1, 0);
        assertEquals(0, nappula.sijaintiPystysuunnassa());
    }

    @Test
    public void liikkuuYhdenVasemmalle() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(0, 1);
        assertEquals(2, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void liikkuuYhdenOikealle() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(0, -1);
        assertEquals(0, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void meneeRikki() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.vahingoittaakoKolaroidessa(8);
        assertEquals(true, nappula.onkoRikki());
    }

    @Test
    public void negatiivinenKolarointiEiKorjaa() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.vahingoittaakoKolaroidessa(8);
        nappula.vahingoittaakoKolaroidessa(-10);
        assertEquals(true, nappula.onkoRikki());
    }

    @Test
    public void kertooAnnetunSiirron() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.asetaSeuraavaSiirto(120);
        assertEquals(120, nappula.kerroSeuraavaSiirto());
    }
    
    @Test
    public void pehmoinenKolarointiEiRiko() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1,1);
        nappula.vahingoittaakoKolaroidessa(0);
        nappula.vahingoittaakoKolaroidessa(0);
        nappula.vahingoittaakoKolaroidessa(0);
        assertEquals(false, nappula.onkoRikki());
    }

    @Test
    public void seuraavatViisiPalauttaauTasanViisi() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        assertEquals(5, nappula.seuraavatViisiVaihtoehtoa().size());
    }

    
}
