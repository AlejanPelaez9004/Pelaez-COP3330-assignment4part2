/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ButtonHandler implements FileInterface {
    @Override
    public void Save(List<Item> list) {
        // open file chooser to user to save file
        // create FileWriter and write using for loop
        // for i<list.size()
        //      write num of items in list + /n
        //      write items name, due date, complete, etc + /n

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save List");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(".txt", "*.txt")
        );
        File file = fileChooser.showSaveDialog(Stage.getWindows().get(0));

        if (file != null)
        {
            try {
                FileWriter fw = new FileWriter(file);

                fw.write((list.size()) + "\n");
                for (Item currentItem : list)
                {
                    fw.write(currentItem.getName() + "$" + currentItem.getDescription() + "$" + currentItem.getDate() + "$" + currentItem.getCompleteStatus() + "\n");
                }
                fw.close();
            }catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public List<Item> Load(File file) throws IOException {
        // create FileReader and read in items using for loop
        // for i<the num in the txt (size)
        //      read and add items name, due date, complete, etc to list

        List<Item> loadedList = new ArrayList<>();
        Scanner scan = new Scanner(file);
        int size = scan.nextInt();

        for (int i = 0; i < size; i++)
        {
            // Split the next line into 4 sections
            // name, description, date, completeStatus
            // and then assign values to a new item then add it to the new list
            String[] nextItemDetails = scan.next().split("\\$");
            Item item = new Item(nextItemDetails[0]);
            item.setDescription(nextItemDetails[1]);
            item.setDate(LocalDate.parse(nextItemDetails[2]));
            item.setComplete(Boolean.parseBoolean(nextItemDetails[3]));
            loadedList.add(item);
        }
        return loadedList;
    }

    public static Item AddItemButton(ListView<String> todoItemView, TextField listTextField)
    {
        String name = listTextField.getCharacters().toString();
        todoItemView.getItems().add(name);
        return new Item(name);
    }

    public static void RenameItem(String newName, int index, List<Item> items, ListView<String> todoItemView)
    {
        items.get(index).setName(newName);
        todoItemView.getItems().set(index, newName);
    }

    public static String Rename(String newName)
    {
        return newName;
    }
}
