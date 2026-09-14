package Entite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Carte.Carte;
import Carte.ChargeMach;
import Carte.GronderMach;
import Carte.MorsureMach;

public class Machouilleur extends Entite{
    static Random random = new Random();
    private static int maxPV = 40;
    private static int actuelPV = maxPV;
    private static List<Carte> deck = deckBase();
    private static String image = "pictures" + File.separator + "monstres" + File.separator +"Spike_Slime_S.png";
    private static int blocage = 0;
    private static String nom = "Machouilleur";
    private static int vulnerable = 0;
    private static int faiblesse = 0;
    private static int force = 0;
    private static int fragile = 0;
    private static int formeDemo = 0;
    private static int compt = 0;
    private static int rituel = 0;
    
    public Machouilleur(){
        super(maxPV, actuelPV, deck, blocage,vulnerable,faiblesse, force,fragile,formeDemo,rituel, image, nom);
    }
    private static List<Carte> deckBase(){
        deck=new ArrayList<>();
        deck.add(new ChargeMach());
        deck.add(new MorsureMach());
        deck.add(new GronderMach());
        return deck;
    }
    public Carte getCarte(){
        if(compt==0){compt++;return deck.get(0);}
        else{int attaque = random.nextInt(100);
            if(attaque<45){return deck.get(2);}
            else if(attaque<75){return deck.get(0);}
            else{return deck.get(1);}
        }
    }
    public String getNom(){
        return nom;
    }
}
