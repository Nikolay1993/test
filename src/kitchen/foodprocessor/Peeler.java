package kitchen.foodprocessor;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 * Интерфейс, содержащий методы для очистки
 * фруктов и овощей.
 *
 * @see FoodProcessor
 */
interface Peeler {
    /**
     * Метод чистит однин фрукт/овощ.
     *
     * @param plant фрукт/овощ для очистки.
     * @return вес обработанного фрукта/овоща.
     */
    double peelItem(Plant plant);

    /**
     * Метод чистит несколько фруктов/овощей.
     *
     * @param plants массив с фруктами/овощами для очистки.
     * @return вес обработанных фруктов/овощей.
     */
    double peelItems(Plant[] plants);
}
