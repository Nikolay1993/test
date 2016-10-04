package taxistation;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Николай on 24.09.2016.
 */

public class TaxiStation {
    /*
    массив для харанение автомобилей
     */
    private final Car[] carsOnStation;

    /*
    название таксопарка
     */
    private String name;
    /*
    количество авто в таксопарке
     */
    private int countOfCarsOnStation = 0;
    /*
    стоимость таксопарка
     */
    private int costOfStation = 0;
    /**
     * Конструктор для создания таксопарка с заданным
     * кол-вом мест для авто.
     *
     * @param countOfCars размер массива, определяющий
     *                    кол-во мест под авто таксопарка.
     */
    public TaxiStation(String name, int countOfCars) {
        this.name = name;
        carsOnStation = new Car[countOfCars];
    }
    /**
     * @return стоимость таксопарка.
     */
    public int getCostOfStation() {
        return costOfStation;
    }
    /**
     * @return кол-во авто в таксопарке.
     */
    public int getCountOfCarsOnStation() {
        return countOfCarsOnStation;
    }

    /**
     * Устанавливает имя таксопарка.
     *
     * @param name новое имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return название таксопарка.
     */
    public String getName() {
        return name;
    }
    /**
     * Метод для добавления автомобиля в таксопарк.
     *
     * @param car добавляемый автомобиль.
     */
    public void addCar (Car car){
        if(!isTherePlaceInStation()){
            throw new IllegalArgumentException("В таксопарке нет места");
            }
            carsOnStation[countOfCarsOnStation++] = car;
            costOfStation += car.getCost();
        }

    /**
     * Метод для удаления конкретного авто из таксопарка.
     *
     * @param modelName название, удаляемого авто.
     * @return true, если удаление прошло успешно,
     *         false, если авто не найдено.
     */

    public boolean removeCar(String modelName){
        Car car = null;
        boolean isFound = false;
        for(int i = 0; i<countOfCarsOnStation; i++){
            if(carsOnStation[i].getModel().equals(modelName)){
                car=carsOnStation[i];
                isFound = true;
            }
        }
        if(!isFound)return false;
        countOfCarsOnStation--;
        costOfStation -= car.getCost();
        return true;
    }

    /**
     * Метод сортирует авто по расходу топлива.
     */
    public void sortOnFuelConsumption() {
        Arrays.sort(carsOnStation, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1 == null || o2 == null) {
                    return 0; //остается на месте
                }
                if (o1.getFuelConsumption() > o2.getFuelConsumption()) {
                    return 1;
                } else if (o1.getFuelConsumption() < o2.getFuelConsumption()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
    /**
     * Метод выводит все авто таксопарка в консоль.
     */
    public void printCarsOfStation() {
        if (countOfCarsOnStation == 0) {
            throw new IllegalArgumentException("В таксопарке нет автомобилей!");
        }
        for (int i=0;i<countOfCarsOnStation;i++) {
            System.out.println(carsOnStation[i]);
        }
    }
    /**
     * Метод возвращает авто с скоростью,
     * которая входит в заданный диапазон.
     * Если авто не найдено метод выбрасывает исключение.
     *
     * @param before от
     * @param after до
     * @return найденный автомобиль.
     */
    public Car carWithSpecifiedSpeed(int before, int after) {
        for (Car car:carsOnStation) {
            if (car != null &&
                    car.getSpeed() >= before &&
                    car.getSpeed() <= after) {
                return car;
            }
        }
        throw new IllegalArgumentException("Такого автомобиля нет!");
    }
    /**
     * Метод проверяет есть ли место для авто
     * в таксопарке.
     */
    public boolean isTherePlaceInStation() {
        return countOfCarsOnStation < carsOnStation.length;
    }
}

