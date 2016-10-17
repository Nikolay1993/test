package kitchen.application;

import java.util.Random;
import java.util.Scanner;
import kitchen.plants.*;
import kitchen.plants.fruits.*;
import kitchen.plants.vegetables.*;
import kitchen.basket.Basket;
import kitchen.foodprocessor.FoodProcessor;
/**
 * Created by Николай on 09.10.2016.
 *
 * Приложение позволяет добавлять овощи/фрукты в корзину, извлекать,
 * а так же пользоваться комбайном.
 * Овощи/фрукты добавляются в корзину путем создания и задания
 * характеристик пользователем и рандомно. В процессе добавления
 * выводится вес корзины. В комбайн попадают овощи/фрукты из корзины.
 * При обработке в комбайне, выводится вес отходов и потери.
 *
 * App - главный класс приложения, который содержит точку
 * входа в программу - метод main() и меню для
 * управления.
 *
 * @see Peellable
 * @see Plant
 * @see Basket
 * @see FoodProcessor
 */
public class App {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Корзина для фруктов и овощей.
     */
    private static Basket basket = new Basket();

    /**
     * Кухонный комбайн.
     */
    private static FoodProcessor foodProcessor = new FoodProcessor("Bosh");

    /**
     * Главное меню - точка входа в программу.
     */
    public static void main(String[] args) {
        int operator;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Выберете пункт меню:");
            System.out.println("1 - Добавить овощи/фрукты в корзину");
            System.out.println("2 - Изьять овощи/фрукты из корзины");
            System.out.println("3 - Запустить комбайн");
            System.out.println("4 - Выйти");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        addToBasketMenu();
                        break;
                    case 2:
                        extractOfBasketMenu();
                        break;
                    case 3:
                        startFoodProcessorMenu();
                        break;
                    case 4:
                        isExit = true;
                        break;
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Меню добавления в корзину. Позволяет выбрать
     * фрукты или овощи.
     */
    static void addToBasketMenu() {
        int operator;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("\nВыберете пункт меню:");
            System.out.println("1 - Добавить овощи");
            System.out.println("2 - Добавить фрукты");
            System.out.println("3 - Вернуться в главное меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        addPlantsToBasket(selectionVegetableMenu());
                        break;
                    case 2:
                        addPlantsToBasket(selectionFruitMenu());
                        break;
                    case 3:
                        isReady = true;
                        System.out.println();
                        break;
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (RuntimeException e) {}
        }
    }

    /**
     * Меню для выбора конкретного фрукта.
     *
     * @return выбранный тип фрукта.
     * @throws RuntimeException для выхода в предыдущее меню
     */
    static Class<? extends Fruit> selectionFruitMenu() {
        int operator;
        while (true) {
            System.out.println("\nВыберете фрукт:");
            System.out.println("1 - Яблоко");
            System.out.println("2 - Банан");
            System.out.println("3 - Апельсин");
            System.out.println("4 - Груша");
            System.out.println("5 - Вернуться в предыдущее меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1: return Apple.class;
                    case 2: return Banana.class;
                    case 3: return Orange.class;
                    case 4: return Pear.class;
                    case 5: throw new RuntimeException();
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные введеные данные!");
            }
        }
    }

    /**
     * Меню для выбора конкретного овоща.
     *
     * @return выбранный тип овоща.
     * @throws RuntimeException для выхода в предыдущее меню
     */
    static Class<? extends Vegetable> selectionVegetableMenu() {
        int operator;
        while (true) {
            System.out.println("\nВыберете овощ:");
            System.out.println("1 - Картофель");
            System.out.println("2 - Морковь");
            System.out.println("3 - Сельдерей");
            System.out.println("4 - Лук");
            System.out.println("5 - Вернуться в предыдущее меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1: return Potatoes.class;
                    case 2: return Carrot.class;
                    case 3: return Celery.class;
                    case 4: return Onion.class;
                    case 5: throw new RuntimeException();
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            }
        }
    }

    /**
     * В методе определяется кол-во фруктов/овощей заданного
     * типа и добавляются в корзину. После добавления в консоль
     * выводится вес корзины.
     *
     * @param plantClass тип фрукта/овоща.
     */
    static void addPlantsToBasket(Class<? extends Plant> plantClass) {
        int count = inputCountOfPlants();
        for (int i=0;i<count;i++) {
            basket.put(initializePlant(plantClass, i + 1));
        }
        System.out.format("\nВес корзины после добавления %1$.2f г\n", basket.getWeightOfBasket());
    }

    /**
     * Меню для ввода кол-ва фруктов/овощей.
     *
     * @return введенное пользователем кол-во.
     */
    static int inputCountOfPlants() {
        int count = 0;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("Введите кол-во:");
            System.out.print("--> ");
            try {
                count = Integer.parseInt(scanner.next());
                if (count < 0) throw new IllegalArgumentException("Не может быть отрицательное значение!");
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return count;
    }

    /**
     * Метод для инициализации одного конкретного фрукта/овоща.
     * Цвет вводит пользователь, вес и свежесть определяется
     * рандомно.
     *
     * @param plantClass переданный тип растения.
     * @param counter индекс растения.
     * @return созданное растение заданного типа.
     */
    static Plant initializePlant(Class<? extends Plant> plantClass, int counter) {
        Random random = new Random();
        System.out.println("Введите цвет " + plantClass.getSimpleName() + " " + counter + ":");
        System.out.print("--> ");
        String color = scanner.next();
        Plant plant = null;
        try {
            plant = plantClass.newInstance();
            plant.setColor(color);
            plant.setWeight(random.nextDouble() * 200 + 100);
            plant.setRipeness(random.nextInt(10) + 1);
        } catch (Exception e) {
            System.out.println("Ошибка создания растения!");
        }
        return plant;
    }

    /**
     * Меню для извлечения из корзины фруктов и овощей.
     */
    static void extractOfBasketMenu() {
        int operator;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("\nВыберете пункт меню:");
            System.out.println("1 - Извлечь все фрукты и овощи");
            System.out.println("2 - Извлечь только фрукты");
            System.out.println("3 - Извлечь только овощи");
            System.out.println("4 - Извлечь конкретный фрукт или овощ по индексу");
            System.out.println("5 - Вернуться в главное меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        printPlants(basket.extractAll());
                        System.out.println();
                        isReady = true; //извлекать уже нечего
                        break;
                    case 2:
                        printPlants(basket.extractAllFruits());
                        break;
                    case 3:
                        printPlants(basket.extractAllVegetables());
                        break;
                    case 4:
                        printExtractPlantMenu();
                        break;
                    case 5:
                        isReady = true;
                        System.out.println();
                        break;
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Метод выводит все растения из массива в консоль.
     *
     * @param plants переданный массив растений.
     */
    static void printPlants(Plant[] plants) {
        System.out.println();
        for (Plant plant:plants) {
            System.out.println(plant);
        }
    }

    /**
     * Меню для ввода индекса искомого растения.
     * Если растение найдено оно выводится в консоль, если нет, то
     * возвращаемся в предидущее меню.
     */
    static void printExtractPlantMenu() {
        int index;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("Введите индекс:");
            System.out.print("--> ");
            try {
                index = Integer.parseInt(scanner.next());
                System.out.println(basket.extract(index));
                isReady = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                isReady = true;
            }
        }
    }

    /**
     * Меню для запуска комбайна.
     */
    static void startFoodProcessorMenu() {
        int operator;
        boolean isReady = false;
        while (!isReady) {
            System.out.println("\nВыберете функцию комбайна:");
            System.out.println("1 - Почистить");
            System.out.println("2 - Нарезать");
            System.out.println("3 - Нашинковать");
            System.out.println("4 - Вернуться в главное меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        peelMenu();
                        break;
                    case 2:
                        cutMenu();
                        break;
                    case 3:
                        sliceMenu();
                        break;
                    case 4:
                        isReady = true;
                        System.out.println();
                        break;
                    default: throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {}
        }
    }

    /**
     * Меню для выбора пользователем фруктов/овощей для обработке
     * в комбайне.
     *
     * @return выбранные растения.
     * @throws RuntimeException для выхода в предыдущее меню
     */
    static Plant[] plantsForProcessorMenu() {
        int operator;
        while (true) {
            System.out.println("\nВыберете пункт меню:");
            System.out.println("1 - Обработать все фрукты и овощи");
            System.out.println("2 - Обработать только фрукты");
            System.out.println("3 - Обработать только овощи");
            System.out.println("4 - Вернуться в предидущее меню");
            System.out.print("--> ");
            try {
                operator = Integer.parseInt(scanner.next());
                switch (operator) {
                    case 1:
                        return basket.extractAll();
                    case 2:
                        return basket.extractAllFruits();
                    case 3:
                        return basket.extractAllVegetables();
                    case 4:
                        throw new RuntimeException();
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
     * Метод для очистки фруктов/овощей с помощью комбайна.
     * В процессе обработки выводится информация о весе
     * фруктов/овощей. После обработки фрукты/овощи возвращаются
     * обратно в корзину.
     */
    static void peelMenu() {
        Plant[] plants = plantsForProcessorMenu();
        try {
            double beforePeel = calculateWeight(plants);
            double afterPeel = foodProcessor.peelItems(plants);
            System.out.format("\nВес перед очисткой %1$.2f г\n", beforePeel);
            System.out.format("Вес после очистки %1$.2f г\n", afterPeel);
            System.out.format("Вес отходов %1$.2f г\n", beforePeel - afterPeel);
        } finally {
            basket.put(plants);
        }
    }

    /**
     * Метод для нарезки фруктов/овощей с помощью комбайна.
     * В процессе обработки выводится информация о весе
     * фруктов/овощей. После обработки фрукты/овощи возвращаются
     * обратно в корзину.
     */
    static void cutMenu() {
        Plant[] plants = plantsForProcessorMenu();
        try {
            double beforeCut = calculateWeight(plants);
            double afterCut = foodProcessor.cutAll(plants);
            System.out.format("\nВес перед нарезкой %1$.2f г\n", beforeCut);
            System.out.format("Вес после нарезки %1$.2f г\n", afterCut);
            System.out.format("Вес потерь %1$.2f г\n", beforeCut - afterCut);
        } finally {
            basket.put(plants);
        }
    }

    /**
     * Метод для шинковки фруктов/овощей с помощью комбайна.
     * В процессе обработки выводится информация о весе
     * фруктов/овощей. После обработки фрукты/овощи возвращаются
     * обратно в корзину.
     */
    static void sliceMenu() {
        Plant[] plants = plantsForProcessorMenu();
        try {
            double beforeSlice = calculateWeight(plants);
            double afterSlice = foodProcessor.sliceAll(plants);
            System.out.format("\nВес перед шинковкой %1$.2f г\n", beforeSlice);
            System.out.format("Вес после шинковки %1$.2f г\n", afterSlice);
            System.out.format("Вес потерь %1$.2f г\n", beforeSlice - afterSlice);
        } finally {
            basket.put(plants);
        }
    }

    /**
     * Метод рассчитывает вес растений в переданном массиве
     * и возвращает его.
     *
     * @param plants переданный массив растений.
     * @return вес растений.
     */
    static double calculateWeight(Plant[] plants) {
        double weigth = 0;
        for(Plant plant:plants) {
            weigth += plant.getWeight();
        }
        return weigth;
    }
}
