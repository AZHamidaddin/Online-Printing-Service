/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: #1
 */
public class PrintService {

    private String printServiceID;
    private String printType;
    private String paperFinishing;
    private String colorMode;
    private double cost;

    public PrintService(String printServiceID, String printType, String paperFinishing, String colorMode, double cost) {
        this.printServiceID = printServiceID;
        this.printType = printType;
        this.paperFinishing = paperFinishing;
        this.colorMode = colorMode;
        this.cost = cost;
    }

    public String getPrintServiceID() {
        return printServiceID;
    }

    public void setPrintServiceID(String printServiceID) {
        this.printServiceID = printServiceID;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getPaperFinishing() {
        return paperFinishing;
    }

    public void setPaperFinishing(String paperFinishing) {
        this.paperFinishing = paperFinishing;
    }

    public String getColorMode() {
        return colorMode;
    }

    public void setColorMode(String colorMode) {
        this.colorMode = colorMode;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "PrintService{" + '}';
    }

}
