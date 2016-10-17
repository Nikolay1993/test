package electroDevices;

/**
 * Created by Николай on 15.10.2016.
 */
//Стиральноя машинка
public class WashingMachine extends ElectroDevices{

    private String name;//Название девайся

    public WashingMachine() {
    }

    public WashingMachine(int powerElectroDevices, boolean socket, String color, int width, int height, ElectroDevices[] arrOfElectroDevice, String name) {
        super(powerElectroDevices, socket, color, width, height, arrOfElectroDevice);
        this.name = name;
    }

    @Override
    public String toString() {
        return  " Стиральная машинка " + name;
    }
}
