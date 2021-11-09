/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alejandro Pelaez
 */
package ucf.assignments;

import java.io.File;
import java.util.List;

public interface FileInterface {
    void Save(List<String> list);
    List<String> Load(File file);
}
