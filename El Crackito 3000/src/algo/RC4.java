package algo;

import Menus.AideMenu;
import Menus.MenuPrincipal;
import java.util.Base64;
import java.util.Scanner;
import static utils.AnsiCouleurs.*;

public class RC4 {

    // Affiche le menu pour les options de chiffrement et déchiffrement avec RC4
    public static void rc4Menu() throws Exception {
        // Initialisation d'un scanner pour les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affichage du menu RC4
        System.out.println(JAUNE + "╔══════════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" + ORANGE + "                       " + GRAS + SOULIGNE + "RC4" + BLANC + "                        " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║" + ORANGE + "  L'algorithme RC4 est un chiffrement de flux     " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "  qui génère un flot de clés pseudo-aléatoires    " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "  pour chaque octet du texte, combiné avec ce     " + JAUNE + "║");
        System.out.println(JAUNE + "║" + ORANGE + "  dernier pour produire un texte chiffré rapide.  " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Chiffrer un message                           " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Déchiffrer un message                         " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + BLEU + ITALIQUE + "Aide                                          " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 4. " + BLEU + ITALIQUE + "Retour au menu principal                      " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 5. " + ROUGE + ITALIQUE + "Quitter                                       " + JAUNE + "║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════════╝");

        System.out.print(BLEU + "Choisissez une option : ");

        // Lecture et traitement du choix de l'utilisateur
        if(scanner.hasNextInt()) {
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi de chiffrer le texte");
                    ChiffrerTexte(); // Appel de la méthode pour chiffrer
                    break;
                case 2:
                    System.out.println("Vous avez choisi de déchiffrer");
                    DechiffrerTexte(); // Appel de la méthode pour déchiffrer
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
                    System.out.println("Vous n'avez pas choisi une option valide");
                    rc4Menu();
                    break;
            }
        } else { // Message d'erreur pour un choix non valide
            System.out.println("Vous n'avez pas choisi une option valide");
            rc4Menu();
        }
    }

    // Tableaux pour la permutation S et le tableau temporaire T utilisés par l'algorithme RC4
    private final byte[] S = new byte[256];
    private final byte[] T = new byte[256];
    private final int keylen;

    // Constructeur qui initialise l'algorithme RC4 avec une clé spécifiée
    public RC4(final byte[] key) {
        if (key.length < 1 || key.length > 256) {
            throw new IllegalArgumentException("La clé doit être entre 1 et 256 octets");
        } else {
            keylen = key.length;
            // Initialisation des tableaux S et T
            for (int i = 0; i < 256; i++) {
                S[i] = (byte) i;
                T[i] = key[i % keylen];
            }
            // Permutation initiale du tableau S selon la clé
            int j = 0;
            for (int i = 0; i < 256; i++) {
                j = (j + S[i] + T[i]) & 0xFF;
                byte temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }
        }
    }

    // Méthode pour chiffrer les données avec RC4
    public byte[] encrypt(final byte[] plaintext) {
        final byte[] ciphertext = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        // Génération du flux de clé et chiffrement de chaque octet
        for (int counter = 0; counter < plaintext.length; counter++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            byte temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            t = (S[i] + S[j]) & 0xFF;
            k = S[t];
            ciphertext[counter] = (byte) (plaintext[counter] ^ k); // XOR entre le texte clair et le flux de clé
        }
        return ciphertext;
    }

    // Méthode de déchiffrement, qui est identique à la méthode de chiffrement pour RC4
    public byte[] decrypt(final byte[] ciphertext) {
        return encrypt(ciphertext);  // Le déchiffrement utilise la même méthode que le chiffrement
    }

    // Méthode pour chiffrer un texte saisi par l'utilisateur
    public static void ChiffrerTexte() throws Exception {
        System.out.println("Veuillez saisir un texte à chiffrer (Il faut écrire 'FIN' pour terminer) : ");
        Scanner texte = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();

        // Lire toutes les lignes jusqu'à ce que l'utilisateur entre "FIN"
        while (true) {
            String line = texte.nextLine();
            if (line.equals("FIN")) {
                break;  // Sortie de la boucle lorsque "FIN" est saisi
            }
            inputText.append(line).append("\n");  // Ajouter chaque ligne avec un saut de ligne
        }

        byte[] plaintext = inputText.toString().getBytes(); // Conversion du texte en tableau d'octets

        System.out.println("Veuillez saisir la clé pour chiffrer : ");
        Scanner cleScanee = new Scanner(System.in);
        byte[] cle = cleScanee.nextLine().getBytes(); // Conversion de la clé en tableau d'octets

        RC4 rc4Encrypt = new RC4(cle);
        byte[] ciphertext = rc4Encrypt.encrypt(plaintext);

        // Encodage en Base64 pour faciliter l'affichage du texte chiffré
        System.out.println("Texte chiffré (en Base64) : " + Base64.getEncoder().encodeToString(ciphertext));

        rc4Menu(); // Retour au menu RC4
    }

    // Méthode pour déchiffrer un texte saisi par l'utilisateur
    public static void DechiffrerTexte() throws Exception {
        System.out.println("Veuillez saisir un texte à déchiffrer (Base64) : ");
        Scanner texte = new Scanner(System.in);
        String base64Ciphertext = texte.nextLine(); // Lecture du texte chiffré en Base64
        byte[] ciphertext = Base64.getDecoder().decode(base64Ciphertext); // Décodage du texte Base64 en tableau d'octets

        System.out.println("Veuillez saisir la clé pour déchiffrer : ");
        Scanner cleScanee = new Scanner(System.in);
        byte[] cle = cleScanee.nextLine().getBytes(); // Conversion de la clé en tableau d'octets

        RC4 rc4Decrypt = new RC4(cle);
        byte[] decryptedText = rc4Decrypt.decrypt(ciphertext);

        // Affiche le texte déchiffré, y compris les sauts de ligne
        System.out.println("Texte déchiffré : " + new String(decryptedText));
        rc4Menu(); // Retour au menu RC4
    }
}