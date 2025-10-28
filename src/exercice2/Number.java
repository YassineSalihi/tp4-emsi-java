package exercice2;

import java.util.Scanner;

public class Number {
    static void main() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int nu = sc.nextInt();

        if (nu < 0  && (nu % 2 != 0 )){
            throw new Exception("Nombre doit être positive paire.");
        }

        System.out.println("Donner 4 nombres : ");
        int sum = 0;
        int array[] = new int[4];
       for (int i = 0; i < 4; i++){
           array[i] = sc.nextInt();
           sum = sum + array[i];
       }

        System.out.println("Somme est: " + sum);
       if (sum > 5000){
           throw new Exception("Somme dépasse 5000.");
       }

    }
}
