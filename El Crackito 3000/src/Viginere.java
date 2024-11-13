import java.text.Normalizer;
import java.util.Scanner;

public class Viginere {

    // Méthode de normalisation du texte pour retirer tous les caractères spéciaux, chiffres et accents
    public static String normalizeText(String text) {
        // Normalise le texte pour retirer les accents et les caractères spéciaux
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        // Garde uniquement les lettres alphabétiques (en retirant tout caractère non alphabétique)
        text = text.replaceAll("[^a-zA-Z]", "");
        // Convertit le texte en minuscules pour simplifier le chiffrement
        return text.toLowerCase();
    }

    // Méthode principale pour chiffrer et déchiffrer le texte avec la méthode de Vigenère
    public static void viginere() throws Exception {
        String texteAChiffrer; // Texte à chiffrer
        String cle; // Clé de chiffrement
        Scanner saisieUtilisateurCle = new Scanner(System.in); // Objet Scanner pour obtenir les entrées de l'utilisateur
        Scanner saisieUtilisateurTexteAChiffrer = new Scanner(System.in); // Objet Scanner pour obtenir les entrées de l'utilisateur

        // Demande à l'utilisateur de saisir le texte à chiffrer
        System.out.println("Veuillez saisir le texte à chiffrer :");
        texteAChiffrer = saisieUtilisateurTexteAChiffrer.nextLine();

        // Vérifie si le texte contient des sauts de ligne, et redemande une entrée correcte si c'est le cas
        while (texteAChiffrer.contains("\n") || texteAChiffrer.isEmpty()) {
            System.out.println("\nCe mode de chiffrement ne prend pas en compte les sauts de lignes.");
            System.out.println("Veuillez entrer un texte sans saut de ligne :");
            texteAChiffrer = saisieUtilisateurTexteAChiffrer.nextLine();
        }

        // Normalise le texte pour le préparer au chiffrement (sans accents ni caractères spéciaux)
        texteAChiffrer = normalizeText(texteAChiffrer);
        System.out.println("Texte après normalisation : " + texteAChiffrer);

        // Demande à l'utilisateur de saisir la clé de chiffrement
        System.out.println("Veuillez saisir la clé :");
        cle = saisieUtilisateurCle.next();
        // Normalise la clé pour s'assurer qu'elle ne contient que des lettres minuscules
        cle = normalizeText(cle);
        System.out.println("Clé après normalisation : " + cle);

        // Variables pour le texte chiffré et déchiffré
        String texteADechiffrer = ""; // Contiendra le texte chiffré
        String texteDechiffre = "";   // Contiendra le texte déchiffré

        // Variables pour les lettres spécifiques lors du chiffrement et déchiffrement
        char lettreAChiffrer, lettreCle, lettreChiffree, lettreDechiffree;
        int size = texteAChiffrer.length(); // Longueur du texte à chiffrer
        int i;

        // Affiche un message indiquant que le chiffrement commence
        System.out.println("On chiffre le texte");
        // Chiffrement du texte avec la méthode de Vigenère
        for (i = 0; i < size; i++) {
            // Récupère la lettre actuelle du texte à chiffrer
            lettreAChiffrer = texteAChiffrer.charAt(i);

            // Récupère la lettre de la clé, en répétant la clé si nécessaire (via modulo)
            lettreCle = cle.charAt(i % cle.length());

            // Calcule la lettre chiffrée en utilisant la formule de Vigenère
            lettreChiffree = (char) (((lettreAChiffrer - 96) + (lettreCle - 96)) % 26 + 96);

            // Ajoute la lettre chiffrée au texte chiffré (texteADechiffrer)
            texteADechiffrer += lettreChiffree;
        }
        // Affiche le texte chiffré
        System.out.println("Texte chiffré : " + texteADechiffrer);

        // Affiche un message indiquant que le déchiffrement commence
        System.out.println("On déchiffre le texte");
        // Déchiffrement du texte
        for (i = 0; i < size; i++) {
            // Récupère la lettre chiffrée actuelle
            lettreChiffree = texteADechiffrer.charAt(i);

            // Récupère la lettre de la clé, en répétant la clé si nécessaire (via modulo)
            lettreCle = cle.charAt(i % cle.length());

            // Calcule la lettre déchiffrée en utilisant la formule de déchiffrement de Vigenère
            lettreDechiffree = (char) (((lettreChiffree - 96) - (lettreCle - 96) + 26) % 26 + 96);

            // Ajoute la lettre déchiffrée au texte déchiffré (texteDechiffre)
            texteDechiffre += lettreDechiffree;
        }
        // Affiche le texte déchiffré pour vérifier que le déchiffrement fonctionne
        System.out.println("Texte déchiffré : " + texteDechiffre);
    }
}
