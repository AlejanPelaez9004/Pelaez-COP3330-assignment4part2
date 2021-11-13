/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class DisplayCompleteManager {
    private static List<Item> completed = new ArrayList<>();
    private static List<Item> incomplete = new ArrayList<>();

    public static void ShowCompletedItems(List<Item> masterList, ListView<String> listView)
    {
        // Loop through all items
        // Use HideAll() to hide them
        // Show the completed items using complete boolean
        HideAll(masterList, listView);

        for (Item item : completed)
            listView.getItems().add(item.getName());
    }

    public static void ShowIncompleteItems(List<Item> masterList, ListView<String> listView)
    {
        // Loop through all items
        // Use HideAll() to hide them
        // Show the incomplete items using complete boolean
        HideAll(masterList, listView);

        for (Item item : incomplete)
            listView.getItems().add(item.getName());
    }

    public static void ShowAllItems(List<Item> masterList, ListView<String> listView)
    {
        // Loop through all items
        // Enable all items
        HideAll(masterList, listView);

        for (Item item : completed)
            listView.getItems().add(item.getName());
        for (Item item : incomplete)
            listView.getItems().add(item.getName());
    }

    private static void HideAll(List<Item> masterList, ListView<String> listView)
    {
        // Update the lists and clear the listView
        completed.clear();
        incomplete.clear();

        for (Item item : masterList) {
            if (item.getCompleteStatus())
                completed.add(item);
            else
                incomplete.add(item);
        }

        listView.getItems().clear();
    }
}
