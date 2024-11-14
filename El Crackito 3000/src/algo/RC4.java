package algo;

import Menus.MenuPrincipal;

import java.util.Base64;
import java.util.Scanner;

import static utils.AnsiCouleurs.*;

public class RC4 {

    public static void RC4Menu() throws Exception {
        // Affichage du menu pour l'option LFSR
        Scanner scanner = new Scanner(System.in);
        System.out.println(JAUNE + "╔══════════════════════════════════════════════════╗");
        System.out.println(JAUNE + "║" +ORANGE + "                      RC4                       "+ JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "║" + BLANC + " 1. " + VERT + "Chiffrer un message " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 2. " + VERT + "Déhifrer un message " + JAUNE + "║");
        System.out.println(JAUNE + "║" + BLANC + " 3. " + ROUGE + "Retour au menu principal                      " + JAUNE + "║");
        System.out.println(JAUNE + "║                                                  ║");
        System.out.println(JAUNE + "╚══════════════════════════════════════════════════╝");
        System.out.print(BLEU + "Choisissez une option : ");

        // Lecture du choix de l'utilisateur
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
                case 3:
                    System.out.println("Vous avez choisi de retourner au menu principal");
                    MenuPrincipal.afficherMenu(); // Retour au menu principal
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi une option valide");
                    break;
            }
        } else {
            System.out.println("Vous n'avez pas choisi une option valide");
        }
    }

    private final byte[] S = new byte[256];
    private final byte[] T = new byte[256];
    private final int keylen;

    public RC4(final byte[] key) {
        if (key.length < 1 || key.length > 256) {
            throw new IllegalArgumentException(
                    "key must be between 1 and 256 bytes");
        } else {
            keylen = key.length;
            for (int i = 0; i < 256; i++) {
                S[i] = (byte) i;
                T[i] = key[i % keylen];
            }
            int j = 0;
            for (int i = 0; i < 256; i++) {
                j = (j + S[i] + T[i]) & 0xFF;
                byte temp = S[i];
                S[i] = S[j];
                S[j] = temp;
            }
        }
    }

    public byte[] encrypt(final byte[] plaintext) {
        final byte[] ciphertext = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        for (int counter = 0; counter < plaintext.length; counter++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            byte temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            t = (S[i] + S[j]) & 0xFF;
            k = S[t];
            ciphertext[counter] = (byte) (plaintext[counter] ^ k);
        }
        return ciphertext;
    }

    public byte[] decrypt(final byte[] ciphertext) {
        return encrypt(ciphertext);  // Le déchiffrement utilise la même méthode que le chiffrement
    }

    public static void ChiffrerTexte() throws Exception {
        System.out.println("Veuillez saisir un texte à chiffrer (appuyez sur Entrée pour terminer) : ");
        Scanner texte = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();

        // Lire toutes les lignes, y compris les sauts de ligne
        while (true) {
            String line = texte.nextLine();
            if (line.equals("FIN")) {
                break;  // Sortir de la boucle lorsque l'utilisateur tape "FIN"
            }
            inputText.append(line).append("\n");  // Ajouter la ligne et un saut de ligne
        }

        byte[] plaintext = inputText.toString().getBytes(); // Convertit le texte en bytes, y compris les sauts de ligne

        System.out.println("Veuillez saisir la clé pour chiffrer : ");
        Scanner cleScanee = new Scanner(System.in);
        byte[] cle = cleScanee.nextLine().getBytes(); // Convertit la clé en bytes

        RC4 rc4Encrypt = new RC4(cle);
        byte[] ciphertext = rc4Encrypt.encrypt(plaintext);

        // Encodage en Base64 pour faciliter l'affichage du texte chiffré
        System.out.println("Texte chiffré (en Base64) : " + Base64.getEncoder().encodeToString(ciphertext));

        RC4Menu();
    }

    public static void DechiffrerTexte() throws Exception {
        System.out.println("Veuillez saisir un texte à déchiffrer (Base64) : ");
        Scanner texte = new Scanner(System.in);
        String base64Ciphertext = texte.nextLine(); // Lire le texte chiffré en Base64
        byte[] ciphertext = Base64.getDecoder().decode(base64Ciphertext); // Décoder en bytes

        System.out.println("Veuillez saisir la clé pour déchiffrer : ");
        Scanner cleScanee = new Scanner(System.in);
        byte[] cle = cleScanee.nextLine().getBytes(); // Convertit la clé en bytes

        RC4 rc4Decrypt = new RC4(cle);
        byte[] decryptedText = rc4Decrypt.decrypt(ciphertext);

        // Affiche le texte déchiffré, y compris les sauts de ligne
        System.out.println("Texte déchiffré : " + new String(decryptedText));
        RC4Menu();
    }

}
