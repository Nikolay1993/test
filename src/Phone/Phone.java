package Phone;

/**
 * Created by Николай on 20.08.2016.
 */
public class Phone implements Comparable<Phone>  {
    private static int genderedId = 0;
    private final int id;
    private String lastName;
    private String name;
    private String middleName;;
    private String address;
    private String numberCreditCart;
    private int debit;
    private int Credit;
    private int TimeCityconversation;
    private int TimeInternationalCalls;

    {
        genderedId++;
    }
     public Phone() {

        id = genderedId;
    }

    public Phone(int id, String lastName, String name, String middleName, String address, String numberCreditCart,
                 int debit, int credit, int timeCityconversation, int timeInternationalCalls) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.numberCreditCart = numberCreditCart;
        this.debit = debit;
        Credit = credit;
        TimeCityconversation = timeCityconversation;
        this.TimeInternationalCalls = timeInternationalCalls;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNumberCreditCart() {
        return numberCreditCart;
    }

    public void setNumberCreditCart(String numberCreditCart) {
        this.numberCreditCart = numberCreditCart;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public int getTimeCityconversation() {
        return TimeCityconversation;
    }

    public void setTimeCityconversation(int timeCityconversation) {
        TimeCityconversation = timeCityconversation;
    }

    public int getTimeInternationalCalls() {
        return TimeInternationalCalls;
    }

    public void setTimeInternationalCalls(int timeInternationalCalls) {
        TimeInternationalCalls = timeInternationalCalls;
    }

    @Override
    public String toString() {
        return lastName  +
                 name +
                middleName  +
                ", Адрес " + address + '\'' +
                ", Номер кридитной карточки " + numberCreditCart +
                ", Дебет " + debit +
                ", Кридит " + Credit +
                ", Время городских разговоров " + TimeCityconversation +
                ", Время загородных разговоров " + TimeInternationalCalls;
    }

    @Override
    public int compareTo(Phone o) {
        return lastName.compareTo(o.lastName);
    }
}
