package Carte;

import java.io.File;

import Combat.Start;

public class LecherPsa extends Carte {
   static String nom = "Lécher : Inflige 1 Faible";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public LecherPsa() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Start.hero.setFaiblesse(1);
   }
}
