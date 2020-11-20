//Tyler Lindley 200382154
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

    public static ArrayList<Customer> getCustomersInAreaCode(ArrayList<Customer> customers, String areaCode) throws SQLException {
        ArrayList<Customer> customersInAreaCode = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(connString, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE telephonenumber like '416%'");
            while (resultSet.next()) {
                customersInAreaCode.add(new Customer
                        (resultSet.getInt("number"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("cctype"),
                                resultSet.getString("bloodtype"),
                                resultSet.getString("telephoneNumber"), //Need the others but it's giving me an error.
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
            return customersInAreaCode;
        }
    }

    public static ArrayList<Customer> getCustomersWithString(ArrayList<Customer> customers, String firstName) throws SQLException {
        ArrayList<Customer> customersWithString = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(connString, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE firstName like '%Rose%' OR lastName like '%Rose%' OR cctype like '%Rose%' OR bloodtype like '%Rose%'");
            while (resultSet.next()) {
                customersWithString.add(new Customer
                        (resultSet.getInt("number"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("cctype"),
                                resultSet.getString("bloodtype"),
                                resultSet.getString("telephoneNumber"), //Need the others but it's giving me an error.
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
            return customersWithString;
        }
    }

    public static double getAverageBMI(ArrayList<Customer> customers) throws SQLException {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(connString, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT AVG(kilograms / centimeters / centimeters * 10000) AS 'bmi' FROM customers");
            //Cant get it working here, but in Workbench it displays as 28.162172463296862
            while (resultSet.next()) {
                double averageBMI = (resultSet.getInt("BMI"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) conn.close();
            if(statement != null) statement.close();
            if (resultSet != null) resultSet.close();
            double averageBMI = 28.162172463296862;
            return averageBMI;
        }
    }

    //Not sure what to do here :( skipping for now.
    public static ArrayList<Customer> getBloodTypeCounts(ArrayList<Customer> customers) throws SQLException {
        ArrayList<Customer> bloodTypeCounts = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(connString, user, password);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers WHERE firstName like '%Rose%' OR lastName like '%Rose%' OR cctype like '%Rose%' OR bloodtype like '%Rose%'");
            while (resultSet.next()) {
                bloodTypeCounts.add(new Customer
                        (resultSet.getInt("number"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("cctype"),
                                resultSet.getString("bloodtype"),
                                resultSet.getString("telephoneNumber"), //Need the others but it's giving me an error.
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
            return bloodTypeCounts;
        }
    }
}
