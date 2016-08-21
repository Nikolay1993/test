package Books;

/**
 * Created by Николай on 19.08.2016.
 */
public class Books {
    private static int genderedId = 0;
    private final int id;
    private String name;
    private String authors;
    private String publishingHouse;
    private int YearEdition;
    private int numberPages;
    private String price;
    private String coverType;
    {
        genderedId++;
    }
    Books() {

        id = genderedId;
    }

    public Books(int id, String name, String authors, String publishingHouse, int yearEdition, int numberPages,String price, String coverType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        YearEdition = yearEdition;
        this.numberPages = numberPages;
        this.price = price;
        this.coverType = coverType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearEdition() {
        return YearEdition;
    }

    public void setYearEdition(int yearEdition) {
        YearEdition = yearEdition;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return  name +
                ", Автор: " + authors +
                ", Издательсвто: " + publishingHouse +
                ", Год издания: " + YearEdition +
                ", Количество страниц: " + numberPages +
                ", Цена: " + price +
                ", Тип Переплета: " + coverType;
    }
}
