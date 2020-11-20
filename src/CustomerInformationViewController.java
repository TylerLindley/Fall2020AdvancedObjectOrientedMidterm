//Tyler Lindley 200382154
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.xml.crypto.Data;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerInformationViewController implements Initializable {

    @FXML
    private ListView<Customer> listView;

    @FXML
    private Label rowsReturnedLabel;

    private ArrayList<Customer> allCustomers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            allCustomers = DataUtility.getCustomers();
            listView.getItems().addAll(DataUtility.getCustomers());
            rowsReturnedLabel.setText(String.format("Rows Returned: %d", listView.getItems().size()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void getCustomers() throws SQLException {
        listView.getItems().clear();
        listView.getItems().addAll(DataUtility.getCustomers());
    }

    @FXML
    void getCustomersInAreaCode() {
        ArrayList<Customer> areaCode = new ArrayList<>();

        listView.getItems().clear();
        listView.getItems().addAll(areaCode);
    }

    @FXML
    void getCustomersWithString() {
        ArrayList<Customer> name = new ArrayList<>();

        listView.getItems().clear();
        listView.getItems().addAll(name);
    }

    @FXML
    void getTallest() {
        ArrayList<Customer> tallest = new ArrayList<>();

        listView.getItems().clear();
        listView.getItems().addAll(tallest);
    }
}
