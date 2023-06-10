# Online-Printing-Service
This is the code for an online printing service. This contains all elements including invoice, ordering, and details.


An online printing service is a very convenient facility that offers a cost-effective alternative to
anyone who wants business cards, customized posters, brochures, or any other type of print work
completed quickly and effectively. Online printing is a great option for anyone who wants to
save money. The customer needs only upload the files online, select the print preferences for
paper, color, etc., and then the printed papers will be delivered right to the customer's doorsteps.
To stay competitive in the market and bring in new customers, the online printing service is
giving discounts on print orders.

The system you are required to develop is called the Online Printing Service, and it is expected
to facilitate online customers to print their pages and assist the operational manager to keep track
of all requests for successful execution. Initially, the system will register all the print services,
customer, and delivery details from inputPrint.txt. Information read from inputPrint.txt is
written with all the details into a file, called outputPrintDB.txt.

After information registration, the system will be ready to generate invoices for any registered
print service. Since the data is already stored in the system, the operational manager will capture
the minimum data while generating an invoice. For each invoice, the delivery service ID, print
service ID, customer ID, order quantity, order date, and first order status are read from the input
file inputOrders.txt. After processing each order, the details are written to the output file
outputInvoices.txt. The invoice will include all the details and the total amount will be
calculated by applying the discount (if applicable), adding the delivery cost as per the selected
shipment company. An additional VAT amount will be added to the total amount.
