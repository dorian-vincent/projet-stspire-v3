package Carte;

import java.io.File;
import Combat.Start;

public class Fdemo extends Carte {
    static String nom = "Donne au joueur 2 points d’un statut spécial Forme démoniaque. Au début de chaque tour le héros gagne un point de Force par point de Forme Démoniaque. Cette carte est mise en exil après avoir été jouée et cout 3 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static boolean exil = true;

    public Fdemo() {
        super(nom, cout, image, exil);
    }
    public String toString() {
        return nom + cout;
     }
  
  
  
     public void appliqueEffet() {
        Start.hero.setFormeDemo(2);
     }
}

