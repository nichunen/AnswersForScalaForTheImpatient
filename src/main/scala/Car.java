/**
 * Created by Ni Chunen on 15/12/11.
 */
public class Car {
    private String manufacturer, model;
    private String number = "";
    private int year = -1;

    public Car(String manu, String model) {
        this.manufacturer = manu;
        this.model = model;
    }

    public Car(String manu, String model, String number) {
        this.manufacturer = manu;
        this.model = model;
        this.number = number;
    }

    public Car(String manu, String model, int year) {
        this.manufacturer = manu;
        this.model = model;
        this.year = year;
    }

    public Car(String manu, String model, int year, String number) {
        this.manufacturer = manu;
        this.model = model;
        this.year = year;
        this.number = number;
    }


    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static void main(String [] args) {

    }
}