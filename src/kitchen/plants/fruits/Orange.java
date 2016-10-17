package kitchen.plants.fruits;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 *  Класс, описывающий апельсин.
 *
 * @see Plant
 * @see Fruit
 */

public class Orange extends Fruit {
    public Orange() {

    }

    public Orange(String color, double weight, int ripeness) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        isPeeled = false;
    }

    public Orange(String color, double weight, int ripeness, boolean isPeeled) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        this.isPeeled = isPeeled;
    }
}
