package Entite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Carte.Carte;
import Carte.ChargeSlime;
import Carte.CrachatSacid;
import Carte.LecherSlime;

public class Sacide extends Entite {
    static Random random = new Random();
    private static int maxPV = 30;
    private static int actuelPV = maxPV;
    private static List<Carte> deck = deckBase();
    private static String image = "pictures" + File.separator + "monstres" + File.separator + "Spike_Slime_S.png";
    private static int blocage = 0;
    private static String nom = "Slime acide";
    private static int vulnerable = 0;
    private static int faiblesse = 0;
    private static int force = 0;
    private static int fragile = 0;
    private static int formeDemo = 0;
    private static int rituel = 0;

    public Sacide() {
        super(maxPV, actuelPV, deck, blocage, vulnerable, faiblesse, force, fragile, formeDemo, rituel, image, nom);
    }

    private static List<Carte> deckBase() {
        deck = new ArrayList<>();
        deck.add(new CrachatSacid());
        deck.add(new LecherSlime());
        deck.add(new ChargeSlime());
        return deck;
    }

    public Carte getCarte() {

        int attaque = random.nextInt(100);
        if (attaque < 40) {
            return deck.get(0);
        }else if(attaque <70){
            return deck.get(1);
        } 
        else {
            return deck.get(2);
        }

    }

    public String getNom() {
        return nom;
    }
}
