package House;

/**
 * Created by Николай on 20.08.2016.
 */
public class House {
    private static int genderedId = 0;
    private final int id;
    private int numberApartment;
    private int ploshchad;
    private int floor;
    private int kolchestvoRooms;
    private String street;
    private String buildingType;
    private int effectiveLife;
    {
        genderedId++;
    }
    House() {

        id = genderedId;
    }

    public House(int id,int numberApartment, int ploshchad, int floor, int kolchestvoRooms, String street, String buildingType, int effectiveLife) {
        this.id = id;
        this.numberApartment = numberApartment;
        this.ploshchad = ploshchad;
        this.floor = floor;
        this.kolchestvoRooms = kolchestvoRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.effectiveLife = effectiveLife;
    }

    public int getNumberApartment() {
        return numberApartment;
    }

    public void setNumberApartment(int numberApartment) {
        this.numberApartment = numberApartment;
    }

    public int getPloshchad() {
        return ploshchad;
    }

    public void setPloshchad(int ploshchad) {
        this.ploshchad = ploshchad;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getKolchestvoRooms() {
        return kolchestvoRooms;
    }

    public void setKolchestvoRooms(int kolchestvoRooms) {
        this.kolchestvoRooms = kolchestvoRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getEffectiveLife() {
        return effectiveLife;
    }

    public void setEffectiveLife(int effectiveLife) {
        this.effectiveLife = effectiveLife;
    }

    @Override
    public String toString() {
        return " Номер квартиры " +numberApartment +
                ", Площадь " + ploshchad +
                ", Этаж " + floor +
                ", Количество комнат " + kolchestvoRooms +
                ", улица" + street +
                ", Тип здания " + buildingType +
                ", Срок эксплуатации " + effectiveLife;
    }
}
