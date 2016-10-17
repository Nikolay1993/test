package kitchen.basket;

import java.util.Arrays;
import java.lang.reflect.Array;
import kitchen.plants.Plant;
import kitchen.plants.fruits.Fruit;
import kitchen.plants.vegetables.Vegetable;
/**
 * Created by Николай on 09.10.2016.
 *
 * Класс описывает корзину для хранения фруктов и овощей.
 * Корзина является расширяемым контейнером.
 */
public class Basket {
    /**
     * Массив для хранения всех овощей и фрутов корзины.
     */
    private Plant[] arrayOfPlants;

    /**
     * Емкость корзины по-умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Вес корзины.
     */
    private double weightOfBasket = 0;

    /**
     * Кол-во овощей и фруктов в корзине.
     */
    private int countPlantsInBasket = 0;

    /**
     * Конструктор для создания пустой корзины.
     */
    public Basket() {
        arrayOfPlants = new Plant[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор для создания новой корзины
     * из уже готовой.
     */
    public Basket(Basket someBasket) {
        this.arrayOfPlants = someBasket.arrayOfPlants;
        this.countPlantsInBasket = someBasket.countPlantsInBasket;
        this.weightOfBasket = someBasket.weightOfBasket;
    }

    /**
     * Метод возвращает текущий вес корзины.
     *
     * @return вес корзины.
     */
    public double getWeightOfBasket() {
        return weightOfBasket;
    }

    /**
     * Метод устанавливает новую емкость для массива корзины.
     * Проверяем есть ли минимальная необходимая емкость
     * и если нет, то создаем новый массив.
     *
     * @param minCapacity минимальное емкость массива для
     *                    добавления новых овощей и фруктов.
     */
    public void ensureCapacity(final int minCapacity) {
        int currentCapacity = arrayOfPlants.length;
        int newCapacity;
        if (currentCapacity < minCapacity) {
            currentCapacity = minCapacity;
            newCapacity = ((currentCapacity * 3) / 2) + 1;
            arrayOfPlants = Arrays.copyOf(arrayOfPlants, newCapacity);
        }
    }

    /**
     * Метод для добавления нового овоща или фрукта в корзину.
     *
     * @param plant добавляемое в корзину растение.
     */
    public void put(Plant plant) {
        int indexOfFreeCell = countPlantsInBasket;
        ensureCapacity(++countPlantsInBasket);
        arrayOfPlants[indexOfFreeCell] = plant;
        calculateWeight(true, plant);
    }

    /**
     * Метод добавляет в корзину все овощи и фрукты из
     * переданного массива.
     *
     * @param somePlants переданный массив с растениями.
     */
    public void put(Plant[] somePlants) {
        ensureCapacity(countPlantsInBasket + somePlants.length);
        System.arraycopy(somePlants, 0,
                arrayOfPlants, countPlantsInBasket,
                somePlants.length);
        countPlantsInBasket += somePlants.length;
        calculateWeight(true, somePlants);
    }

    /**
     * Метод перекладывает овощи и фрукты с
     * этой корзины в переданную и возвращает ее.
     *
     * @param someBasket переданная корзина.
     * @return заполненая корзина с растениями.
     */
    public Basket put(Basket someBasket) {
        Plant[] arrPlantsWithoutNull = Arrays.copyOf(arrayOfPlants, countPlantsInBasket);
        someBasket.put(arrPlantsWithoutNull);
        return someBasket;
    }

    /**
     * Метод извлекает фрукт или овощ из
     * корзины по индексу и возвращает его.
     * Растение из корзины удаляется.
     *
     * @param index заданный индекс искомого эл-та.
     * @return найденный по индексу фрукт или овощ.
     */
    public Plant extract(final int index) {
        if (index < 0 || index >= countPlantsInBasket || countPlantsInBasket == 0) {
            throw new IllegalArgumentException("Такого элемента нет!");
        }
        Plant requiredElement = arrayOfPlants[index];
        remove(index);
        return requiredElement;
    }

    /**
     * Метод возвращает массив со всеми фруктами
     * и овощами, которые хранились в корзине.
     * При этом корзина опустошается.
     *
     * @return массив с содержимым корзины.
     */
    public Plant[] extractAll() {
        if (countPlantsInBasket == 0) {
            throw new IllegalArgumentException("Корзина пуста!");
        }
        Plant[] arrPlantsWithoutNull = Arrays.copyOf(arrayOfPlants, countPlantsInBasket);
        arrayOfPlants = new Plant[DEFAULT_CAPACITY];
        countPlantsInBasket = 0;
        weightOfBasket = 0;
        return arrPlantsWithoutNull;
    }

    /**
     * Метод извлекает из корзины все фрукты.
     *
     * @return массив с фруктами.
     */
    public Fruit[] extractAllFruits() {
        if (countPlantsInBasket == 0) {
            throw new IllegalArgumentException("Корзина пуста!");
        }
        return searchingTypeOfPlant(Fruit.class);
    }

    /**
     * Метод извлекает из корзины все овощи.
     *
     * @return массив с овощами.
     */
    public Vegetable[] extractAllVegetables() {
        if (countPlantsInBasket == 0) {
            throw new IllegalArgumentException("Корзина пуста!");
        }
        return searchingTypeOfPlant(Vegetable.class);
    }

    /**
     * Метод находит в корзине, в зависимости от переданного
     * параметра, овощи или фрукты и возвращает в виде
     * соответствующего массива.
     * Когда овощ/фрукт найден он извлекается из корзины.
     *
     * @param plantType тип распений.
     * @return массив фруктов или овощей.
     * @see Class#isAssignableFrom(Class)
     * @see Array#newInstance(Class, int)
     */
    @SuppressWarnings("unchecked")
    private <T extends Plant> T[] searchingTypeOfPlant(Class<? extends Plant> plantType) {
        T[] searchingPlants = (T[]) Array.newInstance(plantType, countPlantsInBasket);
        int counter = 0;
        for (int i=0;i<countPlantsInBasket;i++) {
            if (plantType.isAssignableFrom(arrayOfPlants[i].getClass())) {
                searchingPlants[counter++] = (T) arrayOfPlants[i];
                remove(i); //удаляем овощ из корзины
                i--; //при удалении элементы смещаются влево
            }
        }
        return Arrays.copyOf(searchingPlants, counter);
    }

    /**
     * Метод рассчитывает вес корзины основываясь
     * на переданных в аргументе овощах и фруктах.
     * Если флаг равен true, то вес добавляется,
     * если false, то отнимается. Переданный массив не должен
     * иметь пустых ячеек (null-обьектов).
     *
     * @param isAdd флаг добавления.
     * @param plants переданные растения.
     */
    private void calculateWeight(boolean isAdd, Plant...plants) {
        if (isAdd) {
            for (Plant plant:plants) {
                weightOfBasket += plant.getWeight();
            }
        } else {
            for (Plant plant:plants) {
                weightOfBasket -= plant.getWeight();
            }
        }
    }

    /**
     * Удаляет фрукт или овощ в массиве по индексу.
     * При удалении элементы смещаются влево.
     *
     * @param index индекс удаляемого элемента.
     */
    private void remove(final int index) {
        if (index < 0 || index >= countPlantsInBasket) {
            throw new IllegalArgumentException("Такого элемента нет!");
        }
        countPlantsInBasket--;
        calculateWeight(false, arrayOfPlants[index]);
        Plant[] newArrayOfPlants = new Plant[arrayOfPlants.length];
        System.arraycopy(arrayOfPlants, 0,
                newArrayOfPlants, 0,
                index);
        System.arraycopy(arrayOfPlants, index + 1,
                newArrayOfPlants, index,
                arrayOfPlants.length - index - 1);
        arrayOfPlants = newArrayOfPlants;
    }
}
