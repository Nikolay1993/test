package Student;

/**
 * Created by Николай on 04.08.2016.
 */
public class App {

    public static void main(String[] args) {
        Student s = new Student (1,"Nikita","Temoshenko","Yrevich","1996.03.25","23 Avgusta","0688809997","2",4,249);
        Student s1 = new Student (2,"Anton","Ivashenko","Vladimerovich","1995.05.25","Geroev Truda","0684409939","1",3,239);
        Student s2 = new Student (3,"Fedor","Zadorojniy","Nikolaevich","1997.09.25","Alekseevka","0688809946","5",2,229);
        Student s3 = new Student (4,"Maksim","Martinov","Olegovich","1998.01.23","Odesskaya","0623809989","4",1,219);
        Student s4 = new Student (5,"Oleg","Timcenko","Valerevich","1994.03.25","Nauchnaya","0688803487","7",5,259);
        Student[] studentsArr = {s,s1,s2,s3,s4};
        print(studentsArr);

    }
    static void print(Student[]s){
        for(Student c: s){
            System.out.println(c+" ");
        }
    }
}
