package Carte;

import java.io.File;

import Combat.Start;
import Combat.Combat;

public class Brule extends Carte {
   static String nom = "Brûle : Inflige 6 dégâts et ajoute 1 Brûlure dans la défausse.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Brule() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 6);
      Combat.deckDefausse.add(new Brulure());
   }
}
