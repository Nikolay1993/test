package Train;

import java.util.Random;
import java.util.Calendar;

/**
 * Created by Николай on 24.08.2016.
 */
public class App {
    private static Trains[] trainses;
    public static final String[] destination = {
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

    public static void listTriens() {
        Random r = new Random();
        trainses = new Trains[10];
        for (int i = 0; i < trainses.length; i++) {
            Trains trains = new Trains();
            trains.setDestination(destination[r.nextInt(9)]);
            trains.setNumberOfTrein(r.nextInt(10) + 1);
            trains.setTimeOfDeparture(generateDate());
            trains.setPlatitude(r.nextInt(500)+1);
            trains.setKupe(r.nextInt(50)+20);
            trains.setPlacart(r.nextInt(50)+20);
            trains.setLusks(r.nextInt(40)+10);
            trainses[i]= trains;

        }
    }

    public static String generateDate() {
        Random rand = new Random();
        return (rand.nextInt(31) + 1) +
                "," + (rand.nextInt(24) + 1) +
                "," + (rand.nextInt(60) + 1);
    }

    public static void printlistTreins(){
        System.out.println("Список поездов");
        for(Trains c: trainses){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listTriens();
        printlistTreins();
        printListTreinDestination("Харьков");
        printlistTreinDestinationAndTimeOfDeparture("Киев",5);
        printListSvobodnihMest("Крым", 3);
    }

    public static void printListTreinDestination(String destination){
        System.out.println();
        System.out.println("Список поездов следующих до заданного пункта назначения");
        for(Trains c: trainses){
            if(c.getDestination().equals(destination)){
                System.out.println(c);
            }
        }
    }

   public static void printlistTreinDestinationAndTimeOfDeparture(String destination, int time){
       System.out.println();
       System.out.println("Список поездво следующих до заданного пункта назначения после заданного времени");
       for (Trains c: trainses){
           if(c.getDestination().equals(destination)){
               int trainsTime = c.getTimeOfDeparture().get(Calendar.HOUR);
               if(trainsTime>time){
                   System.out.println(c);
               }
           }
       }
   }

   public static void printListSvobodnihMest(String  destination,int mest){
       System.out.println();
       System.out.println("Список поездов до заданного направления и имеющие свободные места");
       for (Trains c:trainses){
           if(c.getDestination().equals(destination)){
               if(c.getKupe()>mest){
                   System.out.println(c);
               }
           }
       }
   }

}
