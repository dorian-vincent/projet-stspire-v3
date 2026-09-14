package Carte;

import java.io.File;

import Combat.Combat;

public class Rituel extends Carte {
   static String nom = "Rituel : Le monstre gagne 3 points d’un statut nommé Rituel.";
   static int cout = 0;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Rituel() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Combat.eqpMonstre.get(numMonstre).setRituel(3);
   }
}
