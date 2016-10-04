package Flowershop;

/**
 * Created by Николай on 02.10.2016.
 */
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class App {
    /**
     * Массив для хранения букетов.
     */
    private static Bouquet[] bouquets = new Bouquet[10];

    /**
     * Кол-во букетов в массиве.
     */
    private static int countBouquets = 0;

    private final static Scanner scanner = new Scanner(System.in);

    private final static Random random = new Random();

    /**
     * Minu
     */
    public static void main(String[] args) {
        int operator;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Создать букет");
            System.out.println("2 - Посмотреть готовые букеты");
            System.out.println("3 - Выйти");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        createBouquetMenu();
                        break;
                    case 2:
                        selectBouquetMenu();
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
     * Метод создает букет и добавляет его в массив.
     */
    static void createBouquetMenu() {
        boolean isReady = false;
        while (!isReady) {
            try {
                Bouquet bouquet = new Bouquet();
                bouquet.setFlowers(initializeFlowersMenu());
                bouquet.setAccessories(initializeAccessoriesMenu());
                System.out.println("Стоимость букета " + bouquet.getCost() + " USD");
                addBouquet(bouquet);
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Метод для добавления букета в массив.
     * Массив являетсяя расширяемым контейнером.
     *
     * @param bouquet букет для добавления.
     */
    static void addBouquet(Bouquet bouquet) {
        if (countBouquets >= bouquets.length) {
            int newLength = (bouquets.length * 3) / 2 + 1;
            bouquets = Arrays.copyOf(bouquets, newLength);
        }
        bouquets[countBouquets++] = bouquet;
    }

    /**
     * Метод для создания массива цветов.
     * Пользователь задает кол-во цветов.
     *
     * @return массив цветов.
     */
    static Flower[] initializeFlowersMenu() {
        System.out.println("Введите кол-во цветов:");
        System.out.print("--> ");
        int countOfFlowers = Integer.parseInt(scanner.next());
        if (countOfFlowers < 1) {
            throw new IllegalArgumentException("В букете должен быть хотя бы один цветок!");
        }
        Flower[] flowers = new Flower[countOfFlowers];
        for (int i=0;i<countOfFlowers;i++) {
            flowers[i] = selectFlowerMenu(i + 1);
        }
        return flowers;
    }

    /**
     * Меню для выбора конкретного цветка.
     *
     * @param counter порядковый номер цветка.
     * @return выыбранный цветок.
     */
    static Flower selectFlowerMenu(final int counter) {
        int operator;
        while (true) {
            System.out.println("Выберете цветок " + counter + ":");
            System.out.println("1 - Роза");
            System.out.println("2 - Ромашка");
            System.out.println("3 - Лилия");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1: return initializeFlower(new Rose());
                    case 2: return initializeFlower(new Camomile());
                    case 3: return initializeFlower(new Lily());
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            }
        }
    }

    /**
     * Метод для инициализации конкретного цветка.
     * Пользователь задает цвет, а стоимость, свежесть и длина стебля
     * задаются рандомно.
     *
     * @param flower переданный тип цветка.
     * @return инициализированный цветок.
     */
    static Flower initializeFlower(Flower flower) {
        System.out.println("Введите цвет:");
        System.out.print("--> ");
        flower.setColor(scanner.next());
        flower.setCost(random.nextInt(10) + 5);
        flower.setRecency(random.nextInt(12) + 1);
        flower.setStemLength(random.nextInt(30) + 1);
        return flower;
    }

    /**
     * Метод для создания массива аксессуаров.
     * Пользователь задает кол-во аксессуаров.
     *
     * @return массив аксессуаров.
     */
    static Accessories[] initializeAccessoriesMenu() {
        System.out.println("Введите кол-во аксессуаров:");
        System.out.print("--> ");
        int countOfAccessories = Integer.parseInt(scanner.next());
        if (countOfAccessories < 0) {
            throw new NumberFormatException();
        } else if (countOfAccessories == 0) {
            System.out.println("Букет без аксессуаров!");
            return new Accessories[0];
        }
        Accessories[] accessories = new Accessories[countOfAccessories];
        for (int i=0;i<countOfAccessories;i++) {
            accessories[i] = selectAccessoryMenu(i + 1);
        }
        return accessories;
    }

    /**
     * Меню для выбора аксессуара для букета.
     *
     * @param counter порядковый номер аксессуара в конкретном букете.
     * @return выбранный аксессуар.
     */
    static Accessories selectAccessoryMenu(final int counter) {
        int operator;
        while (true) {
            System.out.println("Выберете аксессуар " + counter + ":");
            System.out.println("1 - Ленточка");
            System.out.println("2 - Оберточная бумага");
            System.out.println("3 - Оберточная клеенка");
            System.out.println("4 - Веточка");
            System.out.println("5 - Веревочка");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1: return Accessories.TAPE;
                    case 2: return Accessories.PAPER;
                    case 3: return Accessories.MEMBRANE;
                    case 4: return Accessories.BRANCH;
                    case 5: return Accessories.ROPE;
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            }
        }
    }

    /**
     * Меню для выбора букета из уже созданных.
     */
    static void selectBouquetMenu() {
        if (countBouquets == 0) {
            throw new IllegalArgumentException("Пока не создано ни одного букета!");
        }
        System.out.println("Выберите индекс букета:");
        for (int i=0;i<countBouquets;i++) {
            System.out.println("букет " + (i + 1));
        }
        int selection = 0;
        boolean isReady = false;
        while (!isReady) {
            System.out.print("--> ");
            try {
                selection = Integer.parseInt(scanner.next());
                if (selection > countBouquets || selection < 0) throw new NumberFormatException();
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные! Повторите попытку.");
            }
        }
        bouquetManagementMenu(bouquets[selection - 1]);
    }

    /**
     * Меню для вывода информации о  конкретном букете.
     *
     * @param bouquet переданный букет.
     */
    static void bouquetManagementMenu(Bouquet bouquet) {
        int operator;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Вывести все цветы отсортированные по свежести");
            System.out.println("2 - Найти цветок в букете с заданной длиной стебля");
            System.out.println("3 - Посчитать цену букета");
            System.out.println("4 - Вернуться в главное меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        bouquet.sortOnRecency();
                        bouquet.printFlowers();
                        break;
                    case 2:
                        searchFlowersOnStemLengthMenu(bouquet);
                        break;
                    case 3:
                        System.out.println("Стоимость букета " + bouquet.getCost() + " USD");
                        break;
                    case 4:
                        isReady = true;
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
     * Меню для задания диапазона и поиска по нему в букете
     * цветов с соответствующими длинами стеблей.
     *
     * @param bouquet переданный букет.
     */
    static void searchFlowersOnStemLengthMenu(Bouquet bouquet) {
        System.out.println("Введите диапазон длины стебля");
        System.out.print("от: ");
        int from = Integer.parseInt(scanner.next());
        System.out.print("до: ");
        int before = Integer.parseInt(scanner.next());
        if (from < 0 || before > 30 || from > before) {
            throw new IllegalArgumentException("Таких цветов нет!");
        }
        bouquet.printFlowersWithLength(from, before);
    }
}
