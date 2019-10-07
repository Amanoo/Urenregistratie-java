package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller  {

    //Begintijd input
    @FXML
    TimeSpinner inTime;

    //Stoptijd input
    @FXML
    TimeSpinner outTime;

    //Input voor hoeveelheid pauze
    @FXML
    TimeSpinner pauseTime;

    //Dag van de week die het nu is
    @FXML
    Label dayLabel;

    //Input voor datum
    @FXML
    DatePicker datePicker;

    /****************** Telepunt tabel *********************/
    //Tabel met telepunt taken
    @FXML
    TableView telepuntTabel;
    //Tijdkolom in tabel
    @FXML
    TableColumn tijdColumn;
    //Omschrijving van taak
    @FXML
    TableColumn omschrijvingColumn;

    @FXML
    Button opslaanButton;
    /***************** Eind telepunt tabel ****************/


    @FXML
    ToggleButton weekButton;
    @FXML
    ToggleButton maandButton;

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
        maandButton.setSelected(true);
    }


    public void annulerenPressed(ActionEvent actionEvent) {
    }

    public void verwijderPressed(ActionEvent actionEvent) {
    }

    public void weekButtonPressed(ActionEvent actionEvent) {
        maandButton.setSelected(false);
    }

    public void maandButtonPressed(ActionEvent actionEvent) {
        weekButton.setSelected(false);
    }
}
