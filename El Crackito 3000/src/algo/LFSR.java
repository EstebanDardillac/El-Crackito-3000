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
    private String Graine; // Graine initiale pour le LFSR
    private int position; // Position du bit de retour dans le registre

    /**
     * Affiche le menu de l'option LFSR où l'utilisateur peut choisir de générer
     * des nombres pseudo-aléatoires ou retourner au menu principal.
     */
    public static void LFSRMenu() throws Exception {
        // Affichage du menu pour l'option LFSR
        Scanner scanner = new Scanner(System.in);
        System.out.println(JAUNE + "╔══════════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "                      " + GRAS + SOULIGNE + "LFSR" + BLANC + "                        "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Regénerer un ou des nombres pseudos aléaoires " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + ROUGE + "Retour au menu principal                      " + JAUNE + "║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        // Lecture du choix de l'utilisateur
        if(scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    // Si l'utilisateur choisit de régénérer des nombres pseudo-aléatoires
                    System.out.println("Vous avez choisi de regenérer des nombres Pseudos-aléatoires");
                    GenererPseudo(); // Appel de la méthode pour générer les nombres
                    break;
                case 2:
                    // Si l'utilisateur choisit de retourner au menu principal
                    System.out.println("Vous avez choisi de retourner au menu principal");
                    MenuPrincipal.afficherMenu(); // Retour au menu principal
                    break;
                default:
                    // Si l'utilisateur entre une option invalide
                    System.out.println("Vous n'avez pas choisi une option valide");
                    break;
            }
        } else {
            // Si l'entrée n'est pas un entier, on affiche un message d'erreur
            System.out.println("Vous n'avez pas choisi une option valide");
        }
    }

    // Constructeur pour initialiser la graine et la position du tap
    public LFSR(String newSeed, int newTap) {
        Graine = newSeed;
        position = newTap;
    }

    // Retourne l'état actuel du registre sous forme de chaîne de caractères
    public String toString() {
        return Graine;
    }

    /**
     * Effectue une étape du LFSR en calculant un XOR entre le bit le plus à gauche
     * et le bit à la position définie par le tap. Le registre est mis à jour à chaque étape.
     *
     * @return le bit généré par l'étape (0 ou 1)
     */
    public int etape() {
        int longueur = Graine.length(); // Récupère la longueur de la graine
        int bitGauche = Graine.charAt(0) - '0'; // Récupère le bit le plus à gauche
        int bitPosition = Graine.charAt(longueur - position - 1) - '0'; // Récupère le bit à la position du tap
        int bit = bitGauche ^ bitPosition; // Applique l'opération XOR pour générer un nouveau bit

        // Met à jour la graine en décalant à gauche et ajoutant le nouveau bit
        Graine = Graine.substring(1) + bit;

        return bit; // Retourne le nouveau bit calculé
    }

    /**
     * Génère un nombre entier constitué de 'k' bits pseudo-aléatoires à partir du LFSR.
     *
     * @param k le nombre de bits à générer
     * @return l'entier correspondant aux 'k' bits générés
     */
    public int generate(int k) {
        int integer = 0; // Variable pour accumuler l'entier

        // Génère k bits pseudo-aléatoires et les place dans un entier
        for(int i = k-1; i >= 0; i--) {
            int bit = etape(); // Obtient un bit du LFSR
            integer += bit * Math.pow(2, i); // Ajoute le bit dans la position correcte de l'entier
        }

        return integer; // Retourne l'entier généré
    }

    /**
     * Cette méthode permet à l'utilisateur de spécifier combien de nombres pseudo-aléatoires
     * il souhaite générer et de quelle longueur. Elle vérifie que les entrées sont valides.
     */
    public static void GenererPseudo() throws Exception {

        // Affiche une aide sur la génération de nombres pseudo-aléatoires
        System.out.println(JAUNE + "╔═════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "              " + GRAS + SOULIGNE + "LFSR" + BLANC + "               "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "║" + ORANGE + "     Pour plus d'info sur le     "+ JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "   génération nombres pseudos    "+ JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "    aléatoires aller dans la     "+ JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "      rubrique aide dans le      "+ JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "         menu principale         "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                 ║");
        System.out.println(JAUNE + "╚═════════════════════════════════╝");

        // Demande à l'utilisateur combien de nombres il souhaite générer (max 200)
        System.out.println("Veuillez saisir combien de nombres pseudos-aléatoires que vous désirez (max: 200)");

        Scanner scanner = new Scanner(System.in);

        // Vérifie que l'utilisateur entre un entier pour le nombre de nombres à générer
        if (!scanner.hasNextInt()) {
            System.out.println(ROUGE + "Entrée invalide, retour au menu principal.");
            MenuPrincipal.afficherMenu(); // Retour au menu principal en cas d'entrée invalide
            return;
        }
        int choix = scanner.nextInt(); // Récupère le nombre de nombres à générer

        // Vérifie si le nombre est trop élevé
        if (choix > 200) {
            System.out.println(ROUGE + "Votre nombre de pseudos-aléatoires est trop élevé");
            MenuPrincipal.afficherMenu();
            return;
        }

        // Demande à l'utilisateur de saisir la longueur des nombres à générer
        System.out.println("Veuillez saisir un nombre");

        // Vérifie que l'utilisateur entre un entier pour la longueur des nombres
        if (!scanner.hasNextInt()) {
            System.out.println(ROUGE + "Entrée invalide, retour au menu principal.");
            MenuPrincipal.afficherMenu(); // Retour au menu principal en cas d'entrée invalide
            return;
        }
        int nombreAGenerer = scanner.nextInt(); // Récupère la longueur des nombres à générer

        // Vérifie si la longueur est trop élevée
        if (nombreAGenerer > 256) {
            System.out.println(ROUGE + "Votre nombre de bits est trop élevé");
            MenuPrincipal.afficherMenu();
            return;
        }

        // Crée un objet LFSR avec une graine et un tap définis, puis génère les nombres
        LFSR lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < choix; i++) {
            int r = lfsr.generate(nombreAGenerer); // Génère un nombre pseudo-aléatoire
            System.out.println(lfsr + " " + r); // Affiche l'état du registre et le nombre généré
        }

        LFSRMenu(); // Retourne au menu LFSR après la génération
    }
}
