package Airline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Николай on 28.08.2016.
 */
public class Airline {
    private static int genderedId = 0;
    private final int id;
    private String destination;
    private int flightNumber;
    private String aircraftType;
    private Calendar departureTime;
    private String dayOfTheWeek;
    {
        genderedId++;
    }

    Airline() {

        id = genderedId;
    }

    public Airline(int id, String destination, int flightNumber, String aircraftType, String departureTime, String dayOfTheWeek) {
        this.id = id;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = makeDate(departureTime);
        this.dayOfTheWeek = dayOfTheWeek;
    }
    public static Calendar makeDate(String dateToParse) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH,mm");
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

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime =  makeDate(departureTime);
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
    private String dateToString() {
        String date = "";
        date += departureTime.get(Calendar.HOUR ) + ".";
        date += departureTime.get(Calendar.MINUTE);
        return date;
    }

    @Override
    public String toString() {
        return "Cамолеты:" +
                " Пункт назначения " + destination +
                ", Номер рейса " + flightNumber +
                ", Тип самолета " + aircraftType +
                ", Время вылета " + dateToString() +
                ", Днь недели " + dayOfTheWeek;
    }
}
