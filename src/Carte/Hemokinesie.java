package Carte;

import java.io.File;


import Combat.Combat;
import Combat.Start;

public class Hemokinesie extends Carte {
   static String nom = "Hemokinesie : Perdez 2 points de vie, inflige 15 points de dégâts à un ennemi et cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Hemokinesie() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
        Start.hero.setActuelPV(-2);
        int target = Carte.selectTarget();
        Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 15));
        if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
           Combat.eqpMonstre.remove(target);
           Combat.prevision.remove(target);
        }
   }
}
