package Carte;

import java.io.File;

import Combat.Start;
import Combat.Combat;

public class Enfer extends Carte {
   static String nom = "Enfer : Inflige 6 dégâts 2 fois et ajoute 3 Brûlure dans la défausse.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Enfer() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 6);
      Carte.appliqueDegats(Start.hero, 6);
      for (int i = 0; i < 3; i++) {
         Combat.deckDefausse.add(new Brulure());
      }
   }
}
