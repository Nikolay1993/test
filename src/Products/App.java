package Products;

import java.util.Random;

/**
 * Created by Николай on 23.08.2016.
 */
public class App {
    private static Products[]productses;
    public static final String[] nameProduct = {
            "Мясо",
            "Рыба",
            "Овощи",
            "Фрукты",
            "Крупы",
            "Молочное",
            "Полу фабрикаты"
    };
    public static final String[] make = {
            "Агромарс ЛТД",
            "Гарант Трейд ЛТД",
            "ЮГ-АГРОС",
            "Французьке Каченя, ТМ",
            "МТН Трейд , ООО",
            "Гал Сир Продукт, ТОВ",
            "Brainfor, ТМ"
    };
    public static void listProduct(){
        Random r = new Random();
        productses = new Products[10];
        for(int i = 0; i<productses.length; i++){
            Products prodect = new Products();
            prodect.setNameProduct(nameProduct[r.nextInt(7)]);
            prodect.setUPC((((int) (Math.random()*1000000000)+1)));
            prodect.setMake(make[r.nextInt(7)]);
            prodect.setPrice(r.nextInt(180)+20);
            prodect.setPeriodOfStorage(r.nextInt(10)+1);
            prodect.setQuantity(r.nextInt(5)+1);
            productses[i]=prodect;
        }
    }
    public static void printListProduct(){
        System.out.println("Список всех продуктов");
        for (Products c: productses){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        listProduct();
        printListProduct();
        printListProductName("Крупы");
        printlistNamePrice(100,"Молочное");
        printlistperiodOfStorageHigtandLow(7);
    }
    public static void printListProductName(String nameProduct){
        System.out.println();
        System.out.println("Список продуктов заданного наименования");
        for (Products c: productses){
            if (c.getNameProduct().equals(nameProduct)){
                System.out.println(c);
            }
        }
    }
    public static void printlistNamePrice(int low, String nameProducts){
        System.out.println();
        System.out.println("Список продуктов заданного наименования цена которых не привосходит заданную");
        for (Products c: productses){
            if (c.getNameProduct().equals(nameProducts)){
                if(c.getPrice()<=low)
                        System.out.println(c);
            }
        }
    }
    public static void printlistperiodOfStorageHigtandLow(int low){
        System.out.println();
        System.out.println("Список товаро у которых срок хранения больше заданного");
        for(Products c: productses){
            if(c.getPeriodOfStorage()>=low){
                System.out.println(c);
            }
        }
    }
}
