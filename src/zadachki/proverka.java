package zadachki;

import java.util.Random;

/**
 * Created by Николай on 24.08.2016.
 */
public class proverka {
    public static void main(String[] args) {
        Random r = new Random();
        int a ;
        for (int i = 0; i < 10; i++) {
            boolean toggle = false;
            a = r.nextInt(10) + 1;
            if (a != a) {
                toggle = true;
                System.out.println(a);
            }
        }
    }
}
