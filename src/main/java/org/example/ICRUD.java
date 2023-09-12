package org.example;

import java.util.Scanner;

public interface ICRUD {
    public void create(Scanner s);
    public void read();
    public void update(Scanner s);
    public void delete(Scanner s);
    public void search(Scanner s);
    public void readByLevel(Scanner s);
    public void saveFile();
    public void loadFile();
}
