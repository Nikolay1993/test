package taxistation;

/**
 * Created by Николай on 24.09.2016.
 */
public class Van extends Car {
    private int capacity; //грузо подьемность

    public Van() {
    }

    public Van(String model, int cost, int speed, double fuelConsumption, int capacity) {
        super(model, cost, speed, fuelConsumption);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль " + super.getModel()  + ":" +
                " грузоподьемность - " + capacity +
                ", стоимость - " + super.getCost() + " USD" +
                ", максимальная скорость - " + super.getSpeed() + " км/ч" +
                ", расход топлива - " + super.getFuelConsumption() + " л/100км.";
    }
}
