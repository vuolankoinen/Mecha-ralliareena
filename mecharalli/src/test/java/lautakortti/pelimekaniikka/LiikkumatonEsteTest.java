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
}
