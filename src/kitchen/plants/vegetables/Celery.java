package kitchen.plants.vegetables;

import kitchen.plants.Plant;

/**
 * Created by Николай on 09.10.2016.
 *
 *  Класс, описывающий сельдерей.
 *
 * @see Plant
 * @see Vegetable
 */

public class Celery extends Vegetable {
    public Celery() {
    }

    public Celery(String color, double weight, int ripeness) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        isPeeled = false;
    }

    public Celery(String color, double weight, int ripeness, boolean isPeeled) {
        this.color = color;
        this.weight = weight;
        this.ripeness = ripeness;
        this.isPeeled = isPeeled;
    }
}
