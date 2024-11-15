package chaine;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import hash.HashMD5;
import hash.HashSHA256;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class ChaineDeHachage {
    // Liste des algorithmes sélectionnés pour la chaîne de hachage
    private static final List<Hachage> hachages = new ArrayList<>();

    // Enumération des hachages disponibles
    public enum Hachage {
        MD5, SHA256
    }

    /**
     * Méthode principale pour afficher le menu de la chaîne de hachage.
     * Permet à l'utilisateur de sélectionner des algorithmes ou d'exécuter la chaîne.
     */
    public static void menuChaineDeHachage() throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Affichage du menu principal
        System.out.println(JAUNE + "╔══════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "               " + GRAS + SOULIGNE + "Chaîne de Hachage" + BLANC + "              " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + ORANGE + "    Bienvenue dans le programme de hachage    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "    de messages. Sélectionnez vos options     " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "    pour générer ou comparer des hashes.      " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "MD5                                       " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "SHA-256                                   " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + VERT + "Exécuter la chaîne                        " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 4. " + VERT + "Réinitialiser la chaîne                   " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + BLANC + " 5. " + BLEU + ITALIQUE + "Aide                                      " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 6. " + BLEU + ITALIQUE + "Retour au menu principal                  " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 7. " + ROUGE + ITALIQUE + "Quitter                                   " + JAUNE + "║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        // Vérification de l'entrée utilisateur
        if (scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la fin de ligne

            switch (choix) {
                case 1: // Ajouter MD5
                    if (hachages.contains(Hachage.MD5)) {
                        System.out.println(ROUGE + "Algorithme MD5 est déjà ajouté à la chaîne.");
                    } else {
                        hachages.add(Hachage.MD5);
                        System.out.println(VERT + "Algorithme MD5 ajouté à la chaîne.");
                    }
                    menuChaineDeHachage();
                    break;
                case 2: // Ajouter SHA-256
                    if (hachages.contains(Hachage.SHA256)) {
                        System.out.println(ROUGE + "Algorithme SHA-256 est déjà ajouté à la chaîne.");
                    } else {
                        hachages.add(Hachage.SHA256);
                        System.out.println(VERT + "Algorithme SHA-256 ajouté à la chaîne.");
                    }
                    menuChaineDeHachage();
                    break;
                case 3: // Exécuter la chaîne
                    executeChaine();
                    break;
                case 4: // Réinitialiser la chaîne
                    hachages.clear();
                    System.out.println(VERT + "Chaîne de hachage réinitialisée.");
                    menuChaineDeHachage();
                    break;
                case 5: // Accéder au menu d'aide
                    AideMenu.afficherMenu();
                    break;
                case 6: // Retour au menu principal
                    MenuPrincipal.afficherMenu();
                    break;
                case 7: // Quitter le programme
                    System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crackito 3000 " + VERT + "!");
                    System.exit(0);
                    break;
                default: // Choix invalide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    menuChaineDeHachage();
                    break;
            }
        } else { // Entrée invalide
            System.out.println(ROUGE + "Entrée invalide. Veuillez saisir un entier entre 1 et 7.");
            scanner.nextLine(); // Vide l'entrée incorrecte
            menuChaineDeHachage();
        }
    }

    /**
     * Exécute la chaîne d'algorithmes sélectionnés par l'utilisateur.
     * Demande à l'utilisateur s'il souhaite hacher ou comparer les résultats.
     */
    private static void executeChaine() throws Exception {
        Scanner scanner = new Scanner(System.in);

        for (Hachage algorithme : hachages) {
            boolean choixValide = false;

            while (!choixValide) {
                System.out.print(BLEU + "Voulez-vous hacher (1) ou comparer (2) avec " + algorithme + " ? : ");
                if (scanner.hasNextInt()) {
                    int action = scanner.nextInt();
                    scanner.nextLine(); // Consomme la fin de ligne

                    if (action == 1 || (action == 2 && algorithme == Hachage.MD5)) {
                        choixValide = true;
                        executeAlgorithme(algorithme, action == 1); // Exécute l'algorithme avec l'action choisie
                    } else {
                        System.out.println(ROUGE + "Option invalide ou SHA-256 ne supporte pas la comparaison.");
                    }
                } else { // Choix invalide
                    System.out.println(ROUGE + "Entrée invalide. Veuillez saisir un entier (1 ou 2).");
                    scanner.nextLine(); // Vide l'entrée incorrecte
                }
            }
        }

        // Retour au menu principal de la chaîne
        menuChaineDeHachage();
    }

    /**
     * Exécute un algorithme de hachage ou de comparaison en fonction du choix de l'utilisateur.
     *
     * @param hachage Le hachage sélectionné (MD5 ou SHA-256).
     * @param hacher  Indique si l'opération est un hachage (true) ou une comparaison (false).
     * @throws Exception Si une erreur survient pendant l'exécution du hachage.
     */
    private static void executeAlgorithme(Hachage hachage, boolean hacher) throws Exception {
        if (hacher) { // Hachage simple
            switch (hachage) {
                case MD5:
                    HashMD5.calculerHashMessage();
                    break;
                case SHA256:
                    HashSHA256.calculerHashMessageSHA256();
                    break;
            }
        } else { // Comparaison pour MD5 uniquement
            HashMD5.comparerHashMessages();
        }
    }
}