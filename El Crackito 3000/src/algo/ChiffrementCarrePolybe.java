/*
    Auteur : Aya AIDOUNI
    Description :
    * Cette classe permet de chiffrer ou déchiffrer un texte en utilisant le carré de Polybe.
    * Le carré de Polybe est une grille de lettres utilisée pour chiffrer des messages.
    * Chaque lettre est remplacée par une paire de chiffres correspondant à ses coordonnées dans la grille.
    * L'utilisateur peut choisir entre chiffrer ou déchiffrer un texte, puis saisir le texte à chiffrer ou déchiffrer.
    * Le texte chiffré ou déchiffré est ensuite affiché à l'écran.
 */

package algo;

import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class ChiffrementCarrePolybe {
    public static void chiffrementMenu() {

        // Affichage du menu qui permet de choisir entre chiffrer ou déchiffrer un texte
        Scanner scanner = new Scanner(System.in);
        System.out.println(JAUNE + "╔═════════════════════════════════╗");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Chiffrer mon texte           " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Déchiffrer mon texte         " + JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + ROUGE + "Retour au menu principal     " + JAUNE + "║");
        System.out.println(JAUNE + "╚═════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        // Récupération du choix de l'utilisateur
        if(scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi de chiffrer un texte");
                    carrePolybeAlgo(true); // Envoie true pour chiffrer le texte
                    break;
                case 2:
                    System.out.println("Vous avez choisi de déchiffrer un texte");
                    carrePolybeAlgo(false); // Envoie false pour déchiffrer le texte
                    break;
                case 3:
                    System.out.println("Vous avez choisi de retourner au menu principal");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi une option valide");
                    break;
            }
        } else {
            System.out.println("Vous n'avez pas choisi une option valide");
        }
    }

    public static void carrePolybeAlgo(Boolean choix) {
        // Création de plusieurs matriceS contentant des carrés de Polybe différents
        // On laisse le choix à l'utilisateur de choisir le carré de Polybe qu'il souhaite
        // Le W est remplacé par deux V donc la lettre W n'est pas présente
        char[][] carrePolybeFaitMaison = {
            {'K', 'I', 'M', 'B', 'C'},
            {'D', 'F', 'H', 'J', 'N'},
            {'P', 'Q', 'R', 'S', 'U'},
            {'V', 'X', 'Y', 'Z', 'L'},
            {'E', 'G', 'O', 'A', 'T'},
        };

        char[][] carrePolybeClassique = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'J'},
            {'K', 'L', 'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S', 'T'},
            {'U', 'V', 'X', 'Y', 'Z'},
        };

        char[][] carrePolybeEscargot = {
            {'Z', 'I', 'K', 'L', 'M'},
            {'Y', 'I', 'B', 'C', 'N'},
            {'X', 'H', 'A', 'D', 'O'},
            {'V', 'G', 'F', 'E', 'P'},
            {'U', 'T', 'S', 'R', 'Q'},
        };


        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de choisir le carré de Polybe qu'il souhaite utiliser
        System.out.println("Choisissez le carré de Polybe que vous souhaitez utiliser : ");
        System.out.println("1. Carré de Polybe fait maison");
        System.out.println("2. Carré de Polybe classique");
        System.out.println("3. Carré de Polybe en forme d'escargot");
        System.out.print("Votre choix : ");
        int choixCarre = scanner.nextInt();
        char[][] carrePolybe = null;


        // Récupération du choix de l'utilisateur et attribution du carré de Polybe correspondant
        switch (choixCarre) {
            case 1:
                System.out.println("Vous avez choisi le carré de Polybe fait maison");
                System.out.println(afficherPolybe(carrePolybeFaitMaison)); // Affichage du carré de Polybe choisit
                carrePolybe = carrePolybeFaitMaison; // Attribution du carré de Polybe
                break;
            case 2:
                System.out.println("Vous avez choisi le carré de Polybe classique");
                System.out.println(afficherPolybe(carrePolybeClassique)); // Affichage du carré de Polybe choisit
                carrePolybe = carrePolybeClassique; // Attribution du carré de Polybe
                break;
            case 3:
                System.out.println("Vous avez choisi le carré de Polybe en forme d'escargot");
                System.out.println(afficherPolybe(carrePolybeEscargot)); // Affichage du carré de Polybe choisit
                carrePolybe = carrePolybeEscargot; // Attribution du carré de Polybe
                break;
            default:
                System.out.println("Vous n'avez pas choisi un carré de Polybe valide");
                break;
        }

        scanner.nextLine();

        if(choix){
            // Chiffrement du texte
            // Demande à l'utilisateur de saisir le texte à chiffrer
            System.out.println("Veuillez saisir le texte : ");
            String texteChoisit = scanner.nextLine();

            // Vérification de la validité du texte
            if (texteChoisit.contains("\n") || texteChoisit.isEmpty()) {
                System.out.println("Le texte saisit n'est pas valide.");
                chiffrementMenu();
            }

            String texteAChiffrerUnifie = texteChoisit.replaceAll("[^\\p{ASCII}]", "").toUpperCase().replaceAll("W", "VV");

            String texteChiffre = "";

            // On parcours chaque lettre du texte à chiffrer
            for (int i = 0; i < texteAChiffrerUnifie.length(); i++) {
                char lettre = texteAChiffrerUnifie.charAt(i); // Récupère la lettre courante
                // Si la lettre est un espace, on l'ajoute au texte chiffré
                if (lettre == ' ') {
                    texteChiffre += " ";
                } else {
                    for (int j = 0; j < carrePolybe.length; j++) { // Parcours des lignes
                        for (int k = 0; k < carrePolybe[j].length; k++) { // Parcours des colonnes
                            // Si la lettre est présente dans le carré de Polybe, on ajoute ses coordonnées au texte chiffré
                            if (lettre == carrePolybe[j][k]) {
                                texteChiffre += (j + 1) + "" + (k + 1); // Ajoute les coordonnées de la lettre au texte chiffré
                            }
                        }
                    }
                }
            }

            // Affichage du texte chiffré
            System.out.println("Texte chiffré : " + texteChiffre);
        }
        else {
            // Déchiffrement du texte
            System.out.println("Veuillez saisir le texte : ");
            String texteChoisit = scanner.nextLine();

            // Vérification de la validité du texte : accepte les chiffres 1-5 et les espaces
            String texteSansEspaces = texteChoisit.replace(" ", "");
            if (!texteSansEspaces.matches("[1-5]+") || texteSansEspaces.length() % 2 != 0) {
                System.out.println("Le texte saisi n'est pas valide. Il doit contenir uniquement des chiffres entre 1 et 5, avec des espaces pour séparer les mots.");
                chiffrementMenu();
            }

            String texteDechiffre = "";

            // Parcours chaque caractère du texte à déchiffrer
            for (int i = 0; i < texteChoisit.length(); i++) {
                char currentChar = texteChoisit.charAt(i);

                if (currentChar == ' ') {
                    // Ajoute un espace pour séparer les mots
                    texteDechiffre += " ";
                } else {
                    // Assure que nous avons une paire de chiffres pour déchiffrer
                    if (i + 1 < texteChoisit.length() && Character.isDigit(texteChoisit.charAt(i + 1))) {
                        int ligne = Character.getNumericValue(currentChar) - 1; // Convertit le caractère en entier et soustrait 1
                        int colonne = Character.getNumericValue(texteChoisit.charAt(i + 1)) - 1; // Convertit le caractère suivant en entier et soustrait 1
                        i++; // Passe au prochain caractère après la paire

                        // Vérification que les indices sont dans les limites de la grille
                        if (ligne >= 0 && ligne < 5 && colonne >= 0 && colonne < 5) {
                            texteDechiffre += carrePolybe[ligne][colonne]; // Ajoute la lettre correspondante au texte déchiffré
                        } else {
                            System.out.println("Erreur : le texte saisi contient des indices hors des limites de la grille.");
                            chiffrementMenu();
                        }
                    } else {
                        System.out.println("Erreur : le texte saisi n'est pas correctement formé pour le déchiffrement.");
                        chiffrementMenu();
                    }
                }
            }
            // Affichage du texte déchiffré
            System.out.println("Texte déchiffré : " + texteDechiffre);

        }
    }


    // Méthode pour afficher le carré de Polybe mis en paramètre
    public static String afficherPolybe(char[][] carrePolybe) {
        String polybe = ""; // Initialisation de la variable qui contiendra le carré de Polybe

        // Parcours de chaque élément du carré de Polybe
        for (int i = 0; i < carrePolybe.length; i++) { // Parcours des lignes
            for (int j = 0; j < carrePolybe[i].length; j++) { // Parcours des colonnes
                polybe += carrePolybe[i][j] + " "; // Ajout de la lettre à la chaîne de caractères
            }
            polybe += "\n"; // Ajout d'un retour à la ligne pour passer à la ligne suivante
        }
        return polybe;
    }
}
