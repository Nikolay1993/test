package Bus;

/**
 * Created by Николай on 28.08.2016.
 */
public class Bus {
    private static int genderedId = 0;
    private final int id;
    private String lastNameAndInitialsToDriver;
    private int numberBus;
    private int numberOfaRoute;
    private String marks;
    private int yearOfTheBeginningOfOperation;
    private int mileage;
    {
        genderedId++;
    }
    Bus() {

        id = genderedId;
    }

    public Bus(int id, String lastNameAndInitialsToDriver, int numberBus, int numberOfaRoute, String marks, int yearOfTheBeginningOfOperation, int mileage) {
        this.id = id;
        this.lastNameAndInitialsToDriver = lastNameAndInitialsToDriver;
        this.numberBus = numberBus;
        this.numberOfaRoute = numberOfaRoute;
        this.marks = marks;
        this.yearOfTheBeginningOfOperation = yearOfTheBeginningOfOperation;
        this.mileage = mileage;
    }

    public String getLastNameAndInitialsToDriver() {
        return lastNameAndInitialsToDriver;
    }

    public void setLastNameAndInitialsToDriver(String lastNameAndInitialsToDriver) {
        this.lastNameAndInitialsToDriver = lastNameAndInitialsToDriver;
    }

    public int getNumberBus() {
        return numberBus;
    }

    public void setNumberBus(int numberBus) {
        this.numberBus = numberBus;
    }

    public int getNumberOfaRoute() {
        return numberOfaRoute;
    }

    public void setNumberOfaRoute(int numberOfaRoute) {
        this.numberOfaRoute = numberOfaRoute;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public int getYearOfTheBeginningOfOperation() {
        return yearOfTheBeginningOfOperation;
    }

    public void setYearOfTheBeginningOfOperation(int yearOfTheBeginningOfOperation) {
        this.yearOfTheBeginningOfOperation = yearOfTheBeginningOfOperation;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Автобусы " +
                " Фамилия инициалы водителя" + lastNameAndInitialsToDriver +
                ", Номер автобуса " + numberBus +
                ", Номер маршрута " + numberOfaRoute +
                ", Марка " + marks +
                ", Год эксплуатации " + yearOfTheBeginningOfOperation +
                ", Пробег " + mileage;
    }
}
