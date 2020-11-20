import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerInformationViewController implements Initializable {

    @FXML
    private ListView<Customer> listView;

    @FXML
    private Label rowsReturnedLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listView.getItems().addAll(DataUtility.getCustomers());
            rowsReturnedLabel.setText(String.format("Rows Returned: %d", listView.getItems().size()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void getCustomers(ActionEvent event) throws SQLException {
        listView.getItems().clear();
        listView.getItems().addAll(DataUtility.getCustomers());
    }

    @FXML
    void getCustomersInAreaCode(ActionEvent event, String areaCode) throws SQLException {
        listView.getItems().clear();
        listView.getItems().addAll(DataUtility.getCustomersInAreaCode());
    }

    @FXML
    void getCustomersWithString(ActionEvent event) {

    }

    @FXML
    void getTallest(ActionEvent event) {
        ArrayList<Customer> tallest = new ArrayList<>();

        listView.getItems().clear();
        for(Customers customer: DataUtility.getCustomers()) {

        }
        listView.getItems().addAll(tallest);
    }
}
