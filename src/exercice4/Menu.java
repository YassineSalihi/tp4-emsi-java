package exercice4;

import java.util.InputMismatchException;
import java.util.Scanner;


// ===============================
//  Exceptions personnalisées
// ===============================
class InvalidMenuSizeException extends Exception {
    public InvalidMenuSizeException(String message) {
        super(message);
    }
}

class NegativeSidesException extends Exception {
    public NegativeSidesException(String message) {
        super(message);
    }
}

class GreaterThanException extends Exception {
    public GreaterThanException(String message) {
        super(message);
    }
}

class NotANumberException extends Exception {
    public NotANumberException(String message) {
        super(message);
    }
}

public class Menu {

    private static Exception InputMismatchException;

    public static int saisirChoix(int n)
            throws InvalidMenuSizeException, NotANumberException {
        if (n <= 1) {
            throw new InvalidMenuSizeException("Le menu doit contenir au moins deux choix !");
        }

        Scanner sc = new Scanner(System.in);
        int userNb;

        while (true) {
            System.out.print("Entrez un nombre compris entre 1 et " + n + " : ");

            try {
                userNb = sc.nextInt();

                if (userNb < 1)
                    throw new NegativeSidesException("Le nombre doit être supérieur ou égal à 1.");

                if (userNb > n)
                    throw new GreaterThanException("Le nombre doit être inférieur ou égal à " + n + ".");

                // Si on arrive ici, la saisie est correcte
                System.out.println("✅ Vous avez saisi : " + userNb);
                return userNb;

            } catch (InputMismatchException e) {
                sc.next(); // vider la mauvaise saisie
                throw new NotANumberException("Vous devez entrer un nombre, pas une chaîne de caractères !");
            } catch (NegativeSidesException | GreaterThanException e) {
                System.out.println("❌ Erreur : " + e.getMessage());
            }
        }
    }

    public static void afficherMenu(String[] choix){
        System.out.println("\n=== MENU ===");
        for (int i = 0; i < choix.length; i++) {
            System.out.println((i + 1) + ". " + choix[i]);
        }
        System.out.println("============");
    }

    public static void main() {

        String[] options = {
                "Ajouter un élément",
                "Modifier un élément",
                "Supprimer un élément",
                "Afficher la liste",
                "Quitter"
        };

        try {
            afficherMenu(options);
            int choix = saisirChoix(options.length);
            System.out.println("Votre choix final est : " + options[choix - 1]);
        } catch (InvalidMenuSizeException | NotANumberException e) {
            System.out.println("❌ Erreur : " + e.getMessage());
        }


    }
}
