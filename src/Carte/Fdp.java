package Carte;

import java.io.File;
import java.util.Random;

import Combat.Combat;

public class Fdp extends Carte {
    static String nom = "Frappe du pommeau : Inflige 9 dégâts à un ennemi puis pioche 1 carte et cout 1 d'énergie";
    static int cout = 1;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Bash.png";
    static Random random = new Random();
    static boolean exil = false;

    public Fdp() {
        super(nom, cout, image, exil);
    }

    public String getImage() {
        return image;
    }

    public void appliqueEffet() {
        int target = Carte.selectTarget();
        Combat.eqpMonstre.set(target, Carte.appliqueDegats(Combat.eqpMonstre.get(target), 9));
        if(Combat.eqpMonstre.get(target).getActuelPV()<=0){
            Combat.eqpMonstre.remove(target);
            Combat.prevision.remove(target);
        }
        if (Combat.deckPioche.size() <= 0) {
            Combat.deckPioche.addAll(Combat.deckDefausse);
            Combat.deckDefausse.clear();
        }
            int num = random.nextInt(Combat.deckPioche.size());
            Combat.deckActuel.add(Combat.deckPioche.get(num));
            Combat.deckPioche.remove(num);
        
    }

}
