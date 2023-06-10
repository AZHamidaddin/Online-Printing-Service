/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: #1
 */
public class Customer {

    private String nationalID;
    private String First_name;
    private String Last_name;
    private String address;
    private int NumOfOrders;

    public Customer(String nationalID, String First_name, String Last_name, String address) {
        this.nationalID = nationalID;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.address = address;
    }

    public int getNumOfOrders() {
        return NumOfOrders;
    }

    public void setNumOfOrders(int NumOfOrders) {
        this.NumOfOrders = NumOfOrders;
    }
    

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getAddress() {
        return address;
    }

    public void getAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + '}';
    }

}
