package Carte;

import java.io.File;



public class Brulure extends Carte {
   static String nom = "Brulure no utilisable qui inflige 2 dégâts au héros si elle est dans sa main.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil;

   public Brulure() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {

   }
}
