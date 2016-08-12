package Customer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

/**
 * Created by Николай on 09.08.2016.
 */
public class App {
    static Customer[] customers;
    static final String [] Name = {
            "Nikita",
            "Aleg",
            "Oleg",
            "Vova",
            "Jeka"
    };
    static final String [] lastName ={
            "Temoshenko",
            "Ashot",
            "Vlasenko",
            "Shved",
            "Nikitin"
    };
    static final String [] middleName = {
            "Aleksandrovich",
            "Yrevich",
            "Enakentevich",
            "Adolfovich",
            "Nikolaevich"
    };
    static {
        Random r = new Random();
        customers = new Customer[10];
        for(int i = 0; i<customers.length; i++){
            Customer c = new Customer();
            c.setName(Name[r.nextInt(5)]);
            c.setLastName(lastName[r.nextInt(5)]);
            c.setMiddleName(middleName[r.nextInt(5)]);
            c.setNumberCreditCard(((int) (Math.random()*200000)+1));
            c.setBankAccountNumber(((int) (Math.random()*200000)+1));
            customers[i] = c;
        }
    }

    public static void main(String[] args) {
        print(customers);
        Arrays.sort(customers); //сортирует по принципу, описанным в compareTo
        System.out.println("after sorting");
        print(customers);

        Arrays.sort(customers);
        System.out.println("after sorting by list of buyers in alphabetical order");
        print(customers);

        Arrays.sort(customers);
        System.out.println("after sorting by the list of buyers at whom the credit card number is in the set interval");
        print(customers);}

        public static void print(Customer[]customers){
         for(Customer c: App.customers){
             System.out.println(c.toString());
             Customer.creditCardGet(customers, 186689,193446);
         }
    }
    }


