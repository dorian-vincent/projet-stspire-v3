package Combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Carte.*;

import Entite.Entite;
import ressources.AssociationTouches;

public class Combat {
    public static List<Entite> eqpMonstre;
    static Random random = new Random();
    public static List<Carte> deckActuel;
    public static List<Carte> deckPioche;
    public static List<Carte> deckDefausse;
    public static List<Carte> exil;
    public static int energie;
    public static List<Carte> prevision;

    public static void combat(List<Entite> importEqpMonstre) {
        eqpMonstre = importEqpMonstre;
        deckActuel = new ArrayList<>();
        deckPioche = Start.hero.getDeck();
        deckDefausse = new ArrayList<>();
        exil = new ArrayList<>();
        System.out.println("");
        System.out.println("");
        System.out.println("***Début combat***");

        while (Start.hero.getActuelPV() > 0 && unEnVie(eqpMonstre)) {
            if (deckPioche.size() < 5) {
                System.out.println("");
                System.out.println("la defausse va dans la pioche");
                deckPioche.addAll(deckDefausse);
                deckDefausse.clear();
            }
            creationDeck();
            System.out.println("");
            System.out.println("/*Debut de tour*/");
            System.out.println("");
            tour();
        }if(!unEnVie(eqpMonstre)){
            System.out.println("*---------------------------------------*");
            System.out.println("* Vous avez gagné selectionné une carte *");
            System.out.println("*---------------------------------------*");
            System.out.println("");
            System.out.println("***********");
            deckPioche.addAll(deckDefausse);
            deckPioche.addAll(deckActuel);
            deckPioche.addAll(exil);
            deckPioche.add(recompense());
            System.out.println("");
            exil.clear();
            deckDefausse.clear();
            deckActuel.clear();
            for (Carte carte : deckPioche) {
                if (carte.getNom() == "Plaie" || carte.getNom() == "Slime") {
                    deckPioche.remove(carte);
                }
            }
            Start.hero.setForce(0);
    
        }

    }

    private static boolean unEnVie(List<Entite> eqpMonstre) {
        for (Entite monstre : eqpMonstre) {
            if (monstre.getActuelPV() > 0) {
                return true;
            }
        }
        return false;
    }

