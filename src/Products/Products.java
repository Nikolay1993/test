package Products;

/**
 * Created by Николай on 23.08.2016.
 */
public class Products {
    private static int genderedId = 0;
    private final int id;
    private String nameProduct;
    private int UPC;
    private String make;
    private int price;
    private int periodOfStorage;
    private int quantity;
    {
        genderedId++;
    }
    Products() {

        id = genderedId;
    }

    public Products(int id, String nameProduct, int UPC, String make, int price, int periodOfStorage, int quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.UPC = UPC;
        this.make = make;
        this.price = price;
        this.periodOfStorage = periodOfStorage;
        this.quantity = quantity;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getUPC() {
        return UPC;
    }

    public void setUPC(int UPC) {
        this.UPC = UPC;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeriodOfStorage() {
        return periodOfStorage;
    }

    public void setPeriodOfStorage(int periodOfStorage) {
        this.periodOfStorage = periodOfStorage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                "Название продуктов: " + nameProduct +
                ", Штрих код " + UPC +
                ", Производитель " + make +
                ", Цена " + price +
                ", Срок хранения " + periodOfStorage +
                ", Количество продуктов " + quantity;
    }
}
