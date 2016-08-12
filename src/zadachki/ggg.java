package zadachki;

import java.util.Scanner;

/**
 * Created by Николай on 31.07.2016.
 */
public class ggg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа для оброботки в программе то число которое будет ближе к 10 выведится на экран");
        int a = sc.nextInt();
        System.out.println("первое чисо");
        int b = sc.nextInt();
        System.out.println("второе число");
        if (a >= 10 && a < b) {
            System.out.println("первое число ближайшие к 10 = " + a);
        }
            else if (a <= 10 && a > b) {
                System.out.println("первое число ближайшие к 10 = " + a);
            }else System.out.println("второе число ближайшие к 10 = " + b);
//            } else System.out.println("второе число ближайшие к 10 = " + b);
        }
    }

