package electroDevices;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Николай on 15.10.2016.
 */
public class App {
    /**
     * Массив для электро приборов.
     */
    private int countElectroDevaices = 0;// кол электро дивайсов

    private final static Scanner sc = new Scanner(System.in);

    private final static Random r = new Random();

    /*
    точка входа в программу
     */
    public static void main(String[] args) {

    }

    //Меню для выбора девайсов которые вы хотите подключить к сети
    public void minu() {
        boolean isOn = false;
        int operator;
        String s = sc.nextLine();
        while (!isOn) {
            System.out.println("Какие вы хотети включить электро приборы:");
            System.out.println("1 - Вы хотите включить микроволновку");
            System.out.println("2 - Вы хотите включить компютер");
            System.out.println("3 - Вы хотите включить стиральную Машинку");
            System.out.println("4 - Вы хотите включить все или отключенными");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(sc.next());
                switch (operator){
                    case 1:
                        OfAndOfTheMicrowave();
                        break;
                    case 2:
                        OfAndOfThelopTop();
                        break;
                    case 3:
                        OfAndOfTheWashingMachine();
                        break;
                    case 4:
                        OfAndOfAllDevices();
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }catch (NumberFormatException e){
                System.out.println("Неверные данные");
            }
        }
    }

    //Метод для включения в сеть микроволновки
    public void OfAndOfTheMicrowave() {
        System.out.println("Если хотите подлуключить микроволновку к розетки, напишите (да) если нет, напишите(нет)");
        String s = sc.nextLine();
        Microwave microwave = new Microwave();
        while (true) {
            if (equals("да")) {
                microwave.setSocket(true);
            } else if (equals("нет")) {
                microwave.setSocket(false);
            }
            else throw new IllegalArgumentException("Неверные данные");
        }
    }
    //Метод для включения в сеть компютера
    public void OfAndOfThelopTop() {
        System.out.println("Если хотите подлуключить компютер к розетки, напишите (да) если нет, напишите(нет)");
        String s = sc.nextLine();
        lopTop lopTop = new lopTop();
        while (true) {
            if (equals("да")) {
                lopTop.setSocket(true);
            } else if (equals("нет")) {
                lopTop.setSocket(false);
            }
            else throw new IllegalArgumentException("Неверные данные");
        }
    }
    //Метод для включения в сеть стреальной машинки
    public void OfAndOfTheWashingMachine() {
        System.out.println("Если хотите подлуключить стиральную машинку к розетки, напишите (да) если нет, напишите(нет)");
        String s = sc.nextLine();
        WashingMachine washingMachine = new WashingMachine();
        while (true) {
            if (equals("да")) {
                washingMachine.setSocket(true);
            } else if (equals("нет")) {
                washingMachine.setSocket(false);
            }
            else throw new IllegalArgumentException("Неверные данные");
        }
    }
    //включить все электро приборы
    public void OfAndOfAllDevices(){
        System.out.println("Если хотите включить все електро приборы, напишите (да) если нет, напишите(нет)");
        String s = sc.nextLine();
        ElectroDevices electroDevices = new ElectroDevices();
        while (true) {
            if (equals("да")) {
                electroDevices.setSocket(true);
            } else if (equals("нет")) {
                electroDevices.setSocket(false);
            }
            else throw new IllegalArgumentException("Неверные данные");
        }
    }

    static Microwave createMicrowave(){
        Microwave microwave = new Microwave();
        microwave.setPowerElectroDevices(r.nextInt(200)+150);
        microwave.setColor("Серебристый");
        microwave.setWidth(r.nextInt(70)+50);
        microwave.setHeight(r.nextInt(50)+30);
        return microwave;
    }

    static lopTop createLopTop(){
        lopTop lopTop = new lopTop();
        lopTop.setPowerElectroDevices(r.nextInt(200)+150);
        lopTop.setColor("Черный");
        lopTop.setWidth(r.nextInt(70)+50);
        lopTop.setHeight(r.nextInt(70)+50);
        return lopTop;
    }

    static WashingMachine createWashingMachine(){
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.setPowerElectroDevices(r.nextInt(200)+150);
        washingMachine.setColor("Белый");
        washingMachine.setWidth(r.nextInt(100)+80);
        washingMachine.setHeight(r.nextInt(100)+80);
        return washingMachine;
    }

}
