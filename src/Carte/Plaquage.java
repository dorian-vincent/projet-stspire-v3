package Carte;

import java.io.File;


import Combat.Combat;
import Combat.Start;

public class Plaquage extends Carte {
   static String nom = "Plaquage : Inflige x dégâts à un ennemi, avec x le nombre de points de blocage de l’entité qui utilise la carte et cout 1 d'énergie";
   static int cout = 1;
   static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
   static boolean exil = false;

   public Plaquage() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }



   public void appliqueEffet() {
      int target = Carte.selectTarget();
      Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), Start.hero.getBlocage()));
      if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
         Combat.eqpMonstre.remove(target);
         Combat.prevision.remove(target);
      }
   }
}
