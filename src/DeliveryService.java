/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: #1
 */
public class DeliveryService {

    private String deliveryServiceID;
    private String deliveryScope;
    private String deliveryPartner;
    private double deliveryCharges;

    public DeliveryService(String deliveryServiceID, String deliveryScope, String deliveryPartner, double deliveryCharges) {
        this.deliveryServiceID = deliveryServiceID;
        this.deliveryScope = deliveryScope;
        this.deliveryPartner = deliveryPartner;
        this.deliveryCharges = deliveryCharges;
    }

    public String getDeliveryServiceID() {
        return deliveryServiceID;
    }

    public void setDeliveryServiceID(String deliveryServiceID) {
        this.deliveryServiceID = deliveryServiceID;
    }

    public String getDeliveryScope() {
        return deliveryScope;
    }

    public void setDeliveryScope(String deliveryScope) {
        this.deliveryScope = deliveryScope;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    @Override
    public String toString() {
        return "DeliveryService{" + '}';
    }

}
