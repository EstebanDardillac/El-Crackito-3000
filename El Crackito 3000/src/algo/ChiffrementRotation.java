/*

    Auteur : Aya AIDOUNI
    Description :
    Ce programme permet de chiffrer ou déchiffrer un texte en utilisant la méthode de chiffrement par rotation.
    L'utilisateur peut choisir entre chiffrer ou déchiffrer un texte, puis saisir le texte à chiffrer ou déchiffrer
    ainsi que la rotation à appliquer. Le texte chiffré ou déchiffré est ensuite affiché à l'écran.

 */

package algo;

import Menus.AideMenu;
import Menus.MenuPrincipal;

import java.lang.String;

import java.text.Normalizer;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;


public class ChiffrementRotation {

    // Affiche un menu qui permet de choisir entre chiffrer ou déchiffrer un texte
    public static void chiffrementMenu() throws Exception {

        // Affichage du menu qui permet de choisir entre chiffrer ou déchiffrer un texte
        Scanner scanner = new Scanner(System.in);
        System.out.println(JAUNE + "╔═════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "         " + GRAS + SOULIGNE + "ROTATION (ROT(X))" + BLANC + "       " + JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" + ORANGE + "   Le chiffrement par rotation   " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   déplace chaque lettre d'un    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "  certain nombre de positions,   " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   défini par Rot(X), dans       " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   l'alphabet pour produire      " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "       un texte chiffré.         " + JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Chiffrer mon texte           " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Déchiffrer mon texte         " + JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + BLEU + ITALIQUE + "Aide                         " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 4. " + BLEU + ITALIQUE + "Retour au menu principal     " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 5. " + ROUGE + ITALIQUE + "Quitter                      " + JAUNE + "║");
        System.out.println(JAUNE + "╚═════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");


        // Récupération du choix de l'utilisateur
        if(scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi de chiffrer un texte");
                    rotationAlgo(true); // Envoie true pour chiffrer le texte
                    break;
                case 2:
                    System.out.println("Vous avez choisi de déchiffrer un texte");
                    rotationAlgo(false); // Envoie false pour déchiffrer le texte
                    break;
                case 3: // Accéder au menu d'aide
                    AideMenu.afficherMenu();
                    break;
                case 4: // Revenir au menu principal
                    MenuPrincipal.afficherMenu();
                    break;
                case 5: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé " + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
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

    // Chiffre ou déchiffre un texte en fonction du choix de l'utilisateur
    public static void rotationAlgo(Boolean choix) throws Exception {

        // Demande à l'utilisateur de saisir le texte à chiffrer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le texte : ");
        String texteAChiffrer = scanner.nextLine();

        // Vérification de la validité du texte
        while (texteAChiffrer.contains("\n") || texteAChiffrer.isEmpty()) {
            System.out.println("Le texte saisit n'est pas valide.");
            chiffrementMenu();
        }

        // Demande à l'utilisateur de saisir la rotation
        System.out.println("Veuillez saisir la rotation entre 0 et 26 : ");
        int rot = scanner.nextInt();

        // Vérification de la validité de la rotation
        // Pas vide, nombre négatif, ou autre caractère qu'un nombre entier
        while (rot <= 0 || rot >= 26 ) {
            System.out.println("La rotation saisie n'est pas valide.");
            chiffrementMenu();
        }

        // Initialisation des variables
        String texteDechiffre = "";
        char lettreAChiffrer;
        char lettreChiffree;
        char lettreDechiffree;
        String texteAChiffrerNormalise = normalizeText(texteAChiffrer);
        int size = texteAChiffrerNormalise.length();

        // indice i utiliser en dans les boucles for
        int i;

        // chiffrage du texte
        if(choix==true){
            // on répète l'opération pour chaque lettre du texte à chiffrer
            for (i = 0; i < size; i++) {
                // on récupère la lettre à chiffrer
                lettreAChiffrer = texteAChiffrerNormalise.charAt(i);

                // on chiffre la lettre en appliquant la formule
                // (lettreAChiffrer + rot(x)) % 26
                // en prenant en compte que a = 97 dans la table ASCII
                lettreChiffree = (char) (((lettreAChiffrer + rot - 96) ) % 26 + 96);

                // on ajoute la lettre chiffrée au texte à déchiffrer
                texteDechiffre += lettreChiffree;

            }
            // on affiche le texte chiffré
            System.out.println("Votre texte chiffre est : " + texteDechiffre);
            chiffrementMenu();
        }


        // déchiffrage du texte
        else if(choix==false){
            // On répète l'opération pour chaque lettre du texte à déchiffrer
            for (i = 0; i < size; i++) {
                // on récupère la lettre à déchiffrer
                lettreChiffree = texteAChiffrer.charAt(i);

                // on déchiffre la lettre en appliquant la formule
                // (lettreChiffree - rot(x) + 26) % 26
                // en prenant en compte que a = 97 dans la table ASCII
                lettreDechiffree = (char) ((lettreChiffree - rot - 96 + 26) % 26 + 96);

                // on ajoute la lettre déchiffrée au texte déchiffré
                texteDechiffre += lettreDechiffree;
            }
            // on affiche le texte déchiffré
            System.out.println("Votre texte dechiffre est : " + texteDechiffre);
            chiffrementMenu();
        }

    }

    // Supprime les espaces et les caractères spéciaux du texte mis en paramètre
    public static String normalizeText(String text) {
        // Retiré tout les caractères spéciaux et chiffres
        text = Normalizer.normalize(text, Normalizer.Form.NFKC);
        text = text.replaceAll("[^a-zA-Z]", ""); //Gardé uniquement les lettres
        return text.toLowerCase(); // Convert to lowercase
    }
}
