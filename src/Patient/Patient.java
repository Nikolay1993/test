package Patient;

/**
 * Created by Николай on 18.08.2016.
 */
public class Patient {
    private static int genderedId = 0;
    private final int id;
    private String name;
    private String lastName;
    private String middleName;
    private String address;
    private String phoneNumber;
    private int numberMedicalCart;
    private String diagnosis;

    {
        genderedId++;
    }
    Patient() {

        id = genderedId;
    }

    public Patient(int id, String name, String lastName, String middleName, String address, String phoneNumber, int numberMedicalCart, String diagnosis) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberMedicalCart = numberMedicalCart;
        this.diagnosis = diagnosis;
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

    public int getNumberMedicalCart() {
        return numberMedicalCart;
    }

    public void setNumberMedicalCart(int numberMedicalCart) {
        this.numberMedicalCart = numberMedicalCart;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return lastName + " " + name + " " + middleName +
                ", адрес: " + address + ", телефон: " + phoneNumber
                + ",Номер медецинской карты: " + numberMedicalCart + ", Диагноз " + diagnosis;
    }
}

