package zadachki;

import java.util.Random;

/**
 * Created by Николай on 14.08.2016.
 */
public class dfdfdf {
    public static void main(String[] args) {

        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();
        getbirthdey();


    }
    public static void getbirthdey() {
        String birthday;
        Random rand = new Random();
        birthday = (rand.nextInt(31) + 1) + "." + (rand.nextInt(12) + 1) + "." + (rand.nextInt(6) + 1992);

            System.out.println(birthday);

    }
}
