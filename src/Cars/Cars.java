package Cars;

/**
 * Created by Николай on 23.08.2016.
 */
/**
 * Created by Николай on 22.08.2016.
 */
public class Cars {
    private static int genderedId = 0;
    private final int id;
    private String brand;
    private String model;
    private int yearManufacture;
    private String color;
    private int price;
    private String registrationNumber;
    {
        genderedId++;
    }
    Cars() {

        id = genderedId;
    }



    public Cars(int id, String brand, String model, int yearManufacture, String color, int price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return
                " Марка " + brand +
                        ", Модель " + model +
                        ", Год выпуска " + yearManufacture +
                        ", Цвет " + color +
                        ", Цена " + price +
                        ", Регестрационный номер " + registrationNumber;
    }

}
