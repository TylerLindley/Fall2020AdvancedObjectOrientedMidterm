import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DataUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connString = "jdbc:mysql://localHost:3306/F20COMP1011Test2";

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
            return customers;
        }
    }
    public static ArrayList<Customer> getTallest(ArrayList<Customer> customers) throws SQLException {
        ArrayList<Customer> tallest = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(connString, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE centimeters >=190 LIMIT 8");
            while (resultSet.next()) {
                String[] phoneNumber = resultSet.getString("telephonenumber").split("- ");
                tallest.add(new Customer
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
            return tallest;
        }
    }
}
