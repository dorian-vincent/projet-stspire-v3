package Carte;

import java.io.File;

import Combat.Start;
import Combat.Combat;

public class CrachatSacid extends Carte {
   static String nom = "Crachat : Inflige 7 dégâts et ajoute une carte Slime dans la défausse";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public CrachatSacid() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 7);
      Combat.deckDefausse.add(new Slime());
   }
}
