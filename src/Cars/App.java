package Cars;
        import java.util.Random;

/**
 * Created by Николай on 22.08.2016.
 */
public class App {
    private static Cars[] cars;
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
        cars = new Cars[10];
        for (int i = 0; i<cars.length;i++){
            Cars car = new Cars();
            car.setBrand(brand[r.nextInt(7)]);
            car.setModel(model[r.nextInt(6)]);
            car.setYearManufacture(r.nextInt(26)+1990);
            car.setColor(color[r.nextInt(8)]);
            car.setPrice((r.nextInt(20000)+1000));
            car.setRegistrationNumber(registrationNumber());
            cars[i]=car;
        }
    }

    public static String registrationNumber(){
        Random r = new Random();
        String a,b; a = ""; b = "";
        String[] regist = {"AX", "ВМ", "АВ", "ВТ", "АА", "АЕ", "АР"} ;
        String[] registLast = {"CH","AB","ИХ","AK","BC","AA","EH"};
        a = a+regist[r.nextInt(7)];
        b+=registLast[r.nextInt(7)];
        String o1;
        o1 = regist[r.nextInt(7)] + " " + r.nextInt(999) + 1 + " " + registLast[r.nextInt(7)];
        return o1;
    }
    public static void printCarList(){
        System.out.println("Список машин");
        for(Cars c: cars){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listCar();
        printCarList();
        printListCarsBrend("Mazda");
        printlistCarsModel("A180");
        printlistCarsYrarsAndPrice(1990,2006, 5000);
    }
    public static void printListCarsBrend(String car){
        System.out.println();
        System.out.println("Список автомобилей заданной марки");
        for (Cars c: cars){
            if (c.getBrand().equals(car)){
                System.out.println(c);
            }
        }
    }
    public static void printlistCarsModel(String model){
        System.out.println();
        System.out.println("Cписок автомобилей заданной модели оторые эксплуатируються больше шести лет");
        for (Cars c: cars){
            if (c.getModel().equals(model)) {
                if (c.getYearManufacture()<=2010)
                System.out.println(c);
            }
        }
    }
    public static void printlistCarsYrarsAndPrice(int low, int hight, int price){
        System.out.println();
        System.out.println("Список автомоболей заданного года выпуска цена которых большей указанной");
        for (Cars c: cars){
            if (c.getYearManufacture()>=low && c.getYearManufacture()<=hight && c.getPrice()>=price){
                System.out.println(c);
            }
        }
    }

}