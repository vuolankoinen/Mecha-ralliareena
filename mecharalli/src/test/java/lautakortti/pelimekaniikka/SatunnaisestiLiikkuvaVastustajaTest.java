package lautakortti.pelimekaniikka;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SatunnaisestiLiikkuvaVastustajaTest {

    @Test
    public void kertooOikeanKuvan() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1, 1);
        assertEquals(3, vastus.mikaKuva());
    }

    @Test
    public void liikkuuAlas() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(5, 5);
        vastus.liiku(-3, -2);
        assertEquals(2, vastus.sijaintiPystysuunnassa());
    }

    @Test
    public void liikkuuVasemmalle() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(5, 5);
        vastus.liiku(-3, -2);
        assertEquals(3, vastus.sijaintiSivusuunnassa());
    }

    @Test
    public void meneeRikki() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1, 1);
        vastus.vahingoittaakoKolaroidessa(8);
        assertEquals(true, vastus.onkoRikki());
    }

    @Test
    public void negatiivinenKolarointi() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1, 1);
        vastus.vahingoittaakoKolaroidessa(8);
        vastus.vahingoittaakoKolaroidessa(-10);
        assertEquals(true, vastus.onkoRikki());
    }

    @Test
    public void siirrotOvatSatunnaisia() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1, 1);
        int tulisiPoiketaNollasta = 0;
        for (int i = 0; i < 8; i++) {
            tulisiPoiketaNollasta += vastus.kerroSeuraavaSiirto();
            tulisiPoiketaNollasta -= vastus.kerroSeuraavaSiirto();
        }
        assertEquals(true, tulisiPoiketaNollasta != 0);
    }

    @Test
    public void siirrotOvatSatunnaisia2() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(1, 1);
        int eiSaisiPoiketaLiikaaNollasta = 0;
        for (int i = 0; i < 8; i++) {
            eiSaisiPoiketaLiikaaNollasta += vastus.kerroSeuraavaSiirto();
            eiSaisiPoiketaLiikaaNollasta -= vastus.kerroSeuraavaSiirto();
        }
        eiSaisiPoiketaLiikaaNollasta = Math.max(eiSaisiPoiketaLiikaaNollasta, -eiSaisiPoiketaLiikaaNollasta);
        assertEquals(true, eiSaisiPoiketaLiikaaNollasta < 12);
    }

    @Test
    public void eiLiikuAlareunanYli() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(2, 2);
        vastus.liiku(-3, -1);
        assertEquals(2, vastus.sijaintiPystysuunnassa());
    }

    @Test
    public void eiLiikuOikeanReunanYli() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(2, 2);
        vastus.liiku(0, 7);
        assertEquals(2, vastus.sijaintiSivusuunnassa());
    }

    @Test
    public void eiHajoaEnnenAikojaan() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(2, 2);
        vastus.vahingoittaakoKolaroidessa(1);
        vastus.vahingoittaakoKolaroidessa(1);
        assertEquals(false, vastus.onkoRikki());
    }

    @Test
    public void vahingoittaa() {
        SatunnaisestiLiikkuvaVastustaja vastus = new SatunnaisestiLiikkuvaVastustaja(2, 2);
        assertEquals(true, vastus.vahingoittaakoKolaroidessa(1));
    }

}
