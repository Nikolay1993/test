package Phone;

import java.util.Random;
import java.util.Arrays;
/**
 * Created by Николай on 20.08.2016.
 */
public class App {
    private static Phone[] phones;
    private static final String[] lastName = {
            "Иванов ",
            "Гончаренко ",
            "Гонеев ",
            "Полбин ",
            "Бражник ",
            "Брусенцов ",
            "Поляк ",
            "Ковалев "
    };
    private static final String [] name={
            "Вася ",
            "Петя ",
            "Гриша ",
            "Юра ",
            "Миша ",
            "Гена ",
            "Никита ",
            "Евгений "
    };
    private static final String[] middleName={
            "Юрьевич ",
            "Сергеевич ",
            "Александрович ",
            "Петрович ",
            "Сергеевич ",
            "Григорьевич ",
            "Владимирович ",
            "Николаевич "
    };
    private static final String[] addres={
            "просп. Гагарина, 41/2",
            "ул. Полевая, 67",
            "просп. Московский, 54а",
            "ул. Якира, 124",
            "ул. Достоевского, 5",
            "ул. Академика Павлова, 120",
            "просп. Победы, 46-а",
            "ул. Малогончаровская, 28/30"
    };
    public static void listPhone(){
        Random r = new Random();
        phones = new Phone[10];
        for (int i = 0; i<phones.length; i++){
            Phone phone = new Phone();
            phone.setLastName(lastName[r.nextInt(8)]);
            phone.setName(name[r.nextInt(8)]);
            phone.setMiddleName(middleName[r.nextInt(8)]);
            phone.setAddress(addres[r.nextInt(8)]);
            phone.setNumberCreditCart("2345446"+(((int) (Math.random()*2345)+1)));
            phone.setDebit(r.nextInt(1000)+1);
            phone.setCredit(r.nextInt(1000)+1);
            phone.setTimeCityconversation(r.nextInt(200)+1);
            phone.setTimeInternationalCalls(abonentListTimeInternational());
            phones[i]= phone;

        }
    }
    public static void printlistPhone(){
        Arrays.sort(phones);
        System.out.println("Cписок Абонентов");
        for (Phone c: phones){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listPhone();
        printlistPhone();
        printListAbonentTimeCity(100);
        printlistTimeInternationalCalls();
    }
        public static void printListAbonentTimeCity(int maxTime){
            System.out.println();
            System.out.println("Свединие об абонентах у которых время внутри городских разговоров привышает заданное");
            Arrays.sort(phones);
            for (Phone c: phones){
                if(c.getTimeCityconversation()>=100){
                    System.out.println(c);
                }
            }
        }
        public static void printlistTimeInternationalCalls() {
            System.out.println();
            System.out.println("Сведение об обонентах которые пользовались загородной связью");
                for (Phone c: phones){
                    if(c.getTimeInternationalCalls()>1){
                        System.out.println(c);
                    }
                }
        }
        public static int abonentListTimeInternational(){
                int a = (int)(Math.random() * 100) + 1;
                if (50 > a) {
                return a;
            }else return 0;

        }
}
