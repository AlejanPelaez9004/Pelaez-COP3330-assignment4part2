/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemViewController {

    @FXML
    private Button addButton;
    @FXML
    private MenuItem allOption;
    @FXML
    private CheckBox completeCheckbox;
    @FXML
    private MenuItem completeOption;
    @FXML
    private DatePicker datePicker;
    @FXML
    private MenuButton fileButton;
    @FXML
    private MenuItem removeAll;
    @FXML
    private MenuItem deleteSelected;
    @FXML
    private Button homeButton;
    @FXML
    private MenuItem incompleteOption;
    @FXML
    private TextField itemTextField;
    @FXML
    private MenuItem loadMenuOption;
    @FXML
    private Button renameButton;
    @FXML
    private MenuItem saveMenuOption;
    @FXML
    private MenuButton displayDropdown;
    @FXML
    private ListView<String> todoItemView;

    private List<Item> items = new ArrayList<>();

    @FXML
    void onAddButtonPressed(ActionEvent event) {
        items.add(ButtonHandler.AddItemButton(todoItemView, itemTextField.getCharacters().toString()));
    }

    @FXML
    void onItemListClicked() {
        todoItemView.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY)
                {
                    boolean hasItems = items.size() > 0;
                    if (hasItems)
                    {
                        if (todoItemView.getSelectionModel().getSelectedIndex() != -1)
                        {
                            // Get the selected item
                            Item selectedItem = items.get(todoItemView.getSelectionModel().getSelectedIndex());
                            if (!Objects.equals(selectedItem.getName(), todoItemView.getSelectionModel().getSelectedItem()))
                                selectedItem = Item.GetItemByString(items, todoItemView.getSelectionModel().getSelectedItem());

                            // Update the top bar fields to what the item's values are
                            completeCheckbox.setSelected(selectedItem.getCompleteStatus());
                            datePicker.setValue(selectedItem.getDate());
                            itemTextField.setText(selectedItem.getName());
                        }
                        if (event.getClickCount() == 2 && todoItemView.getSelectionModel().getSelectedIndex() != -1)
                        {
                            CreateDialogInputBox();
                        }
                    }
                }
            }
        });
    }

    private void CreateDialogInputBox()
    {
        // initialize variables and get the selected item
        Item selectedItem = items.get(todoItemView.getSelectionModel().getSelectedIndex());
        TextInputDialog inputDialog = new TextInputDialog();
        TextField input = inputDialog.getEditor();

        // set up the inputDialog panel
        inputDialog.setHeaderText("Edit the description of the item you selected.");
        inputDialog.getDialogPane().getButtonTypes().remove(1); // remove cancel button
        inputDialog.setTitle("Edit Description");

        // show the dialog panel and save the users input
        if (selectedItem.getDescription() != null)
            input.setText(selectedItem.getDescription());
        inputDialog.showAndWait();

        // save the description to the selected item for later use
        if (input.getText() != null)
            selectedItem.setDescription(input.getText());
    }

    @FXML
    void onCompleteCheckbox(ActionEvent event) {
        // set the complete status to the item
        items.get(todoItemView.getSelectionModel().getSelectedIndex()).setComplete(completeCheckbox.isSelected());
    }

    @FXML
    void onAllOptionSelected(ActionEvent event) {
        DisplayCompleteManager.ShowAllItems(items, todoItemView);
    }

    @FXML
    void onIncompleteOptionSelected(ActionEvent event) {
        DisplayCompleteManager.ShowIncompleteItems(items, todoItemView);
    }

    @FXML
    void onCompleteOptionSelected(ActionEvent event) {
        DisplayCompleteManager.ShowCompletedItems(items, todoItemView);
    }

    @FXML
    void onDatePickerAction(ActionEvent event) {
        int index = todoItemView.getSelectionModel().getSelectedIndex();

        // set the date format to "yyyy-mm-dd"
        datePicker.setConverter(new StringConverter<>()
        {
            private final DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public String toString(LocalDate localDate)
            {
                if (localDate == null)
                    return "";
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString)
            {
                if (dateString == null || dateString.trim().isEmpty())
                {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
        items.get(index).setDate(datePicker.getValue());
    }

    @FXML
    void onDeleteSelectedPressed(ActionEvent event) {
        int index = todoItemView.getSelectionModel().getSelectedIndex();
        todoItemView.getItems().remove(index);
        items.remove(index);
    }

    @FXML
    void onRemoveAllPressed(ActionEvent event) {
        todoItemView.getItems().clear();
        items.clear();
    }

    @FXML
    void onLoadPressed(ActionEvent event) throws IOException {
        // Create a FileChooser for the user to open a previous list
        ButtonHandler bh = new ButtonHandler();
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open List");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(".txt", "*.txt")
        );
        File file = fileChooser.showOpenDialog(Stage.getWindows().get(0));
        if (file != null)
            items = bh.Load(file);

        // when loaded, update the visual list
        todoItemView.getItems().clear();
        for (Item item : items)
        {
            todoItemView.getItems().add(item.getName());
        }
    }

    @FXML
    void onRenameButtonPressed(ActionEvent event) {
        ButtonHandler.RenameItem(itemTextField.getCharacters().toString(), todoItemView.getSelectionModel().getSelectedIndex(), items, todoItemView);
    }

    @FXML
    void onSavePressed(ActionEvent event) {
        ButtonHandler bh = new ButtonHandler();
        bh.Save(items);
    }

}
