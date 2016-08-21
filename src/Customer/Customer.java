package Customer;

/**
 * Created by Николай on 09.08.2016.
 */
public class Customer implements Comparable<Customer> {

    private int id;
   private String Name;
   private String lastName;
   private String middleName;
    private String address;
    private String phoneNumber;
   private int numberCreditCard;
   private int bankAccountNumber;

    public Customer() {
    }

    public Customer(String name, String lastName, String middleName, int numberCreditCard, int bankAccountNumber) {
        Name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.numberCreditCard = numberCreditCard;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getName() { return Name; }

    public void setName(String name) { Name = name;}

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMiddleName() { return middleName; }

    public void setMiddleName(String middleName) { this.middleName = middleName;}

    public int getNumberCreditCard() { return numberCreditCard; }

    public void setNumberCreditCard(int numberCreditCard) { this.numberCreditCard = numberCreditCard; }

    public int getBankAccountNumber() { return bankAccountNumber;  }

    public void setBankAccountNumber(int bankAccountNumber) { this.bankAccountNumber = bankAccountNumber;}

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", numberCreditCard=" + numberCreditCard +
                ", bankAccountNumber=" + bankAccountNumber +
                '}';
    }

    public int compareTo(Customer o) {
        return lastName. compareTo(o.lastName);
    }
    public static void creditCardGet(Customer[]customers, int a, int b) {
        for(int i = 0; i<customers.length; i++){
            if(customers[i].numberCreditCard>a && customers[i].numberCreditCard<b){
                System.out.println(customers[i].toString());
            }
        }
    }

}


