package Carte;

import java.io.File;

import Combat.Start;

public class LecherSlime extends Carte {
   static String nom = "Lécher : Inflige 1 Fragile";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public LecherSlime() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Start.hero.setFragile(1);
   }
}
