package Carte;

import java.io.File;

import Combat.Start;

public class ChargeSlime extends Carte {
   static String nom = "Charge : Inflige 10 dégât";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public ChargeSlime() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 10);
   }
}
