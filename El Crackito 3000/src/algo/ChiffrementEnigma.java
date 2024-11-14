package algo;

import Menus.AideMenu;
import Menus.MenuPrincipal;

import java.util.Scanner;

import static utils.AnsiCouleurs.*;
import static utils.AnsiCouleurs.ROUGE;

public class ChiffrementEnigma {

    public static void chiffrementMenu() throws Exception {
        // Affichage du menu qui permet de choisir entre chiffrer ou déchiffrer un texte
        Scanner scanner = new Scanner(System.in);
        System.out.println(JAUNE + "╔═══════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "                " + GRAS + SOULIGNE + "ENIGMA" + BLANC + "             " + JAUNE + "║");
        System.out.println(JAUNE + "║                                   ║");
        System.out.println(JAUNE + "║" + ORANGE + "  L'algorithme Enigma utilise des  " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   rotors pour substituer chaque   " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   lettre, inversant le message    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   via un miroir et revenant par   " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "  les rotors pour un chiffrement   " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "      complexe du texte.           " + JAUNE + "║");
        System.out.println(JAUNE + "║                                   ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Chiffrer mon texte             " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Déchiffrer mon texte           " + JAUNE + "║");
        System.out.println(JAUNE + "║                                   ║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + BLEU + ITALIQUE + "Aide                           " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 4. " + BLEU + ITALIQUE + "Retour au menu principal       " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 5. " + ROUGE + ITALIQUE + "Quitter                        " + JAUNE + "║");
        System.out.println(JAUNE + "╚═══════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");


        // Récupération du choix de l'utilisateur
        if(scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi de chiffrer un texte");
                    enigmaAlgo(true); // Envoie true pour chiffrer le texte
                    break;
                case 2:
                    System.out.println("Vous avez choisi de déchiffrer un texte");
                    enigmaAlgo(false); // Envoie false pour déchiffrer le texte
                    break;
                case 3: // Accéder au menu d'aide
                    AideMenu.afficherMenu();
                    break;
                case 4: // Revenir au menu principal
                    MenuPrincipal.afficherMenu();
                    break;
                case 5: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                    System.exit(0);
                    break;
                default: // Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    chiffrementMenu();
                    break;
            }
        } else {
            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            chiffrementMenu();
        }
    }

    public static void enigmaAlgo(Boolean choix) throws Exception {

        // Demande à l'utilisateur de saisir le texte à chiffrer ou déchiffrer
        Scanner scanner = new Scanner(System.in);
        System.out.println(BLEU + "Veuillez saisir le texte : ");
        String texteUtilisateur = scanner.nextLine();

        // Vérification de la validité du texte
        while (texteUtilisateur.contains("\n") || texteUtilisateur.isEmpty()) {
            System.out.println(ROUGE + "Le texte saisi n'est pas valide.");
            chiffrementMenu();
        }

        String texteUtilisateurNeutre = texteUtilisateur.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
        String texteChiffre = "";

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        char[] miroir = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        // Déclaration des rotateurs
        char[][] rotator1 = {
                alphabet,
                {'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'}
        };

        char[][] rotator2 = {
                alphabet,
                {'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'}
        };

        char[][] rotator3 = {
                alphabet,
                {'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O'}
        };

        if(choix){
            // Algorithme de chiffrement Enigma
            for (int i = 0; i < texteUtilisateurNeutre.length(); i++) {
                char lettreChiffree = texteUtilisateurNeutre.charAt(i);

                // Passage dans les rotators en sens direct
                lettreChiffree = passerRotator(lettreChiffree, rotator1, true);
                lettreChiffree = passerRotator(lettreChiffree, rotator2, true);
                lettreChiffree = passerRotator(lettreChiffree, rotator3, true);

                // Passage dans le miroir
                lettreChiffree = passerMiroir(lettreChiffree, alphabet, miroir);

                // Passage dans les rotators en sens inverse
                lettreChiffree = passerRotator(lettreChiffree, rotator3, true);
                lettreChiffree = passerRotator(lettreChiffree, rotator2, true);
                lettreChiffree = passerRotator(lettreChiffree, rotator1, true);

                // Ajout de la lettre chiffrée au texte final
                texteChiffre += lettreChiffree;
            }
        }

        else{
            // Algorithme de déchiffrement Enigma
            for (int i = 0; i < texteUtilisateurNeutre.length(); i++) {
                char lettreChiffree = texteUtilisateurNeutre.charAt(i);

                // Passage dans les rotators en sens direct
                lettreChiffree = passerRotator(lettreChiffree, rotator1, false);
                lettreChiffree = passerRotator(lettreChiffree, rotator2, false);
                lettreChiffree = passerRotator(lettreChiffree, rotator3, false);

                // Passage dans le miroir
                lettreChiffree = passerMiroir(lettreChiffree, alphabet, miroir);

                // Passage dans les rotators en sens inverse
                lettreChiffree = passerRotator(lettreChiffree, rotator3, false);
                lettreChiffree = passerRotator(lettreChiffree, rotator2, false);
                lettreChiffree = passerRotator(lettreChiffree, rotator1, false);

                // Ajout de la lettre chiffrée au texte final
                texteChiffre += lettreChiffree;
            }
        }

        // Affichage du texte chiffré
        System.out.println(BLEU + "Votre texte chiffré est : " + BLANC + texteChiffre);
        chiffrementMenu();
    }

    // Méthode pour passer dans un rotator
    private static char passerRotator(char lettre, char[][] rotator, boolean sensDirect) {
        for (int j = 0; j < rotator[0].length; j++) { // Parcours des lettres du rotator
            if (sensDirect && lettre == rotator[0][j]) {  // Sens direct, on cherche la lettre dans la première ligne
                return rotator[1][j]; // Retourne la lettre correspondante dans la deuxième ligne
            } else if (!sensDirect && lettre == rotator[1][j]) {  // Sens inverse, on cherche la lettre dans la deuxième ligne
                return rotator[0][j]; // Retourne la lettre correspondante dans la première ligne
            }
        }
        return lettre;  // Retourne la lettre inchangée si elle n'est pas trouvée
    }

    // Méthode pour passer dans le miroir
    private static char passerMiroir(char lettre, char[] alphabet, char[] miroir) {
        for (int j = 0; j < alphabet.length; j++) { // Parcours de l'alphabet
            if (lettre == alphabet[j]) { // Si la lettre est trouvée
                return miroir[j]; // Retourne la lettre correspondante dans le miroir
            }
        }
        return lettre;
    }
}
