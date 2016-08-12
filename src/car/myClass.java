package car;

/**
 * Created by Николай on 04.08.2016.
 */
import java.util.Comparator;

/**
 * Created by JAVA on 29.07.2016.
 */
public class myClass implements Comparable<myClass>{
    double engineVolume;
    String vender;
    String color;
    int seats;

    public myClass() {
    }

    public myClass(double engineVolume, String vender, String color, int seats) {
        this.engineVolume = engineVolume;
        this.vender = vender;
        this.color = color;
        this.seats = seats;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "myClass{" +
                "engineVolume=" + engineVolume +
                ", vender='" + vender + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof myClass)){
            return false;
        }
        myClass o = (myClass)obj;
        return this.vender.equals(o.vender);
    }

    public int compareTo(myClass o) {
        return vender.compareTo(o.vender);
    }

    static class myClassComparator implements Comparator<myClass>{
        private int sortingField = 0;
        public static final int SORTING_FIELD_VOLUME = 0;
        public static final int SORTING_FIELD_COLOR = 1;
        public static final int SORTING_FIELD_VENDER = 2;
        public static final int SORTING_FIELD_SEATS = 3;


        public myClassComparator(int sortingFieldVender){

        }

        public int compare(myClass o1, myClass o2){

            switch (sortingField){
                case 0:{
                    if(o1.engineVolume > o2.engineVolume){
                        return 1;
                    }else if(o1.engineVolume < o2.engineVolume){
                        return -1;
                    }else{
                        return 0;
                    }
                }
                case 1:{
                    return o1.color.compareTo(o2.color);
                }
                case 2:{
                    return o1.vender.compareTo(o2.vender);
                }
                case 3:{
                    return o1.seats - o2.seats;
                }
                default:{
                    o1.compareTo(o2);
                }
            }
            return 0;
        }
    }
}
