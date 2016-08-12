package zadachki;

/**
 * Created by Николай on 03.08.2016.
 */
import java.util.Scanner;
public class ttt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 4){
                System.out.print(i);
            }
        }
    }
}
//    String s = sc.nextLine();
//        for(int i=0; i < s.length(); i++) {
//        if(s.charAt(i) == ' ') {
//        System.out.println(i);
//        }
//        }