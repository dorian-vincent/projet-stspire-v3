package Carte;

import java.io.File;


import Combat.Start;

public class Defense extends Carte {
   static String nom = "Defense : gagne 5 points de blocage cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Defend_R.png";
   static boolean exil = false;

   public Defense() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueBlocage(Start.hero, 5);
   }

}
