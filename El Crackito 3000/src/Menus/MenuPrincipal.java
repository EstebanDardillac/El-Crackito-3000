package Menus;

import algo.ChiffrementRotation;
import algo.Vigenere;

import static utils.AnsiCouleurs.*;

import java.util.Scanner;

/**
 * La classe MenuPrincipal représente le menu principal de l'application El Crackito 3000.
 * Elle affiche les options principales et permet à l'utilisateur de naviguer entre
 * les différents menus, incluant les algorithmes de cryptage, le menu d'aide, et l'option de quitter.
 */
public class MenuPrincipal {

    /**
     * Affiche le menu principal et gère les choix de l'utilisateur.
     * Cette méthode reste active jusqu'à ce que l'utilisateur choisisse de quitter l'application.
     */
    public static void afficherMenu() throws Exception {
        // Crée un scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affiche les options du menu
        System.out.println(CYAN_CLAIR + "    ________   ______                __   _ __           _____ ____  ____  ____ ");
        System.out.println("   / ____/ /  / _____________ ______/ /__(_/ /_____     |__  // __ \\/ __ \\/ __ \\");
        System.out.println("  / __/ / /  / /   / ___/ __ `/ ___/ //_/ / __/ __ \\     /_ </ / / / / / / / / /");
        System.out.println(" / /___/ /  / /___/ /  / /_/ / /__/ ,< / / /_/ /_/ /   ___/ / /_/ / /_/ / /_/ / ");
        System.out.println("/_____/_/   \\____/_/   \\__,_/\\___/_/|_/_/\\__/\\____/   /____/\\____/\\____/\\____/  ");
        System.out.println(ORANGE + "\n✦ " + BLEU + "Menu Principal - El Crackito 3000" + ORANGE + " ✦");
        System.out.println(JAUNE + "╔═════════════════════════════════╗");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Algorithme de ROT(X)         " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Algorithme de Vigenère       " + JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + BLEU + "Aide                         " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 4. " + ROUGE + "Quitter                      " + JAUNE + "║");
        System.out.println(JAUNE + "╚═════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        if (scanner.hasNextInt()) { // Vérifie si la prochaine entrée de l'utilisateur est un entier
            int choix = scanner.nextInt(); // Lit l'entier saisi par l'utilisateur et le stocke dans la variable `choix`

            switch (choix) {
                case 1: // utiliser l'algorithme de César
                    ChiffrementRotation.chiffrementMenu();
                    break;
                case 2: // utiliser l'algorithme de Vigenère
                    Vigenere.rotationMenu();
                    break;
                case 3: // Accéder au menu d'aide
                    AideMenu.afficherMenu();
                    break;
                case 4: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé " + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                    System.exit(0);
                    break;
                default: // Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    afficherMenu();
            }
        } else {
            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            afficherMenu();
        }

        // Ferme le scanner pour libérer les ressources
        scanner.close();
    }
}
