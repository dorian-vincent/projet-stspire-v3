package Carte;

import java.io.File;
import java.util.Random;

import Combat.Combat;

public class Ebr extends Carte {
    static String nom = "Epée boomerang : Inflige 3 dégâts à un ennemi au hasard. Cet effet s’applique3 fois à la suite et cout 1 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static Random random = new Random();
    static boolean exil = false;

    public Ebr() {
        super(nom, cout, image, exil);
    }

    public String toString() {
        return nom + cout;
    }

    public void appliqueEffet() {
        for (int i = 0; i < 3; i++) {
            int target = random.nextInt(Combat.eqpMonstre.size());
            Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 3));
            if (Combat.eqpMonstre.get(target).getActuelPV() <= 0) {
                i=3;
                Combat.eqpMonstre.remove(target);
                Combat.prevision.remove(target);
            }
        }
    }
}
