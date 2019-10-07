package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller  {
    @FXML
    TimeSpinner inTime;
    @FXML
    TimeSpinner outTime;
    @FXML
    TimeSpinner pauseTime;
    @FXML
    Label dayLabel;
    @FXML
    DatePicker datePicker;
    @FXML
    TableView telepuntTabel;
    @FXML
    TableColumn tijdColumn;
    @FXML
    TableColumn omschrijvingColumn;
    @FXML
    public void initialize()
    {
        dayLabel.setTextAlignment(TextAlignment.RIGHT);
        String dag = LocalDate.now().getDayOfWeek().name();
        dayLabel.setText(dag.substring(0, 1).toUpperCase() + dag.substring(1).toLowerCase()+" ");
        datePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            String day = newValue.getDayOfWeek().name();
            dayLabel.setText(day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase()+" ");
        });
        datePicker.setValue(LocalDate.now());
        inTime.getEditor().setText("9:00");
        outTime.getEditor().setText("17:00");
    }


}
