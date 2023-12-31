package customerfinancemanager;

import java.util.Locale;
import javax.swing.JOptionPane;

/*------------------------------------------------------start------------------------------------------------------*/
// Main class for handling customer finance calculations
public class Customer_Finance {
    
    /*------------------------------------------main method start------------------------------------------*/
    public static void main(String[] args) {
        // Create an instance of the Finance_Period class to represent a customer 
        Finance_Period customer = new Finance_Period();
        
        // Input details for the first customer with no interest
        if (!inputCustomerDetails(customer, "Enter customer details to see if interest applies:")) {
            // User clicked Cancel
            JOptionPane.showMessageDialog(null, "Application Cancelled");
            System.exit(0);
        }
        
        // Calculate repayment and display results for the customer
        customer.calculateRepayment();
        displayResults(customer);  
    }
    /*-------------------------------------------main method end-------------------------------------------*/ 

    // Method for inputting customer details
    private static boolean inputCustomerDetails(Customer customer, String prompt) {
        // Prompt user for customer name
        customer.setCustomerName(JOptionPane.showInputDialog(null, prompt + "\nEnter customer name:", "Customer Name", JOptionPane.QUESTION_MESSAGE));
        if (customer.getCustomerName() == null) {
            return false; // User clicked Cancel
        }
        
        // Prompt user for contact number
        customer.setContactNumber(JOptionPane.showInputDialog(null, prompt + "\nEnter contact number:", "Customer Contact", JOptionPane.QUESTION_MESSAGE));
        if (customer.getContactNumber() == null) {
            return false; // User clicked Cancel
        }
        
        // Prompt user for product price and convert input to double
        String productPriceInput = JOptionPane.showInputDialog(null, prompt + "\nEnter product price:", "Product Price", JOptionPane.QUESTION_MESSAGE);
        if (productPriceInput == null) {
            return false; // User clicked Cancel
        }
        customer.setProductPrice(Double.parseDouble(productPriceInput));

        // Prompt user for number of months and convert input to integer
        String numberOfMonthsInput = JOptionPane.showInputDialog(null, prompt + "\nEnter number of months:", "Number of Months", JOptionPane.QUESTION_MESSAGE);
        if (numberOfMonthsInput == null) {
            return false; // User clicked Cancel
        }
        customer.setNumberOfMonths(Integer.parseInt(numberOfMonthsInput));

        return true; // Input successful
    }

    // Method for displaying customer finance results
    private static void displayResults(Customer customer) {
        // Build a string with formatted results
        StringBuilder result = new StringBuilder("Results:\n");
        result.append(String.format(Locale.ENGLISH, "%-29s: %s%n", "Customer Name", customer.getCustomerName()));
        result.append(String.format(Locale.ENGLISH, "%-29s: %s%n", "Contact Number", customer.getContactNumber()));
        result.append(String.format(Locale.ENGLISH, "%-33s: R %,.2f%n", "Product Price", customer.getProductPrice()));
        result.append(String.format(Locale.ENGLISH, "%-27s: %d%n", "Number of Months", customer.getNumberOfMonths()));
        result.append(String.format(Locale.ENGLISH, "%-26s: R %,.2f%n", "Monthly Repayment", customer.getMonthlyRepaymentAmount()));
        result.append(String.format(Locale.ENGLISH, "%-36s: R %,.2f%n", "Total Due", customer.calculateTotalDue()));

        // Display results using JOptionPane
        JOptionPane.showMessageDialog(null, result.toString());
    }
}
/*-------------------------------------------------------end-------------------------------------------------------*/
