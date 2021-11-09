/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class ListViewController {
        @FXML
        private Button addButton;
        @FXML
        private MenuItem deleteItem;
        @FXML
        private MenuButton fileButton;
        @FXML
        private TextField listTextField;
        @FXML
        private MenuItem loadMenuOption;
        @FXML
        private Button renameButton;
        @FXML
        private MenuItem saveAllMenuOption;
        @FXML
        private ListView<String> todoListView;

        private ButtonHandler bh;
        private ToDoApplication app;
        @FXML
        void onAddButtonPressed(ActionEvent event) {
                /*app.setCurrentList(bh.AddListButton(todoListView, listTextField));
                listTextField.clear();*/
        }

        @FXML
        void onListCellClicked(MouseEvent event) {
                /*todoListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                                if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2)
                                {
                                        String selectedItem = todoListView.getSelectionModel().getSelectedItem();
                                        System.out.println(selectedItem);

                                        app.setCurrentList(ListWithSelectedItemName);
                                        stage.Load("ItemView.fxml");
                                }
                        }
                });*/
        }

        @FXML
        void onLoadPressed(ActionEvent event) {
                //ButtonHandler.Load(file);
        }

        @FXML
        void onRenameButtonPressed(ActionEvent event) {
                //todoListView.getSelectionModel().getSelectedItem() = ButtonHandler.Rename(listTextField.getValue());
        }

        @FXML
        void onSavePressed(ActionEvent event) {
                //ButtonHandler.Save(todoListView);
        }

        @FXML
        void onDelete(ActionEvent event) {
                //int index = todoListView.getSelectionModel().getSelectedIndex();
                //todoListView.getSelectionModel().getSelectedIndices().remove(index);
        }
}