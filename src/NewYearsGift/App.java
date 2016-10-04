package NewYearsGift;

/**
 * Created by Николай on 02.10.2016.
 */
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class App {
    //масив для новогоднего подарка
    public static NewYearsGift[] newYearsGifts = new NewYearsGift[10];
    /**
     * Кол-во подарков в массиве.
     */
    private static int countNewYearsGifts = 0;

    private final static Scanner scanner = new Scanner(System.in);

    private final static Random random = new Random();

    //Меню
    public static void main(String[] args) {
        int operator;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Создать новогодний подарок");
            System.out.println("2 - Посмотреть готовые Подарки");
            System.out.println("3 - Выйти");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        createNewYearsGristMenu();
                        break;
                    case 2:
                        selectNewYearsGistMenu();
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
     * Метод создает подарок и добавляет его в массив.
     */
    static void createNewYearsGristMenu(){
        boolean isReady=false;
        while (!isReady)
        try{
            NewYearsGift newYearsGift = new NewYearsGift();
            newYearsGift.setCandies(initializeCandysMenu());
            System.out.println("Количество сахара в конфетах " + newYearsGift.getWeight());
            addNewYearsGift(newYearsGift);
            isReady = true;
        } catch (NumberFormatException e) {
            System.out.println("Неверные данные!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        }

    /**
     * Метод для добавления подарка в массив.
     * Массив являетсяя расширяемым контейнером.
     */
    static void addNewYearsGift(NewYearsGift newYearsGift){
        if(countNewYearsGifts>=newYearsGifts.length){
            int newlength = (newYearsGifts.length*3)/2+1;
            newYearsGifts =Arrays.copyOf(newYearsGifts,newlength);
        }
        newYearsGifts[countNewYearsGifts]=newYearsGift;
    }
    /**
     * Метод для создания массива конфет.
     * Пользователь задает кол-во конфет.
     *
     * @return массив конфет.
     */
    static Candy[] initializeCandysMenu(){
        System.out.println("Введите количество конфет:");
        System.out.print("--> ");
        int coutnOfCandys = Integer.parseInt(scanner.next());
        if(coutnOfCandys<1){
            throw new IllegalArgumentException("В подарке должна быть хотя-бы одна конфета");
        }
        Candy[]candies = new Candy[coutnOfCandys];
        for(int i = 0; i<coutnOfCandys; i++){
            candies[i] = selectNewYearsGristMenu(i + 1);
        }
        return candies;
    }
    /**
     * Меню для выбора конкретной конфеты.
     *
     * @return выыбранная конфета.
     */
    static Candy selectNewYearsGristMenu(final int counter) {
        int operator;
        while (true) {
            System.out.println("Выберете конфету " + counter + ":");
            System.out.println("1 - Шоколадка");
            System.out.println("2 - Шоколадный снеговик");
            System.out.println("3 - Шоколадная конфета");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1: return initializeFlower(new Сhocolate());
                    case 2: return initializeFlower(new ChocolateSnowman());
                    case 3: return initializeFlower(new ChocolateCandy());
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            }
        }
    }

    /**
     * Метод для инициализации конкретной конфеты.
     *
     * @param candy переданный тип цветка.
     * @return инициализированноя конфета.
     */
    static Candy initializeFlower(Candy candy) {
        candy.setWeight(random.nextInt(100)+10);
        candy.setSugar(random.nextInt(10) + 5);
        candy.setCaloricContent(random.nextInt(100) + 10);
        candy.setCost(random.nextInt(30) + 5);
        return candy;
    }
    //Меню для выбора подарка из уже созданных
    static void selectNewYearsGistMenu(){

        if (countNewYearsGifts == 0) {
            throw new IllegalArgumentException("Пока не создано ни одного подарка");
        }
        System.out.println("Выберите индекс букета:");
        for (int i=0;i<countNewYearsGifts;i++) {
            System.out.println("букет " + (i + 1));
        }
        int selection = 0;
        boolean isReady = false;
        while (!isReady) {
            System.out.print("--> ");
            try {
                selection = Integer.parseInt(scanner.next());
                if (selection > countNewYearsGifts || selection < 0) throw new NumberFormatException();
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные! Повторите попытку.");
            }
        }
        newYearsGiftManagementMenu(newYearsGifts[selection - 1]);
    }
    static void newYearsGiftManagementMenu(NewYearsGift newYearsGift) {
        int operator;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Вывести все подарки отсортированные по колорийности");
            System.out.println("2 - Найти конфету в подарке с заданным весом");
            System.out.println("3 - Посчитать содержания сахара в конфете");
            System.out.println("4 - Вернуться в главное меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        newYearsGift.sortOnCaloricContent();
                        newYearsGift.printCandys();
                        break;
                    case 2:
                        searchCandyOnStemLengthMenu(newYearsGift);
                        break;
                    case 3:
                        System.out.println("Стоимость подарка " + newYearsGift.getWeight());
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
    static void searchCandyOnStemLengthMenu(NewYearsGift newYearsGift) {
        System.out.println("Введите диапазон длины стебля");
        System.out.print("от: ");
        int from = Integer.parseInt(scanner.next());
        System.out.print("до: ");
        int before = Integer.parseInt(scanner.next());
        if (from < 0 || before > 30 || from > before) {
            throw new IllegalArgumentException("Таких цветов нет!");
        }
        newYearsGift.printCandyWichSugar(from, before);
    }

}

