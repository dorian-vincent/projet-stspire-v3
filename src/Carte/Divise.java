package Carte;

import java.io.File;

import Combat.Start;

public class Divise extends Carte {
   static String nom = "Divise : Inflige  1 + (PV du héros) 12 dégâts 6 fois";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Divise() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      for(int i=0;i<6;i++){
         Carte.appliqueDegats(Start.hero, 1+Start.hero.getActuelPV()/12);
      }
   }
}
