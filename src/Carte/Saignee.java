package Carte;

import java.io.File;


import Combat.Combat;
import Combat.Start;

public class Saignee extends Carte {
   static String nom = "Saignee : Perdez 3 points de vie puis gagnez 2 points d'énergie et cout 0 d'énergie";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Saignee() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
        Start.hero.setActuelPV(-3);
        Combat.energie+=2;
   }
}
