package Bus;

import java.util.Random;

/**
 * Created by Николай on 28.08.2016.
 */
public class App {
    private static Bus[] buses;
    public static final String[] lastNameAndInitialsToDriver ={
            "Иванов Н.Ю ",
            "Гончаренко С.В ",
            "Гонеев О.Ю ",
            "Полбин С.Н ",
            "Бражник П.Ю",
            "Брусенцов О.Г ",
            "Поляк П.В ",
            "Ковалев С.С "
    };
    public static final String[] marks = {
            "БМВ",
            "Лада",
            "Мерседес",
            "РолсРойс"
    };
    public static void listBus(){
        Random r = new Random();
        buses  = new Bus[10];
        for(int i = 0; i<buses.length;i++){
            Bus bus = new Bus();
            bus.setLastNameAndInitialsToDriver(lastNameAndInitialsToDriver[r.nextInt(8)]);
            bus.setNumberBus(r.nextInt(100)+100);
            bus.setNumberOfaRoute(r.nextInt(10)+1);
            bus.setMarks(marks[r.nextInt(4)]);
            bus.setYearOfTheBeginningOfOperation(r.nextInt(36)+1980);
            bus.setMileage(r.nextInt(10000)+1000);
            buses[i]=bus;
        }
    }
    public static void printListBus(){
        System.out.println("Cписок всех автобусов");
        for (Bus c: buses){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listBus();
        printListBus();
        printListBusAndNumberRoute(7);
        printListBusAkspoteit(2005);
        printlistBusProbeg(7000);
    }
    public static void printListBusAndNumberRoute(int route){
        System.out.println();
        System.out.println("Cписок автобусов для заданного номера маршрута");
        for(Bus c: buses){
            if(c.getNumberOfaRoute()==route){
                System.out.print(c);
            }
        }
    }
    public static void printListBusAkspoteit(int low){
        System.out.println();
        System.out.println("Cписок автобусов которые экплоатирывались больше чем надо");
        for(Bus c: buses){
            if(c.getYearOfTheBeginningOfOperation()<low){
                System.out.println(c);
            }
        }
    }
    public static void printlistBusProbeg(int low){
        System.out.println();
        System.out.println("Список автобусов у которых пробех больше чем надо");
        for(Bus c: buses){
            if(c.getMileage()>low){
                System.out.println(c);
            }
        }
    }
}
