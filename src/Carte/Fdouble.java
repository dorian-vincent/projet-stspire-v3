package Carte;

import java.io.File;


import Combat.Combat;

public class Fdouble extends Carte {
   static String nom = "Frappe double : Inflige 5 dégâts 2 fois à un ennemi et cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Fdouble() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
      int target = Carte.selectTarget();
      Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 5));
      Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 5));
      if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
         Combat.eqpMonstre.remove(target);
         Combat.prevision.remove(target);
      }
   }
}
