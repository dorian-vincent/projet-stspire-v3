package Carte;

import java.io.File;


import Combat.Start;

public class Invincible extends Carte {
   static String nom = "Invincible : Gagne 30 points de blocage. Cette carte est mise en exilaprès avoir été jouée et cout 2 d'énergie";
   static int cout = 2;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Defend_R.png";
   static boolean exil = true;

   public Invincible() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
    Carte.appliqueBlocage(Start.hero, 30);
   }

}
