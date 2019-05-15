package personnage;

import java.util.Scanner;

public class Start {
    private Personnage[] personnagetab;
    private int i;

    public Start(int size) {
        personnagetab = new Personnage[size];
    }

    public void startmenu() {
        int choice;
        do {
            choice = demande("\n1 Creer un personnage " + "\n2 Afficher, modifier, supprimer les personnages"
                    + "\n3 Pour sortir");
            switch (choice) {
            case 1:
                creatpersonnage();
                break;
            case 2:
                affichmodifsupperso();
                break;
            }
        } while (choice != 3);

    }

    private void creatpersonnage() {
        int choice;
        do {
            choice = demande("1 Creer un guerrier \n" + "2 Creer un magicien \n" + "3 Retour au menu");
        } while (choice < 1 || choice > 3);
        if (choice == 3) {
            startmenu();
        } else
            creat(choice);
    }

    private void creat(int choice) {
        System.out.println("vous avez choisi de creer un guerrier");
        String nom = demande("entrer un nom :");
        String image = demande("renseigner une image :");
        int vie = questionValeur("parametrer la vie :", 5, 10);
        int attaque = questionValeur("parametrer ton attaque :", 5, 10);
        if (choice == 1) {
            String bouclier = demande("nom d'un bouclier :");
            String nomarme = demande("renseigner le nom de l'arme :");
            int niveauarme = questionValeur("parametrer le nieveau de l'arme :", 5, 10);
            Personnage guerrier = new Guerrier(nom, image, vie, attaque, bouclier, nomarme, niveauarme);
            personnagetab[i] = guerrier;
        } else {
            String sort = demande("nom d'un sort :");
            String nomphiltre = demande("renseigner le nom du philtre :");
            int niveauphiltre = questionValeur("parametrer le nieveau du philtre :", 5, 10);
            Personnage magicien = new Guerrier(nom, image, vie, attaque, sort, nomphiltre, niveauphiltre);
            personnagetab[i] = magicien;
        }
        System.out.println(personnagetab[i]);
        i = i + 1;
    }

    private void affichmodifsupperso() {
        int choice;
        int personnagechoisi = choixpersonnage();
        do {
            choice = demande("1 Modifier \n" + "2 Supprimer \n" + "3 Retour au menu");
            switch (choice) {
            case 1:
                modifpersonnage(personnagechoisi);
                break;
            case 2:
                supprimer(personnagechoisi);
                break;
            case 3:
                startmenu();
                break;
            }
        } while (choice < 1 || choice > 3);
    }

    private void modifpersonnage(int personnagechoisi) {
        int choiceint;
        if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
            System.out.println(" Guerrier : " + personnagetab[personnagechoisi]);
        } else
            System.out.println(" Magicien : " + personnagetab[personnagechoisi]);

        do {
            choiceint = demande("Que veux tu modifier ? 0 pour sortir");
            switch (choiceint) {
            case 1:
                personnagetab[personnagechoisi].setNom = demande("changer de nom");
                break;
            case 2:
                personnagetab[personnagechoisi].setImage = demande("changer l'image");
                break;
            case 3:
                personnagetab[personnagechoisi].setVie = questionValeur("changer la vie :", 5, 10);
                ;
                break;
            case 4:
                personnagetab[personnagechoisi].setAttaque = questionValeur("parametrer ton attaque :", 5, 10);
                break;
            case 5:
                if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                    ((Guerrier) personnagetab[choiceTab]).setBouclier = demande("changer le nom du bouclier :");
                } else
                    ((Magicien) personnagetab[choiceTab]).setSort = demande("changer le nom du sort :");
                break;
            case 6:
                if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                    ((Guerrier) personnagetab[choiceTab]).getArme().setNom = demande("renseigner le nom de l'arme :");
                } else
                    ((Magicien) personnagetab[choiceTab]).getPhiltre().setNom = demande("changer le nom du filtre :");
                break;
            case 7:
                if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                    ((Guerrier) personnagetab[choiceTab]).getArme().setNiveauattaque = questionValeur(
                            "parametrer le nieveau de l'arme :", 5, 10);
                } else
                    ((Magicien) personnagetab[choiceTab]).getPhiltre().setNiveauattaque = demande(
                            "changer le nom du filtre :");
                break;
            }
        } while (choiceint != 0);
    }

    private int choixpersonnage() {
        int choiceint;
        int i;
        for (i = 0; i < personnagetab.length; i++) {
            if (personnagetab[i] != null) {
                if (personnagetab[i].getClass().getSimpleName().equals("Guerrier")) {
                    System.out.println(i + " Guerrier : " + personnagetab[i].getName());
                } else
                    System.out.println(i + " Magicien : " + personnagetab[i].getName());
            }
        }
        do {

            choiceint = demande("entrer le numero du personnage à afficher ");

        } while (choiceint < 0 && choiceint > i);
        return choiceint;
    }

    private void supprimer(int index) {
        personnagetab[index] = null;
        personnagetab--;
    }

    private static String demande(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String str = sc.nextLine();
        return str;
    }

    private static int questionValeur(String question, int minv, int maxv) {
        int value;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(question + " entre " + minv + " et " + maxv);
            value = sc.nextInt();
        } while (value < minv || value > maxv);
        return value;
    }
}
