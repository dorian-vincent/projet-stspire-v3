package Carte;

import Combat.Combat;
import Entite.Entite;
import ressources.AssociationTouches;

public class Carte {
   private String nom;
   private int cout;
   private String image;
   private boolean exil;
   public static int numMonstre = 0;

   public Carte(String nom, int cout, String image, boolean exil) {
      this.nom = nom;
      this.cout = cout;
      this.image = image;
      this.exil = exil;
   }

   public boolean estExil() {
      return exil;
   }

   public String getNom() {
      return this.nom;
   }

   public int getCout() {
      return this.cout;
   }

   public String getImage() {
      return this.image;
   }

   public String toString() {
      return this.nom + "\n" + this.cout;
   }

   public void appliqueEffet() {
   }

   protected static Entite appliqueBlocage(Entite receveur, int point) {
      if (receveur.getFragile() != 0) {
         point = (int) Math.floor(point * 0.75);
      }
      receveur.setBlocage(point);
      return receveur;

   }

   public static Entite appliqueDegats(Entite attaquer, int degats) {
      if (attaquer.getFaiblesse() != 0) {
         degats += attaquer.getFaiblesse();
      }
      if (attaquer.getFaiblesse() != 0) {
         degats = (int) Math.floor(degats * 0.25);
      }
      if (attaquer.getVulnerable() != 0) {
         degats = (int) Math.floor(degats * 1.5);
      }
      int blocage = attaquer.getBlocage();
      if (blocage >= degats) {
         attaquer.setBlocage(blocage - degats);
      } else {
         attaquer.setActuelPV(blocage - degats);
         attaquer.setBlocage(0);
      }
      return attaquer;
   }

   protected static int selectTarget() {
      int select = 0;
      if (Combat.eqpMonstre.size() == 1) {
         return 0;
      }System.out.println("Selectionner un ennemie : ");
      while (true) {
         String toucheSuivante = AssociationTouches.trouveProchaineEntree();
         if (toucheSuivante.equals("Droite")) {
            if (select >= Combat.eqpMonstre.size() - 1) {
               select = 0;
               System.out.println("cart selectionné : " + Combat.eqpMonstre.get(select).getNom() + " vie du monstre : " + Combat.eqpMonstre.get(select).getActuelPV());
            } else {
               select++;
               System.out.println("cart selectionné : " + Combat.eqpMonstre.get(select).getNom() + " vie du monstre : " + Combat.eqpMonstre.get(select).getActuelPV());
            }
         } else if (toucheSuivante.equals("Gauche")) {
            if (select <= 0) {
               select = Combat.eqpMonstre.size() - 1;
               System.out.println("cart selectionné : " + Combat.eqpMonstre.get(select).getNom() + " vie du monstre : " + Combat.eqpMonstre.get(select).getActuelPV());
            } else {
               select--;
               System.out.println("cart selectionné : " + Combat.eqpMonstre.get(select).getNom() + " vie du monstre : " + Combat.eqpMonstre.get(select).getActuelPV());
            }
         } else if (toucheSuivante.equals("Entree")) {
            return select;
         }
      }
   }
}
