package Entite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Carte.Brule;
import Carte.Carte;
import Carte.ChargeHexa;
import Carte.Divise;
import Carte.Enfer;
import Carte.Enflamme;

public class Hexaghost extends Entite {
    private static int maxPV = 250;
    private static int actuelPV = maxPV;
    private static List<Carte> deck = deckBase();
    private static String image = "pictures" + File.separator + "monstres" + File.separator + "Spike_Slime_S.png";
    private static int blocage = 0;
    private static String nom = "Hexaghost";
    private static int vulnerable = 0;
    private static int faiblesse = 0;
    private static int force = 0;
    private static int fragile = 0;
    private static int formeDemo = 0;
    private int compt = 0;
    private static int rituel = 0;

    public Hexaghost() {
        super(maxPV, actuelPV, deck, blocage, vulnerable, faiblesse, force, fragile, formeDemo, rituel, image, nom);
    }

    private static List<Carte> deckBase() {
        deck = new ArrayList<>();
        deck.add(new Divise());
        deck.add(new Brule());
        deck.add(new ChargeHexa());
        deck.add(new Enflamme());
        deck.add(new Enfer());
        return deck;
    }

    public Carte getCarte() {
        if (compt == 0) {
            compt++;
            return deck.get(0);
        } else if (compt == 1 || compt == 3 || compt == 6) {
            compt++;
            return deck.get(1);
        }else if (compt == 2 || compt == 5){
            compt++;
            return deck.get(2);
        }else if(compt==4){
            compt++;
            return deck.get(3);
        }else{
            compt=1;
            return deck.get(4);
        }
    }

    public String getNom() {
        return nom;
    }
}
