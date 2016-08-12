package zadachki;

import java.util.Scanner;

/**
 * Created by Николай on 31.07.2016.
 */
public class vvv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
        int i = 2;
        System.out.print("Введите целое число: ");
        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            i = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            System.out.println("Вы ввели целое число");
            if(i%2==0){
                System.out.println("Число делится на 2 : " +i);
            }else System.out.println("Число не делится на 2 : " +i);
        } else System.out.println("Вы ввели не целое число");

    }
}
