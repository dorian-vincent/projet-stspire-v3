package Carte;

import java.io.File;


import Combat.Combat;
import Entite.Entite;

public class Odc extends Carte {
    static String nom = "Onde de choc : Inflige 3 points de Faiblesse et de Vulnérables à tous les ennemis. Cette carte est mise en exil après avoir été jouée et cout 2 d'énergie";
    static int cout = 2;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Bash.png";
    static boolean exil = true;

    public Odc() {
        super(nom, cout, image, exil);
    }

    public String getImage() {
        return image;
    }

    public void appliqueEffet() {
        for(Entite monstre : Combat.eqpMonstre){
            monstre.setVulnerable(3);
            monstre.setFaiblesse(3);
            if(monstre.getActuelPV()<=0){
                Combat.eqpMonstre.remove(monstre);
            }
        }
    }

}
