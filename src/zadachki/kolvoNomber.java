package zadachki;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Николай on 04.08.2016.
 */
public class kolvoNomber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user;
        int summ = 0;
        int summ2 = 0;
        boolean toggle = false;
        System.out.println("Введите число");
        do {
            user = sc.nextInt();
            System.out.println("Введите число");
            summ += user;
                if (user > 1 && user <=99) {
                    user = 1;
                    summ2 += user;
            }

        }while(user != 100);
            System.out.println(summ);
            System.out.println(summ2);
    }
}
