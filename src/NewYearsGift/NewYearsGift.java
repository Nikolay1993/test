package NewYearsGift;

import Flowershop.Flower;

/**
 * Created by Николай on 02.10.2016.
 */
import java.util.Arrays;
public class NewYearsGift {
    private Candy[]candies;//Масив конфет
    private int weight = 0;//вес подарка

    public NewYearsGift() {
    }
    /**
     *  Метод для добавления в подарок массива конфет.
     * При добавлении считается Вес.
     */
    public void setCandies(Candy[] candies){
        for (Candy candy:candies){
            weight+=candy.getWeight();
        }
        this.candies=candies;
    }
//текущий вес подарка
    public int getWeight() {
        return weight;
    }
//метод сортирует конфеты по калорийности
    public void sortOnCaloricContent(){
        Arrays.sort(candies);
    }
    /**
     * Метод выводит в консоль конфеты, у которых
     * содержания сахора входит в заданный диапазон.
     *
     * @param from от
     * @param before до
     */
    public void printCandyWichSugar(final int from, final int before){
        boolean isSugar=false;
        for (Candy candy: candies){
            if (candy.getSugar()>=from&&candy.getSugar()<=before){
                System.out.println(candy);
                isSugar = true;
            }
        }
        if(!isSugar){
            throw new IllegalArgumentException("Такого содержания сахора нет в конфетах");
        }
    }

    public void printCandys() {
        for (Candy candy:candies) {
            System.out.println(candy);
        }
    }


}
