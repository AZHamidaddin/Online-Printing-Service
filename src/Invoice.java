/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: #1
 */
import java.util.Date;
import java.time.LocalDate;

public class Invoice {

    private long invoiceNo;
    private String printservice;
    private String deliveryservice;
    private String customer;
    private double VAT = 0.15;
    private int NoOfPrints;
    private LocalDate invoiceDate;
    private boolean isFirstOrder;

    public Invoice(long invoiceNo, String printservice, String deliveryservice,
            String customer, int NoOfPrints, LocalDate invoiceDate, boolean isFirstOrder) {
        this.invoiceNo = invoiceNo;
        this.printservice = printservice;
        this.deliveryservice = deliveryservice;
        this.customer = customer;
        this.NoOfPrints = NoOfPrints;
        this.invoiceDate = invoiceDate;
        this.isFirstOrder = isFirstOrder;
    }

    public Invoice(long invoiceNo, String printservice, String deliveryservice, String customer, int NoOfPrints) {
        this.invoiceNo = invoiceNo;
        this.printservice = printservice;
        this.deliveryservice = deliveryservice;
        this.customer = customer;
        this.NoOfPrints = NoOfPrints;
    }

    public Invoice(LocalDate invoiceDate, boolean isFirstOrder) {
        this.invoiceDate = invoiceDate;
        this.isFirstOrder = isFirstOrder;
    }

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getPrintservice() {
        return printservice;
    }

    public void setPrintservice(String printservice) {
        this.printservice = printservice;
    }

    public String getDeliveryservice() {
        return deliveryservice;
    }

    public void setDeliveryservice(String deliveryservice) {
        this.deliveryservice = deliveryservice;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getVAT() {
        return VAT;
    }

    public int getNoOfPrints() {
        return NoOfPrints;
    }

    public void setNoOfPrints(int NoOfPrints) {
        this.NoOfPrints = NoOfPrints;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public boolean isIsFirstOrder() {
        return isFirstOrder;
    }

    public void setIsFirstOrder(boolean isFirstOrder) {
        this.isFirstOrder = isFirstOrder;
    }

    public double CalculateTotalAmount(boolean isFirstOrder, double cost, int numOfPrints, double deliveryCharge) {
        double total = cost * numOfPrints;
        
        if (total >= 100 && total < 200) {
            total *= 0.9;
        } 
        else if (total >= 200 && total < 300) {
            total *= 0.85;
        } 
        else if (total >= 300 && total <500) {
            total *= 0.8;   
        }
        else if (total > 500) {
            total *= 0.7;
        }
        
        if(isFirstOrder) {
            if (total < 20)
                total = 0;
            else
                total -= 20;
        }
        
        if (total < 250)
            total += deliveryCharge;
        
        total += total * VAT;
        
        return total;

    }
}
