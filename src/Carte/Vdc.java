package Carte;

import java.io.File;

import Combat.Combat;

public class Vdc extends Carte {
    static String nom = "Volée de coups : Inflige 2 dégâts 4 fois à un ennemi. Cette carte est mise en exil après avoir été jouée et cout 1 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static boolean exil = true;

    public Vdc() {
        super(nom, cout, image, exil);
    }

    public String toString() {
        return nom + cout;
    }

    public void appliqueEffet() {
        int target = Carte.selectTarget();
        for (int i = 0; i < 4; i++) {
            Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 2));
        }
        if (Combat.eqpMonstre.get(target).getActuelPV() <= 0) {
            Combat.eqpMonstre.remove(target);
            Combat.prevision.remove(target);
        }
    }
}
