package kitchen.plants.vegetables;

import kitchen.plants.Plant;

/**
 * Created by Николай on 09.10.2016.
 *
 *  Класс, описывающий абстрактный овощ.
 *  Овощ может быть очищен.
 */
public abstract class Vegetable extends Plant {
    /**
     * Индекс очищенности овощей
     */
    private final static double PEEL_INDEX = 0.05;

    /**
     * Реализация метода, которая очищает овощ от кожуры.
     * Вес уменьшается на 5%, помечает овощ как очищенный.
     * Для конкретной реализации вызывается только полиморфно.
     */
    @Override
    public void peel() {
        weight = weight - weight * PEEL_INDEX;
        isPeeled = true;
    }
}
