package algo;

import Menus.MenuPrincipal;

import java.text.Normalizer;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;
import static utils.AnsiCouleurs.JAUNE;

/**
 * Génère une source de bits qui semblent aléatoires pour tout attaquant.
 * Utilise un registre à décalage à rétroaction linéaire (LFSR).
 */

public class LFSR {
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    private String Graine; // graine initiale
    private int position; // position du bit de retour

    public static void LFSRMenu() throws Exception {

        // Affichage du menu
        Scanner scanner = new Scanner(System.in);
        System.out.println(JAUNE + "╔══════════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" +ORANGE + "                      LFSR                        "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Regénerer un ou des nombres pseudos aléaoires " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + ROUGE + "Retour au menu principal                      " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        // Récupération du choix de l'utilisateur
        if(scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi de regenérer des nombres Pseudos-aléatoires");
                    GenererPseudo(); // Envoie true pour chiffrer le texte
                    break;
                case 2:
                    System.out.println("Vous avez choisi de retourner au menu principal");
                    MenuPrincipal.afficherMenu(); // Envoie false pour déchiffrer le texte
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi une option valide");
                    break;
            }
        } else {
            System.out.println("Vous n'avez pas choisi une option valide");
        }


    }

    // Constructeur
    public LFSR(String newSeed, int newTap) {
        Graine = newSeed;
        position = newTap;
    }

    // Retourne une chaîne de caractères représentant les valeurs du registre.
    public String toString() {
        return Graine;
    }

    // Calcule le XOR du bit le plus à gauche et du bit de retour.
    public int  etape() {
        int longueur = Graine.length();
        int bitGauche = Graine.charAt(0) - '0'; // bit le plus à gauche
        int bitPosition = Graine.charAt(longueur - position - 1) - '0'; // bit à la position du tap
        int bit = bitGauche ^ bitPosition; // opération XOR pour obtenir le nouveau bit

        Graine = Graine.substring(1) + bit; // mise à jour du registre

        return bit; // retourne le nouveau bit calculé
    }

    // Retourne k bits pseudo-aléatoires encodés en entier.
    public int generate(int k) {
        int integer = 0;

        for(int i = k-1; i >= 0; i--) {
            int bit = etape();
            integer += bit * Math.pow(2, i); // ajoute le bit dans la position correspondante
        }

        return integer; // retourne l'entier représentant les k bits générés
    }

    public static void GenererPseudo() throws Exception {

        System.out.println(JAUNE + "╔═════════════════════════════════╗");
        System.out.println(JAUNE + "║" +ORANGE + "              LFSR               "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" +ORANGE + "     Pour plus d'info sur le     "+ JAUNE + "║");
        System.out.println(JAUNE + "║" +ORANGE + "   génération nombres pseudos    "+ JAUNE + "║");
        System.out.println(JAUNE + "║" +ORANGE + "    aléatoires aller dans la     "+ JAUNE + "║");
        System.out.println(JAUNE + "║" +ORANGE + "      rubrique aide dans le      "+ JAUNE + "║");
        System.out.println(JAUNE + "║" +ORANGE + "         menu principale         "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "╚═════════════════════════════════╝");

        System.out.println("Veuillez saisir combien de nombres pseudos-aléatoires que vous désirez (max: 200)");

        // Vérification si l'entrée est un entier
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println(ROUGE + "Entrée invalide, retour au menu principal.");
            MenuPrincipal.afficherMenu(); // Retour au menu principal si l'entrée n'est pas un entier
            return;
        }
        int choix = scanner.nextInt();

        if (choix > 200) {
            System.out.println(ROUGE + "Votre nombre de pseudos-aléatoires est trop élevé");
            MenuPrincipal.afficherMenu();
            return;
        }

        System.out.println("Veuillez saisir un nombre");

        // Vérification si l'entrée est un entier
        if (!scanner.hasNextInt()) {
            System.out.println(ROUGE + "Entrée invalide, retour au menu principal.");
            MenuPrincipal.afficherMenu(); // Retour au menu principal si l'entrée n'est pas un entier
            return;
        }
        int nombreAGenerer = scanner.nextInt();

        if (nombreAGenerer > 256) {
            System.out.println(ROUGE + "Votre nombre de bits est trop élevé");
            MenuPrincipal.afficherMenu();
            return;
        }

        // Génération des nombres pseudo-aléatoires
        LFSR lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < choix; i++) {
            int r = lfsr.generate(nombreAGenerer);
            System.out.println(lfsr + " " + r); // affiche l'état du registre et l'entier généré
        }

        LFSRMenu(); // Retour au menu LFSR après la génération
    }

}
