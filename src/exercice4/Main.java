package exercice4;

import java.util.InputMismatchException;
import java.util.Scanner;

// =====================
// 🔹 Exceptions perso
// =====================
class NegativeSidesException extends Exception {
    public NegativeSidesException() {
        super("Le nombre saisi est inférieur à 1");
    }
}

class GreaterThanException extends Exception {
    public GreaterThanException() {
        super("Le nombre saisi est supérieur à la limite autorisée");
    }
}

class InputMismatchCustomException extends Exception {
    public InputMismatchCustomException() {
        super("Vous avez saisi une valeur non numérique");
    }
}

// =====================
// 🔹 Classe Menu
// =====================
class Menu {
    private String[] options; // Tableau d'options du menu

    // Constructeur
    public Menu(String[] options) {
        this.options = options;
    }

    // Méthode pour afficher les options
    public void afficher() {
        System.out.println("\n===== MENU =====");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Méthode pour saisir un choix avec gestion d'exceptions
    public int saisirChoix() throws NegativeSidesException, GreaterThanException, InputMismatchCustomException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Votre choix : ");
        try {
            int choix = sc.nextInt();
            if (choix < 1)
                throw new NegativeSidesException();
            if (choix > options.length)
                throw new GreaterThanException();
            return choix;
        } catch (InputMismatchException e) {
            sc.next(); // vider le buffer
            throw new InputMismatchCustomException();
        }
    }

    // Méthode principale du menu (affiche + saisie avec répétition jusqu’à saisie correcte)
    public int executer() {
        afficher();
        int choix = -1;
        boolean ok = false;
        while (!ok) {
            try {
                choix = saisirChoix();
                ok = true;
            } catch (NegativeSidesException e) {
                System.out.println("❌ Erreur : " + e.getMessage());
            } catch (GreaterThanException e) {
                System.out.println("❌ Erreur : " + e.getMessage());
            } catch (InputMismatchCustomException e) {
                System.out.println("❌ Erreur : " + e.getMessage());
            }
        }
        System.out.println("✅ Vous avez choisi : " + options[choix - 1]);
        return choix;
    }
}

// =====================
// 🔹 Programme principal
// =====================
public class Main {
    public static void main(String[] args) {

        // --- Menu 1 : Opérations principales ---
        String[] menuPrincipal = {
                "Ajouter un élément",
                "Modifier un élément",
                "Supprimer un élément",
                "Quitter"
        };
        Menu m1 = new Menu(menuPrincipal);
        int choix1 = m1.executer();

        // --- Menu 2 : Choix de langue ---
        String[] menuLangues = {
                "Français",
                "Anglais",
                "Espagnol"
        };
        Menu m2 = new Menu(menuLangues);
        int choix2 = m2.executer();

        // --- Menu 3 : Choix du niveau ---
        String[] menuNiveaux = {
                "Débutant",
                "Intermédiaire",
                "Avancé"
        };
        Menu m3 = new Menu(menuNiveaux);
        int choix3 = m3.executer();

        // --- Résumé final ---
        System.out.println("\n=== RÉSUMÉ DE VOS CHOIX ===");
        System.out.println("Menu principal : " + menuPrincipal[choix1 - 1]);
        System.out.println("Langue choisie : " + menuLangues[choix2 - 1]);
        System.out.println("Niveau choisi : " + menuNiveaux[choix3 - 1]);

        System.out.println("\n✅ Fin du programme. Merci !");
    }
}
