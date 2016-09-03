package Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Николай on 24.08.2016.
 */
public class Trains {
    private static int genderedId = 0;
    private final int id ;
    private String destination;
    private int NumberOfTrein;
    private Calendar timeOfDeparture;
    private int platitude;
    private int kupe;
    private int placart;
    private int lusks;

    {
        genderedId++;
    }
    Trains() {

        id = genderedId;
    }


    public Trains(String destination, int numberOfTrein,
                  String timeOfDeparture, int platitude,
                  int kupe, int placart, int lusks) {
        this.destination = destination;
        NumberOfTrein = numberOfTrein;
        this.timeOfDeparture = makeDate(timeOfDeparture);
        id = genderedId;
        this.platitude = platitude;
        this.kupe = kupe;
        this.placart = placart;
        this.lusks = lusks;
    }

    public static Calendar makeDate(String dateToParse) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd,HH,mm");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(dateToParse));
        } catch (ParseException e) {
            System.out.println("Неверные данные!");
            return null;
        }
        return calendar;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfTrein() {
        return NumberOfTrein;
    }

    public void setNumberOfTrein(int numberOfTrein) {
        NumberOfTrein = numberOfTrein;
    }

    public Calendar getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = makeDate(timeOfDeparture);
    }

    public int getPlatitude() {
        return platitude;
    }

    public void setPlatitude(int platitude) {
        this.platitude = platitude;
    }

    public int getKupe() {
        return kupe;
    }

    public void setKupe(int kupe) {
        this.kupe = kupe;
    }

    public int getPlacart() {
        return placart;
    }

    public void setPlacart(int placart) {
        this.placart = placart;
    }

    public int getLusks() {
        return lusks;
    }

    public void setLusks(int lusks) {
        this.lusks = lusks;
    }

    private String dateToString() {
        String date = "";
        date += timeOfDeparture.get(Calendar.DAY_OF_MONTH) + ".";
        date += timeOfDeparture.get(Calendar.HOUR ) + ".";
        date += timeOfDeparture.get(Calendar.MINUTE);
        return date;
    }

    @Override
    public String toString() {
        return "Поезда " +
                ", Пункт назначения " + destination +
                ", Номер поезда " + NumberOfTrein +
                ", Время отправления " + dateToString() +
                ", Число свободных мест " + platitude +
                ", Купе " + kupe +
                ", Плацкарт " + placart +
                ", Люкс " + lusks ;
    }
}
