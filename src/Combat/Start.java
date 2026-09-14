package Combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entite.*;
import ressources.AssociationTouches;

public class Start {
    public static Hero hero = new Hero();
    public static List<Entite> equipeMonstre = new ArrayList<>();
    private static Random rand = new Random();

    public static void start() {
        int comptSalle = 0;
        while (hero.getActuelPV() > 0 && comptSalle < 15) {
            if (!(comptSalle == 2 && comptSalle == 6 && comptSalle == 10 && comptSalle == 13)) {
                setEquipe(comptSalle);
                Combat.combat(equipeMonstre);
                comptSalle++;
            }else if(!(comptSalle==14)){
                Repos.repos();
                comptSalle++;
            }else{                
                equipeMonstre.add(new Hexaghost());
                Combat.combat(equipeMonstre);}
        }
        if (hero.getActuelPV() > 0) {
            System.out.println("Le hero est mort");
            System.out.println("Voulez vous continuer : ");
            System.out.println("");
            if (select()) {
                start();
            } else {
                System.out.println("Fin");
            }
        } else {
            System.out.println("Vous avez gagner");
            System.out.println("Voulez vous recommencer : ");
            System.out.println("");
            if (select()) {
                start();
            } else {
                System.out.println("Fin");
            }
        }

    }

    private static void setEquipe(int avancer) {
        int nombreAleatoire = rand.nextInt(100);
        if (nombreAleatoire < 100 - 8 * avancer) {
            nombreAleatoire = 1;
        } else if (nombreAleatoire < 6 * avancer) {
            nombreAleatoire = 2;
        } else {
            nombreAleatoire = 3;
        }
        for (int i = 0; i < nombreAleatoire; i++) {
            equipeMonstre.add(selecteMontre(avancer));
        }
    }

    private static Entite selecteMontre(int avancer) {
        int type = rand.nextInt(100 - 5 * avancer);
        if (type < 100 - 5 * avancer) {
            int monstre = rand.nextInt(2);
            if (monstre == 0) {
                return new Psa();
            } else {
                return new Psp();
            }
        } else {
            int monstre = rand.nextInt(4);
            if (monstre == 0) {
                return new Machouilleur();
            } else if (monstre == 1) {
                return new Cultiste();
            } else if (monstre == 2) {
                return new Spiquant();
            } else {
                return new Sacide();
            }
        }
    }

    public static void showEqp(List<Entite> equipeMonstres) {
        System.out.println("Vie de l'équipe de monstres :");
        for (Entite monstre : equipeMonstres) {
            System.out.println("Monstre " + monstre.getNom() + ": " + monstre.getActuelPV() + " points de vie");
        }
    }

    private static boolean select() {
        boolean select = true;
        System.out.println("Oui");
        while (true) {
            String toucheSuivante = AssociationTouches.trouveProchaineEntree();
            if (toucheSuivante.equals("Droite")) {
                if (select) {
                    select = false;
                    System.out.println("Non");
                } else {
                    select = true;
                    System.out.println("Oui");
                }
            } else if (toucheSuivante.equals("Gauche")) {
                if (select) {
                    select = false;
                    System.out.println("Non");
                } else {
                    select = true;
                    System.out.println("Oui");
                }
            } else if (toucheSuivante.equals("Entree")) {
                return select;
            }
        }
    }
}
