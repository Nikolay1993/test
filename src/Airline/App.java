package Airline;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by Николай on 28.08.2016.
 */
public class App {
    private static Airline[] airlines;
    public static final String[] destination ={
            "Киев",
            "Льевов",
            "Харьков",
            "Донецк",
            "Днепропетровск",
            "Луганск",
            "Запороже",
            "Крым",
            "Одесса"
    };
    public static final String[] aircraftType ={
            "Пассажирский",
            "Частный"
    };
    public static final String[] dayOfTheWeek ={
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенья"
    };
    public static void listAirline(){
        Random r = new Random();
        airlines = new Airline[10];
        for (int i = 0; i<airlines.length;i++){
            Airline airline = new Airline();
            airline.setDestination(destination[r.nextInt(9)]);
            airline.setFlightNumber(r.nextInt(20)+1);
            airline.setAircraftType(aircraftType[r.nextInt(2)]);
            airline.setDepartureTime(generateDate());
            airline.setDayOfTheWeek(dayOfTheWeek[r.nextInt(7)]);
            airlines[i]=airline;
        }
    }

    public static String generateDate() {
        Random rand = new Random();
        return  (rand.nextInt(24) + 1) +
                "," + (rand.nextInt(60) + 1);
    }

    public static void printListAirline(){
        System.out.println("Список самолетов");
        for(Airline c: airlines){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listAirline();
        printListAirline();
        printListDestination("Харьков");
        printListOfTheDey("Пятница");
        printListDestinationAndTime("Киев",2);
    }

    public static void printListDestination(String destination){
        System.out.println();
        System.out.println("Список рейсов для заданного пункта назначения");
        for(Airline c: airlines){
            if(c.getDestination().equals(destination)){
                System.out.println(c);
            }
        }
    }

    public static void printListOfTheDey(String dey){
            System.out.println();
            System.out.println("Список рейсов заднного дня недели");
            for(Airline c: airlines){
                if(c.getDayOfTheWeek().equals(dey)){
                    System.out.println(c);
                }
            }
    }

    public static void printListDestinationAndTime(String destination, int time){
        System.out.println();
        System.out.println("Список рейсов для заданного дня недели время для которых больше заданного");
        for(Airline c: airlines){
            if(c.getDayOfTheWeek().equals(destination)){
                int timeAirline = c.getDepartureTime().get(Calendar.HOUR);
                if(timeAirline>time){
                    System.out.println(c);
                }
            }
        }
    }
}
