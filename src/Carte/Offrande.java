package Carte;

import java.io.File;
import java.util.Random;

import Combat.Combat;
import Combat.Start;

public class Offrande extends Carte {
    static String nom = "Offrande : Perds 6 points de vie, gagne 2 points d’énergie, puis pioche 3cartes. Cette carte est mise en exil après avoir été jouée et cout 0 d'énergie";
    static int cout = 0;
    static String image = "pictures" + File.separator + "Cartes" + File.separator + "Strike_R.png";
    static boolean exil = true;
    static Random random = new Random();

    public Offrande() {
        super(nom, cout, image, exil);
    }

    public String toString() {
        return nom + cout;
    }

    public void appliqueEffet() {
        Start.hero.setActuelPV(-6);
        Combat.energie += 2;
        for (int i = 0; i < 3; i++) {
            if (Combat.deckPioche.size() <= 0) {
                Combat.deckPioche.addAll(Combat.deckDefausse);
                Combat.deckDefausse.clear();
            }
            int num = random.nextInt(Combat.deckPioche.size());
            Combat.deckActuel.add(Combat.deckPioche.get(num));
            Combat.deckPioche.remove(num);
        }
    }
}
