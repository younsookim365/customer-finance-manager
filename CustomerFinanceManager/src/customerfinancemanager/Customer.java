package customerfinancemanager;

public class Customer {
    private String customerName;
    private String contactNumber;
    private double productPrice;
    private int numberOfMonths;
    double monthlyRepaymentAmount;

    // Getter and setter methods for each field (excluding monthlyRepaymentAmount)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public double getMonthlyRepaymentAmount() {
        return monthlyRepaymentAmount;
    }

    // Method to calculate monthly repayment amount and total due
    public void calculateRepayment() {
        this.monthlyRepaymentAmount = productPrice / numberOfMonths;
    }

    // Method to calculate total due (without an additional field)
    public double calculateTotalDue() {
        return monthlyRepaymentAmount * numberOfMonths;
    }
}