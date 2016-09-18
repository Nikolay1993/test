package zadachki;

import java.util.Scanner;

/**
 * Created by Николай on 04.09.2016.
 */
public class toggle {
    public static void main(String[] args) {
        int num;
        boolean isPrime;
        Scanner sc= new Scanner(System.in);
        num = sc.nextInt();
        if (num < 2) isPrime = false;
        else isPrime = true;

        for (int i = 2; i <= num / i; i++) {
            if ((num % i) == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Четное");
            isPrime = false;
        } else {
            System.out.println("He простое число");
            isPrime = true;
        }
    }
    }
