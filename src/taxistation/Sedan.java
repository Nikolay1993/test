package taxistation;

/**
 * Created by Николай on 03.09.2016.
 */
public class Sedan extends Car {
    private int countOfSeats;

    public Sedan() {
    }

    public Sedan(String model, int cost, int speed, double fuelConsumption, int countOfSeats) {
        super(model, cost, speed, fuelConsumption);
        this.countOfSeats = countOfSeats;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    @Override
    public String toString() {
        return "Легковой автомобиль " + super.getModel()  + ":" +
                " кол-во посадочных мест - " + countOfSeats +
                ", стоимость - " + super.getCost() + " USD" +
                ", максимальная скорость - " + super.getSpeed() + " км/ч" +
                ", расход топлива - " + super.getFuelConsumption() + " л/100км.";
    }
}
