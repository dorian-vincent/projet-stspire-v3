package Carte;

import java.io.File;

import Combat.Combat;

public class GronderMach extends Carte {
   static String nom = "Gronder : Gagne 6 points de blocage et 3 Force.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public GronderMach() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueBlocage(Combat.eqpMonstre.get(numMonstre), 6);
      Combat.eqpMonstre.get(numMonstre).setForce(3);
   }
}
