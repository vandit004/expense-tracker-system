import java.sql.Connection;
import java.sql.DriverManager;

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

    
}