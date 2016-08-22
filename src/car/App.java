package Car;

import java.util.Random;

/**
 * Created by Николай on 22.08.2016.
 */
public class App {
    private static Car[] cars;
    private static final String[] brand = {
            "BMW",
            "Mercedes",
            "Fort",
            "Mazda",
            "Lada",
            "Nissan",
            "Porshe"
    };
    private static final String[]model ={
            "A180",
            "Е320",
            "S540",
            "B220",
            "A420",
            "С180"
    };
    private static final String[] color = {
            "Black",
            "White",
            "Silver",
            "Yellow",
            "Orange",
            "Red",
            "Blue",
            "Green"
    };
    public static void listCar(){
        Random r = new Random();
        cars = new Car[10];
        for (int i = 0; i<cars.length;i++){
            Car car = new Car();
            car.setBrand(brand[r.nextInt(7)]);
            car.setModel(model[r.nextInt(6)]);
            car.setYearManufacture(r.nextInt(26)+1900);
            car.setColor(color[r.nextInt(8)]);
            car.setPrice((r.nextInt(20000)+1000)+"$");
//            car.setRegistrationNumber(RegistrationNumberlist());
            cars[i]=car;
        }
    }
    public static void RegistrationNumberlist(){
        Random r = new Random();
        String a,b; a = ""; b = "";
        String[] regist = {"AX", "ВМ", "АВ", "ВТ", "АА", "АЕ", "АР"} ;
        String[] registLast = {"CH","AB","ИХ","AK","BC","AA","EH"};
        a = a+regist[r.nextInt(7)];
        b+=registLast[r.nextInt(7)];
        String o1;
        Car[] arr = new Car[10];
        for (int i = 0; i<arr.length;i++) {
            o1 = regist[r.nextInt(7)] + " " + r.nextInt(999) + 1 + " " + registLast[r.nextInt(7)];
            System.out.println(o1);
        }
    }
}
