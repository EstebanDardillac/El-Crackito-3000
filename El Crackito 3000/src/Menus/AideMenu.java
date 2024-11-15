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
    public static void afficherMenu() throws Exception {
        // Crée un scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affiche le message d'aide
        System.out.println(JAUNE + "╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" + BLEU + "    Bienvenue dans le menu d'aide d'" + GRAS + CYAN_CLAIR + "El Crackito 3000 " + BLEU + "!                        " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    Ce programme propose plusieurs algorithmes de cryptage,                   " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    notamment les algorithmes de Rotation (Rot(X)) et de Vigenère.            " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    Utilisez ces outils pour en apprendre davantage sur le chiffrement.       " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                                              ║");
        System.out.println(JAUNE + "║" + VERT + "    Options disponibles :                                                     " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    - Algorithme de Rotation (Rot(X)) : Un chiffrement simple qui déplace les " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "      lettres d'un certain nombre de positions.                               " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    - Algorithme de Vigenère : Un chiffrement qui utilise un mot-clé pour     " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "      encoder le texte.                                                       " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                                              ║");
        System.out.println(JAUNE + "║" + BLANC + "    Si vous avez des questions, consultez la documentation ou contactez le    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    support. Merci d'utiliser " + GRAS + CYAN_CLAIR + "El Crackito 3000 " + BLANC + "!                              " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                                              ║");

        // Affiche les options de navigation
        System.out.println(JAUNE + "║" + BLANC + " 1. " + BLEU + ITALIQUE + "Revenir au menu principal                                                 " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + ROUGE + ITALIQUE + "Quitter                                                                   " + JAUNE + "║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        if (scanner.hasNextInt()) { // Vérifie si la prochaine entrée de l'utilisateur est un entier
            int choix = scanner.nextInt(); // Lit l'entier saisi par l'utilisateur et le stocke dans la variable `choix`

            switch (choix) {
                case 1: // Revenir au menu principal
                    MenuPrincipal.afficherMenu();
                    break;
                case 2: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                    System.exit(0);
                    break;
                default: // Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    afficherMenu();
            }
        } else { // Message d'erreur pour un choix non valide
            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            afficherMenu();
        }

        // Ferme le scanner pour libérer les ressources
        scanner.close();
    }
}