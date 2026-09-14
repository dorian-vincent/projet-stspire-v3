package Carte;

import java.io.File;


import Combat.Combat;

public class Frappe extends Carte {
   static String nom = "Frappe : inflige 6 dégâts à un ennemi et cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Frappe() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
      int target = Carte.selectTarget();
      Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 6));
      if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
         Combat.eqpMonstre.remove(target);
         Combat.prevision.remove(target);
      }
   }
}
