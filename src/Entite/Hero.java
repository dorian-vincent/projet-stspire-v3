package Entite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Carte.Carte;
import Carte.Defense;
import Carte.Frappe;
import Carte.Heurt;


public class Hero extends Entite {

    private static int maxPV = 70;
    private static int actuelPV = maxPV;
    private static List<Carte> deck = deckBase();
    private static String image = "pictures" + File.separator + "Ironclad.png";
    private static int blocage = 0;
    private static String nom = "Hero";
    private static int vulnerable = 0;
    private static int faiblesse = 0;
    private static int force = 0;
    private static int fragile = 0;
    private static int formeDemo = 0;
    private static int rituel = 0;

    
    public Hero(){
        super(maxPV, actuelPV, deck, blocage,vulnerable,faiblesse, force,fragile,formeDemo, rituel, image, nom);
    }

    public int getActuelPV(){
        return actuelPV;
    }
    public int getPVMax(){
        return maxPV;
    }
    public void setActuelPV(int n){
        actuelPV+=n;
    }
    public Carte getCard(int n){
        return deck.get(n);
    }
    public List<Carte> getDeck(){
        return deck;
    }

    public String getImage(){
        return image;
    }
    public int getBlocage(){
        return blocage;
    }
    public void setBlocage(int n){
        blocage=n+blocage;
    }
    public String getNom(){
        return nom;
    }

    
    private static List<Carte> deckBase(){
        deck = new ArrayList<>();
        for(int i=0;i<5 ;i++){
            deck.add(new Frappe());
        }
        for(int i=0;i<4 ;i++){
            deck.add(new Defense());
        }
        deck.add(new Heurt());
        return deck;
        
        
    }
}
