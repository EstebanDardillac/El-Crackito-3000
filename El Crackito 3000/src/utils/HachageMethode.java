package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HachageMethode {

    /**
     * Calcule le hash MD5 ou SHA-256 d'un message donné.
     *
     * @param message Le message dont on souhaite calculer le hash.
     * @return Le hash type (MD5 ou SHA-256) sous forme de chaîne hexadécimale.
     * @throws NoSuchAlgorithmException Si l'algorithme type (MD5 ou SHA-256) n'est pas disponible.
     */
    public static String hacher(String message, String type) throws NoSuchAlgorithmException {
        // Obtient une instance de l'algorithme selon le type (MD5 ou SHA-256)
        MessageDigest md = MessageDigest.getInstance(type);
        // Calcule le hash du message en tant que tableau de bytes
        byte[] hashBytes = md.digest(message.getBytes());

        // Convertit les bytes du hash en format hexadécimal pour lisibilité
        StringBuilder hashHex = new StringBuilder();
        for (byte b : hashBytes) {
            hashHex.append(String.format("%02x", b));
        }

        return hashHex.toString();
    }
}