    private static void creationDeck() {
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(deckPioche.size());
            deckActuel.add(deckPioche.get(num));
            deckPioche.remove(num);
        }
    }

    private static void tour() {
        energie = 3;
        int select = 0;
        prevision = new ArrayList<>();
        if (Start.hero.getFormeDemo() != 0) {
            Start.hero.setForce(Start.hero.getFormeDemo());
        }
        for (Entite monstre : eqpMonstre) {
            prevision.add(monstre.getCarte());
            if (monstre.getFormeDemo() != 0) {
                monstre.setForce(monstre.getFormeDemo());
            }
        
        }
        while (restEnergie() && unEnVie(eqpMonstre) && !(Start.hero.getActuelPV() <= 0)) {
            System.out.println("Vie du hero : " + Start.hero.getActuelPV());
            Start.showEqp(eqpMonstre);
            System.out.println("");
            affichePrevision();
            System.out.println("");
            System.out.println("Deck : ");
            System.out.println("********");
            afficheDeck(deckActuel);
            System.out.println("********");
            System.out.println("");
            select = 0;
            select = selectCarte(select,deckActuel);
            Start.hero.setBlocage(0);
            if (select != -1) {
                Carte selCarte = deckActuel.get(select);
                System.out.println("");
                if (selCarte.getNom() == "Plaie") {
                    System.out.println("Carte Plaie non jouable");
                    System.out.println("");
                } else if (selCarte.getNom() == "Brulure") {
                    System.out.println("Carte Brulure non jouable");
                    System.out.println("");
                } else if (selCarte.getCout() <= energie) {
                    selCarte.appliqueEffet();
                    if (!selCarte.estExil()) {
                        deckDefausse.add(selCarte);
                        deckActuel.remove(select);
                    } else {
                        exil.add(selCarte);
                        deckActuel.remove(select);
                    }
                    energie -= selCarte.getCout();
                } else {
                    System.out.println("");
                    System.out.println("pas assez d'énergie");
                    System.out.println("");
                }
            } else {
                energie = -1;
            }
        }
        if (Start.hero.getActuelPV() > 0) {
            for (Carte carte : deckActuel) {
                if (carte.getNom() == "Brulure") {
                    Carte.appliqueDegats(Start.hero, 2);
                }
            }
            deckDefausse.addAll(deckActuel);
            deckActuel.clear();
            for (Entite monstre : eqpMonstre) {
                monstre.setBlocage(0);
            }
            for (Carte carte : prevision) {
                carte.appliqueEffet();
                if (eqpMonstre.get(Carte.numMonstre).getRituel() != 0) {
                    eqpMonstre.get(Carte.numMonstre).setForce(eqpMonstre.get(Carte.numMonstre).getRituel());
                }
                Carte.numMonstre++;
            }
            Carte.numMonstre = 0;
            moinsVulFai();
        }
    }
    private static void affichePrevision(){
        for(int i=0;i<eqpMonstre.size() ;i++){
            System.out.println("Monstre ''" + eqpMonstre.get(i).getNom() + "'' va faire : " + prevision.get(i).getNom());
            i++;
        }
    }

    private static boolean restEnergie() {
        for (Carte carte : deckActuel) {
            if (carte.getCout() <= energie) {
                return true;
            }
        }
        return false;
    }

    private static int selectCarte(int select, List<Carte> listCarte) {
        while (true) {
            String toucheSuivante = AssociationTouches.trouveProchaineEntree();
            if (toucheSuivante.equals("Droite")) {
                if (select >= listCarte.size() - 1) {
                    select = 0;
                    System.out.println("cart selectionné : " + listCarte.get(select).getNom());
                } else {
                    select++;
                    System.out.println("cart selectionné : " + listCarte.get(select).getNom());
                }
            } else if (toucheSuivante.equals("Gauche")) {
                if (select <= 0) {
                    select = listCarte.size() - 1;
                    System.out.println("cart selectionné : " + listCarte.get(select).getNom());
                } else {
                    select--;
                    System.out.println("cart selectionné : " + listCarte.get(select).getNom());
                }
            } else if (toucheSuivante.equals("Entree")) {
                return select;
            } else if (toucheSuivante.equals("Echap")) {
                return -1;
            }
        }
    }

    private static void moinsVulFai() {
        if (Start.hero.getVulnerable() > 0) {
            Start.hero.setVulnerable(-1);
        }
        if (Start.hero.getFaiblesse() > 0) {
            Start.hero.setVulnerable(-1);
        }
        for (Entite monstre : eqpMonstre) {
            if (monstre.getVulnerable() > 0) {
                monstre.setVulnerable(-1);
            }
            if (monstre.getFaiblesse() > 0) {
                monstre.setFaiblesse(-1);
            }
        }
    }

    private static void afficheDeck(List<Carte> deck) {
        for (Carte carte : deck) {
            System.out.println(carte.getNom());
        }
    }

    private static Carte recompense(){
        List<Carte> listRec = new ArrayList<>();
        for(int i=0;i<3 ;i++){
            int num = random.nextInt(100);
            if(num<60){
                int chois = random.nextInt(11);
                if(chois == 0){listRec.add(new Frappe());}
                else if(chois == 1){listRec.add(new Defense());}
                else if(chois == 2){listRec.add(new Heurt());}
                else if(chois == 3){listRec.add(new Mpm());}
                else if(chois == 4){listRec.add(new Vdf());}
                else if(chois == 5){listRec.add(new Fdp());}
                else if(chois == 6){listRec.add(new Fdouble());}
                else if(chois == 7){listRec.add(new Ebr());}
                else if(chois == 8){listRec.add(new Manchette());}
                else if(chois == 9){listRec.add(new Plaquage());}
                else if(chois == 10){listRec.add(new Enchainement());}
            }else if(num<97){
                int chois = random.nextInt(9);
                if(chois == 0){listRec.add(new Saignee());}
                else if(chois == 1){listRec.add(new Hemokinesie());}
                else if(chois == 2){listRec.add(new Uppercut());}
                else if(chois == 3){listRec.add(new Vdc());}
                else if(chois == 4){listRec.add(new VoirRouge());}
                else if(chois == 5){listRec.add(new Enflammer());}
                else if(chois == 6){listRec.add(new Desarmement());}
                else if(chois == 7){listRec.add(new Odc());}
                else if(chois == 8){listRec.add(new Tenacite());}
            }else{
                int chois = random.nextInt(4);
                if(chois == 0){listRec.add(new Gourdin());}
                 if(chois == 1){listRec.add(new Invincible());}
                else if(chois == 2){listRec.add(new Offrande());}
                else if(chois == 3){listRec.add(new Fdemo());}
            }
        }
        afficheDeck(listRec);
        int select = 0;
        selectCarte(select,listRec);
        return listRec.get(select);
    }

}
