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
    public void likkuuYhdenYlos() {
        Nappula nappula = new Nappula(1, 1);
        nappula.liiku(1, 0);
        assertEquals(2,nappula.sijaintiPystysuunnassa());
    }

}
