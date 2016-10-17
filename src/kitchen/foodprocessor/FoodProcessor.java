package kitchen.foodprocessor;

import kitchen.plants.Plant;
/**
 * Created by Николай on 09.10.2016.
 *
 * Класс описывает кухонный комбайн.
 * Комбайн позволяет чистить, нарезать ломтиками,
 * шинковать фрукты и овощи.
 */

public class FoodProcessor implements Peeler, Cutter, Slicer {
    /**
     * Название комбайна.
     */
    private String name;

    /**
     * Конструктор для создания комбайна.
     */
    public FoodProcessor(String name) {
        this.name = name;
    }

    @Override
    public double peelItem(Plant plant) {
        if (!plant.isPeeled()) {
            plant.peel();
        }
        return plant.getWeight();
    }

    @Override
    public double peelItems(Plant[] plants) {
        double peelWeight = 0;
        for (Plant plant:plants) {
            if (!plant.isPeeled()) {
                plant.peel();
                peelWeight += plant.getWeight();
            }
        }
        return peelWeight;
    }

    @Override
    public double cut(Plant plant) {
        if (!plant.isPeeled()) {
            throw new IllegalArgumentException("Попал неочищенный фрукт/овощ!");
        }
        double cutWeight = plant.getWeight() - plant.getWeight() * Cutter.CUT_INDEX;
        plant.setWeight(cutWeight);
        return cutWeight;
    }

    @Override
    public double cutAll(Plant[] plants) {
        double cutWeight = 0;
        for (Plant plant:plants) {
            cutWeight += cut(plant);
        }
        return cutWeight;
    }

    @Override
    public double slice(Plant plant) {
        if (!plant.isPeeled()) {
            throw new IllegalArgumentException("Попал неочищенный фрукт/овощ!");
        }
        double sliceWeight = plant.getWeight() - plant.getWeight() * Slicer.SLICE_INDEX;
        plant.setWeight(sliceWeight);
        return sliceWeight;
    }

    @Override
    public double sliceAll(Plant[] plants) {
        double sliceWeight = 0;
        for (Plant plant:plants) {
            sliceWeight += slice(plant);
        }
        return sliceWeight;
    }
}
