package Carte;

import java.io.File;

import Combat.Combat;

public class Enflamme extends Carte {
   static String nom = "Enflamme : Gagne 12 points de blocage et 2 Force.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Enflamme() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueBlocage(Combat.eqpMonstre.get(numMonstre), 12);
      Combat.eqpMonstre.get(numMonstre).setForce(2);
   }
}
