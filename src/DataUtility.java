import java.sql.*;
import java.util.ArrayList;

public class DataUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connString = "jdbc:mysql://localHost:3306/F20COMP1011Test1";

    public static ArrayList<Customer> getCustomers() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(connString, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers");
            while (resultSet.next()) {
                String[] phoneNumber = resultSet.getString("telephonenumber").split("- ");
                customers.add(new Customer
                        (resultSet.getInt("number"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("cctype"),
                        resultSet.getString("bloodtype"),
                        phoneNumber[0].trim(), //Need the others but it's giving me an error.
                        resultSet.getDouble("kilograms"),
                        resultSet.getDouble("centimeters")
                ));
            }

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
            if(conn != null) conn.close();
            if(statement != null) statement.close();
            if (resultSet != null) resultSet.close();
            return athletes;
        }
    }
}
