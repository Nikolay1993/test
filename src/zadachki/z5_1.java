package zadachki;

/**
 * Created by Николай on 03.08.2016.
 */
import java.util.Scanner;
public class z5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Угадайте число заданное программой");
        System.out.println("Введите число от -10 до 10");
        int user;
        int prog = (int) (Math.random() * 21)-10;
        int summ = 1;
        do {
            user = sc.nextInt();
            if (user == prog) {
                System.out.println("Вы угодали");
            } else {
                if (user > 0 && user <= 10 || user>=-10 && user <0) {
                    System.out.println("вы не угадали");
                    if (prog < user) {
                        System.out.println("Ваше число меньше");
                    } else {
                        System.out.println("ваше число больше");
                    }

                } else {
                    System.out.println("Ваше число не из нужного отрезка");
                }
           }
            if(user != prog){
                summ+=1;
            }
            if(prog<0){
                System.out.println("Ваше число с отрицательным знаком");
            }else{
                System.out.println("Ваше число с положительным знаком");
            }

        } while (user != prog);
        System.out.println("Количество попыток за которое вы угодали = "+summ);
        System.out.println("Досвидание");
    }
}
