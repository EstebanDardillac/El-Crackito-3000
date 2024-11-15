package chaine;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import algo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class ChaineDeChiffrement {

    private static final List<Algorithme> algorithmes = new ArrayList<>(); // Liste des algorithmes sélectionnés pour le chiffrement

    public enum Algorithme {
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
            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            menuChaineDeChiffrement();
        }
    }

    // Exécute la chaîne de chiffrement
    private static void executeChaine() throws Exception {
        Scanner scanner = new Scanner(System.in);

        for (Algorithme algorithme : algorithmes) {
            switch (algorithme) {
                case ROT_X:
                    boolean choixValideROTX = false; // Initialise la variable choixValide à false pour entrer dans la boucle

                    while (!choixValideROTX) { // Boucle qui se répète jusqu'à ce que l'utilisateur saisisse une option valide (1 ou 2)
                        System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le texte avec ROT(X) ? : ");

                        // Lecture de l'option de l'utilisateur (1 pour chiffrer, 2 pour déchiffrer)
                        int operation = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne pour éviter des erreurs de lecture

                        if (operation == 1) { // Si l'utilisateur choisit l'option 1, on procède au chiffrement
                            choixValideROTX = true; // Met fin à la boucle
                            ChiffrementRotation.rotationAlgo(true); // Appelle la méthode de chiffrement
                        } else if (operation == 2) { // Si l'utilisateur choisit l'option 2, on procède au déchiffrement
                            choixValideROTX = true; // Met fin à la boucle
                            ChiffrementRotation.rotationAlgo(false); // Appelle la méthode de déchiffrement
                        } else { // Si l'utilisateur saisit une option invalide, un message d'erreur est affiché et la boucle continue
                            System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                        }
                    }
                    break;
                case VIGENERE:
                    boolean choixValideVigenere = false; // Variable pour vérifier si l'utilisateur a fait un choix valide

                    while (!choixValideVigenere) { // Boucle jusqu'à ce que l'utilisateur saisisse une option valide
                        System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le tetxte avec Vigenère ? : ");

                        // Lecture de l'option saisie par l'utilisateur
                        int action = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne pour éviter des problèmes lors de la saisie suivante

                        if (action == 1) { // Si l'utilisateur choisit l'option 1, on procède au chiffrement
                            choixValideVigenere = true; // Sort de la boucle une fois que le choix est valide
                            Vigenere.ChiffrerVigenere(); // Appelle la méthode pour chiffrer avec Vigenère
                        } else if (action == 2) { // Si l'utilisateur choisit l'option 2, on procède au déchiffrement
                            choixValideVigenere = true; // Sort de la boucle une fois que le choix est valide
                            Vigenere.DechiffrerVigenere(); // Appelle la méthode pour déchiffrer avec Vigenère
                        } else { // Si l'utilisateur saisit une option invalide, affiche un message d'erreur
                            System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                        }
                    }
                    break;
                case CARRE_POLYBE:
                    boolean choixValidePolybe = false; // Variable pour vérifier si l'utilisateur a fait un choix valide

                    while (!choixValidePolybe) { // Boucle pour garantir un choix valide
                        System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le texte avec le Carré de Polybe ? : ");

                        // Lecture de l'option saisie par l'utilisateur
                        int operationPolybe = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne pour éviter les erreurs

                        if (operationPolybe == 1) { // Si l'utilisateur choisit de chiffrer
                            choixValidePolybe = true; // Sort de la boucle
                            try {
                                ChiffrementCarrePolybe.carrePolybeAlgo(true); // Appelle la méthode de chiffrement
                            } catch (Exception e) {
                                System.out.println(ROUGE + "Une erreur est survenue lors du chiffrement avec le Carré de Polybe.");
                            }
                        } else if (operationPolybe == 2) { // Si l'utilisateur choisit de déchiffrer
                            choixValidePolybe = true; // Sort de la boucle
                            try {
                                ChiffrementCarrePolybe.carrePolybeAlgo(false); // Appelle la méthode de déchiffrement
                            } catch (Exception e) {
                                System.out.println(ROUGE + "Une erreur est survenue lors du déchiffrement avec le Carré de Polybe.");
                            }
                        } else { // Si l'utilisateur saisit une option invalide, affiche un message d'erreur
                            System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                        }
                    }
                    break;
                case ENIGMA:
                    boolean choixValideEnigma = false; // Variable pour vérifier si l'utilisateur a fait un choix valide

                    while (!choixValideEnigma) { // Boucle pour garantir un choix valide
                        System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le texte avec Enigma ? : ");

                        // Lecture de l'option saisie par l'utilisateur
                        int operationEnigma = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne pour éviter les erreurs

                        if (operationEnigma == 1) { // Si l'utilisateur choisit de chiffrer
                            choixValideEnigma = true; // Sort de la boucle
                            try {
                                ChiffrementEnigma.enigmaAlgo(true); // Appelle la méthode de chiffrement
                            } catch (Exception e) {
                                System.out.println(ROUGE + "Une erreur est survenue lors du chiffrement avec Enigma.");
                            }
                        } else if (operationEnigma == 2) { // Si l'utilisateur choisit de déchiffrer
                            choixValideEnigma = true; // Sort de la boucle
                            try {
                                ChiffrementEnigma.enigmaAlgo(false); // Appelle la méthode de déchiffrement
                            } catch (Exception e) {
                                System.out.println(ROUGE + "Une erreur est survenue lors du déchiffrement avec Enigma.");
                            }
                        } else { // Si l'utilisateur saisit une option invalide, affiche un message d'erreur
                            System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                        }
                    }
                    break;
                case RC4:
                    boolean choixValideRC4 = false; // Variable pour vérifier si l'utilisateur a fait un choix valide

                    while (!choixValideRC4) { // Boucle pour garantir un choix valide
                        System.out.print(BLEU + "Voulez-vous chiffrer (1) ou déchiffrer (2) le texte avec RC4 ? : ");

                        // Lecture de l'option saisie par l'utilisateur
                        int operationRC4 = scanner.nextInt();
                        scanner.nextLine(); // Consomme la fin de ligne pour éviter les erreurs

                        if (operationRC4 == 1) { // Si l'utilisateur choisit de chiffrer
                            choixValideRC4 = true; // Sort de la boucle
                            try {
                                RC4.ChiffrerTexte(); // Appelle la méthode de chiffrement
                            } catch (Exception e) {
                                System.out.println(ROUGE + "Une erreur est survenue lors du chiffrement avec RC4.");
                            }
                        } else if (operationRC4 == 2) { // Si l'utilisateur choisit de déchiffrer
                            choixValideRC4 = true; // Sort de la boucle
                            try {
                                RC4.DechiffrerTexte(); // Appelle la méthode de déchiffrement
                            } catch (Exception e) {
                                System.out.println(ROUGE + "Une erreur est survenue lors du déchiffrement avec RC4.");
                            }
                        } else { // Si l'utilisateur saisit une option invalide, affiche un message d'erreur
                            System.out.println(ROUGE + "Option invalide. Veuillez sélectionner 1 pour chiffrer ou 2 pour déchiffrer.");
                        }
                    }
                    break;
                default: // Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Algorithme non reconnu.");
            }
        }
        menuChaineDeChiffrement();
    }
}
