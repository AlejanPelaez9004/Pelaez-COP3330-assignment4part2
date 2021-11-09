/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import java.util.List;

public class ToDoList {
    private String listName;
    private List<Item> listItems;

    public String getListName()
    {
        return listName;
    }

    public List<Item> getListItems()
    {
        return listItems;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }
}
