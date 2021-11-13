/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import java.time.LocalDate;
import java.util.List;

public class Item {
    private String name;
    private LocalDate date;
    private boolean complete;
    private String description;

    public Item(String name)
    {
        this.setName(name);
        this.setDate(LocalDate.now());
        this.setComplete(false);
    }

    public static Item GetItemByString(List<Item> items, String searchString)
    {
        Item resultItem = new Item("");
        for (Item item : items) {
            if (searchString.equals(item.getName()))
                resultItem = item;
        }
        return resultItem;
    }

    public String getName()
    {
        return name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public boolean getCompleteStatus()
    {
        return complete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
