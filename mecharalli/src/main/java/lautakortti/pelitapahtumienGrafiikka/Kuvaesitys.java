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
    private int ruudunKoko;     //Piirrettävän pelilaudan ruudun sivu pikseleinä.
    private int ruutujaPystysuoraan;
    private int ruutujaVaakasuoraan;

    public Kuvaesitys() {
        this.kuvastuvat = new ArrayList<Kuvastuva>();
        setPreferredSize(new Dimension(500, 450));
        super.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void piirra(int laudanLeveys, int laudanKorkeus, List<Kuvastuva> laudanElementit) {
        this.kuvastuvat = (ArrayList<Kuvastuva>) laudanElementit;
        this.ruudunKoko = (int) (350 / Math.max(laudanKorkeus, laudanLeveys));
        this.ruutujaPystysuoraan = laudanLeveys;
        this.ruutujaVaakasuoraan = laudanKorkeus;
        repaint();
    }

    @Override
    public void paintComponent(Graphics graffat) {
        super.paintComponent(graffat);
        graffat.drawRect(2, 2, ruutujaVaakasuoraan* this.ruudunKoko, ruutujaPystysuoraan*  this.ruudunKoko); //laudan neliönmuotoiset reunat
        for (Kuvastuva kuva : this.kuvastuvat) {
            graffat.setColor(Color.blue);
            if (kuva.mikaKuva() == 1) {
                piirraPelaaja(kuva, graffat);
            } else if (kuva.mikaKuva() == 2) {
                graffat.drawRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 3) {
                graffat.setColor(Color.RED);
                graffat.fillRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 6) {
                graffat.setColor(Color.black);
                graffat.fillRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 7) {
                graffat.setColor(Color.ORANGE);
                graffat.fillRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 10) { //maali
                graffat.setColor(Color.PINK);
                graffat.fillRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + 30, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + 30, this.ruudunKoko - 60, this.ruudunKoko - 60);
            }
        }
//        repaint();
    }

    private void piirraPelaaja(Kuvastuva mecha, Graphics graffat) {
        graffat.drawRect((mecha.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (mecha.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
        graffat.fillRect((mecha.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + 40, (mecha.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + 40, this.ruudunKoko - 80, this.ruudunKoko - 80);
    }

    public int ruutu() {     //Vain testejä varten :P
        return this.ruudunKoko;
    }
}
