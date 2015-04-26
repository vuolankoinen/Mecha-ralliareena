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
public class NappulaTest {

    public NappulaTest() {
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
        Nappula nappula = new Nappula(1, 1);
        assertEquals(1, nappula.mikaKuva());
    }

    @Test
    public void liikkuuYhdenYlos() {
        Nappula nappula = new Nappula(1, 1);
        nappula.liiku(1, 0,5,5);
        assertEquals(2, nappula.sijaintiPystysuunnassa());
    }

    @Test
    public void liikkuuYhdenAlas() {
        Nappula nappula = new Nappula(2, 2);
        nappula.liiku(-1, 0,3,3);
        assertEquals(1, nappula.sijaintiPystysuunnassa());
    }

    @Test
    public void liikkuuYhdenVasemmalle() {
        Nappula nappula = new Nappula(1, 1);
        nappula.liiku(0, 1,4,4);
        assertEquals(2, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void liikkuuYhdenOikealle() {
        Nappula nappula = new Nappula(2, 2);
        nappula.liiku(0, -1,4,4);
        assertEquals(1, nappula.sijaintiSivusuunnassa());
    }
    @Test
    public void eiLiikuReunanYli() {
        Nappula nappula = new Nappula(1, 1);
        nappula.liiku(-1, -1,4,4);
        assertEquals(1, nappula.sijaintiSivusuunnassa()*nappula.sijaintiPystysuunnassa());
    }

    @Test
    public void meneeRikki() {
        Nappula nappula = new Nappula(1, 1);
        nappula.vahingoittaakoKolaroidessa(8);
        assertEquals(true, nappula.onkoRikki());
    }

    @Test
    public void negatiivinenKolarointiEiKorjaa() {
        Nappula nappula = new Nappula(1, 1);
        nappula.vahingoittaakoKolaroidessa(8);
        nappula.vahingoittaakoKolaroidessa(-10);
        assertEquals(true, nappula.onkoRikki());
    }

    @Test
    public void kertooAnnetunSiirron() {
        Nappula nappula = new Nappula(1, 1);
        nappula.asetaSeuraavaSiirto(120);
        assertEquals(120, nappula.kerroSeuraavaSiirto());
    }
    
    @Test
    public void pehmoinenKolarointiEiRiko() {
        Nappula nappula = new Nappula(1, 1,1);
        nappula.vahingoittaakoKolaroidessa(0);
        nappula.vahingoittaakoKolaroidessa(0);
        nappula.vahingoittaakoKolaroidessa(0);
        assertEquals(false, nappula.onkoRikki());
    }

}
