package Carte;

import java.io.File;

import Combat.Start;

public class ChargePsp extends Carte {
   static String nom = "Charge : Inflige 5 dégât";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public ChargePsp() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 5);
   }
}
