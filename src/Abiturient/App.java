package Abiturient;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Николай on 18.08.2016.
 */
public class App {
private static Abiturient[]abiturients;
    private static final String[] name = {
            "Вася",
            "Петя",
            "Гриша",
            "Юра",
            "Миша",
            "Гена",
            "Никита",
            "Евгений"
    };
    private static final String[] lastName = {
            "Иванов",
            "Гончаренко",
            "Гонеев",
            "Полбин",
            "Бражник",
            "Брусенцов",
            "Поляк",
            "Ковалев"
    };
    private static final String[] middleName = {
            "Юрьевич",
            "Сергеевич",
            "Александрович",
            "Петрович",
            "Сергеевич",
            "Григорьевич",
            "Владимирович",
            "Николаевич"
    };
    private static final String[] address = {
            "просп. Гагарина, 41/2",
            "ул. Полевая, 67",
            "просп. Московский, 54а",
            "ул. Якира, 124",
            "ул. Достоевского, 5",
            "ул. Академика Павлова, 120",
            "просп. Победы, 46-а",
            "ул. Малогончаровская, 28/30"
    };
 public static void abiturientsList(){
     Random r = new Random();
     abiturients = new Abiturient[8];
     for(int i = 0; i<abiturients.length; i++){
         Abiturient abiturient = new Abiturient();
         abiturient.setName(name[r.nextInt(8)]);
         abiturient.setLastName(lastName[r.nextInt(8)]);
         abiturient.setMiddleName(middleName[r.nextInt(8)]);
         abiturient.setAddress(address[r.nextInt(8)]);
         abiturient.setPhoneNumber("+38063"+(((int) (Math.random()*1000000)+1)));
         abiturient.setEstimates(r.nextInt(4)+2);
         abiturients[i]= abiturient;
     }
 }
 public static void printListAbiturients(){
     System.out.println("Список абитуриентов");
     for(Abiturient c: abiturients){
         System.out.println(c);
     }
 }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
        abiturientsList();
        printListAbiturients();
        printListAbiturientsInSummEstimatesLowAndHig(3,4,3);
    }
    public static void printListAbiturientsInSummEstimatesLowAndHig(int low, int hig, int middle){
        System.out.println();
        System.out.println("Абитуриенты у которых оценки меньше заданной");
        for(Abiturient c: abiturients){
            if(c.getEstimates()<low){
                System.out.println(c);
            }
        }
        System.out.println();
        System.out.println("Абитуриенты у которых оценки соответствует заданной");
        for(Abiturient c: abiturients){
            if(c.getEstimates()>=hig){
                System.out.println(c);
            }
        }
        System.out.println();
        System.out.println("Абитуриенты у которых оценки полупроходимые ");
        for(Abiturient c: abiturients){
            if(c.getEstimates()==middle){
                System.out.println(c);
            }
        }

    }


}
