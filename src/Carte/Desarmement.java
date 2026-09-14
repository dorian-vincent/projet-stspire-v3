package Carte;

import java.io.File;

import Combat.Combat;

public class Desarmement extends Carte {
    static String nom = "Desarmement : Fait perdre 2 de Force à un ennemi. Cette carte est mise en exil après avoir été jouée et cout 1 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static boolean exil = true;

    public Desarmement() {
        super(nom, cout, image, exil);
    }

    public String toString() {
        return nom + cout;
    }

    public void appliqueEffet() {
        int target = Carte.selectTarget();
        Combat.eqpMonstre.get(target).setForce(-2);
    }
}
