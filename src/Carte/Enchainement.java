package Carte;

import java.io.File;
import Combat.Combat;
import Entite.Entite;

public class Enchainement extends Carte {
    static String nom = "Enchainement : Inflige 8 dégâts à tous les ennemis et cout 1 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static boolean exil = false;

    public Enchainement() {
        super(nom, cout, image, exil);
    }

    public String toString() {
        return nom + cout;
    }

    public void appliqueEffet() {
        int i = 0;
        for (Entite target : Combat.eqpMonstre) {
            target = appliqueDegats(target, 8);
            if (target.getActuelPV() <= 0) {
                Combat.eqpMonstre.remove(target);
                Combat.prevision.remove(i);
            }else{i++;}
        }
    }
}
