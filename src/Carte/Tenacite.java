package Carte;

import Combat.Combat;
import Combat.Start;

public class Tenacite extends Carte {
    static String nom = "Tenacite : Ajoute 2 cartes Plaie à sa main, gagne 15 points de blocage et cout 1 d'énergie";
    static int cout = 1;
    static String image;
    static boolean exil = false;

    public Tenacite() {
        super(nom, cout, image, exil);
    }

    public String toString() {
        return nom + cout;
    }

    public void appliqueEffet() {
        Combat.deckActuel.add(new Plaie());
        Combat.deckActuel.add(new Plaie());
        Carte.appliqueBlocage(Start.hero, 15);
    }
}
