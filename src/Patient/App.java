package Patient;

import java.util.Random;

/**
 * Created by Николай on 18.08.2016.
 */
public class App {
private static Patient[] patients;
    private static final String[] name = {
            "Вася",
            "Петя",
            "Гриша",
            "Юра",
            "Миша",
            "Гена",
            "Никита",
            "Евгений"
    };
    private static final String[] lastName = {
            "Иванов",
            "Гончаренко",
            "Гонеев",
            "Полбин",
            "Бражник",
            "Брусенцов",
            "Поляк",
            "Ковалев"
    };
    private static final String[] middleName = {
            "Юрьевич",
            "Сергеевич",
            "Александрович",
            "Петрович",
            "Сергеевич",
            "Григорьевич",
            "Владимирович",
            "Николаевич"
    };
    private static final String[] address = {
            "просп. Гагарина, 41/2",
            "ул. Полевая, 67",
            "просп. Московский, 54а",
            "ул. Якира, 124",
            "ул. Достоевского, 5",
            "ул. Академика Павлова, 120",
            "просп. Победы, 46-а",
            "ул. Малогончаровская, 28/30"
    };
    private static final String[] diagnosis = {
            "Ветрянка",
            "Гайморит",
            "Ангина",
            "Остеохондроз",
            "Бронхит.",
            "Рак",
            "Туберкулез",
            "Гонорея"
    };
    public static void patientsList(){
        Random r = new Random();
        patients = new Patient[8];
        for(int i = 0; i<patients.length;i++){
            Patient c = new Patient();
            c.setName(name[r.nextInt(8)]);
            c.setLastName(lastName[r.nextInt(8)]);
            c.setMiddleName(middleName[r.nextInt(8)]);
            c.setAddress(address[r.nextInt(8)]);
            c.setPhoneNumber("+38063"+(((int) (Math.random()*1000000)+1)));
            c.setNumberMedicalCart(r.nextInt(8)+1);
            c.setDiagnosis(diagnosis[r.nextInt(8)]);
            patients[i] = c;
        }
    }
    public static void pirntPatientList(){
        System.out.println("Список всех поцеентов");
        for(Patient c: App.patients){
            System.out.println(c.toString());
        }
    }

    public static void main(String[] args) {
        patientsList();
        pirntPatientList();
        printPatientsDiagnosis("Рак");
        printPatientsNumberCard(3,6);
    }
    public static void printPatientsDiagnosis(String diagnosis){
        System.out.println();
        System.out.println("Cписок пациентов имеющих данный диагноз");
        for(Patient c: patients){
            if(c.getDiagnosis().equals(diagnosis)){
                System.out.println(c);
            }
        }
    }
    public static void printPatientsNumberCard(int from, int befor){
        System.out.println();
        System.out.println("Cписок пациентов номер медецинской карты которых находится в заданном порядке");
        for(Patient c: patients){
            if(c.getNumberMedicalCart()>=from && c.getNumberMedicalCart() <=befor){
                System.out.println(c);
            }
        }
    }
}
