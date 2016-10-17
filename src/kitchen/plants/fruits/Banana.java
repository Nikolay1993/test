package kitchen.plants.fruits;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 *
 * Класс, описывающий банан.
 *
 * @see Plant
 * @see Fruit
 */
public class Banana extends Fruit{
    public Banana() {

    }
    public Banana(String color, double weight, int ripeness) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        isPeeled = false;
    }

    public Banana(String color, double weight, int ripeness, boolean isPeeled) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        this.isPeeled = isPeeled;
    }
}
