package electroDevices;

import java.util.Arrays;

/**
 * Created by Николай on 15.10.2016.
 */
public class ElectroDevices implements Comparable<ElectroDevices>{
    private int powerElectroDevices;// мощьность электро приборов
    private boolean socket;// розетка
    private String color;// цвет
    private int width;// ширина
    private int height;// высота
    private ElectroDevices[] arrOfElectroDevice;// масив электро приборов
    private int countExpenseOfElectroEnergy=0; //счетчик электро энергии



    public ElectroDevices() {
    }

    public ElectroDevices(int powerElectroDevices, boolean socket, String color, int width, int height, ElectroDevices[] arrOfElectroDevice) {
        this.powerElectroDevices = powerElectroDevices;
        this.socket = socket;
        this.color = color;
        this.width = width;
        this.height = height;
        this.arrOfElectroDevice = arrOfElectroDevice;
    }

    public int getPowerElectroDevices() {
        return powerElectroDevices;
    }

    public void setPowerElectroDevices(int powerElectroDevices) {
        this.powerElectroDevices = powerElectroDevices;
    }

    public boolean getSocket() {
        return socket;
    }

    public void setSocket(boolean socket) {
        this.socket = socket;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ElectroDevices[] getArrOfElectroDevice() {
        return arrOfElectroDevice;
    }

    public void setArrOfElectroDevice(ElectroDevices[] arrOfElectroDevice) {
        this.arrOfElectroDevice = arrOfElectroDevice;
    }

    public int getCountExpenseOfElectroEnergy() {
        return countExpenseOfElectroEnergy;
    }

    public void setCountExpenseOfElectroEnergy(int countExpenseOfElectroEnergy) {
        this.countExpenseOfElectroEnergy = countExpenseOfElectroEnergy;
    }

    // сравнить приборы по потребляемой мощности
    @Override
    public int compareTo(ElectroDevices o) {
        if(o == null) {
            return 0;
        }
        if(this.powerElectroDevices < o.powerElectroDevices){
            return 1;
        }
        else if(this.powerElectroDevices > o.powerElectroDevices){
            return -1;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" +
                " Мощность электро приборов VT - " + powerElectroDevices +
                " Цвет " + color + '\'' +
                " Ширина " + width +
                " Высота " + height +
                ", arrOfElectroDevice=" + Arrays.toString(arrOfElectroDevice) +
                '}';
    }

    public void sortOfpowerElectroDevices(){
        Arrays.sort(arrOfElectroDevice);
    }
// метод выводит все електро девайсы в консоль
    public void printElectroDevaices(){
        for(ElectroDevices electroDevices: arrOfElectroDevice){
            System.out.println(electroDevices);
        }
    }

    public void printDevaicesWichLine(final int from, final int before){
        boolean isPresence = false;
        for(ElectroDevices electroDevices: arrOfElectroDevice){
            if(electroDevices.getPowerElectroDevices()>= from &&
                    electroDevices.getPowerElectroDevices()<=before){
                System.out.println(electroDevices);
                isPresence = true;
            }
        }
        if(!isPresence){
            throw new IllegalArgumentException("Таких девайсов нет");
        }
    }

    public void setPowerElectroDevaices(ElectroDevices[] electroDevices){
        for(ElectroDevices c: electroDevices){
            countExpenseOfElectroEnergy+=c.getCountExpenseOfElectroEnergy();
        }
        this.arrOfElectroDevice=arrOfElectroDevice;
    }

}
