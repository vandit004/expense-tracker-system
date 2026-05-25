import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
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


    public void viewExpenses() {

        try{

            Connection connection = DatabaseConnection.connect();

            String query = "SELECT * FROM expenses";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                int id  = resultSet.getInt("id");
                String title = resultSet.getString("title");
                double amount = resultSet.getDouble("amount");
                String category = resultSet.getString("category");
                Date expenseDate = resultSet.getDate("expense_date");

                System.out.println("ID" + id);
                System.out.println("Title" + title);
                System.out.println("Amount" + amount);
                System.out.println("Category "+ category);
                System.out.println("Date"+ expenseDate);

                System.out.println("-------------------");
            }

         

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}