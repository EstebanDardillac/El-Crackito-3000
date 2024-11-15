package chaine;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import algo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class ChaineDeChiffrement {
    private static final List<Algorithme> algorithmes = new ArrayList<>(); // Liste des algorithmes sélectionnés pour la chaîne de chiffrement

    // Enumération des algorithmes disponibles
    public enum Algorithme {
        ROT_X, VIGENERE, CARRE_POLYBE, ENIGMA, RC4
    }

    /**
     * Méthode principale pour afficher le menu de la chaîne de chiffrement
     * Permet à l'utilisateur de sélectionner des algorithmes ou d'exécuter la chaîne
     */
    public static void menuChaineDeChiffrement() throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Affichage du menu principal
        System.out.println(JAUNE + "╔══════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "             " + GRAS + SOULIGNE + "Chaîne de Chiffrement" + BLANC + "            " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + ORANGE + "  Bienvenue dans le programme de chiffrement  " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   de messages. Choisissez une option pour    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "    appliquer différents algorithmes ou       " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "            accéder à l'aide.                 " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "ROT(X)                                    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Vigenère                                  " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + VERT + "Carré de Polybe                           " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 4. " + VERT + "Enigma                                    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 5. " + VERT + "RC4                                       " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + BLANC + " 6. " + VERT + "Lancer les algorithmes                    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 7. " + VERT + "Recommencer la sélection                  " + JAUNE + "║");
        System.out.println(JAUNE + "║                                              ║");
        System.out.println(JAUNE + "║" + BLANC + " 8. " + BLEU + ITALIQUE + "Aide                                      " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 9. " + BLEU + ITALIQUE + "Retour au menu principal                  " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 10. " + ROUGE + ITALIQUE + "Quitter                                  " + JAUNE + "║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        // Vérification que l'entrée soit bien un entier
        if (scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la fin de ligne

            // Gestion des choix utilisateur
            switch (choix) {
                case 1: // Sélectionner ROT X
                    algorithmes.add(Algorithme.ROT_X);
                    System.out.println(VERT + "Algorithme ROT(X) ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 2: // Sélectionner Vigenere
                    algorithmes.add(Algorithme.VIGENERE);
                    System.out.println(VERT + "Algorithme Vigenère ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 3: // Sélectionner Carré Polybe
                    algorithmes.add(Algorithme.CARRE_POLYBE);
                    System.out.println(VERT + "Algorithme Carré de Polybe ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 4: // Sélectionner Enigma
                    algorithmes.add(Algorithme.ENIGMA);
                    System.out.println(VERT + "Algorithme Enigma ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 5: // Sélectionner RC4
                    algorithmes.add(Algorithme.RC4);
                    System.out.println(VERT + "Algorithme RC4 ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 6: // Executer la chaine
                    executeChaine();
                    break;
                case 7: // Réinitialiser les sélections des algorithmes
                    algorithmes.clear();
                    System.out.println("Chaîne de chiffrement réinitialisée.");
                    menuChaineDeChiffrement();
                    break;
                case 8: // Accéder au menu d'aide
                    AideMenu.afficherMenu();
                    break;
                case 9: // Revenir au menu principal
                    MenuPrincipal.afficherMenu();
                    break;
                case 10: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                    System.exit(0);
                    break;
                default: // Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    menuChaineDeChiffrement();
            }
        } else { // Message d'erreur pour un choix non valide
            System.out.println(ROUGE + "Entrée invalide. Veuillez saisir un entier entre 1 et 10.");
            scanner.nextLine(); // Vide l'entrée incorrecte
            menuChaineDeChiffrement();
        }
    }

    /**
     * Exécute la chaîne d'algorithmes sélectionnés par l'utilisateur.
     * Pour chaque algorithme, l'utilisateur choisit entre chiffrement et déchiffrement,
     * puis l'algorithme est exécuté en conséquence.
     *
     * @throws Exception Si une erreur survient pendant l'exécution des algorithmes.
     */
    private static void executeChaine() throws Exception {
        Scanner scanner = new Scanner(System.in); // Initialise un scanner pour lire les entrées utilisateur.

        // Parcours de la liste des algorithmes sélectionnés
        for (Algorithme algorithme : algorithmes) {
            boolean choixValide = false; // Boolean pour valider le choix de l'utilisateur.

            while (!choixValide) { // Demande à l'utilisateur de choisir entre chiffrement et déchiffrement pour l'algorithme courant
                System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le texte avec " + algorithme + " ? : ");
                if (scanner.hasNextInt()) { // Vérifie si l'entrée est un entier.
                    int action = scanner.nextInt(); // Récupère l'entrée de l'utilisateur.
                    scanner.nextLine(); // Consomme la fin de ligne pour éviter les erreurs de lecture.

                    if (action == 1 || action == 2) { // Vérifie si l'action choisie est valide (1 pour chiffrer, 2 pour déchiffrer)
                        choixValide = true; // Met fin à la boucle après une saisie valide.
                        executeAlgorithme(algorithme, action == 1); // Exécute l'algorithme avec l'opération choisie.
                    } else { // Message d'erreur pour un choix valide mais hors des options proposées
                        System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                    }
                } else { // Message d'erreur pour une entrée invalide (non entière).
                    System.out.println(ROUGE + "Entrée invalide. Veuillez saisir un entier (1 ou 2).");
                    scanner.nextLine(); // Vide l'entrée incorrecte pour éviter des boucles infinies.
                }
            }
        }

        // Retourne au menu principal de la chaîne après avoir exécuté tous les algorithmes.
        menuChaineDeChiffrement();
    }

    /**
     * Exécute un algorithme de chiffrement ou de déchiffrement en fonction de l'algorithme choisi
     * et de l'opération demandée (chiffrement ou déchiffrement).
     *
     * @param algorithme L'algorithme sélectionné (ROT_X, VIGENERE, etc.).
     * @param chiffrer   Indique si l'opération est un chiffrement (true) ou un déchiffrement (false).
     * @throws Exception Si une erreur survient pendant l'exécution de l'algorithme.
     */
    private static void executeAlgorithme(Algorithme algorithme, boolean chiffrer) throws Exception {
        // Vérifie quel algorithme est sélectionné et exécute la méthode appropriée.
        switch (algorithme) {
            case ROT_X: // Exécute le chiffrement ou le déchiffrement avec l'algorithme ROT(X).
                ChiffrementRotation.rotationAlgo(chiffrer);
                break;
            case VIGENERE: // Exécute le chiffrement ou le déchiffrement avec l'algorithme de Vigenère.
                if (chiffrer) {
                    Vigenere.ChiffrerVigenere(); // Appelle la méthode pour chiffrer.
                } else {
                    Vigenere.DechiffrerVigenere(); // Appelle la méthode pour déchiffrer.
                }
                break;
            case CARRE_POLYBE: // Exécute le chiffrement ou le déchiffrement avec le Carré de Polybe.
                ChiffrementCarrePolybe.carrePolybeAlgo(chiffrer);
                break;
            case ENIGMA: // Exécute le chiffrement ou le déchiffrement avec l'algorithme Enigma.
                ChiffrementEnigma.enigmaAlgo(chiffrer);
                break;
            case RC4: // Exécute le chiffrement ou le déchiffrement avec l'algorithme RC4.
                if (chiffrer) {
                    RC4.ChiffrerTexte(); // Appelle la méthode pour chiffrer.
                } else {
                    RC4.DechiffrerTexte(); // Appelle la méthode pour déchiffrer.
                }
                break;
            default: // Ce cas ne devrait pas se produire, car les algorithmes sont prédéfinis.
                throw new IllegalArgumentException(ROUGE + "Algorithme inconnu : " + algorithme);
        }
    }
}