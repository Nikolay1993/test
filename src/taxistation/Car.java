package taxistation;

import java.math.*;

/**
 * Created by Николай on 03.09.2016.
 */
public abstract class Car implements Comparable<Car> {
    private String model;
    private int cost;
    private int speed;
    private double fuelConsumption;

    public Car() {
    }

    public Car(String model, int cost, int speed, double fuelConsumption) {
        this.model = model;
        this.cost = cost;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public int compareTo(Car o) {
        if (o == null) {
            return -1;
        }
        if (this.fuelConsumption > o.fuelConsumption) {
            return 1;
        } else if (this.fuelConsumption < o.fuelConsumption) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }
        Car o = (Car)obj;
        return this.model.equals(o.model);
    }
}
//}