package Entite;

import java.util.List;

import Carte.Carte;

public class Entite {

    private int maxPV;
    private int actuelPV;
    private List<Carte> deck;
    private String image;
    private int blocage;
    private int vulnerable;
    private int faiblesse;
    private int force;
    private String nom;
    private int fragile;
    private int formeDemo;
    private int rituel;

    public Entite(int maxPV, int actuelPV, List<Carte> deck, int blocage, int vulnerable, int faiblesse, int force,int fragile,int formeDemo, int rituel, String image,
            String nom) {
        this.maxPV = maxPV;
        this.actuelPV = maxPV;
        this.deck = deck;
        this.blocage = blocage;
        this.image = image;
        this.nom = nom;
        this.vulnerable = vulnerable;
        this.faiblesse = faiblesse;
        this.force = force;
        this.fragile = fragile;
        this.formeDemo = formeDemo;
        this.rituel = rituel;

    }
    public int getRituel(){
        return rituel;
    }
    public void setRituel(int n) {
        rituel += n;
    }
    public int getFormeDemo(){
        return formeDemo;
    }
    public void setFormeDemo(int n) {
        formeDemo += n;
    }
    public int getFragile(){
        return fragile;
    }
    public void setFragile(int n) {
        fragile += n;
    }
    
    public int getForce() {
        return force;
    }

    public void setForce(int n) {
        force += n;
    }

    public int getFaiblesse() {
        return faiblesse;
    }
    public void setFaiblesse(int n) {
        faiblesse += n;
    }
    public int getVulnerable() {
        return vulnerable;
    }

    public void setVulnerable(int n) {
        vulnerable += n;
    }

    public int getActuelPV() {
        return actuelPV;
    }

    public int getPVMax() {
        return maxPV;
    }

    public void setActuelPV(int n) {
        actuelPV += n;
    }

    public Carte getCard() {
        return null;
    }

    public List<Carte> getDeck() {
        return deck;
    }

    public String getImage() {
        return image;
    }

    public int getBlocage() {
        return blocage;
    }

    public void setBlocage(int n) {
        blocage = n + blocage;
    }

    public Carte getCarte() {
        return deck.get(0);
    }

    public String getNom() {
        return nom;
    }

}
