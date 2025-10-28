package exercice1;

import java.util.Scanner;

public class Division {
    static int[] tableau = {17, 12, 15, 38, 29, 157, 89, -22, 0, 5};

    static int division (int indice,int diviseur) {
//        if (diviseur == 0){
//            throw new ArithmeticException("cannot Divide By 0 : My exception");
//        }
        try {
            return tableau[indice] / diviseur;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Yassine said: Don't divide a number by zero");
        }catch (ArrayIndexOutOfBoundsException exception){
            throw new ArrayIndexOutOfBoundsException("Yassine said: choose less than 10.");
        }
    }

        public static void main (String[] args) {
            int x, y;
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez l’indice de l’entier à diviser: ");
            x = sc.nextInt();
            System.out.println ("Entrez le diviseur: ");
            y = sc.nextInt();
            sc.close();
            System.out.println ("Le résultat de la division est: ");
            System.out.println (division(x,y));
    }
 }

