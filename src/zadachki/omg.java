package zadachki;

import java.util.Scanner;

/**
 * Created by Николай on 31.07.2016.
 */
public class omg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a > b && a > c) {
            System.out.println("a " + a);
        } else if (b > a && b > c) {
            System.out.println("b " + b);

        } else  {
            System.out.println("c " + c);
        }
    }
}