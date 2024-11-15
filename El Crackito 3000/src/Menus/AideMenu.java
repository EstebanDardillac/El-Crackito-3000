package Menus;

import static utils.AnsiCouleurs.*;

import java.util.Scanner;

/**
 * La classe AideMenu représente le menu d'aide de l'application El Crackito 3000.
 * Elle affiche des informations sur les fonctionnalités et options disponibles dans l'application,
 * et permet à l'utilisateur de naviguer en revenant au menu principal ou de quitter le programme.
 */
public class AideMenu {

    /**
     * Affiche le menu d'aide et gère les choix de l'utilisateur.
     * Cette méthode présente un message d'aide expliquant les fonctionnalités de l'application.
     * L'utilisateur peut choisir de revenir au menu principal ou de quitter l'application.
     */
    public static void afficherMenu() throws Exception {
        // Crée un scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affiche le message d'aide
        System.out.println(JAUNE + "╔═══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" + BLEU + "    Bienvenue dans le menu d'aide d'" + GRAS + CYAN_CLAIR + "El Crackito 3000  " + BLEU + "!                        " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    Ce programme propose plusieurs algorithmes de cryptage,                    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    notamment les algorithmes de Rotation (Rot(X)) et de Vigenère.             " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + "    Utilisez ces outils pour en apprendre davantage sur le chiffrement.        " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                                               ║");
        System.out.println(JAUNE + "║" + VERT + "    Options disponibles :                                                      " + JAUNE + "║");
        System.out.println(JAUNE + "║    " + BLANC + GRAS + "Algorithmes :                                                              " + JAUNE + "║");
        System.out.println(JAUNE + "║    " + BLANC + SOULIGNE + "- Chiffrement de Rotation (Rot(X)) :" + BLANC + " Le chiffrement par rotation déplace   " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "chaque lettre d'un certain nombre de positions, défini par Rot(X),       " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "dans l'alphabet pour produire un texte chiffré.                          " + JAUNE + "║");
        System.out.println(JAUNE + "║    " + BLANC + SOULIGNE +"- Chiffrement de Vigenère :" + BLANC + " Le chiffrement de Vigenère utilise un mot-clé  " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "pour chiffrer le texte en décalant chaque lettre en fonction des         " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "lettres du mot-clé. Ce système rend le chiffrement plus difficile à      " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "casser que les substitutions simples.                                    " + JAUNE + "║");

        System.out.println(JAUNE + "║    " + BLANC + SOULIGNE +"- Le carée de Polybe : " + BLANC + "L'algorithme du Carré de Polybe utilise une         " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "grille de lettres où chaque lettre est remplacée par une paire de        " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "chiffres. Cette technique offre un chiffrement simple mais efficace      " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "du texte.                                                                " + JAUNE + "║");
        System.out.println(JAUNE + "║    " + BLANC + SOULIGNE +"- LFSR : " + BLANC + "Un générateur de séquence pseudo-aléatoire utilisé en             " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "cryptographie.                                                           " + JAUNE + "║");

        System.out.println(JAUNE + "║    " + BLANC + SOULIGNE + "- Chiffrement RC4 :" + BLANC + " L'algorithme RC4 est un chiffrement de flux qui        " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "génère un flot de clés pseudo-aléatoires pour chaque octet du texte,     " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "combiné avec ce dernier pour produire un texte chiffré rapide.           " + JAUNE + "║");

        System.out.println(JAUNE + "║    " + BLANC +  SOULIGNE + "- Chiffrement Enigma :" + BLANC + " L'algorithme Enigma utilise des rotors pour         " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "substituer chaque lettre, inversant le message via un miroir et          " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "revenant par les rotors pour un chiffrement complexe du texte.           " + JAUNE + "║");

        System.out.println(JAUNE + "║    " + BLANC + GRAS + "Hashages :                                                                 " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + SOULIGNE + "- Hashage MD5 : " + BLANC + "L'algorithme MD5 est une fonction de hachage qui           " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "convertit un message en une empreinte unique de 128 bits, permettant     " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "de vérifier l'intégrité d'un message ou fichier.                         " + JAUNE + "║");

        System.out.println(JAUNE + "║      " + BLANC + SOULIGNE + "- Hashage SHA-256 : " + BLANC + "L'algorithme SHA-256 génère une empreinte unique de    " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "256 bits à partir d'un message, offrant une vérification fiable de       " + JAUNE + "║");
        System.out.println(JAUNE + "║      " + BLANC + "son intégrité avec un haut niveau de sécurité.                           " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                                               ║");
        System.out.println(JAUNE + "║" + GRAS + CYAN_CLAIR + "El Crackito 3000!                                                              " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                                               ║");

        // Affiche les options de navigation
        System.out.println(JAUNE + "║" + BLANC + " 1. " + BLEU + ITALIQUE + "Revenir au menu principal                                                  " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + ROUGE + ITALIQUE + "Quitter                                                                    " + JAUNE + "║");
        System.out.println(JAUNE + "╚═══════════════════════════════════════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        if (scanner.hasNextInt()) { // Vérifie si la prochaine entrée de l'utilisateur est un entier
            int choix = scanner.nextInt(); // Lit l'entier saisi par l'utilisateur et le stocke dans la variable `choix`

            switch (choix) {
                case 1: // Revenir au menu principal
                    MenuPrincipal.afficherMenu();
                    break;
                case 2: // Quitter le menu / l'app
                    System.out.println(VERT + "Merci d'avoir utilisé " + GRAS + CYAN_CLAIR + "El Crakito 3000 " + VERT + "!");
                    System.exit(0);
                    break;
                default: // Message d'erreur pour un choix non valide
                    System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
                    afficherMenu();
            }
        } else { // Message d'erreur pour un choix non valide
            System.out.println(ROUGE + "Option invalide. Veuillez réessayer.");
            afficherMenu();
        }

        // Ferme le scanner pour libérer les ressources
        scanner.close();
    }
}