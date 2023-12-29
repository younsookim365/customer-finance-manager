package customerfinancemanager;

public class Finance_Period extends Customer {
    // Override calculateRepayment() to include interest calculation
    @Override
    public void calculateRepayment() {
        if (getNumberOfMonths() > 3 && getNumberOfMonths() <= 12) {
            // Apply 25% interest
            double interest = getProductPrice() * 0.25;
            setMonthlyRepaymentAmount((getProductPrice() + interest) / getNumberOfMonths());
        } else {
            // No interest
            super.calculateRepayment();
        }
    }

    // Setter method for monthlyRepaymentAmount
    private void setMonthlyRepaymentAmount(double monthlyRepaymentAmount) {
        this.monthlyRepaymentAmount = monthlyRepaymentAmount;
    }
}