package personnage;

import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class ChoixPerso {
        public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                int choiceP;

                do {
                        System.out.println(
                                        "Veuillez saisir soit 1 pour creer un guerrier soit 2 pour creer un magicien:");
                        choiceP = sc.nextLine();
                      
                
                        System.out.println(choicep);

                } while (choiceP != 1 && choiceP != 2);

                if (choiceP == 1) {
                        System.out.println(" vous avez choisi de creer un guerrier");
                } else {
                        System.out.println("vous avez choisi de creer un magicien");
                        Guerrier g = new Guerrier("toto");
                        Guerrier g2 = new Guerrier();
                        g2.getAttaque();
                        Guerrier g3 = new Guerrier("dddd", "eeee", 5, 12, 13, "222", 5);
                        System.out.println();

                }

        }

}
