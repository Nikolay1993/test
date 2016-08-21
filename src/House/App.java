package House;

import java.util.Random;

/**
 * Created by Николай on 20.08.2016.
 */
public class App {
    private static House[] houses;
    private static final String[] street = {
            " ул. Гагарина",
            " ул. Полевая",
            " ул. Московския",
            " ул. Якира",
            " ул. Достоевского",
            " ул. Академика Павлова",
            " ул. Научная",
            " ул. Малогончаровская"
    };
    private static final String[] buildingType = {
            "Новострой",
            "Сталинка",
            "Хрущевка"
    };
    public static void listHouse(){
        Random r = new Random();
        houses = new House[10];
        for(int i = 0; i<houses.length;i++){
            House house = new House();
            house.setNumberApartment(r.nextInt(100)+1);
            house.setPloshchad(r.nextInt(70)+30);
            house.setFloor(r.nextInt(5)+1);
            house.setKolchestvoRooms(r.nextInt(5)+1);
            house.setStreet(street[r.nextInt(8)]);
            house.setBuildingType(buildingType[r.nextInt(3)]);
            house.setEffectiveLife(r.nextInt(50)+1);
            houses[i]=house;
        }
    }
    public static void printListHouse(){
        System.out.println("Список квартир");
        for (House c: houses){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listHouse();
        printListHouse();
        printListRoom(3);
        printListRoomOfFloor(3,5,2);
        printListRoomOfPloshad(70);
    }
    public static void printListRoom(int room){
        System.out.println();
        System.out.println("Список квартир с заданным количеством комнат");
        for(House c: houses){
            if(c.getKolchestvoRooms()==room){
                System.out.println(c);
            }
        }
    }
    public static void printListRoomOfFloor(int floorlow, int floorhight, int room){
        System.out.println();
        System.out.println("Cписок квартир расположинх на этоже с заданным количеством комнат");
        for (House c: houses){
            if(c.getFloor()>=floorlow && c.getFloor()<=floorhight && c.getKolchestvoRooms()==room){
                System.out.println(c);
            }
        }
    }
    public static void printListRoomOfPloshad(int room){
        System.out.println();
        System.out.println("Список квартир имеющих заданную площадь");
        for (House c: houses){
            if(c.getPloshchad()>=room){
                System.out.println(c);
            }
        }
    }
}
