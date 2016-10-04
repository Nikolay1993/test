package Flowershop;

/**
 * Created by Николай on 02.10.2016.
 */
public abstract class Flower implements Comparable<Flower> {

    private String color;// цвет
    private int recency;//свежесть
    private int stemLength;// длина стебля
    private int cost;// стоимость

    public Flower() {
    }

    public Flower(String color, int recency,
                  int stemLength, int cost) {
        this.color = color;
        this.recency = recency;
        this.stemLength = stemLength;
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRecency() {
        return recency;
    }

    public void setRecency(int recency) {
        if(recency<0){
            throw new NumberFormatException("Свежесть не может быть отрецательной");
        }
        this.recency = recency;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        if(stemLength<0){
            throw new NumberFormatException("Длина не может быть отрецательной");
        }
        this.stemLength = stemLength;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost<0){
            throw new NumberFormatException("Цена не может быть отрецательной");
        }
        this.cost = cost;
    }

    // Метод сравненивает цветок по свежести
    @Override
    public int compareTo(Flower o) {
        if (o == null){
            return 0;
        }
        if(this.recency<o.recency){
            return 1;
        }
        else if(this.recency>o.recency){
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" +
                "  цвет - " + color +
                ", свежесть - " + recency +
                ", длина стебля - " + stemLength +
                ", цена - " + cost + " USD";
    }
}
