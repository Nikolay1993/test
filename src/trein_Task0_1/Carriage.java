package trein_Task0_1;

/**
 * Created by Николай on 19.09.2016.
 */

public class Carriage implements Comparable<Carriage> {
    private int index;//индекс вагона в поезде
    private int quantityPassangers;// число пассажиров
    private int quantityBaggage;//число багажа
    private int comfortLevel;// уровень комфорт
//    private int expres;
//    private int passenger;

    private final CarriageType carriageType;

    public Carriage(CarriageType carriageType, int index, int quantityPassangers, int comfortLevel ) {
        this.carriageType=carriageType;
        this.index=index;
        this.quantityPassangers=quantityPassangers;
        this.comfortLevel=comfortLevel;
        quantityBaggage=quantityPassangers /3;
    }

    public int getQuantityPassangers(){
        return quantityPassangers;

}

    public int getQuantityBaggage(){
        return quantityPassangers;
    }

    @Override
    public int compareTo(Carriage o) {
        if(o == null){
            return -1;
        }
        if(this.comfortLevel > o.comfortLevel){
            return 1;
        }
        if(this.comfortLevel < o.comfortLevel){
            return -1;
        }
        else{
            return 0;
        }
    }

    public enum CarriageType{
        TYPE_EXPRESS, TYPE_COUPE, TYPE_PLACKART;

        public String toString(){
            switch (this){
                case TYPE_EXPRESS: return "Експрес";
                case TYPE_COUPE: return "Купе";
                case TYPE_PLACKART: return "Плацкарт";
                default: throw new IllegalArgumentException();
            }
        }
    }


    @Override
    public String toString() {
        return "Вагон" +
                " Индекс" + index +
                ", Количество пассажиров" + quantityPassangers +
                ", Количество багажа в вагоне" + quantityBaggage +
                ", Уровень комфорта в вагоне" + comfortLevel;
    }
}
