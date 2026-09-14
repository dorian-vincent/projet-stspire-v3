package Carte;

import java.io.File;
import Combat.Start;

public class Enflammer extends Carte {
    static String nom = "Enflammer : Gagne 2 de Force. Cette carte est mise en exil après avoir été joué et cout 1 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static boolean exil = true;

    public Enflammer() {
        super(nom, cout, image, exil);
    }
    public String toString() {
        return nom + cout;
     }
  
  
  
     public void appliqueEffet() {
        Start.hero.setForce(2);
     }
}

