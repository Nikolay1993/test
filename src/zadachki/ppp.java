package zadachki;

import java.util.Scanner;

/**
 * Created by Николай on 31.07.2016.
 */
public class ppp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 2 целых числа : ");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a-b);
        }else System.out.println("числа не целые");
    }
}