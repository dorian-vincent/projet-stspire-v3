package Carte;



import Combat.Combat;
import Combat.Start;

public class Vdf extends Carte {
   static String nom = "Vague de fer : Gagne 5 points de blocage puis inflige 5 dégâts à un ennemi et cout 1 d'énergie";
   static int cout = 1;
   static String image;
   static boolean exil = false;

   public Vdf() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }

   public void appliqueEffet() {
      Carte.appliqueBlocage(Start.hero, 5);
      int target = Carte.selectTarget();
      Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 5));
      if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
         Combat.eqpMonstre.remove(target);
         Combat.prevision.remove(target);
      }
   }

}
