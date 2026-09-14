package Carte;

import java.io.File;

import Combat.Start;
import Combat.Combat;

public class CrachatSpiq extends Carte {
   static String nom = "Crachat : Inflige 8 dégât et ajoute une carte Slime dans la défausse";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public CrachatSpiq() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 8);
      Combat.deckDefausse.add(new Slime());
   }
}
