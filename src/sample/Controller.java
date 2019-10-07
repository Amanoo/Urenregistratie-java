package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.LocalTime;

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



        ChangeListener<Number> cl = (observable, oldValue, newValue) -> {
            int i = 0;
            for (Node n : telepuntTabel.lookupAll(".scroll-bar")) {
                if (n instanceof ScrollBar) {
                    ScrollBar bar = (ScrollBar) n;
                    if (bar.isVisible()) {
                        i = 16;
                    }else{
                        i=0;
                    }
                }
            }
            omschrijvingColumn.setPrefWidth(telepuntTabel.getWidth() - tijdColumn.getWidth() - 2 - i);
        };
        telepuntTabel.widthProperty().addListener(cl);
        telepuntTabel.heightProperty().addListener(cl);



        Callback<TableColumn, TableCell> omschrijvingFactory =
                p -> new EditingOmschrijvingCell();

        Callback<TableColumn, TableCell> timeFactory =
                p -> new EditingTimeCell();

        omschrijvingColumn.setCellValueFactory(
                new PropertyValueFactory<TelepuntEntry,String>("omschrijving"));
        tijdColumn.setCellValueFactory(
                new PropertyValueFactory<TelepuntEntry,String>("tijd"));


        //omschrijvingColumn.setCellValueFactory(new PropertyValueFactory<>("omschrijving"));
        //tijdColumn.setCellValueFactory(new PropertyValueFactory<>("tijd"));



        omschrijvingColumn.setCellFactory(omschrijvingFactory);
        omschrijvingColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<TelepuntEntry, String>>() {
                    @Override public void handle(TableColumn.CellEditEvent<TelepuntEntry, String> t) {
                        ((TelepuntEntry)t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setOmschrijving(t.getNewValue());
                    }
                });


        tijdColumn.setCellFactory(timeFactory);
        tijdColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<TelepuntEntry, LocalTime>>() {
                    @Override public void handle(TableColumn.CellEditEvent<TelepuntEntry, LocalTime> t) {
                        ((TelepuntEntry)t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setTijd(t.getNewValue());
                    }
                });


        TelepuntEntry telepuntEntry = new TelepuntEntry("John", LocalTime.of(11,00));
        TelepuntEntry telepuntEntry2 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry3 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry4 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry5 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry6 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry7 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry8 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry9 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry10 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry11 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry12 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        TelepuntEntry telepuntEntry13 = new TelepuntEntry("Johgrgggergersgresregresgersgresgresgresgersgersgersgersgresrgern", LocalTime.of(8,03));
        telepuntTabel.getItems().add(telepuntEntry);
        telepuntTabel.getItems().add(telepuntEntry2);
        telepuntTabel.getItems().add(telepuntEntry3);
        telepuntTabel.getItems().add(telepuntEntry4);
        telepuntTabel.getItems().add(telepuntEntry5);
        telepuntTabel.getItems().add(telepuntEntry6);
        telepuntTabel.getItems().add(telepuntEntry7);
        telepuntTabel.getItems().add(telepuntEntry8);
        telepuntTabel.getItems().add(telepuntEntry9);
        telepuntTabel.getItems().add(telepuntEntry10);
        telepuntTabel.getItems().add(telepuntEntry11);
        telepuntTabel.getItems().add(telepuntEntry12);
        telepuntTabel.getItems().add(telepuntEntry13);


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

    public void backButtonPressed(ActionEvent actionEvent) {
    }

    public void forwardButtonPressed(ActionEvent actionEvent) {
    }

    public void huidigButtonPressed(ActionEvent actionEvent) {
    }



}
