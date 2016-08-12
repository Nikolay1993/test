package car;

/**
 * Created by Николай on 04.08.2016.
 */
        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Random;
        import java.util.Arrays;

/**
 * Created by JAVA on 29.07.2016.
 */
public class App {
    static myClass[] cars;
    static final String[] venders ={
            "audi",
            "bmw",
            "mazda",
            "lada"
    };
    static final String [] colors ={
            "red",
            "blue",
            "while",
            "oronge"
    };
    static {
        Random r = new Random();
        cars= new myClass[10];
        for(int i = 0; i<cars.length;i++){
            myClass c = new myClass();
            c.setColor(colors[r.nextInt(4)]);
            c.setEngineVolume(r.nextDouble()*100);
            c.setSeats(r.nextInt(6)+1);
            c.setVender(venders[r.nextInt(4)]);
            cars[i]= c;
        }
    }
    public static void main(String[] args) {
        print();
        Arrays.sort(cars);
        System.out.println("after sorting");
        print();
        myClass.myClassComparator comp = new myClass.myClassComparator(myClass.myClassComparator.SORTING_FIELD_VENDER);
        Arrays.sort(cars,comp);
        System.out.println("after sorting by seats");
        print();
//comp = setsSortingField()
        Arrays.sort(cars,comp);
        System.out.println("after sorting by color");
        print();

        Arrays.sort(cars,comp);
        System.out.println("after sorting by vender");
        print();

        Arrays.sort(cars,comp);
        System.out.println("after sorting by engine volume");
        print();

    }
    static void print(){
        for(myClass c: cars){
            System.out.println(c);
        }
    }
}