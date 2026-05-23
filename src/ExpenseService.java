import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExpenseService {

    public void addExpense(Expense expense) {

        String query =
                "INSERT INTO expenses(title, amount, category, expense_date) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = DatabaseConnection.connect();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setString(1, expense.getTitle());
            pstmt.setDouble(2, expense.getAmount());
            pstmt.setString(3, expense.getCategory());
            pstmt.setDate(4, expense.getExpenseDate());

            pstmt.executeUpdate();

            System.out.println("Expense added successfully!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Failed to add expense!");
            e.printStackTrace();
        }
    }
}