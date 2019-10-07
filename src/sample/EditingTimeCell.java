package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

import java.time.LocalTime;

class EditingTimeCell extends TableCell<TelepuntEntry, LocalTime> {

    private TimeSpinner timeSpinner;

    LocalTime localItem;

    public EditingTimeCell() {}

    @Override
    public void startEdit() {
        super.startEdit();

        if (timeSpinner == null) {
            createTextField();
        }

        setGraphic(timeSpinner);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        //timeSpinner.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void updateItem(LocalTime item, boolean empty) {

        if (localItem!=null){
            super.updateItem(localItem, empty);
        }else{
            super.updateItem(item, empty);

        }
        if (item!=null)  System.out.println("item is " + item.toString());
        if (empty) {

            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (timeSpinner != null) {
                    //timeSpinner.getEditor().setText(getString());
                }
                setGraphic(timeSpinner);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                //System.out.println(timeSpinner.getValue().toString());
                //System.out.println(getString());
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    private void createTextField() {
        timeSpinner = new TimeSpinner();
        timeSpinner.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
        timeSpinner.getEditor().setText(getString());
        startEdit();




        timeSpinner.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!timeSpinner.isFocused()){
                    localItem= timeSpinner.getValue();
                    setItem(localItem);
                    setText(localItem.toString());
                    commitEdit(localItem);
                }
            }
        });

    }



    /**
     * Get the current value of the cell
     * @return Current value of the cell
     */
    private String getString() {

        return getItem() == null ? "" : getItem().toString();
    }
}