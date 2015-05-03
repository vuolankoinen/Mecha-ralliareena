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
public class PelaajanappulaTest {

    private Pelaajanappula nappula1;

    public PelaajanappulaTest() {
    }

    @Before
    public void setUp() {
        nappula1 = new Pelaajanappula(1, 1);

    }

    @Test
    public void kertooOikeanKuvan() {
        assertEquals(1, nappula1.mikaKuva());
    }

    @Test
    public void liikkuuYhdenYlos() {
        nappula1.liiku(1, 0, 5, 5);
        assertEquals(2, nappula1.sijaintiPystysuunnassa());
    }

    @Test
    public void liikkuuYhdenYlosJaYhdenOikealle() {
        nappula1.liiku(1, 1, 5, 5);
        assertEquals(4, nappula1.sijaintiPystysuunnassa() + nappula1.sijaintiSivusuunnassa());
    }

    @Test
    public void liikkuuYhdenVasemmalle() {
        Pelaajanappula nappula = new Pelaajanappula(2, 2);
        nappula.liiku(0, -1, 4, 4);
        assertEquals(1, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void liikkuuKaksiVasemmalle() {
        Pelaajanappula nappula = new Pelaajanappula(3, 3);
        nappula.liiku(0, -2, 4, 4);
        assertEquals(1, nappula.sijaintiSivusuunnassa());
    }

    @Test
    public void eiLiikuReunanYli() {
        nappula1.liiku(-1, -2, 4, 4);
        assertEquals(1, nappula1.sijaintiSivusuunnassa() * nappula1.sijaintiPystysuunnassa());
    }

    @Test
    public void meneeRikki() {
        nappula1.vahingoittaakoKolaroidessa(8);
        assertEquals(true, nappula1.onkoRikki());
    }

    @Test
    public void negatiivinenKolarointiEiKorjaa() {
        nappula1.vahingoittaakoKolaroidessa(8);
        nappula1.vahingoittaakoKolaroidessa(-10);
        assertEquals(true, nappula1.onkoRikki());
    }

    @Test
    public void kertooAnnetunSiirron() {
        nappula1.asetaSeuraavaSiirto(120);
        assertEquals(120, nappula1.kerroSeuraavaSiirto());
    }

    @Test
    public void pehmoinenKolarointiEiRiko() {
        Pelaajanappula nappula = new Pelaajanappula(1, 1, 1);
        nappula.vahingoittaakoKolaroidessa(0);
        nappula.vahingoittaakoKolaroidessa(0);
        nappula.vahingoittaakoKolaroidessa(0);
        assertEquals(false, nappula.onkoRikki());
    }

    @Test
    public void seuraavatViisiPalauttaauTasanViisi() {
        assertEquals(5, nappula1.seuraavatViisiVaihtoehtoa().size());
    }

    @Test
    public void vaihtoehdotOnSekoitettu() {
        ArrayList<Integer> siirrot = nappula1.seuraavatViisiVaihtoehtoa();
        assertEquals(true, siirrot.get(0) != siirrot.get(1) || siirrot.get(2) != siirrot.get(3));
    }

    @Test
    public void eiMeneReunanYli() {
        nappula1.liiku(1, 1, 1, 1);
        nappula1.liiku(4, 4, 2, 2);
        nappula1.liiku(-2, -2, 1, 1);
        assertEquals(2, nappula1.sijaintiPystysuunnassa() + nappula1.sijaintiSivusuunnassa());
    }

    @Test
    public void vahingoittaa() {
        assertEquals(true, nappula1.vahingoittaakoKolaroidessa(3));
    }

    @Test
    public void pakkaLoppuu() {
        for (int t = 1; t < 4; t++) {
            nappula1.seuraavatViisiVaihtoehtoa();
        }
        assertEquals(true, nappula1.seuraavatViisiVaihtoehtoa().get(4) == 0);
    }

    @Test
    public void pakkaJaetaanUudelleen() {
        for (int t = 0; t < 5; t++) {
            nappula1.seuraavatViisiVaihtoehtoa();
        }
        assertEquals(true, nappula1.seuraavatViisiVaihtoehtoa().get(4) != 0);
    }

    @Test
    public void pakkaSekoitetaanUudelleen() {
        for (int t = 0; t < 6; t++) {
            nappula1.seuraavatViisiVaihtoehtoa();
        }
        ArrayList<Integer> siirrot = nappula1.seuraavatViisiVaihtoehtoa();
        assertEquals(true, siirrot.get(0) != siirrot.get(1) || siirrot.get(2) != siirrot.get(3) || siirrot.get(1) != siirrot.get(3));
    }

    @Test
    public void siirronNollaaminenToimii() {
        nappula1.asetaSeuraavaSiirto(3);
        nappula1.asetaSeuraavaSiirto(2);
        nappula1.nollaaSiirrot();;
        assertEquals(true, nappula1.kerroSeuraavaSiirto() == 0);
    }

}
