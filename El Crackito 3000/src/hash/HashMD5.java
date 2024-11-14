package hash;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import utils.HachageMethode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class HashMD5 {

    public static void md5Menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Affiche le menu
            System.out.println(JAUNE + "╔══════════════════════════════════════╗");
            System.out.println(JAUNE + "║" + ORANGE + "                " + GRAS + SOULIGNE + "MD5" + BLANC + "                   " + JAUNE + "║");
            System.out.println(JAUNE + "║                                      ║");
            System.out.println(JAUNE + "║" + ORANGE + " L'algorithme MD5 est une fonction    " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + " de hachage qui convertit un message  " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + " en une empreinte unique de 128 bits, " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + " permettant de vérifier l'intégrité   " + JAUNE + "║");
            System.out.println(JAUNE + "║" + ORANGE + " d'un message ou fichier.             " + JAUNE + "║");
            System.out.println(JAUNE + "║                                      ║");
            System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Calculer le hash MD5 d'un message " + JAUNE + "║");
            System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Comparer deux hash MD5            " + JAUNE + "║");
            System.out.println(JAUNE + "║                                      ║");
            System.out.println(JAUNE + "║" + BLANC + " 3. " + BLEU + ITALIQUE + "Aide                              " + JAUNE + "║");
            System.out.println(JAUNE + "║" + BLANC + " 4. " + BLEU + ITALIQUE + "Retour au menu principal          " + JAUNE + "║");
            System.out.println(JAUNE + "║" + BLANC + " 5. " + ROUGE + ITALIQUE + "Quitter                           " + JAUNE + "║");
            System.out.println(JAUNE + "╚══════════════════════════════════════╝");
            System.out.print(BLEU + "Choisissez une option : ");

            // Vérifie si l'entrée est un entier avant de lire le choix
            if (scanner.hasNextInt()) {
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la fin de ligne

                try {
                    switch (choix) {
                        case 1: // Appelle la méthode pour calculer le hash
                            calculerHashMessage();
                            break;
                        case 2: // Appelle la méthode pour comparer deux hash
                            comparerHashMessages();
                            break;
                        case 3: // Accéder au menu d'aide
                            AideMenu.afficherMenu();
                            break;
                        case 4: // Revenir au menu principal
                            MenuPrincipal.afficherMenu();
                            return;
                        case 5: // Quitter le menu / l'app
                            System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                            break;
                    }
                } catch (NoSuchAlgorithmException e) {
                    System.err.println(ITALIQUE + ROUGE + "Erreur : Algorithme MD5 non disponible.");
                } catch (Exception e) {
                    System.out.println(GRAS + ROUGE + "Une erreur a été détectée : " + e);
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                md5Menu();
            }
        }
    }

    /**
     * Calcule le hash MD5 d'un message saisi par l'utilisateur.
     */
    private static void calculerHashMessage() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(BLEU + "Entrez le message pour calculer son hash MD5 : ");
        String message = scanner.nextLine();
        String hash = HachageMethode.hacher(message, "MD5");
        System.out.println(BLEU + "Hash MD5 du message : " + hash);
    }

    /**
     * Compare les hash MD5 de deux messages saisis par l'utilisateur.
     */
    private static void comparerHashMessages() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(BLEU + "Entrez le premier message : ");
        String message1 = scanner.nextLine();
        String hash1 = HachageMethode.hacher(message1, "MD5");
        System.out.println(BLEU + "Hash MD5 du premier message : " + hash1);

        System.out.print(BLEU + "Entrez le deuxième message : ");
        String message2 = scanner.nextLine();
        String hash2 = HachageMethode.hacher(message2, "MD5");
        System.out.println(BLEU + "Hash MD5 du deuxième message : " + hash2);

        if (comparerHash(hash1, hash2)) {
            System.out.println(BLANC + "Les messages sont identiques (hashs " + VERT + "égaux" + BLANC + ").");
        } else {
            System.out.println(BLANC + "Les messages sont différents (hashs " + ROUGE + "différents" + BLANC + ").");
        }
    }

    /**
     * Compare deux hash MD5 pour vérifier si les messages sont identiques.
     *
     * @param hash1 Le premier hash MD5.
     * @param hash2 Le deuxième hash MD5.
     * @return True si les hash sont identiques, false sinon.
     */
    public static boolean comparerHash(String hash1, String hash2) {
        return hash1.equals(hash2);
    }
}