package taxistation;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Николай on 03.09.2016.
 */
public class App {
    /**
     * Массив хранит все созданные пользователем таксопарки.
     */
    private static TaxiStation[] taxiStations = new TaxiStation[10];

    /**
     * Кол-во созданных таксопарков.
     */
    private static int countTaxiStation = 0;

    private static Scanner scanner = new Scanner(System.in);

    private static Random random = new Random();

    /**
     * Главное меню.
     */
    public static void main(String...args) {
        int operator;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Создать таксопарк");
            System.out.println("2 - Управлять таксопарками");
            System.out.println("3 - Выйти");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        createTaxiStationMenu();
                        break;
                    case 2:
                        printAllTaxiStations();
                        break;
                    case 3:
                        isExit = true;
                        break;
                    default:
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * Меню для создания таксопарка.
     */
    static void createTaxiStationMenu() {
        boolean isReady = false;
        while (!isReady) {
            try {
                System.out.println("Введите название таксопарка:");
                System.out.print("--> ");
                String stationName = scanner.next();
                System.out.println("Введите кол-во мест под авто в таксопарке:");
                System.out.print("--> ");
                int countPlaces = Integer.parseInt(scanner.next());
                if (countPlaces < 1) {
                    throw new IllegalArgumentException("Должно быть минимум одно место!");
                }
                System.out.println("Введите кол-во авто для таксопарке, которое вы хотите создать сейчас:");
                System.out.print("--> ");
                int countCars = Integer.parseInt(scanner.next());
                if (countCars > countPlaces || countCars < 0) {
                    throw new NumberFormatException();
                }
                initializeTaxiStation(stationName, countPlaces, countCars);
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * Метод инициализирует один таксопарк и добавляет его
     * в массив taxiStations.
     *
     * @param stationName имя таксопарка
     * @param countPlaces кол-во место в таксопарке
     * @param countCars кол-во авто, которые будут созданны сразу.
     */
    static void initializeTaxiStation(String stationName, int countPlaces, int countCars) {
        TaxiStation taxiStation = new TaxiStation(stationName, countPlaces);
        for (int i=0;i<countCars;i++) {
            taxiStation.addCar(initializeCarMenu(i+1));
        }
        if (countTaxiStation >= taxiStations.length) {
            taxiStations = Arrays.copyOf(taxiStations, countTaxiStation + 10);
        }
        taxiStations[countTaxiStation++] = taxiStation;
    }
    /**
     * Меню для создания автомобиля с определенным типом
     * кузова.
     *
     * @param counter порядковый номер авто в таксопарке.
     * @return созданный автомобиль.
     */
    static Car initializeCarMenu(final int counter) {
        int operator;
        while (true) {
            System.out.println("Автомобиль " + counter + ":");
            System.out.println("Выберете тип кузова:");
            System.out.println("1 - Легковой автомобиль");
            System.out.println("2 - Грузовой автомобиль");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        return createSedan();
                    case 2:
                        return createVan();
                    default:
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            }
        }
    }

    /**
     * Метод создает и возвращает легковой автомобиль.
     */
    static Sedan createSedan() {
        Sedan sedan = new Sedan();
        System.out.println("Введите модель легкового авто:");
        System.out.print("--> ");
        sedan.setModel(scanner.next());
        sedan.setCost(random.nextInt(500000) + 100000);
        sedan.setSpeed(random.nextInt(150) + 150);
        sedan.setFuelConsumption(random.nextDouble() * 10 + 5);
        sedan.setCountOfSeats(random.nextInt(4) + 4);
        return sedan;
    }

    /**
     * Метод создает и возвращает грузовой автомобиль.
     */
    static Van createVan() {
        Van van = new Van();
        System.out.println("Введите модель грузовика:");
        System.out.print("--> ");
        van.setModel(scanner.next());
        van.setCost(random.nextInt(600000) + 100000);
        van.setSpeed(random.nextInt(100) + 150);
        van.setFuelConsumption(random.nextDouble() * 10 + 15);
        van.setCapacity(random.nextInt(5) + 3);
        return van;
    }

    /**
     * Метод выводит все созданные таксопарки в консоль
     * и предлагает пользывателю выбрать таксопарк для
     * управления.
     */
    static void printAllTaxiStations() {
        if (countTaxiStation == 0) {
            throw new IllegalArgumentException("Пока не создано ни одного таксопарка.");
        }
        System.out.println("Выберете таксопарк:");
        for (int i=0;i<countTaxiStation;i++) {
            System.out.println(i + 1 + " - " + taxiStations[i].getName());
        }
        int selection = 0;
        boolean isReady = false;
        while (!isReady) {
            System.out.print("--> ");
            try {
                selection = Integer.parseInt(scanner.next());
                if (selection > countTaxiStation || selection < 0) {
                    throw new NumberFormatException();
                }
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные! Повторите попытку.");
            }
        }
        controlTaxiStationMenu(selection - 1);
    }

    /**
     * Меню для управления конкретным таксопарком.
     *
     * @param indexOfStation индекс выбранного таксопарка в массиве.
     */
    static void controlTaxiStationMenu(final int indexOfStation) {
        TaxiStation taxiStation = taxiStations[indexOfStation];
        int operator;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Вывести все авто таксопарка");
            System.out.println("2 - Добавить авто в таксопарк");
            System.out.println("3 - Стоимость таксопарка");
            System.out.println("4 - Вывести авто, отсортированные по расходу топлива");
            System.out.println("5 - Найти автомобиль с заданными параметрами скорости");
            System.out.println("6 - Удалить авто из таксопарка");
            System.out.println("7 - Вернуться в предидущее меню");
            System.out.println("8 - Вернуться в главное меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        taxiStation.printCarsOfStation();
                        break;
                    case 2:
                        if (!taxiStation.isTherePlaceInStation()) {
                            throw new IllegalArgumentException("В таксопарке нет места!");
                        }
                        Car car = initializeCarMenu(taxiStation.getCountOfCarsOnStation() + 1);
                        taxiStation.addCar(car);
                        break;
                    case 3:
                        System.out.println("Стоимость таксопарка " +
                                taxiStation.getCostOfStation() + " USD");
                        break;
                    case 4:
                        taxiStation.sortOnFuelConsumption();
                        taxiStation.printCarsOfStation();
                        break;
                    case 5:
                        searchCarMenu(taxiStation);
                        break;
                    case 6:
                        removeCarMenu(taxiStation);
                        break;
                    case 7:
                        printAllTaxiStations();
                        isExit = true;
                        break;
                    case 8:
                        isExit = true;
                        break;
                    default:
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Меню, которое позволяет пользователю найти
     * конкретный автомобиль по заданному диапазону
     * скорости.
     *
     * @param taxiStation таксопарк, в котором будет
     *                    производиться поиск.
     */
    static void searchCarMenu(TaxiStation taxiStation) {
        System.out.println("Введите диапазон скорости");
        System.out.print("от: ");
        int from = Integer.parseInt(scanner.next());
        System.out.print("до: ");
        int before = Integer.parseInt(scanner.next());
        Car car = taxiStation.carWithSpecifiedSpeed(from, before);
        System.out.println("Авто с такой скоростью: " + car);
    }

    /**
     * Меню, которое позволяет удалить конкретный
     * автомобиль из таксопарка.
     *
     * @param taxiStation таксопарк, в котором будет
     *                    производиться поиск.
     */
    static void removeCarMenu(TaxiStation taxiStation) {
        System.out.println("Введите модель авто:");
        System.out.print("--> ");
        String model = scanner.next();
        if (taxiStation.removeCar(model)) {
            System.out.println("Авто удалено из таксопарка.");
        } else {
            System.out.println("Такого авто нет!");
        }
    }
}
