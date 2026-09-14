package Carte;

import java.io.File;

import Combat.Start;

public class Attaque extends Carte {
   static String nom = "Attaque : Inflige 6 dégâts";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Attaque() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 6);
   }
}
