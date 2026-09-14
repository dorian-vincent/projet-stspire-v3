package Carte;

import java.io.File;

import Combat.Start;

public class ChargeHexa extends Carte {
   static String nom = "Charge : Inflige 5 dégâts 2 fois.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public ChargeHexa() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 5);
      Carte.appliqueDegats(Start.hero, 5);
   }
}
