package lautakortti.kayttoliittyma;

import javax.swing.JButton;

public class Kortinvalintapainike extends JButton {

    private int siirto;

    public Kortinvalintapainike() {

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
        return "0";

    }

}
