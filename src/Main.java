import java.sql.Date;
import java.util.Scanner;

public class Main {
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