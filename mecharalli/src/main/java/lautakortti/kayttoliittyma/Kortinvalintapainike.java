package lautakortti.kayttoliittyma;

import java.util.Random;
import javax.swing.JButton;

public class Kortinvalintapainike extends JButton {

    private int siirto;
    private Random arpa;

    /**
     * JButton, joka muistaa siihen tallennetun pelisiirron ja osaa kertoa sen
     * pyydettäessä.
     */
    public Kortinvalintapainike() {
        this.arpa = new Random();
    }

    /**
     * Alustaa painikkeen annetun siirron mukaan.
     * <p>
     * Annettua siirtoa vastaava kuva tulee painikkeen tekstiksi. Annettua
     * siirtoa vastaava numero tallentuu oliomuuttujaan.
     *
     * @param siirto Painikkeeseen talletettavan siirron numerokoodi.
     */
    public void alusta(int siirto) {
        this.siirto = siirto;
        this.setText(annaNimi());
        this.setEnabled(true);
    }

    /**
     * Kertoo painikkeeseen tallennetun siirron kirjainkoodin.
     *
     * @return Painikkeen siirron kirjainkoodi.
     */
    public String annaSiirto() {
        this.setEnabled(false);
        if (siirto == 1) {
            return "a";
        }
        if (siirto == 2) {
            return "s";
        }
        if (siirto == 3) {
            return "w";
        }
        if (siirto == 4) {
            return "z";
        }
        if (siirto == 5) {
            siirto = arpa.nextInt(4) + 1;
            return annaSiirto();
        }
        return "0";

    }

    //Palauttaa numerokoodilla yksilöityä siirtoa vastaavan kuvan.
    private String annaNimi() {
        if (siirto == 1) {
            return "<";
        }
        if (siirto == 2) {
            return ">";
        }
        if (siirto == 3) {
            return "v";
        }
        if (siirto == 4) {
            return "^";
        }
        if (siirto == 5) {
            return "?";
        }
        return "0";

    }

}
