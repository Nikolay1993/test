package trein_Task0_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/**
 * Created by Николай on 19.09.2016.
 */
public class App {

    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    static Train [] arrayOfTrains = new Train[10];
    static int trainCount; // Счетчик поездов
    static int quantityOfCoupe; // Количество вагонов - купе
    static int quantityOfPK; // Количесто плац-карт вагонов

    public static void main(String[] args) {
        int operator;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Создать поезд");
            System.out.println("2 - Информация о поезде");
            System.out.println("3 - Показать все поезда");
            System.out.println("4 - Выйти");
            System.out.print("--> ");
            try{
                int userChoice = Integer.parseInt(sc.next());

                switch(userChoice){
                    case 1 : createTrain(); break;
                    case 2 : trainInfo();  break;
                    case 3 : showAllTrains(); break;
                }

            }catch(NumberFormatException e){
                System.out.println("Введены неверные данные ");
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void createTrain(){
        System.out.println("Выберите тип поезда");
        System.out.println("1. Экспресс");
        System.out.println("2. Пассажирский");

        try {
            int userChoice = Integer.parseInt(sc.next());

            switch (userChoice){
                case 1:  createExpress(); break;
                case 2 : createPassengerTrain();break;
            }
        }catch(NumberFormatException e){
            System.out.println("Попробуйте еще раз");
        }catch(IllegalArgumentException e){
            System.out.println("Введены неверные данные");
        }
    }

    /*
    Метод создает пассажирский поезд, заполняет его нужным количеством вагонов
    */
    public static void createPassengerTrain(){
        checkCarriageQuantity();
        Train trainPassenger = new Train(quantityOfCoupe,quantityOfPK);
        fillArrayWithTrains(trainPassenger);

        for(int i=0; i < trainPassenger.getCarriageCoupeQuantity(); i ++){
            Carriage carriageCoupe = new Carriage(Carriage.CarriageType.TYPE_COUPE, i + 1,
                    getRandomPassengers(), 3);
            trainPassenger.addCarriages(carriageCoupe);
        }
        for(int y = trainPassenger.getCarriageCoupeQuantity();
            y <trainPassenger.getCarriagePKQuantity() + trainPassenger.getCarriageCoupeQuantity(); y++){

            Carriage carriagePK = new Carriage(Carriage.CarriageType.TYPE_PLACKART, y + 1,
                    getRandomPassengers(), 2);
            trainPassenger.addCarriages(carriagePK);
        }
    }

    public static void checkCarriageQuantity(){
        boolean onStart = false;
        System.out.println("Внимание! Максимальное количество вагонов - 15. Минимальное - 5");
        while (!onStart){
            int maxQuantity = 0;// максимально кол-во вагонов в поезде
            System.out.println("Введите количество вагонов - купе");
            quantityOfCoupe = Integer.parseInt(sc.next());
            maxQuantity+=quantityOfCoupe;
            System.out.println("Введите количество вагонов плац-карт");
            quantityOfPK = Integer.parseInt(sc.next());
            maxQuantity+=quantityOfPK;
            if(maxQuantity<5 || maxQuantity >15){
                System.out.println("Неверное количество вагонов. Попробуйте еще раз");
            }
            else{
                onStart = true;
            }

        }
    }
    /*
    Метод заполняет массив поездами.
    В случае если длинны массива не хватает метод увеличивает его на 10 элементов
    */
    public static void fillArrayWithTrains(Train train){
        if(trainCount>=arrayOfTrains.length){
            arrayOfTrains = Arrays.copyOf(arrayOfTrains, trainCount + 10);
        }
        arrayOfTrains[trainCount++] = train;
    }
    /*
    Метод возвращает количество вагонов,которое не может быть меньше 5
    и больше 15
    */
    public static int getExpressCarriageQuantity(){
        System.out.println("Введите количество вагонов, в вашем поезде. ВНИМАНИЕ. Вагонов не может быть меньше 5 или больше 15");
        while(true){  try{
            int userChoice = Integer.parseInt(sc.next());
            if(userChoice>=5 && userChoice <=15){
                return userChoice;
            } else{
                throw new IllegalArgumentException();
            }

        }catch(IllegalArgumentException e){
            System.out.println("Введены неверные данные");
        }

        }
    }
    public static int getRandomComfortLevel(){
        int comfortLevel = r.nextInt(5);
        while(comfortLevel<=3){
            comfortLevel = r.nextInt(5);
        }
        return comfortLevel;

    }

    /*
   Метод предоставляет пользователю выбрать нужный поезд. И возвращает число,
   которое является индексом нужного поезда в массиве arrayOfTrains
   */

    public static int chooseTrain(){
        System.out.println("Выберите поезд");
        for(int i =0; i < trainCount; i++){
            System.out.println((i+1)+ " Поезд." + arrayOfTrains[i]);
        }
        int userChoice = Integer.parseInt(sc.next());
        if(userChoice>0 && userChoice<=trainCount){
            return userChoice -1;
        }
        else{
            throw new IllegalArgumentException("Поезда под таким номером не существует");
        }
    }

    /*
   Метод выводит массив всех поездов
   */
    public static void showAllTrains(){
        for(int i =0; i < trainCount; i ++){
            System.out.println("Поезд " + (i+1) +"." + arrayOfTrains[i]);
        }
    }

    /*
   Метод предоставляет пользователю меню для просмотра информации про поезд
   */
     /*
    Метод находит вагоны с заданным диапазоно пассажиров
    */
    public static void passengersInRange(Train train){
        String range = "";
        int from; // от
        int to; // до
        boolean onStart = false;

        while(!onStart){
            System.out.println("Через дефис напишите диапазон пассажиров. В таком виде: n-n");
            range = sc.next();
            String []split = range.split("-");
            from = Integer.parseInt(split[0]);
            to = Integer.parseInt(split[1]);
            for(int i = 0 ; i < train.getCarriageQuantity(); i ++){
                if(train.getArrayOfCarriages()[i].getQuantityBaggage()>=from
                        && train.getArrayOfCarriages()[i].getQuantityBaggage()<=to){
                    System.out.println(train.getArrayOfCarriages()[i]);
                }
            }
            onStart = true;
        }

    }
    public static void sortOnComfortLevel(Train train){
        Arrays.sort(train.getArrayOfCarriages());
        train.showAllCarriages();
    }
    /*
    Метод, который находит общее количество пассажиров в поезде
    */
    public static void showQuantityOfPAssengers(Train train){
        int allPassengers = 0; // Все пассажиры поезда
        for(int i =0 ; i < train.getCarriageQuantity(); i ++){
            allPassengers += train.getArrayOfCarriages()[i].getQuantityPassangers();
        }
        System.out.println("Общее количество пассажиров в поезде: " + allPassengers);
    }
    /*
    Метод, который находит общее количество багажа в поезде
    */
    public static void showQuantityOfBaggage(Train train){
        int allBaggage = 0; //Общее количество багажа
        for(int i = 0; i < train.getCarriageQuantity(); i ++){
            allBaggage += train.getArrayOfCarriages()[i].getQuantityBaggage();
        }
        System.out.println("Общее количество багажа в поезде: " + allBaggage);
    }
    public static void trainInfo(){
        if(trainCount ==0){
            throw new IllegalArgumentException("Пока не создано ни одного поезда");
        }
        Train train = arrayOfTrains[chooseTrain()];
        System.out.println("1. Показать все вагоны поезда");
        System.out.println("2. Найти в поезде вагоны с заданным диапазоном пассажиров");
        System.out.println("3. Отсортировать вагоны на основе уровня комфортности");
        System.out.println("4. Посчитать общую численность пассажиров ");
        System.out.println("5. Подсчитать общее число багажа");
        try{
            int userChoice = Integer.parseInt(sc.next());

            switch(userChoice){
                case 1 : train.showAllCarriages();break;
                case 2 : passengersInRange(train);break;
                case 3 : sortOnComfortLevel(train); break;
                case 4 : showQuantityOfPAssengers(train); break;
                case 5 : showQuantityOfBaggage(train); break;
            }
        }catch(NumberFormatException e){
            System.out.println("Попробуйте еще раз");
        }catch(IllegalArgumentException e){
            System.out.println("Неверные данные");
        }
    }
    /*
    Метод возвращяет количество пассажиров, которое может быть только в диапазоне 15-50
    */
    public static int getRandomPassengers(){
        int passengers = r.nextInt(50);
        while(passengers<=15){
            passengers = r.nextInt(50);
        }
        return passengers;

    }

    public static void createExpress(){
        Train trainExpress = new Train(getExpressCarriageQuantity());
        fillArrayWithTrains(trainExpress);
        for(int i =0 ; i < trainExpress.getCarriageQuantity(); i ++){
            Carriage carriageExpress = new Carriage(Carriage.CarriageType.TYPE_EXPRESS, i + 1,getRandomPassengers(),getRandomComfortLevel());
            trainExpress.addCarriages(carriageExpress);
        }
    }
}


