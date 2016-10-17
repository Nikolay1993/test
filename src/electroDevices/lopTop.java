package electroDevices;

/**
 * Created by Николай on 16.10.2016.
 */
public class lopTop extends ElectroDevices {

    private String name;//Название девайся

    public lopTop() {
    }

    public lopTop(int powerElectroDevices, boolean socket, String color, int width, int height, ElectroDevices[] arrOfElectroDevice, String name) {
        super(powerElectroDevices, socket, color, width, height, arrOfElectroDevice);
        this.name = name;
    }

    @Override
    public String toString() {
        return " Компютер " + name;
    }
}
