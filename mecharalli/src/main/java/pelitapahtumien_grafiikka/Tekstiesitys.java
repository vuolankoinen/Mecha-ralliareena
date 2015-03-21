package pelitapahtumien_grafiikka;

import java.util.List;

public class Tekstiesitys implements Piirrustava {
    //Tämä pelilauta"piirrin" on tarkoitus korvata pian toimivammalla (ja sittemmin graafisella) versiolla.

    public void piirra(int leveys, int korkeus, List<Kuvastuva> elementit) {
        for (Kuvastuva juttu : elementit) {
            System.out.println(etsiNimi(juttu.mikaKuva()) + ": Sijainti on " + juttu.sijaintiSivusuunnassa() + " x, " + juttu.sijaintiPystysuunnassa() + " y.");
        }
        System.out.println("\n");
    }

    private String etsiNimi(int etsittava) {
        if (etsittava == 1) {
            return "Pelaajanappula";
        } else if (etsittava == 6) {
            return "Kivi";
        } else {
            return "Tuntematon";
        }
    }

}
