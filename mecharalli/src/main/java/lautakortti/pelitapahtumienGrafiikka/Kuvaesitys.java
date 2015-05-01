package lautakortti.pelitapahtumienGrafiikka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.WindowConstants;
import lautakortti.pelitapahtumienGrafiikka.Kuvastuva;
import lautakortti.pelitapahtumienGrafiikka.Piirrustava;

public class Kuvaesitys extends JPanel implements Piirrustava {

    private ArrayList<Kuvastuva> kuvastuvat;
    private int ruudunKoko;     //Piirrettävän pelilaudan ruudun sivu pikseleinä.
    private int ruutujaPystysuoraan;
    private int ruutujaVaakasuoraan;
//    private Image nappula;

    public Kuvaesitys() {
        this.kuvastuvat = new ArrayList<Kuvastuva>();
        setPreferredSize(new Dimension(500, 500));
        super.setBackground(Color.LIGHT_GRAY);
        //      this.nappula = new ImageIcon("nappula.png").getImage();
    }

    @Override
    public void piirra(int laudanLeveys, int laudanKorkeus, List<Kuvastuva> laudanElementit) {
        this.kuvastuvat = (ArrayList<Kuvastuva>) laudanElementit;
        this.ruudunKoko = (int) (500 / Math.max(laudanKorkeus, laudanLeveys));
        this.ruutujaPystysuoraan = laudanLeveys;
        this.ruutujaVaakasuoraan = laudanKorkeus;
        repaint();
    }

    @Override
    public void paintComponent(Graphics graffat) {
        super.paintComponent(graffat);
        graffat.drawRect(1, 1, 498, 498); //laudan neliönmuotoiset reunat
        for (Kuvastuva kuva : this.kuvastuvat) {
            if (kuva.mikaKuva() == 1) {
                piirraPelaaja(kuva, graffat);
            } else if (kuva.mikaKuva() == 2) {
                graffat.drawRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
            } else if (kuva.mikaKuva() == 3) {
                piirraVastus(kuva, graffat);
            } else if (kuva.mikaKuva() == 6) {
                piirraKivikasa(kuva, graffat);
            } else if (kuva.mikaKuva() == 7) {
                piirraLaatikko(kuva, graffat);
            } else if (kuva.mikaKuva() == 10) { //maali
                graffat.setColor(Color.PINK);
                graffat.fillRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + (this.ruudunKoko / 3), (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + (this.ruudunKoko / 3), (this.ruudunKoko / 3), (this.ruudunKoko / 3));
            }
        }
    }

    private void piirraPelaaja(Kuvastuva mecha, Graphics graffat) {
        graffat.setColor(Color.black);
        suorakaide(mecha, graffat, 25, 60, 5, 35);  //jalkamännät
        suorakaide(mecha, graffat, 70, 60, 5, 35);
        suorakaide(mecha, graffat, 24, 45, 7, 38);
        suorakaide(mecha, graffat, 69, 45, 7, 38);
        graffat.setColor(Color.blue);
        suorakaide(mecha, graffat, 19, 25, 62, 40); //runko
        pallo(mecha, graffat, 18, 15, 63);
        suorakaide(mecha, graffat, 23, 92, 9, 3);   //tassut
        suorakaide(mecha, graffat, 68, 92, 9, 3);
        graffat.setColor(Color.DARK_GRAY);
        suorakaide(mecha,graffat,73,31,4,4);    //tuuletusaukot
        suorakaide(mecha,graffat,73,37,4,4);
        graffat.setColor(Color.black);  //sensori
        pallo(mecha,graffat,34,44,9);
        graffat.setColor(Color.red);
        pallo(mecha,graffat,37,47,4);
    }

