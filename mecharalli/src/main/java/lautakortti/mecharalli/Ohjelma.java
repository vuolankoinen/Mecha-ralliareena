package lautakortti.mecharalli;

import javax.swing.SwingUtilities;
import lautakortti.kayttoliittyma.*;

//Tämä ohjelma ei tee muuta kuin käynnistää käyttöliittymän.
/**
 * Pääluokka, jonka suorittaminen käynnistää pelin käyttöliittymän.
 * @author Matti Palomäki
 */
public class Ohjelma {

    public static void main(String[] args) {

        Kayttoliittyma kayttis = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttis);
    }
}