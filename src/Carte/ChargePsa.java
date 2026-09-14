package Carte;

import java.io.File;

import Combat.Start;

public class ChargePsa extends Carte {
   static String nom = "Charge : Inflige 3 dégâts";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public ChargePsa() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 3);
   }
}
