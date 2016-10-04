package Flowershop;

/**
 * Created by Николай on 02.10.2016.
 */
import java.util.Arrays;
public class Bouquet {

    private Flower[] flowers;
    private Accessories[] accessories;
    private int cost = 0;

    public Bouquet() {
    }
    /**
     * Метод для добавления в букет массива цветов.
     * При добавлении считается стоимость.
     *
     * @param flowers переданный массив цветов.
     */
    public void setFlowers(Flower[] flowers) {
        for (Flower flower:flowers) {
            cost += flower.getCost();
        }
        this.flowers = flowers;
    }
    /**
     * Метод для добавления в букет массива акссесуаров.
     * При добавлении считается стоимость.
     *
     * @param accessories переданный массив акссесуаров.
     */
    public void setAccessories(Accessories[] accessories) {
        for (Accessories accessory:accessories) {
            cost += accessory.getPrice();
        }
        this.accessories = accessories;
    }
    /**
     * @return текущая стоимость букета.
     */
    public int getCost() {
        return cost;
    }
    /**
     * Метод сортирует цветы по свежести.
     * Чем больше свежесть, тем свежее цветок.
     *
     * @see Flower#compareTo(Flower)
     */
    public void sortOnRecency() {
        Arrays.sort(flowers);
    }
    /**
     * Метод выводит все цветы букета в консоль.
     *
     * @see Flower#toString()
     */
    public void printFlowers() {
        for (Flower flower:flowers) {
            System.out.println(flower);
        }
    }
    /**
     * Метод выводит в консоль цветы, у которых
     * длина стебля входит в заданный диапазон.
     *
     * @param from от
     * @param before до
     */
    public void printFlowersWithLength(final int from, final int before) {
        boolean isPresence = false;
        for (Flower flower:flowers) {
            if (flower.getStemLength() >= from &&
                    flower.getStemLength() <= before) {
                System.out.println(flower);
                isPresence = true;
            }
        }
        if (!isPresence) {
            throw new IllegalArgumentException("Таких цветов нет!");
        }
    }
}
