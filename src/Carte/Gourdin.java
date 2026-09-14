package Carte;

import java.io.File;


import Combat.Combat;

public class Gourdin extends Carte {
   static String nom = "Gourdin : Inflige 32 points de dégâts à un ennemi et cout 3 d'énergie";
   static int cout = 3;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Gourdin() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
      int target = Carte.selectTarget();
      Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 32));
      if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
         Combat.eqpMonstre.remove(target);
         Combat.prevision.remove(target);
      }
   }
}
