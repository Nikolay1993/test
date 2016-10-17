package kitchen.plants.fruits;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 *  Класс, описывающий грушу.
 *
 * @see Plant
 * @see Fruit
 */

public class Pear extends Fruit {
    public Pear() {

    }

    public Pear(String color, double weight, int ripeness) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        isPeeled = false;
    }

    public Pear(String color, double weight, int ripeness, boolean isPeeled) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        this.isPeeled = isPeeled;
    }
}
