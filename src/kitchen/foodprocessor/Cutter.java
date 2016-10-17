package kitchen.foodprocessor;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 * Интерфейс, содержащий методы для шинковки
 * фруктов и овощей.
 *
 * @see FoodProcessor
 */
interface Cutter {
    /**
     * При шинковке вес овощей/фруктов уменьшается на 2%.
     */
    double CUT_INDEX = 0.02;

    /**
     * Метод шинкует однин фрукт/овощ.
     *
     * @param plant фрукт/овощ для шинковки.
     * @return вес обработанного фрукта/овоща.
     */
    double cut(Plant plant);

    /**
     * Метод шинкует несколько фруктов/овощей.
     *
     * @param plants массив с фруктами/овощами для шинковки.
     * @return вес обработанных фруктов/овощей.
     */
    double cutAll(Plant[] plants);
}
