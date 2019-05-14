package personnage;

import personnage.arme.Arme;

public class Guerrier extends Personnage {

    private String bouclier;
    private Arme arme;


    public Guerrier() {
    }

    public Guerrier(String nom, String image, int vie, int attaque, String bouclier, String nomarme, int nivatk) {
        super(nom, image, vie, attaque);
        this.bouclier = bouclier;
        this.arme = new Arme(nomarme, nivatk);
    }

    public void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    public String getBouclier() {
        return bouclier;
    }

    public Arme getArme() {
        return arme;
    }

    public String toString() {
        return super.toString() +
                "\nnom du bouclier : " + this.bouclier +
                "\nnom arme : " + this.arme.getName() +
                "\nnineau arme : " + this.arme.getNiveauattaque();

    }
}
