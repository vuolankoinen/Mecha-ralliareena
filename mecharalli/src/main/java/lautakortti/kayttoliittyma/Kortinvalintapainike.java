package lautakortti.kayttoliittyma;

import java.util.Random;
import javax.swing.JButton;

public class Kortinvalintapainike extends JButton {

    private int siirto;
    private Random arpa;

    public Kortinvalintapainike() {
        this.arpa = new Random();
    }

    public void alusta(int siirto) {
        this.siirto = siirto;
        this.setText(annaNimi());
        this.setEnabled(true);
    }

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
