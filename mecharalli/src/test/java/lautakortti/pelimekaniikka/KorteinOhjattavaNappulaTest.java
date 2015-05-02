package lautakortti.pelimekaniikka;

import java.util.ArrayList;
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


    @Before
    public void setUp() {
    }


    @Test
    public void kertooOikeanKuvan() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        assertEquals(1, nappula.mikaKuva());
    }

    @Test
    public void liikkuuYhdenYlos() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(1, 0, 5, 5);
        assertEquals(2, nappula.sijaintiPystysuunnassa());
    }

    @Test
    public void liikkuuYhdenYlosJaYhdenOikealle() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(1, 1, 5, 5);
        assertEquals(4, nappula.sijaintiPystysuunnassa() + nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void liikkuuYhdenVasemmalle() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(2, 2);
        nappula.liiku(0, -1, 4, 4);
        assertEquals(1, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void liikkuuKaksiVasemmalle() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(3, 3);
        nappula.liiku(0, -2, 4, 4);
        assertEquals(1, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void eiLiikuReunanYli() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        nappula.liiku(-1, -2, 4, 4);
        assertEquals(1, nappula.sijaintiSivusuunnassa() * nappula.sijaintiPystysuunnassa());
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
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1, 1);
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

    @Test
    public void vaihtoehdotOnSekoitettu() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        ArrayList<Integer> siirrot = nappula.seuraavatViisiVaihtoehtoa();
        assertEquals(true, siirrot.get(0) != siirrot.get(1) || siirrot.get(2) != siirrot.get(3));
    }

    @Test
    public void minimikonstruktori1() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        nappula.vahingoittaakoKolaroidessa(4);
        assertEquals(true, nappula.onkoRikki());
    }

    @Test
    public void minimikonstruktori2() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        nappula.vahingoittaakoKolaroidessa(3);
        assertEquals(false, nappula.onkoRikki());
    }

    @Test
    public void eiMeneReunanYli() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        nappula.liiku(1, 1, 1, 1);
        nappula.liiku(4, 4, 2, 2);
        nappula.liiku(-2, -2, 1, 1);
        assertEquals(2, nappula.sijaintiPystysuunnassa() + nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void vahingoittaa() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        assertEquals(true, nappula.vahingoittaakoKolaroidessa(3));
    }

    @Test
    public void pakkaLoppuu() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        for (int t = 1; t < 4; t++) {
            nappula.seuraavatViisiVaihtoehtoa();
        }
        assertEquals(true, nappula.seuraavatViisiVaihtoehtoa().get(4) == 0);
    }

    @Test
    public void pakkaJaetaanUudelleen() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        for (int t = 0; t < 5; t++) {
            nappula.seuraavatViisiVaihtoehtoa();
        }
        assertEquals(true, nappula.seuraavatViisiVaihtoehtoa().get(4) != 0);
    }

    @Test
    public void pakkaSekoitetaanUudelleen() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula(1, 1);
        for (int t = 0; t < 6; t++) {
            nappula.seuraavatViisiVaihtoehtoa();
        }
        ArrayList<Integer> siirrot = nappula.seuraavatViisiVaihtoehtoa();
        assertEquals(true, siirrot.get(0) != siirrot.get(1) || siirrot.get(2) != siirrot.get(3) || siirrot.get(1) != siirrot.get(3));
    }

    @Test
    public void siirronNollaaminenToimii() {
        KorteinOhjattavaNappula nappula = new KorteinOhjattavaNappula();
        nappula.asetaSeuraavaSiirto(3);
        nappula.asetaSeuraavaSiirto(2);
        nappula.nollaaSiirrot();;
        assertEquals(true, nappula.kerroSeuraavaSiirto() == 0);
    }

}
