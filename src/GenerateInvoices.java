/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: #1
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GenerateInvoices {

    public static void main(String[] args) throws FileNotFoundException {

        //create file object for inputPrint.txt
        File inputPrint = new File("inputPrint.txt");
        Scanner read_IP = new Scanner(inputPrint);

        //check if file exists
        if (!inputPrint.exists()) {
            System.exit(0);
        }

        //create object arrays for commands
        PrintService[] AddPS = new PrintService[read_IP.nextInt()];
        DeliveryService[] AddDS = new DeliveryService[read_IP.nextInt()];
        Customer[] AddCust = new Customer[read_IP.nextInt()];

        //create index counters for each of the arrays
        int PSindex = 0;
        int DSindex = 0;
        int Custindex = 0;

        //start a loop that reads the file inputPrint.txt
        while (read_IP.hasNext()) {
            String line = read_IP.next();

            //check if the first word in each line is Quit
            if (line.equals("Quit")) {
                break;
            }

            //check which command is invoked and and data values accordingly
            switch (line) {
                case "AddPrintService":
                    PrintService ps = new PrintService(read_IP.next(), read_IP.next(), read_IP.next(), read_IP.next(), read_IP.nextDouble());
                    AddPS[PSindex] = ps;
                    PSindex++;
                    break;

                case "AddDeliveryService":
                    DeliveryService ds = new DeliveryService(read_IP.next(), read_IP.next(), read_IP.next(), read_IP.nextDouble());
                    AddDS[DSindex] = ds;
                    DSindex++;
                    break;

                case "AddCustomer":
                    Customer c = new Customer(read_IP.next(), read_IP.next(), read_IP.next(), read_IP.next());
                    AddCust[Custindex] = c;
                    Custindex++;
                    break;

            }

        }
        
//--------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------This is the end of step 1----------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
 
        //create file object for inputOrders.txt
        File inputOrders = new File("inputOrders.txt");
        Scanner read_IO = new Scanner(inputOrders);

        //check if file exists
        if (!inputOrders.exists()) {
            System.exit(0);
        }

        //create array for invoices
        Invoice[] AddInvoice = new Invoice[read_IO.nextInt()];

        //create loop that reads the file inputOrders.txt
        for (int i = 0; i < AddInvoice.length; i++) {
            String line = read_IO.next();

            //check if the first word in each line is Quit
            //no need to add a GenerateInvoice command as there is no other type of command
            if (line.equals("Quit")) {
                break;
            } //Enter information into the invoice array
            else {
                Invoice invoice = new Invoice(i + 1, read_IO.next(), read_IO.next(), read_IO.next(), read_IO.nextInt());
                LocalDate d = LocalDate.of(read_IO.nextInt(), read_IO.nextInt(), read_IO.nextInt());
                invoice.setInvoiceDate(d);
                invoice.setIsFirstOrder(read_IO.nextBoolean());
                AddInvoice[i] = invoice;

            }

        }

//----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------End of Step 2----------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------

        //create a new file object for outputInvoices.txt
        File outputInvoices = new File("outputInvoices.txt");

        //create PrintWriter object to write into the outputInvoices.txt file
        PrintWriter output = new PrintWriter(outputInvoices);
        output.println("--------------- Welcome to Online Printing Service Invoice System ---------------");
        output.println();
        output.println();

        //start a loop that generates invoices into outputInvoices.txt
        for (int i = 0; i < AddInvoice.length; i++) {
            output.println("Invoice No. " + AddInvoice[i].getInvoiceNo() + "                Date: " + AddInvoice[i].getInvoiceDate());
            output.println();
            output.println("Print Service Details");
            output.println("        Print Service ID: " + AddInvoice[i].getPrintservice());

            //this nested loop checks for the print service ID and matches it with the order details
            for (int j = 0; j < AddPS.length; j++) {
                if (AddInvoice[i].getPrintservice().equals(AddPS[j].getPrintServiceID())) {
                    output.println("        Print Type: " + AddPS[j].getPrintType());
                    output.println("        Paper Finishing: " + AddPS[j].getPaperFinishing());
                    output.println("        Color Mode: " + AddPS[j].getColorMode());
                    output.println("        Cost: " + AddPS[j].getCost());
                    PSindex = j;
                    break;
                }

            }
            output.println("        No. of Prints: " + AddInvoice[i].getNoOfPrints());
            output.println();

            output.println("Delivery Service Details");
            output.println("        Delivery Service Code: " + AddInvoice[i].getDeliveryservice());

            //this nested loop checks for delivery service ID and matched it with the order details
            for (int j = 0; j < AddDS.length; j++) {
                if (AddInvoice[i].getDeliveryservice().equals(AddDS[j].getDeliveryServiceID())) {
                    output.println("        Delivery Scope: " + AddDS[j].getDeliveryScope());
                    output.println("        Delivery Address: " + AddDS[j].getDeliveryPartner());
                    DSindex = j;
                    break;
                }

            }
            output.println();

            output.println("Customer Details");
            output.println("        Customer ID: " + AddInvoice[i].getCustomer());

            //this nested loop checks for the name associated with the customer ID as well as counts num of order per customer
            for (int j = 0; j < AddCust.length; j++) {
                if (AddInvoice[i].getCustomer().equals(AddCust[j].getNationalID())) {
                    output.println("        Full Name: " + AddCust[j].getFirst_name() + " " + AddCust[j].getLast_name());
                    Custindex = j;
                    AddCust[j].setNumOfOrders(AddCust[j].getNumOfOrders() + 1);
                    break;
                }

            }
            output.println();

            //call an invoice method to calculate the total amount
            output.print("Total Amount: (including VAT): ");
            output.printf("%.2f", AddInvoice[i].CalculateTotalAmount(AddInvoice[i].isIsFirstOrder(),
                    AddPS[PSindex].getCost(), AddInvoice[i].getNoOfPrints(), AddDS[DSindex].getDeliveryCharges()));
            output.println(" SAR");
            output.println("───────────────────────────────────────────────────────");

            //at the end of each iteration an invoice will have been completely generated
        }

        //start forming the template of total print services by a customer
        output.println("--------Total Print Service(s) by customer--------");
        output.println();
        output.println("Customer ID             Customer Name       Total Delivery Orders(s)");
        output.println();

        //start a loop to write out all the remaining information in outputInvoices.txt
        for (int i = 0; i < AddCust.length; i++) {
            String name = AddCust[i].getFirst_name() + " " + AddCust[i].getLast_name();
            output.printf("%s%27s%30s%n", AddCust[i].getNationalID(), name, AddCust[i].getNumOfOrders());

        }

        output.flush();
        output.close();

//---------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------Invoices have been generated-------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------   
        
        //create file object for outputPrintDB.txt
        File outputPrintDB = new File("outputPrintDB.txt");

        //create printwriter object to write into outputPrintDB.txt
        PrintWriter database = new PrintWriter(outputPrintDB);

        //begin writing into outputPrintDB.txt
        database.println("--------------- Welcome to Online Printing Service Database ---------------");
        database.println();
        database.println();
        database.println("Adding (" + AddPS.length + ") Print Service to the System...\n");

        //open loop for Print Service items
        for (int i = 0; i < AddPS.length; i++) {

            database.println("\tService ID: " + AddPS[i].getPrintServiceID() + "\tPrint Type: " + AddPS[i].getPrintType()
                    + "\tPaper Finishing: " + AddPS[i].getPaperFinishing() + "\tColor Mode: " + AddPS[i].getColorMode()
                    + "\tPrint cost: " + AddPS[i].getCost() + " SAR");

        }

        //add partition and continue writing into the file
        database.println("----------------------------------------------------------------------------------------------\n\n"
                + "Adding (" + AddDS.length + ") Delivery Service to the System...\n");

        //open a loop for Delivery Service items
        for (int i = 0; i < AddDS.length; i++) {

            database.println("\tDelivery Code: "
                    + AddDS[i].getDeliveryServiceID() + "\tDelivery Scope: " + AddDS[i].getDeliveryScope()
                    + "\tDelivery Description: " + AddDS[i].getDeliveryPartner() + "\tDelivery Charges: "
                    + AddDS[i].getDeliveryCharges() + " SAR");

        }

        //add partition and continue writing into the file
        database.println("----------------------------------------------------------------------------------------------\n\n"
                + "Adding (" + AddCust.length + ") Customers to the System...\n");

        //open loop for customer items
        for (int i = 0; i < AddCust.length; i++) {
            database.println("\tCustomer ID: " + AddCust[i].getNationalID() + "\tName: " + AddCust[i].getFirst_name()
                    + " " + AddCust[i].getLast_name() + "\tAddress: " + AddCust[i].getAddress());

        }

        //final partition
        database.println("----------------------------------------------------------------------------------------------");

        database.flush();
        database.close();
    }

}
