package lautakortti.pelimekaniikka;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class LiikkumatonTuuppivaVastustajaTest {

    LiikkumatonTuuppivaVastustaja vastus;

    @Before
    public void setUp() {
        vastus = new LiikkumatonTuuppivaVastustaja(2, 2);
    }

    @Test
    public void eiSatuta() {
        assertEquals(false, vastus.vahingoittaakoKolaroidessa(0));
    }

    @Test
    public void antaaMahdollisenSiirron() {
        int summa = 0;
        for (int i = 0; i < 10; i++) {
            summa += vastus.kerroSeuraavaSiirto();
        }
        assertEquals(true, summa > 12 && summa < 34);
    }

    @Test
    public void meneeRikki() {
        vastus.vahingoittaakoKolaroidessa(3);
        assertEquals(true, vastus.onkoRikki());
    }

    @Test
    public void kertooKuvansa() {
        assertEquals(4, vastus.mikaKuva());
    }
    @Test
    public void eiLiiku() {
        vastus.liiku(2, 1, 3, 3);
        assertEquals(4, vastus.sijaintiPystysuunnassa()+vastus.sijaintiSivusuunnassa());
    }
    @Test
    public void eiNegatiivisiaKolarointeja() {
        vastus.vahingoittaakoKolaroidessa(5);
        vastus.vahingoittaakoKolaroidessa(-5);
        assertEquals(true, vastus.onkoRikki());
    }
    @Test
    public void eiMeneHetiRikki() {
        vastus.vahingoittaakoKolaroidessa(1);
        assertEquals(false, vastus.onkoRikki());
    }
}
