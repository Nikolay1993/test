package Student;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Николай on 04.08.2016.
 */
public class App {
    private static Student[] students;
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
    private static final String[] departament = {
            "АП",
            "ИТ",
            "КИТ",
            "КН",
            "МШ",
            "МО",
            "МТ",
            "СГТ"
    };
    public static void studentList() {
        Random r = new Random();
        students = new Student[8];
        for(int i = 0; i<students.length;i++){
           Student student = new Student();
            student.setName(name[r.nextInt(8)]);
            student.setLastName(lastName[r.nextInt(8)]);
            student.setMiddleName(middleName[r.nextInt(8)]);
            student.setBirthday((r.nextInt(31)+1) +"." +(r.nextInt(12)+1) + "." + (r.nextInt(6)+1992));
            student.setAddress(address[r.nextInt(8)]);
            student.setPhoneNumber("+38063"+(((int) (Math.random()*1000000)+1)));
            student.setDepartament(departament[r.nextInt(8)]);
            student.setCource(r.nextInt(6)+1);
            student.setGroup(r.nextInt(3)+1);
            students[i] = student;

        }
    }
        public static void printListAllStudents(Student[] students){
            System.out.println("Список всех студентов");
            for(Student c: App.students){
                System.out.println(c.toString());
            }
        }

    public static void main(String[] args) {
        studentList();
        printListAllStudents(students);
        printSortingDepartament("ИТ");
        pririnStudentListCourseAndDepartament(1, "АП");
        printStudentListYear(1995);
    }
        static void printSortingDepartament (String departament){
            System.out.println();
            System.out.println("Выводит список студентов заданного факультета факультета");
            for(Student c: students){
                if(c.getDepartament().equals(departament)){
                    System.out.println(c);
                }
            }
        }
        static void pririnStudentListCourseAndDepartament(int course, String departament){
            System.out.println();
            System.out.println("Список студентов для каждого Факультета и курса");
            for (Student c: students){
                if(c.getCource()==course && c.getDepartament().equals(departament)){
                    System.out.println(c);
                }
            }
        }
        static void printStudentListYear(int year){
            System.out.println();
            System.out.println("Cписок студентов родившихся после заддоного года");
            for(Student c: students){
                int studentYear = Integer.parseInt(c.getBirthday().split("[.]")[2]);
                if(studentYear > year){
                    System.out.println(c);
                }
            }
        }

        }
