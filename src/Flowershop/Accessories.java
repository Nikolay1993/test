package Flowershop;

/**
 * Created by Николай on 02.10.2016.
 */
public enum Accessories {
    TAPE(5), //лента
    PAPER(6),  //бумага
    MEMBRANE(4),  //клеенка
    BRANCH(7),  //веточка
    ROPE(2);  //веревка

    private int price;// цена

    Accessories(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
