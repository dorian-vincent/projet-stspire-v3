package Carte;

import java.io.File;


import Combat.Combat;

public class Uppercut extends Carte {
    static String nom = "Uppercut : Inflige 13 points de dégâts à un ennemi, puis inflige 1 points de Faiblesse et Vulnérable et cout 2 d'énergie";
    static int cout = 2;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Bash.png";
    static boolean exil = false;

    public Uppercut() {
        super(nom, cout, image, exil);
    }

    public String getImage() {
        return image;
    }

    public void appliqueEffet() {
        int target = Carte.selectTarget();
        Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 13));
        Combat.eqpMonstre.get(target).setFaiblesse(1);
        Combat.eqpMonstre.get(target).setVulnerable(1);
        if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
            Combat.eqpMonstre.remove(target);
            Combat.prevision.remove(target);
        }
    }

}
