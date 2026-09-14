package Carte;

import java.io.File;


import Combat.Combat;

public class VoirRouge extends Carte {
   static String nom = "Voir rouge : Gagne 2 points d’énergies. Cette carte est mise en exil après avoir été jouée et cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = true;

   public VoirRouge() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
        Combat.energie+=2;
   }
}
