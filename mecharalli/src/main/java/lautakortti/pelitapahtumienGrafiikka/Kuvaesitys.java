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

/**
 * Swing-componentti, joka osaa piirtää pelilaudan pelilauta-olion sille
 * välittämien tietojen pohjalta.
 */
public class Kuvaesitys extends JPanel implements Piirrustava {

    private ArrayList<Kuvastuva> kuvastuvat;
    private int ruudunKoko;     //Piirrettävän pelilaudan ruudun sivu pikseleinä.
    private int ruutujaPystysuoraan;
    private int ruutujaVaakasuoraan;

    /**
     * Konstruktori.
     */
    public Kuvaesitys() {
        this.kuvastuvat = new ArrayList<Kuvastuva>();
        setPreferredSize(new Dimension(500, 500));
        super.setBackground(Color.LIGHT_GRAY);
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
        graffat.drawRect(1, 1, 498, 498); //laudan suorakaiteenmuotoiset reunat
        for (Kuvastuva kuva : this.kuvastuvat) {
            if (kuva.mikaKuva() == 2) {
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
            } else if (kuva.mikaKuva() == 4) {
                piirraTeslatorni(kuva, graffat);
            } else if (kuva.mikaKuva() == 1) {
                piirraPelaaja(kuva, graffat);
            } else if (kuva.mikaKuva() == -1) {
                piirraPelaaja(kuva, graffat);
                piirraHalkeamia(kuva, graffat);
            }

        }
    }

    private void piirraPelaaja(Kuvastuva mecha, Graphics graffat) {
        graffat.setColor(Color.black);
        suorakaide(mecha, graffat, 25, 60, 5, 35);  //jalkamännät
        suorakaide(mecha, graffat, 70, 60, 5, 35);
        suorakaide(mecha, graffat, 24, 45, 7, 38);
        suorakaide(mecha, graffat, 69, 45, 7, 38);
        graffat.setColor(Color.MAGENTA);
        suorakaide(mecha, graffat, 19, 25, 62, 40); //runko
        pallo(mecha, graffat, 18, 15, 63);
        suorakaide(mecha, graffat, 23, 92, 9, 3);   //tassut
        suorakaide(mecha, graffat, 68, 92, 9, 3);
        graffat.setColor(Color.DARK_GRAY);
        suorakaide(mecha, graffat, 73, 31, 4, 4);    //tuuletusaukot
        suorakaide(mecha, graffat, 73, 37, 4, 4);
        graffat.setColor(Color.black);  //sensori
        pallo(mecha, graffat, 34, 44, 9);
        graffat.setColor(Color.red);
        pallo(mecha, graffat, 37, 47, 4);
    }

    private void piirraLaatikko(Kuvastuva loota, Graphics graffat) { //Piirtää puulaatikon.
        graffat.setColor(Color.ORANGE);
        suorakaide(loota, graffat, 10, 10, 80, 80);
        graffat.setColor(Color.BLACK);
        graffat.drawRect((loota.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + this.ruudunKoko / 10, (loota.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + this.ruudunKoko / 10, 4 * this.ruudunKoko / 5, 4 * this.ruudunKoko / 5);
        viiva(loota, graffat, 10, 20, 90, 20);
        viiva(loota, graffat, 10, 80, 90, 80);
        viiva(loota, graffat, 30, 20, 30, 80);
        viiva(loota, graffat, 50, 20, 50, 80);
        viiva(loota, graffat, 70, 20, 70, 80);
    }

    private void piirraTeslatorni(Kuvastuva kuva, Graphics graffat) {   //Piirtää nyrkkitornin.
        graffat.setColor(Color.BLACK);
        suorakaide(kuva, graffat, 40, 30, 20, 65);
        graffat.setColor(Color.blue);
        pallo(kuva, graffat, 32, 25, 35);
        viiva(kuva, graffat, 30, 20, 25, 15);
        viiva(kuva, graffat, 26, 43, 21, 52);
        viiva(kuva, graffat, 70, 27, 78, 22);
        viiva(kuva, graffat, 70, 43, 78, 51);
    }

    private void piirraVastus(Kuvastuva kuva, Graphics graffat) {
        graffat.setColor(Color.black);
        suorakaide(kuva, graffat, 21, 60, 10, 35);  //jalat
        suorakaide(kuva, graffat, 74, 60, 10, 35);
        graffat.setColor(Color.blue);
        suorakaide(kuva, graffat, 20, 20, 64, 50);  //runko
        pallo(kuva, graffat, 17, 12, 70);
        suorakaide(kuva, graffat, 18, 91, 16, 4);   //tassut
        suorakaide(kuva, graffat, 71, 91, 16, 4);
        graffat.setColor(Color.black);
        pallo(kuva, graffat, 66, 49, 9);        //"silmät"
        pallo(kuva, graffat, 62, 57, 6);
        graffat.setColor(Color.red);
        pallo(kuva, graffat, 69, 52, 4);
        pallo(kuva, graffat, 65, 60, 2);
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

    private void piirraHalkeamia(Kuvastuva kuva, Graphics graffat) {  //Koristelee vahingoittuneen mechan.
        graffat.setColor(Color.black);
        viiva(kuva, graffat, 60, 60, 70, 50);
        viiva(kuva, graffat, 70, 50, 75, 45);
        viiva(kuva, graffat, 70, 50, 75, 52);
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
     * Piirtää viivan laudan ruudun sisälle.
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

    /**
     * Piirtää ympyrän pelilaudan ruudun sisälle.
     *
     * @param kuva
     * @param graffat
     * @param x
     * @param y
     * @param r
     */
    private void pallo(Kuvastuva kuva, Graphics graffat, int x, int y, int r) {
        graffat.fillOval((kuva.sijaintiSivusuunnassa() - 1) * this.ruudunKoko + (x * this.ruudunKoko / 100), (kuva.sijaintiPystysuunnassa() - 1) * this.ruudunKoko + (y * this.ruudunKoko / 100), r * this.ruudunKoko / 100, r * this.ruudunKoko / 100);
    }
}
