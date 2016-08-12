package zadachki;

import java.util.Scanner;

/**
 * Created by Николай on 03.08.2016.
 */
public class z4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        for (int i = 4; i < 5; i++) {
            if (s.length()>=5 && s.length()<=5){
                System.out.print(s.toUpperCase());
            }
//        }
    }
}