    private void piirraLaatikko(Kuvastuva loota, Graphics graffat) {
        graffat.setColor(Color.ORANGE);
//        graffat.fillRect((loota.sijaintiSivusuunnassa() - 1) * this.ruudunKoko, (loota.sijaintiPystysuunnassa() - 1) * this.ruudunKoko, this.ruudunKoko, this.ruudunKoko);
        suorakaide(loota, graffat, 10, 10, 80, 80);
        graffat.setColor(Color.BLACK);
        graffat.drawRect((loota.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + this.ruudunKoko / 10, (loota.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + this.ruudunKoko / 10, 4 * this.ruudunKoko / 5, 4 * this.ruudunKoko / 5);
        viiva(loota, graffat, 10, 20, 90, 20);
        viiva(loota, graffat, 10, 80, 90, 80);
        viiva(loota, graffat, 30, 20, 30, 80);
        viiva(loota, graffat, 50, 20, 50, 80);
        viiva(loota, graffat, 70, 20, 70, 80);
    }

    private void piirraVastus(Kuvastuva kuva, Graphics graffat) {
        graffat.setColor(Color.black);
        suorakaide(kuva, graffat, 21, 60, 10, 35);  //jalat
        suorakaide(kuva, graffat, 74, 60, 10, 35);
        graffat.setColor(Color.MAGENTA);
        suorakaide(kuva, graffat, 20, 20, 64, 50);  //runko
        pallo(kuva, graffat, 17, 12, 70);
        suorakaide(kuva, graffat, 18, 91, 16, 4);   //tassut
        suorakaide(kuva, graffat, 71, 91, 16, 4);
        graffat.setColor(Color.black);
        pallo(kuva, graffat, 66, 49, 9);        //"silmät"
        pallo(kuva, graffat, 63, 56, 6);
        graffat.setColor(Color.red);
        pallo(kuva, graffat, 69, 52, 4);
        pallo(kuva, graffat, 66, 59, 2);
    }

    private void piirraKivikasa(Kuvastuva kuva, Graphics graffat) {
        graffat.setColor(Color.black);
        pallo(kuva, graffat, 30, 35, 40);
        pallo(kuva, graffat, 50, 55, 20);
        pallo(kuva, graffat, 60, 35, 20);
        suorakaide(kuva, graffat, 22, 43, 67, 45);
        suorakaide(kuva, graffat, 45, 25, 35, 30);
        suorakaide(kuva, graffat, 18, 50, 10, 10);
        suorakaide(kuva, graffat, 15, 55, 20, 20);
        suorakaide(kuva, graffat, 25, 35, 10, 20);
    }

    public int ruutu() {     //Vain testejä varten :P
        return this.ruudunKoko;
    }

    /**
     * Piirtää suorakaiteen laudan ruudun sisälle.
     *
     * @param kuva
     * @param graffat
     * @param X Miltä leveydeltä aloitetaan, prosentteja ruudun sivusta
     * @param Y Miltä korkeudelta aloitetaan, prosentteja ruudun sivusta
     * @param prosenttiX Kuinka leveä kuva, prosentteina ruudusta
     * @param prosenttiY Kuinka korkea kuva, prosentteina ruudusta
     */
    private void suorakaide(Kuvastuva kuva, Graphics graffat, int X, int Y, int prosenttiX, int prosenttiY) {
        graffat.fillRect((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + X * this.ruudunKoko / 100, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + Y * this.ruudunKoko / 100, prosenttiX * this.ruudunKoko / 100, prosenttiY * this.ruudunKoko / 100);
    }

    /**
     * Piirtää suorakaiteen laudan ruudun sisälle.
     *
     * @param kuva
     * @param graffat
     * @param alkuX Miltä leveydeltä aloitetaan, prosentteja ruudun sivusta
     * @param alkuY Miltä korkeudelta aloitetaan, prosentteja ruudun sivusta
     * @param loppuX mihin leveydelle lopetetaan, prosentteina ruudusta
     * @param loppuY Mille korkeudelle lopetetaan, prosentteina ruudusta
     */
    private void viiva(Kuvastuva kuva, Graphics graffat, int alkuX, int alkuY, int loppuX, int loppuY) {
        graffat.drawLine((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + alkuX * this.ruudunKoko / 100, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + alkuY * this.ruudunKoko / 100, (kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + loppuX * this.ruudunKoko / 100, (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + loppuY * this.ruudunKoko / 100);
    }

    private void pallo(Kuvastuva kuva, Graphics graffat, int x, int y, int r) {
        graffat.fillOval((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + (x * this.ruudunKoko / 100), (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + (y * this.ruudunKoko / 100), r * this.ruudunKoko / 100, r * this.ruudunKoko / 100);
    }
}
