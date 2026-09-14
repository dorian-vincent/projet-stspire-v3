package Carte;

import java.io.File;



public class Plaie extends Carte {
   static String nom = "Plaie non jouable";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil;

   public Plaie() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {

   }
}
