package lautakortti.mecharalli;

import javax.swing.SwingUtilities;
import lautakortti.kayttoliittyma.*;

//Tämä ohjelma ei tee muuta kuin käynnistää käyttöliittymän.
public class Ohjelma {

    public static void main(String[] args) {

//        Kayttoliittyma kayttis = new Kayttoliittyma();    //tekstipohjainen koeversio
//        kayttis.kaynnista();

//        GraafinenKayttoliittyma kayttis = new GraafinenKayttoliittyma();
//        SwingUtilities.invokeLater(kayttis);

        KortillinenGraafinenKayttoliittyma kayttis = new KortillinenGraafinenKayttoliittyma();
        SwingUtilities.invokeLater(kayttis);
    }
}