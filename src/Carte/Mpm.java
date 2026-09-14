package Carte;


import java.util.Random;

import Combat.Combat;
import Combat.Start;

public class Mpm extends Carte {
   static String nom = "Même pas mal : Gagne 8 points de blocage puis pioche 1 carte et cout 1 d'énergie";
   static int cout = 1;
   static String image;
   static Random random = new Random();
   static boolean exil = false;
   
   public Mpm() {
      super(nom, cout, image, exil);
   }

   public String toString() {
      return nom + cout;
   }


   public void appliqueEffet() {
      Carte.appliqueBlocage(Start.hero, 8);
      if(Combat.deckPioche.size()<=0){
         Combat.deckPioche.addAll(Combat.deckDefausse);
         Combat.deckDefausse.clear();
      }
         int num = random.nextInt(Combat.deckPioche.size());
         Combat.deckActuel.add(Combat.deckPioche.get(num));
         Combat.deckPioche.remove(num);
      
   }
}
