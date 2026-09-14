package Carte;

import java.io.File;

import Combat.Start;
import Combat.Combat;

public class ChargeMach extends Carte {
   static String nom = "Charge : Inflige 7 dégâts et gagne 5 points de blocage.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public ChargeMach() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueDegats(Start.hero, 7);
      Carte.appliqueBlocage(Combat.eqpMonstre.get(numMonstre), 5);
   }
}
