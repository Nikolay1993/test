package trein_Task0_1;

/**
 * Created by Николай on 19.09.2016.
 */
public class Train {

    private final int carriageQuantity; // Общее количество вагонов
    private  final int carriageCoupeQuantity; // Количество вагонов купе
    private final int carriagePKQuantity; // Количество вагонов плац-карт
    private int coupeCount; // Счетчик вагонов купе
    private int pkCount; // Счетчик вагонов плац-карт
    private int expressCount; // Счетчик вагонов экспресс
    public final TrainType trainType;
    private Carriage[] arrayOfCarriages; // Массив вагонов
    private int carriageCount; // Счетчик вагонов поезда

    public Carriage[] getArrayOfCarriages() {
        return arrayOfCarriages;
    }
    /*
   Конструктор для создания экспресс поезда
   */
    public Train(int carriageCoupeQuantity, int carriagePKQuantity){
        trainType = TrainType.TYPE_PASSENGER;
        this.carriageCoupeQuantity=carriageCoupeQuantity;
        this.carriagePKQuantity=carriagePKQuantity;
        carriageQuantity = carriagePKQuantity + carriageCoupeQuantity;
        arrayOfCarriages = new Carriage[carriageQuantity];
    }
    /*
   Конструктор для создания пассажирского поезда
   */
    public Train(int carriageQuantity){
        trainType = TrainType.TYPE_EXPRES;
        this.carriageQuantity = carriageQuantity;
        this.carriageCoupeQuantity = 0;
        this.carriagePKQuantity = 0;
        arrayOfCarriages = new Carriage[carriageQuantity];
    }

    public static enum TrainType{
            TYPE_PASSENGER,TYPE_EXPRES;

        @Override
        public String toString() {
            switch (this){
                case TYPE_PASSENGER:return "Пассажирский";
                case TYPE_EXPRES:return "Экспресс";
                default: throw new IllegalArgumentException();
            }
        }
    }

    public int getCarriageQuantity() {
        return carriageQuantity;
    }
    /*
     Метод добавляет определенный вагон в массив вагонов поезда
     */
    public void addCarriages(Carriage carriage){
        arrayOfCarriages[carriageCount++] = carriage;
    }
    /*
    Метод выводит все вагоны данного поезда
    */
    public void showAllCarriages(){
        for(int i =0; i < carriageCount; i ++){
            System.out.println(arrayOfCarriages[i]);
        }
    }

    @Override
    public String toString() {
        return " Тип:" + trainType + "; Количество вагонов: " + carriageQuantity;
    }

    public int getCarriageCoupeQuantity() {
        return carriageCoupeQuantity;
    }

    public int getCarriagePKQuantity() {
        return carriagePKQuantity;
    }
}
