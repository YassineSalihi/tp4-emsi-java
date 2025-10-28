package exercice3;

import java.util.Scanner;

// Exception personnalisée
class NombreHorsIntervalleException extends Exception {
    public NombreHorsIntervalleException(String message) {
        super(message);
    }
}

public class ZeroCent {

    // ⚠️ Le main doit être "public static void main(String[] args)"
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez un entier : ");
        int nombre = sc.nextInt();

        try {
            verifierIntervalle(nombre);
            System.out.println("✅ Le nombre " + nombre + " est dans l'intervalle [0, 100].");
        } catch (NombreHorsIntervalleException e) {
            System.out.println("❌ " + e.getMessage());
        }

        sc.close();
    }

    // Méthode pour vérifier l'intervalle
    public static void verifierIntervalle(int n) throws NombreHorsIntervalleException {
        if (n < 0 || n > 100) {
            throw new NombreHorsIntervalleException("Le nombre " + n + " est hors de l’intervalle [0, 100] !");
        }
    }
}
