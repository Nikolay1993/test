package electroDevices;

/**
 * Created by Николай on 15.10.2016.
 */
// Микроволновка
public class Microwave extends ElectroDevices {

    private String name;// названия девайся

    public Microwave() {
    }

    public Microwave(int powerElectroDevices, boolean socket, String color, int width, int height, ElectroDevices[] arrOfElectroDevice, String name) {
        super(powerElectroDevices, socket, color, width, height, arrOfElectroDevice);
        this.name = name;
    }

    @Override
    public String toString() {
        return " Микроволновка " + name;
    }
}
