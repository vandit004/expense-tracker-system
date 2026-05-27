
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseService {

    public void addExpense(Expense expense) {

        String query
                = "INSERT INTO expenses(title, amount, category, expense_date) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = DatabaseConnection.connect();

            PreparedStatement pstmt
                    = conn.prepareStatement(query);

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

    public void viewExpenses() {

        try {

            Connection connection = DatabaseConnection.connect();

            String query = "SELECT * FROM expenses";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                double amount = resultSet.getDouble("amount");
                String category = resultSet.getString("category");
                Date expenseDate = resultSet.getDate("expense_date");

                System.out.println("ID:" + id);
                System.out.println("Title:" + title);
                System.out.println("Amount:" + amount);
                System.out.println("Category: " + category);
                System.out.println("Date:" + expenseDate);

                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteExpense(int id) {

        try {

            Connection connection = DatabaseConnection.connect();

            String query = "Delete FROM expenses WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Expense Deleted Sucessfully");

            } else {
                System.out.println("Expense ID not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateExpenseAmount(int id, double newAmount) {

        try {

            Connection connection = DatabaseConnection.connect();

            String query = "UPDATE expenses SET amount = ? WHERE id =?";

            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);

            preparedStatement.setDouble(1, newAmount);

            preparedStatement.setInt(2, id);

            int rowsAffected
                    = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.println("Expense updated successfully!");

            } else {

                System.out.println("Expense ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showMonthlyExpenseSummary(int month, int year) {

        try {

            Connection connection
                    = DatabaseConnection.connect();

            String query
                    = "SELECT SUM(amount) FROM expenses "
                    + "WHERE EXTRACT(MONTH FROM expense_date) = ? "
                    + "AND EXTRACT(YEAR FROM expense_date) = ?";

            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);

            preparedStatement.setInt(1, month);

            preparedStatement.setInt(2, year);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            if (resultSet.next()) {

                double totalExpense
                        = resultSet.getDouble(1);

                System.out.println("Total Expense: " + totalExpense);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
