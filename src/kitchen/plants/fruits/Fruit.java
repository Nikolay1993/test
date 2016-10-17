package kitchen.plants.fruits;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 *
 *   Класс, описывающий абстрактный фрукт.
 *   Фрукт может быть очищен.
 */
public abstract class Fruit extends Plant {
    /**
     * Индекс очищенности фруктов
     */
    private final static double PEEL_INDEX = 0.02;

    /**
     * Реализация метода, которая очищает фрукт от кожуры.
     * Вес уменьшается на 2%, помечает фрукт как очищенный.
     * Для конкретной реализации вызывается только полиморфно.
     */
    @Override
    public void peel() {
        weight = weight - weight * PEEL_INDEX;
        isPeeled = true;
    }
}
