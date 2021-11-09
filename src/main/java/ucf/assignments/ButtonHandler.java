/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.List;

public class ButtonHandler implements FileInterface {
    @Override
    public void Save(List<String> list) {
        // open file chooser to user to save file
        // create FileWriter and write using for loop
        // for i<list.size()
        //      write name of list + /n
        //      write items name, due date, complete + /n
    }

    @Override
    public List<String> Load(File file) {
        return null;
    }

    public Item AddItemButton(ListView<String> todoItemView, TextField listTextField)
    {
        /*String name = listTextField.getCharacters().toString();
        todoItemView.getItems().add(name);
        return new Item(name);*/
        return null;
    }

    public ToDoList AddListButton(ListView<String> todoListView, TextField listTextField)
    {
        /*String name = listTextField.getCharacters().toString();
        todoListView.getItems().add(name);
        return new ToDoList();*/
        return null;
    }

    public void RenameItem(String currentName, int index, List<Item> items)
    {
        //items.get(index).setName(currentName);
    }

    public String Rename(String newName)
    {
        return newName;
    }

    public void HomeButton()
    {
        // Load ListView.fxml using stage
    }
}
