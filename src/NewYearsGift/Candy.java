package NewYearsGift;

/**
 * Created by Николай on 02.10.2016.
 */
//Конфеты
public abstract class Candy implements Comparable<Candy>{

    private int weight;//вес
    private int sugar;//содержания сахора
    private int caloricContent;//Калорийность
    private int cost;// стоимость

    public Candy() {
    }

    public Candy(int weight, int sugar,
                 int caloricContent, int cost) {
        this.weight = weight;
        this.sugar = sugar;
        this.caloricContent = caloricContent;
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight<0){
            throw new NumberFormatException("Вес не может быть отрецательным");
        }
        this.weight = weight;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        if (sugar<0){
            throw new NumberFormatException("Содержания сахара не может быть отрецательным");
        }
        this.sugar = sugar;
    }

    public int getCaloricContent() {
        return caloricContent;
    }

    public void setCaloricContent(int caloricContent) {
        if(caloricContent<1){
            throw new NumberFormatException("Содержания калорийности не может быть отрецательным");
        }
        this.caloricContent = caloricContent;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost<1){
            throw new NumberFormatException("Цена не может быть отрецательной");
        }
        this.cost = cost;
    }
//Сортировка конфет по колорийности
    @Override
    public int compareTo(Candy o) {
        if (o == null){
            return 0;
        }
        if(this.caloricContent<o.caloricContent){
            return 1;
        }
        else if(this.caloricContent>o.caloricContent){
            return -1;
        }
        else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" +
                "  Вес - " + weight +
                ", Сахар - " + sugar +
                ", Калорийность - " + caloricContent +
                ", цена - " + cost + " USD";
    }
}
