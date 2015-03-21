
package lautakortti.mecharalli;

import kayttoliittyma.Kayttoliittyma;

//Tämä ohjelma ei tee muuta kuin käynnistää käyttöliittymän.

public class Ohjelma {

    public static void main(String[] args) {

        Kayttoliittyma kayttis = new Kayttoliittyma(); 
        kayttis.kaynnista();
        
    }
}
