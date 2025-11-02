package exercice4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Exception InputMismatchException;

    public static void saisirChoix(int n) {
        //n = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre un nombre compris entre 1 et " + n + " : ");
        //int userNb = sc.nextInt();
        try {
            int userNb = sc.nextInt();

            if (userNb < 1)
                throw new NegativeSidesException();

            if (userNb > n)
                throw new GreaterThanException();

            System.out.println("Vous avez saisi : " + userNb);
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Vous avez saisi une chaîne de caractères au lieu d’un nombre.");
        } catch (NegativeSidesException e) {
            System.out.println("Erreur : Vous avez saisi un nombre inférieur à 1.");
        } catch (GreaterThanException e) {
            System.out.println("Erreur : Vous avez saisi un nombre supérieur à " + n + ".");
        }
    }

    public static void main() {

        System.out.println("S) Saisir un entier : ");
        System.out.println("L) Load cargo from dock <stackIndex>");
        System.out.println("U) Unload cargo from ship <srcStackIndex>");
        System.out.println("M) Move cargo between stacks <srcStackIndex> <dstStackIndex>");
        System.out.println("K) Clear dock");
        System.out.println("P) Print ship stacks");
        System.out.println("S) Search for cargo <name>");
        System.out.println("Q) Quit");

        String options = null;                         // Giving options null is redundant
        Scanner scan = new Scanner(System.in); // Capturing the input
        do {
            System.out.println("===== Selectionner un choix ====");
            options = scan.nextLine();
            switch (options) {
                case "S":
                    System.out.println("enter n : ");
                    int n = scan.nextInt();
                    saisirChoix(n);
                    // do what you want
                    break;
                case "L":
                    // do what you want
                    break;
                case "U":
                    // do what you want
                    break;
                case "M":
                    break;
                // Add the rest of your cases
            }
        } while (!options.equals("Q")); // quitting the program
    }
}
