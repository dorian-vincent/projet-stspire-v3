package Entite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Carte.Carte;
import Carte.ChargePsp;

public class Psp extends Entite{
    private static int maxPV = 12;
    private static int actuelPV = maxPV;
    private static List<Carte> deck = deckBase();
    private static String image = "pictures" + File.separator + "monstres" + File.separator +"Spike_Slime_S.png";
    private static int blocage = 0;
    private static String nom = "Petit slime piquant";
    private static int vulnerable = 0;
    private static int faiblesse = 0;
    private static int force = 0;
    private static int fragile = 0;
    private static int formeDemo = 0;
    private static int rituel = 0;

    public Psp(){
        super(maxPV, actuelPV, deck, blocage,vulnerable,faiblesse, force,fragile,formeDemo,rituel, image, nom);
    }
    private static List<Carte> deckBase(){
        deck=new ArrayList<>();
        deck.add(new ChargePsp());
        return deck;
    }
    public Carte getCarte(){
        return new ChargePsp();
    }
    public String getNom(){
        return nom;
    }
}
