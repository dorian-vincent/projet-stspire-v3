package Carte;

import java.io.File;



public class Slime extends Carte {
   static String nom = "Slime carte sans effet et cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = true;

   public Slime() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
      
   }
}
