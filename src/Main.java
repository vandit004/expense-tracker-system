
import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseService service
                = new ExpenseService();

        while (true) {

            System.out.println("\n===== Expense Tracker Menu =====");
            System.out.println("1. ADD expenses");
            System.out.println("2. VIEW expenses");
            System.out.println("3. DELETE expenses");
            System.out.println("4. UPDATE expenses");
            System.out.println("5. Monthly expense Sumamry");
            System.out.println("6. Exit     ");

            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("ADD Expense selected");

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

                    Expense expense
                            = new Expense(
                                    category,
                                    amount,
                                    description,
                                    date
                            );

                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    System.out.println("n====== Current Expenses =====");

                    service.viewExpenses();

                    System.out.println("Enter Expense ID to delete");

                    int id = sc.nextInt();

                    sc.nextLine();

                    service.deleteExpense(id);

                    break;

                case 4:

                    System.out.println("\n===== Current Expenses =====");

                    service.viewExpenses();

                    System.out.print("Enter Expense ID to update: ");

                    int updateId = sc.nextInt();

                    System.out.print("Enter new amount: ");

                    double newAmount = sc.nextDouble();

                    sc.nextLine();

                    service.updateExpenseAmount(updateId, newAmount);

                    break;

                case 5:

                    System.out.print("Enter month (1-12): ");

                    int month = sc.nextInt();

                    System.out.print("Enter year: ");

                    int year = sc.nextInt();

                    sc.nextLine();

                    service.showMonthlyExpenseSummary(month, year);

                    break;

                case 6:
                    System.out.println("Exiting Application");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        //service.addExpense(expense);
        //service.viewExpenses();
    }
}
