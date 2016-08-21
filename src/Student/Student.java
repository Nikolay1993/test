package Student;

/**
 * Created by Николай on 04.08.2016.
 */
public class Student {
    private static int genderedId = 0;
    private final int id;
    private String name;
    private String lastName;
    private String middleName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String departament;
    private int cource;
    private int group;

    {
        genderedId++;
    }
    Student() {

        id = genderedId;
    }

    public Student(int id, String name, String lastName,
                   String middleName, String birthday,
                   String address, String phoneNumber,
                   String department, int coerce, int group) {
        this.id = genderedId;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.departament = department;
        this.cource = coerce;
        this.group = group;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public int getCource() {
        return cource;
    }

    public void setCource(int cource) {
        this.cource = cource;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return lastName + " " + name + " " + middleName + ", дата рождения: "
                + birthday + ", адрес: " + address + ", телефон: " + phoneNumber + ", факультет "
                + departament + ", " + cource + " курс" + ", группа " + group;
    }
}
