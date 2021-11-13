/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

class Tests {

    @Test
    void Load() throws IOException {
        ButtonHandler bh = new ButtonHandler();
        File file = new File("src/test/java/ucf/assignments/todolisttest.txt");

        Assertions.assertNotNull(bh.Load(file));
    }

    @Test
    void Check()
    {
        Item item = new Item("Test");
        item.setComplete(true);
        Item falseItem = new Item("False");
        falseItem.setComplete(false);

        Assertions.assertNotEquals(item.getCompleteStatus(), falseItem.getCompleteStatus());
    }

    @Test
    void Description()
    {
        Item item = new Item("Test");
        item.setDescription("Yay");

        Assertions.assertNotEquals(item.getDescription(), "");
    }

    @Test
    void DueDate()
    {
        Item item = new Item("Test");
        item.setDate(LocalDate.now());

        Assertions.assertEquals(item.getDate(), LocalDate.now());
    }
}