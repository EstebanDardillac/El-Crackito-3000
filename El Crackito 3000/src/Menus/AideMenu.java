package Menus;

import static utils.AnsiCouleurs.*;

import java.util.Scanner;

/**
 * La classe AideMenu représente le menu d'aide de l'application El Crackito 3000.
 * Elle affiche des informations sur les fonctionnalités et options disponibles dans l'application,
 * et permet à l'utilisateur de naviguer en revenant au menu principal ou de quitter le programme.
 */
public class AideMenu {

    /**
     * Affiche le menu d'aide et gère les choix de l'utilisateur.
     * Cette méthode présente un message d'aide expliquant les fonctionnalités de l'application.
     * L'utilisateur peut choisir de revenir au menu principal ou de quitter l'application.
     */
    public void afficherMenu() {
        // Crée un scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affiche le message d'aide
        System.out.println(BLEU + "Bienvenue dans le menu d'aide d'El Crackito 3000 !" + BLANC);
        System.out.println("Ce programme propose plusieurs algorithmes de cryptage,");
        System.out.println("notamment les algorithmes de César et de Vigenère.");
        System.out.println("Utilisez ces outils pour en apprendre davantage sur le chiffrement.");
        System.out.println();
        System.out.println("Options disponibles :");
        System.out.println("1. Algorithme de César : Un chiffrement simple qui déplace les lettres.");
        System.out.println("2. Algorithme de Vigenère : Un chiffrement qui utilise un mot-clé pour encoder le texte.");
        System.out.println();
        System.out.println("Si vous avez des questions, consultez la documentation ou contactez le support.");
        System.out.println("Merci d'utiliser El Crackito 3000 !\n");

        // Affiche les options de navigation
        System.out.println(JAUNE + "╔═════════════════════════════════╗");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Revenir au menu principal    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + ROUGE + "Quitter                      " + JAUNE + "║");
        System.out.println(JAUNE + "╚═════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        if (scanner.hasNextInt()) { // Vérifie si la prochaine entrée de l'utilisateur est un entier
            int choix = scanner.nextInt(); // Lit l'entier saisi par l'utilisateur et le stocke dans la variable `choix`

            switch (choix) {
                case 1: // Revenir au menu principal
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.afficherMenu();
                    break;
                case 2: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé El Crakito 3000 !");
                    System.exit(0);
                    break;
                default:// Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            }
        } else { // Si l'entrée n'est pas un entier, affiche un message d'erreur
            System.out.println(ROUGE + "Entrée non valide. Veuillez entrer un nombre.");
            scanner.next(); // Consomme l'entrée non valide pour éviter une boucle infinie en sautant l'entrée incorrecte
        }

        // Ferme le scanner pour libérer les ressources
        scanner.close();
    }
}
