package kitchen.plants.vegetables;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 *  Класс, описывающий картофель.
 *
 * @see Plant
 * @see Vegetable
 */

public class Potatoes extends Vegetable {
    public Potatoes() {

    }

    public Potatoes(String color, double weight, int ripeness) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        isPeeled = false;
    }

    public Potatoes(String color, double weight, int ripeness, boolean isPeeled) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        this.isPeeled = isPeeled;
    }
}
