package personnage;


import java.util.Scanner;

public class Start {
    private Personnage[] personnagetab;
    private int i;

    public Start(int size) {
        personnagetab = new Personnage[size];
    }

    public void startmenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println(
                    "\n1 Creer un personnage \n" +
                            "2 Afficher et modifier les personnages " +
                            "\n3 Pour sortir");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    creatpersonnage();
                    break;
                case 2:
                    affichmodifperso();
                    break;

            }
        } while (choice != 3);


    }

    private void creatpersonnage() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println(
                    "1 Creer un guerrier \n" +
                            "2 Creer un magicien \n" +
                            "0 Retour au menu");
            choice = sc.nextInt();

        } while (choice != 1 && choice != 2);
        creat(choice);
    }


    private void creat(int choice) {
        switch (choice) {
            case 1:
                System.out.println("vous avez choisi de creer un guerrier");
                String nom = demande("entrer un nom :");
                String image = demande("renseigner une image :");
                int vie = questionValeur("parametrer la vie :", 5, 10);
                int attaque = questionValeur("parametrer ton attaque :", 5, 10);
                String bouclier = demande("nom d'un bouclier :");
                String nomarme = demande("renseigner le nom de l'arme :");
                int niveauarme = questionValeur("parametrer le nieveau de l'arme :", 5, 10);
                Personnage guerrier = new Guerrier(nom, image, vie, attaque, bouclier, nomarme, niveauarme);
                personnagetab[i] = guerrier;
                System.out.println(personnagetab[i]);
                i = i + 1;
                break;

            case 2:

            case 0:
                startmenu();
        }
    }


    private void affichmodifperso() {
        Scanner sc = new Scanner(System.in);
        int choiceint;
        String choicestring;
        {
            for (i = 0; i < personnagetab.length; i++) {
                if (personnagetab[i] != null) {
                    if (personnagetab[i].getClass().getSimpleName().equals("Guerrier")) {
                        System.out.println(i + " Guerrier : " + personnagetab[i].getName());
                    } else System.out.println(i + "Magicien" + personnagetab[i].getName());
                }
            }

            do {
                System.out.println(
                        "entrer le numero du personnage à afficher :" +
                                "99- retour au menu");
                choiceint = sc.nextInt();

            } while (choiceint != 1 && choiceint != 2 && choiceint != 3);
            switch (choiceint) {

                case 1:

                    choiceint = sc.nextInt();
                    System.out.println(personnagetab[choiceint]);
                    startmenu();

                    break;
                case 2:
                    int choiceTab;
                    do {
                        System.out.println("entrer le numero du personnage à modifier :");
                        choiceTab = sc.nextInt();
                        System.out.println(personnagetab[choiceTab].getName());


                        System.out.println("que voulez vous modifier :");
                        System.out.println(
                                "\n1 nom: \n" +
                                        "2 image " +
                                        "\n3 vie" +
                                        "\n4 attaque" +
                                        "\n5 nom bouclier" +
                                        "\n6 nom arme" +
                                        "\n7 niveau arme");
                        choiceint = sc.nextInt();
                    } while (choiceint < 1 || choiceint > 7);


                    switch (choiceint) {
                        case 1:
                            System.out.println("entrer un nouvelle valeur pour la non:");
                            choicestring = sc.nextLine();
                            personnagetab[choiceTab].setNom(choicestring);

                            break;
                        case 2:
                            System.out.println("entrer un nouvelle valeur pour la image :");
                            choicestring = sc.nextLine();
                            personnagetab[choiceTab].setImage(choicestring);
                            break;
                        case 3:

                            System.out.println("entrer un nouvelle valeur pour la vie :");
                            choiceint = sc.nextInt();
                            personnagetab[choiceTab].setVie(choiceint);

                            break;
                        case 4:
                            System.out.println("entrer un nouvelle valeur pour la attaque :");
                            choiceint = sc.nextInt();
                            personnagetab[choiceTab].setAttaque(choiceint);
                            break;
                        case 5:
                            System.out.println("entrer un nouveau nom pour le bouclier :");
                            choicestring = sc.nextLine();
                            ((Guerrier) personnagetab[choiceTab]).setBouclier(choicestring);
                            break;
                        case 6:
                            System.out.println("entrer un nouveau nom pour le bouclier :");
                            choicestring = sc.nextLine();
                            ((Guerrier) personnagetab[choiceTab]).getArme().setNom(choicestring);
                            break;
                        case 7:
                            System.out.println("entrer un nouvelle valeur pour la attaque :");
                            choiceint = sc.nextInt();
                            ((Guerrier) personnagetab[choiceTab]).getArme().setNiveauattaque(choiceint);
                            break;

                    }
                    break;
                case 3:
                    startmenu();
                    break;
            }


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
            System.out.println(question + " entre " + minv + " et " + maxv);
            value = sc.nextInt();
        } while (value < minv || value > maxv);
        return value;
    }
}
