/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    @FXML
    void onAddButtonPressed(ActionEvent event) {
        //items.add(ButtonHandler.AddItemButton(todoItemView, itemTextField));
    }

    @FXML
    void onItemListClicked(MouseEvent event) {
        /*todoItemView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                        if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2)
                        {
                                String selectedItem = todoItemView.getSelectionModel().getSelectedItem();
                                System.out.println(selectedItem);

                                Item selectedItem = items.get(todoItemView.getSelectionModel().getSelectedIndex();
                                completeCheckbox.setSelected(selectedItem).getCompleteStatus());
                                datePicker.setDate(selectedItem.getDate());
                                itemTextField.set(selectedItem.getName());
                        }
                }
        });*/
    }

    @FXML
    void onCompleteCheckbox(ActionEvent event) {
        //items.get(todoItemView.getSelectionModel().getSelectedIndex()).setComplete(completeCheckbox.IsSelected());
    }

    @FXML
    void onAllOptionSelected(ActionEvent event) {
        // Use DisplayCompleteManager.ShowAll();
    }

    @FXML
    void onIncompleteOptionSelected(ActionEvent event) {
        // Use DisplayCompleteManager.ShowIncompleteItems();
    }

    @FXML
    void onCompleteOptionSelected(ActionEvent event) {
        // Use DisplayCompleteManager.ShowCompletedItems();
    }

    @FXML
    void onDatePickerAction(ActionEvent event) {
        //Item item = new Item();
        //item.setDate(datePicker.getValue());
    }

    @FXML
    void onDeleteSelectedPressed(ActionEvent event) {
        //int index = todoListView.getSelectionModel().getSelectedIndex();
        //todoListView.getSelectionModel().getSelectedIndices().remove(index);
        // delete item class
    }

    @FXML
    void onHomeButtonPressed(ActionEvent event) {
        //ButtonHandler.HomeButton();
    }

    @FXML
    void onLoadPressed(ActionEvent event) {
        //ButtonHandler.Load(file);
    }

    @FXML
    void onRenameButtonPressed(ActionEvent event) {
        //ButtonHandler.Rename(todoItemView.getSelectionModel().getSelectedItem(), todoItemView.getSelectionModel().getSelectedIndex(), items);
    }

    @FXML
    void onSavePressed(ActionEvent event) {
        //ButtonHandler.Save(todoItemView);
    }

}
