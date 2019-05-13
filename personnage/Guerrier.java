package personnage;

import personnage.arme.Arme;

public class Guerrier {
    private String nom;
    private String image;
    private int vie;
    private int attaque;
    private int bouclier;
    private Arme arme;

    public String toString() {
        return "nom : " + this.nom  +
                "\n image : " + this.image +
                "\n vie :" + this.vie +
                "\nattaque :" + this.attaque+
                "\nattaque :" + this.attaque+
                "\n nomarme:" + this.arme.getName()+
                " nomarme:" + this.arme.getNiveauattaque();
    }

    public Guerrier(){}

    public Guerrier(String nom, String image, int vie, int attaque, int bouclier, String nomArme, int nivatk ) {
        this.nom = nom;
        this.image =image;
        this.vie =  vie;
        this.attaque = attaque;
        this.bouclier = bouclier;
       this.arme = new Arme( nomArme, nivatk);

    }
    public Guerrier(String nom){
        this.nom = nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getName() {
        return nom;
    }

    public void setImage(String image) {
        this.image = nom;
    }

    public String getImage() {
        return image;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getVie() {
        return vie;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setBouclier(int bouclier) {
        this.bouclier = bouclier;
    }

    public int getBouclier() {
        return bouclier;
    }
    public Arme getArme() {
        return arme;
    }
}
