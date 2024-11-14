import Menus.MenuPrincipal;

/**
 * La classe principale qui lance l'application El Crackito 3000.
 * Elle initialise et affiche le menu principal pour permettre à l'utilisateur de naviguer
 * dans les différentes fonctionnalités du programme.
 */
public class Main {

    /**
     * Méthode principale qui démarre l'application.
     * Elle crée une instance de MenuPrincipal et appelle la méthode afficherMenu
     * pour afficher le menu principal de l'application.
     *
     * @param args les arguments de la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) throws Exception {
        MenuPrincipal menuPrincipal = new MenuPrincipal(); // Crée une instance de MenuPrincipal
        menuPrincipal.afficherMenu(); // Appelle la méthode pour afficher le menu principal
    }
}