package lautakortti.pelitapahtumienGrafiikka;

import static java.awt.Color.*;
import java.awt.Dimension;
import java.util.ArrayList;
//import javax.swing.JFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KuvaesitysTest {
    
    public KuvaesitysTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
        @Test
    public void esitysSailyttaaVarin() {
        Kuvaesitys esitys = new Kuvaesitys();
        esitys.piirra(1,1,new ArrayList<Kuvastuva>());
        assertEquals(LIGHT_GRAY, esitys.getBackground());
    }
//        @Test
//    public void kaivattuKoko() {
//        JFrame frame = new JFrame();
//        Kuvaesitys esitys = new Kuvaesitys();
//        frame.add(esitys);
//        esitys.piirra(100,100,new ArrayList<Kuvastuva>());
//        assertEquals(450, esitys.getHeight());
//    }
        @Test
    public void puhtaassaEiKomponentteja() {
        Kuvaesitys esitys = new Kuvaesitys();
        esitys.piirra(1,1,new ArrayList<Kuvastuva>());
        assertEquals(0, esitys.getComponentCount());
    }
        @Test
    public void ruudutEiReunoiltaYli() {
        Kuvaesitys esitys = new Kuvaesitys();
        esitys.piirra(10,10,new ArrayList<Kuvastuva>());
        assertEquals(true, (esitys.ruutu()*10)<500);
    }
        @Test
    public void ruudunKokoPyoristyy() {
        Kuvaesitys esitys = new Kuvaesitys();
        esitys.piirra(36,7,new ArrayList<Kuvastuva>());
        assertEquals(9, esitys.ruutu());
    }

}
