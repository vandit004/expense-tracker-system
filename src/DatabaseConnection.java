import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.Scanner;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5434/expense_tracker";

    private static final String USER = "postgres";

    private static final String PASSWORD = "Vandit2004@";

    public static Connection connect() {

        try {

            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            return conn;

        } catch (Exception e) {

            System.out.println("Connection failed!");

            e.printStackTrace();

            return null;
        }
    }

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

System.out.print("Enter category: ");
String category = sc.nextLine();

System.out.print("Enter amount: ");
double amount = sc.nextDouble();
sc.nextLine();

System.out.print("Enter description: ");
String description = sc.nextLine();

System.out.print("Enter date (YYYY-MM-DD): ");
String dateInput = sc.nextLine();

Date date = Date.valueOf(dateInput);

Expense expense =
        new Expense(
                category,
                amount,
                description,
                date
        );

    ExpenseService service =
            new ExpenseService();

    service.addExpense(expense);
}
}