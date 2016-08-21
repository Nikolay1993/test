package Books;

import java.util.Random;

/**
 * Created by Николай on 19.08.2016.
 */
public class App {
private static Books[] bookses;
    private static final String[] name={
            "Железная пята",
            "Портрет Дориана Грея",
            "Гриша",
            "Моби Дик",
            "Чемодан",
            "Три товарища",
            "Рассказы и повести"
    };
    private static final String[] authors={
            "Василий Шкляр",
            "Сергей Жадан",
            "Андрей Курков",
            "Юрий Издрык",
            "Юрий Андрухович"
//            "Никита Никулин",
//            "Владислав Иванов",
//            "Петер Гонеев",
//            "Юрий Светляков",
//            "Сергей Лазерев",
//            "Никита Иванов",
//            "Владислав Владимиров",
//            "Петер Полбин",
//            "Михаил Светляков",
    };
    private static final String[] publishingHouse ={
            "Брошура",
            "Журнал",
            "Книга"
    };
    private static final String[] coverType = {
            "Магкий",
            "Жесткий",
            "Твердый"
    };
//    public static void autors(){
//        boolean flag = true;
//        for (Books book: bookses){
//            if (book.equals(name)&&book.equals(authors)){
//                System.out.print(authors);
//                flag = false;
//            }
//        }
//        if (flag=true){
//            flag=false;
//        }
//    }
    public static void listBooks(){
        Random r = new Random();
        bookses = new Books[10];
        for (int i=0;i<bookses.length;i++){
            Books book = new Books();
            book.setName(name[r.nextInt(7)]);
            book.setAuthors(authors[r.nextInt(5)]);
//            book.setAuthors(autors(r));
            book.setPublishingHouse(publishingHouse[r.nextInt(3)]);
            book.setYearEdition(r.nextInt(7)+2008);
            book.setNumberPages(r.nextInt(100)+100);
            book.setPrice((((int) (Math.random()*200)+1))+" грн");
            book.setCoverType(coverType[r.nextInt(3)]);
            bookses[i]=book;
        }
    }
    public static void printlistBooks(){
        System.out.println("Cписок всех авторов:");
        for(Books c: bookses){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listBooks();
        printlistBooks();
        printlistAuthors("Андрей Курков");
        printListPublishingHouse("Книга");
        printListBooksYear(2011);
    }
    public static void printlistAuthors(String authors){
        System.out.println();
        System.out.println("Список книг заданного автора:");
        for(Books c: bookses){
            if (c.getAuthors().equals(authors)){
                System.out.println(c);
            }
        }
    }
    public static void printListPublishingHouse(String publishingHouse){
        System.out.println();
        System.out.println("Список книг одного издательства");
        for (Books c: bookses){
            if(c.getPublishingHouse().equals(publishingHouse)){
                System.out.println(c);
            }
        }
    }
    public static void printListBooksYear(int from){
        System.out.println();
        System.out.println("Список книг выпущиных после заданного года");
        for(Books c: bookses){
            if(c.getYearEdition()>=from){
                System.out.println(c);
            }
        }
    }
}
