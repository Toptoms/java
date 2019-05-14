package personnage;


import java.util.Scanner;

public class StartMenu {

    private Personnage[] personnagetab;
    private int i;


    public StartMenu(int size) {
        personnagetab = new Personnage[size];
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choiceS;
        do {
            System.out.println(
                    "que vous les vous faire ? \n" +
                            "1- creer un personnage \n" +
                            "2- afficher et modifier les personnages ");
            int str = sc.nextInt();
            choiceS = str;
        } while (choiceS != 1 && choiceS != 2 && choiceS != 3);

        switch (choiceS) {
            case 1:
                System.out.println("Vous avez choisi de creer un personnage");
                creatpersonnage();
                break;
            case 2:
                System.out.println("Vous avez choisi d'afficher et modifier les personnages");
                affichmodifperso();
                break;
            case 3:

        }
    }

    private void creatpersonnage() {
        Scanner sc = new Scanner(System.in);
        int choiceP;
        do {
            System.out.println(
                    "1- pour creer un guerrier \n" +
                            " 2- pour creer un magicien");
            choiceP = sc.nextInt();

        } while (choiceP != 1 && choiceP != 2);
        creat(choiceP);
    }


    private void creat(int choice) {
        if (choice == 1) {
            System.out.println("vous avez choisi de creer un guerrier");
            System.out.println("vous avez choisi crer un guerrier complet");
            String nom = demande("entrer un nom");
            String image = demande("renseigner une image");
            int vie = questionValeur("parametrer la vie", 5, 10);
            int attaque = questionValeur("parametrer ton attaque", 5, 10);
            String bouclier = demande("nom d'un bouclier");
            String nomarme = demande("renseigner le nom de l'arme");
            int niveauarme = questionValeur("parametrer le nieveau de l'arme", 5, 10);
            Personnage guerrier = new Guerrier(nom, image, vie, attaque, bouclier, nomarme, niveauarme);
            personnagetab[i] = guerrier;
            System.out.println(personnagetab[i]);
            i = i + 1;
            start();
        } else {
            Guerrier g3 = new Guerrier();
        }
    }

    private void affichmodifperso() {
        Scanner sc = new Scanner(System.in);
        int choiceP;

        do {
            System.out.println(
                    "que voulez vous afficher ?\n" +
                            "1- guerrier \n" +
                            "2- magicien \n" +
                            "3- retour au menu");
            choiceP = sc.nextInt();

        } while (choiceP != 1 && choiceP != 2 && choiceP != 3);

        switch (choiceP) {
            case 1:
                for (i = 0; i < personnagetab.length; i++) {

                }

                do {
                    System.out.println(
                            "1- afficher un guerrier \n" +
                                    "2- modifier un guerrier \n" +
                                    "3- retour au menu");

                    choiceP = sc.nextInt();

                } while (choiceP != 1 && choiceP != 2 && choiceP != 3);


                switch (choiceP) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        start();
                        break;
                }
                break;

            case 2:
                System.out.println("Vous les vous afficher un magicien en particulier ou la liste des magiciens ?");

                break;
            case 3:
                start();
                break;
        }
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
            System.out.println(question + " entre " + minv + "et" + maxv);
            value = sc.nextInt();
        } while (value < minv || value > maxv);
        return value;

    }
}
