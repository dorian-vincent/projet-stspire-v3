package Carte;

import java.io.File;


import Combat.Combat;

public class Heurt extends Carte {
    static String nom = "Heurt : Inflige 8 dégâts à un ennemi puis 2 de Vulnérable et cout 2 d'énergie";
    static int cout = 2;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Bash.png";
    static boolean exil = false;

    public Heurt() {
        super(nom, cout, image, exil);
    }

    public String getImage() {
        return image;
    }

    public void appliqueEffet() {
        int target = Carte.selectTarget();
        Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 8));
        Combat.eqpMonstre.get(target).setVulnerable(2);
        if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
            Combat.eqpMonstre.remove(target);
            Combat.prevision.remove(target);
        }
    }

}
