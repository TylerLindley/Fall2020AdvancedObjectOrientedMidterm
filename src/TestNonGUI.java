//Tyler Lindley 200382154
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class TestNonGUI {
    public static void main(String[] args) throws SQLException {

        System.out.println("DataUtility class - challenge 1");
        ArrayList<Customer> customers = DataUtility.getCustomers();
        System.out.println("this should equal 1000: " + customers.size());
//
        System.out.println("\nDataUtility class - challenge 2");
        ArrayList<Customer> tallest = DataUtility.getTallest(customers);
        System.out.println("This should display the 8 tallest customers. " +
               "ID's 66, 160, 222, 242, 445, 516, 549, 698");
        tallest.stream().forEach(System.out::println);
//
        System.out.println("\nDataUtility class - challenge 3");
        ArrayList<Customer> areaCodeList = DataUtility.getCustomersInAreaCode(customers, "416");
        System.out.println("This should display 125 records: "+areaCodeList.size());
//
        System.out.println("\nDataUtility class - challenge 4");
        ArrayList<Customer> searchListResults = DataUtility.getCustomersWithString(customers, "Rose");
        System.out.println("This should display 3 records: "+searchListResults.size());
        searchListResults.stream().forEach(System.out::println);
//
        System.out.println("\nDataUtility class - challenge 5");
        double avgBMI = DataUtility.getAverageBMI(customers);
        System.out.printf("This should return 28.2. Returned: %.1f: %n",avgBMI);
//          (Skipping for now, not sure what to do here)
//        System.out.println("\nDataUtility class - challenge 6");
//        TreeMap<String, Integer> bloodTypeCounts = DataUtility.getBloodTypeCounts(customers);
//        for (String bloodType: bloodTypeCounts.keySet())
//            System.out.printf("blood type: %-3s  count: %3d%n",bloodType, bloodTypeCounts.get(bloodType));
//
    }
}