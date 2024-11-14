package chaine;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import algo.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class ChaineDeChiffrement {

    private static final List<Algorithm> algorithmes = new ArrayList<>(); // Liste des algorithmes sélectionnés pour le chiffrement

    public enum Algorithm {
        ROT_X, VIGENERE, CARRE_POLYBE, ENIGMA, RC4
    }

    // Affiche le menu pour sélectionner et exécuter la chaîne de chiffrement
    public static void menuChaineDeChiffrement() throws Exception {
        Scanner scanner = new Scanner(System.in);

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

        // Vérifie si l'entrée est un entier
        if (scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la fin de ligne

            switch (choix) {
                case 1: // Sélectionner ROT X
                    algorithmes.add(Algorithm.ROT_X);
                    System.out.println(VERT + "Algorithme ROT(X) ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 2: // Sélectionner Vigenere
                    algorithmes.add(Algorithm.VIGENERE);
                    System.out.println(VERT + "Algorithme Vigenère ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 3: // Sélectionner Carré Polybe
                    algorithmes.add(Algorithm.CARRE_POLYBE);
                    System.out.println(VERT + "Algorithme Carré de Polybe ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 4: // Sélectionner Enigma
                    algorithmes.add(Algorithm.ENIGMA);
                    System.out.println(VERT + "Algorithme Enigma ajouté à la chaîne.");
                    menuChaineDeChiffrement();
                    break;
                case 5: // Sélectionner RC4
                    algorithmes.add(Algorithm.RC4);
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
                default:
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    menuChaineDeChiffrement();
            }
        } else {
            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            menuChaineDeChiffrement();
        }
    }

    // Exécute la chaîne de chiffrement
    private static void executeChaine() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le message à chiffrer : ");
        String message = scanner.nextLine();

        for (Algorithm algorithme : algorithmes) {
            switch (algorithme) {
                case ROT_X:
                    // Initialise la variable choixValide à false pour entrer dans la boucle
                    boolean choixValide = false;

                    // Boucle qui se répète jusqu'à ce que l'utilisateur saisisse une option valide (1 ou 2)
                    while (!choixValide) {
                        System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le texte avec ROT(X) ? : ");

                        // Lecture de l'option de l'utilisateur (1 pour chiffrer, 2 pour déchiffrer)
                        int operation = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne pour éviter des erreurs de lecture

                        if (operation == 1) { // Si l'utilisateur choisit l'option 1, on procède au chiffrement
                            choixValide = true; // Met fin à la boucle
                            ChiffrementRotation.rotationAlgo(true); // Appelle la méthode de chiffrement
                        } else if (operation == 2) { // Si l'utilisateur choisit l'option 2, on procède au déchiffrement
                            choixValide = true; // Met fin à la boucle
                            ChiffrementRotation.rotationAlgo(false); // Appelle la méthode de déchiffrement
                        } else { // Si l'utilisateur saisit une option invalide, un message d'erreur est affiché et la boucle continue
                            System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                        }
                    }
                    break;
                case VIGENERE:
                    System.out.print("Entrez la clé pour Vigenère : ");
                    String cle = scanner.nextLine();
                    //TODO message = Vigenere
                    System.out.println("Message après Vigenère : " + message);
                    break;
                case CARRE_POLYBE:
                    //TODO message = ChiffrementCarrePolybe
                    System.out.println("Message après Carré de Polybe : " + message);
                    break;
                case ENIGMA:
                    //TODO message = ChiffrementEnigma
                    System.out.println("Message après Enigma : " + message);
                    break;
                case RC4:
                    System.out.print("Entrez la clé pour RC4 : ");
                    String rc4Key = scanner.nextLine();
                    //TODO message = RC4
                    System.out.println("Message après RC4 : " + message);
                    break;
                default:
                    System.out.println("Algorithme non reconnu.");
            }
        }

        System.out.println("Message final après la chaîne de chiffrement : " + message);
        menuChaineDeChiffrement();
    }
}
