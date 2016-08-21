package Abiturient;

/**
 * Created by Николай on 18.08.2016.
 */
public class Abiturient {
    private static int genderedId = 0;
    private final int id;
    private String name;
    private String lastName;
    private String middleName;
    private String address;
    private String phoneNumber;
    private int estimates;


    {
        genderedId++;
    }
    Abiturient() {

        id = genderedId;
    }

    public Abiturient(int id, String name, String lastName, String middleName, String address, String phoneNumber, int estimates) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.estimates = estimates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEstimates() {
        return estimates;
    }

    public void setEstimates(int estimates) {
        this.estimates = estimates;
    }

    @Override
    public String toString() {
        return
                name  +
                " " + lastName +
                " " + middleName +
                ", Адрес " + address +
                ", Телефон " + phoneNumber +
                ", Оценки " + estimates
                ;
    }
}
