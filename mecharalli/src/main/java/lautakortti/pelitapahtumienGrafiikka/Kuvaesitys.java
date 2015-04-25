package lautakortti.pelitapahtumienGrafiikka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.WindowConstants;
import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;
import lautakortti.pelitapahtumienGrafiikka.Piirrustava;

public class Kuvaesitys extends JPanel implements Piirrustava {

    private ArrayList<Kuvastuva> kuvastuvat;
    private int ruudunKoko;

    public Kuvaesitys() {
        this.kuvastuvat = new ArrayList<Kuvastuva>();
        setPreferredSize(new Dimension(500, 450));
        super.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void piirra(int laudanLeveys, int laudanKorkeus, List<Kuvastuva> laudanElementit) {
        this.kuvastuvat = (ArrayList<Kuvastuva>) laudanElementit;
        this.ruudunKoko = (int) (350 / Math.max(laudanKorkeus, laudanLeveys));
        repaint();
    }

    @Override
    public void paintComponent(Graphics graffat) {
        super.paintComponent(graffat);
        for (Kuvastuva kuva : this.kuvastuvat) {
            graffat.setColor(Color.blue);
            if (kuva.mikaKuva() == 1) {
                graffat.drawRect(kuva.sijaintiSivusuunnassa() * this.ruudunKoko, kuva.sijaintiPystysuunnassa() * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 2) {
                graffat.drawRect(kuva.sijaintiSivusuunnassa() * this.ruudunKoko, kuva.sijaintiPystysuunnassa() * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 3) {
                graffat.setColor(Color.RED);
                graffat.fillRect(kuva.sijaintiSivusuunnassa() * this.ruudunKoko, kuva.sijaintiPystysuunnassa() * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 6) {
                graffat.setColor(Color.black);
                graffat.fillRect(kuva.sijaintiSivusuunnassa() * this.ruudunKoko, kuva.sijaintiPystysuunnassa() * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 7) {
                graffat.setColor(Color.ORANGE);
                graffat.fillRect(kuva.sijaintiSivusuunnassa() * this.ruudunKoko, kuva.sijaintiPystysuunnassa() * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            }
        }
//        repaint();
    }
    
    public int ruutu(){
        return this.ruudunKoko;
    }
}
