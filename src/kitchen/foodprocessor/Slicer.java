package kitchen.foodprocessor;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 * Интерфейс, содержащий методы для нарезки ломтиками
 * фруктов и овощей.
 *
 * @see FoodProcessor
 */
interface Slicer {
    /**
     * При нарезке вес овощей/фруктов уменьшается на 2%.
     */
    double SLICE_INDEX = 0.02;

    /**
     * Метод нарезает ломтиками однин фрукт/овощ.
     *
     * @param plant фрукт/овощ для шинковки.
     * @return вес обработанного фрукта/овоща.
     */
    double slice(Plant plant);

    /**
     * Метод нарезает ломтиками несколько фруктов/овощей.
     *
     * @param plants массив с фруктами/овощами для шинковки.
     * @return вес обработанных фруктов/овощей.
     */
    double sliceAll(Plant[] plants);
}
