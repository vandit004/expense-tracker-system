import java.sql.Date;

public class Expense {

    private String title;
    private double amount;
    private String category;
    private Date expenseDate;

    public Expense(String title, double amount,
               String category, Date expenseDate) {

        this.title = title;
        this.amount = amount;
        this.category = category;
        this.expenseDate = expenseDate;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public Date getExpenseDate() {
        return expenseDate;

    }
}