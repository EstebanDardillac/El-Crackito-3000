package hash;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import utils.HachageMethode;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

/**
 * La classe HashSHA256 permet à un utilisateur de calculer le hash SHA-256 d'un message.
 * Cette fonctionnalité aide à vérifier l'intégrité du message en générant une empreinte unique.
 */
public class HashSHA256 {

    /**
     * Menu interactif pour calculer le hash SHA-256.
     * L'utilisateur peut saisir un message, et le programme affichera le hash SHA-256 correspondant.
     */
    public static void sha256Menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Affichage du menu
            System.out.println(JAUNE + "╔════════════════════════════════════════════╗");
            System.out.println(JAUNE + "║" + ORANGE + "                   " + GRAS + SOULIGNE + "SHA-256" + BLANC + "                  " + JAUNE + "║");
            System.out.println(JAUNE + "║                                            ║");
            System.out.println(JAUNE + "║" + ORANGE + "  L'algorithme SHA-256 génère une empreinte " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + "  unique de 256 bits à partir d'un message, " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + "   offrant une vérification fiable de son   " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + "      intégrité avec un haut niveau         " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + "               de sécurité.                 " + JAUNE + "║");
            System.out.println(JAUNE + "║                                            ║");
            System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Calculer le hash SHA-256 d'un message   " + JAUNE + "║");
            System.out.println(JAUNE + "║                                            ║");
            System.out.println(JAUNE + "║" + BLANC + " 2. " + BLEU + ITALIQUE + "Aide                                    " + JAUNE + "║");
            System.out.println(JAUNE + "║" + BLANC + " 3. " + BLEU + ITALIQUE + "Retour au menu principal                " + JAUNE + "║");
            System.out.println(JAUNE + "║" + BLANC + " 4. " + ROUGE + ITALIQUE + "Quitter                                 " + JAUNE + "║");
            System.out.println(JAUNE + "╚════════════════════════════════════════════╝");
            System.out.print(BLEU + "Choisissez une option : ");

            // Vérifie si l'entrée est un entier
            if (scanner.hasNextInt()) {
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la fin de ligne

                try {
                    switch (choix) {
                        case 1:
                            calculerHashMessageSHA256();
                            break;
                        case 2: // Accéder au menu d'aide
                            AideMenu.afficherMenu();
                            break;
                        case 3: // Revenir au menu principal
                            MenuPrincipal.afficherMenu();
                            return;
                        case 4: // Quitter le menu / l'app
                            System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                            sha256Menu();
                            break;
                    }
                } catch (NoSuchAlgorithmException e) {
                    System.err.println(ITALIQUE + ROUGE + "Erreur : Algorithme SHA-256 non disponible.");
                } catch (Exception e) {
                    System.out.println(GRAS + ROUGE + "Une erreur a été détectée : " + e);
                }
            } else {
                System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                sha256Menu();
            }
        }
    }

    /**
     * Permet à l'utilisateur de saisir un message et affiche son hash SHA-256.
     */
    private static void calculerHashMessageSHA256() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(BLEU + "Entrez le message pour calculer son hash SHA-256 : ");
        String message = scanner.nextLine();
        String hash = HachageMethode.hacher(message, "SHA-256");
        System.out.println(BLEU + "Hash SHA-256 du message : " + hash); // 64 caractères hexadécimaux, correspondant bien à 256 bits (chaque caractère hexadécimal représente 4 bits)
    }
}