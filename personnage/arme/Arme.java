package personnage.arme;

public class Arme {
  String nom;
    int niveauattaque;



public Arme(String nom, int niveauattaque) {
    this.nom = nom;
    this.niveauattaque = niveauattaque;
    }

    public String getName() {
        return nom;
    }

    public  int getNiveauattaque (){
    return niveauattaque;
    }
}