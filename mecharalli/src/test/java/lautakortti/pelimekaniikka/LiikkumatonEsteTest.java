package lautakortti.pelimekaniikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LiikkumatonEsteTest {
    
    public LiikkumatonEsteTest() {
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
     public void turvallinenEste() {
     LiikkumatonEste este = new LiikkumatonEste(1,1);
     assertEquals(false,este.vahingoittaakoKolaroidessa(1));
     }
          @Test
     public void palauttaaOikeanKuvan() {
     LiikkumatonEste este = new LiikkumatonEste(1,1);
     assertEquals(6,este.mikaKuva());
     }
          @Test
     public void eiHajoa() {
     LiikkumatonEste este = new LiikkumatonEste(1,1);
     assertEquals(false,este.onkoRikki());
     }
     @Test
     public void kertooSijainninOikein() {
     LiikkumatonEste este = new LiikkumatonEste(4,1);
     assertEquals(4,este.sijaintiSivusuunnassa());
     }


}
