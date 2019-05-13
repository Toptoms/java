package personnage;


import java.util.Scanner;

public class StartMenu {

    private Guerrier[] guerriertab;

    private Magicien[] magicientab;
    private int i;

    public StartMenu(int size) {
        Guerrier[] guerriertab = new Guerrier[size];
        Magicien[] magicientab = new Magicien[size];
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choiceP;
        int choicePC;

        do {
            System.out.println(
                    "Veuillez saisir soit 1 pour creer un guerrier soit 2 pour creer un magicien:");
            int str = sc.nextInt();
            choiceP = str;
        } while (choiceP != 1 && choiceP != 2);

        if (choiceP == 1) {
            System.out.println("vous avez choisi de creer un guerrier");

            System.out.println("pour crer un guerrier complet faites 1 sinon faites 2");
            int str = sc.nextInt();
            choicePC = str;

            if (choicePC == 1) {
                System.out.println("vous avez choisi crer un guerrier complet");
                String nom = demande("entrer votre nom");

                String image = demande("renseigner une image");
                int vie = questionValeur("parametrer la vie", 5, 10);
                int attaque = questionValeur("parametrer ton attaque", 5, 10);
                int bouclier = questionValeur("parametrer le bouclier", 5, 10);
                String nomarme = demande("renseigner le nom de l'arme");
                int niveauarme = questionValeur("parametrer le bouclier", 5, 10);

                Guerrier guerrier = new Guerrier(nom, image, vie, attaque, bouclier, nomarme, niveauarme);
                guerriertab[i] = guerrier;
                System.out.println(guerriertab[i]);
                i = i + 1;

            } else {
                Guerrier g3 = new Guerrier();
            }

        } else {
            System.out.println(" vous avez choisi de creer un guerrier");

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
