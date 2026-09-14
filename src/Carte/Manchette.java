package Carte;

import java.io.File;


import Combat.Combat;

public class Manchette extends Carte {
    static String nom = "Manchette : inflige 12 dégâts à un ennemi puis 2 de Faiblesse et cout 2 d'énergie";
    static int cout = 2;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Bash.png";
    static boolean exil = false;

    public Manchette() {
        super(nom, cout, image, exil);
    }

    public String getImage() {
        return image;
    }

    public void appliqueEffet() {
        int target = Carte.selectTarget();
        Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 12));
        Combat.eqpMonstre.get(target).setFaiblesse(2);
        if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
            Combat.eqpMonstre.remove(target);
            Combat.prevision.remove(target);
        }
    }

}
