package CatalogManager;

import java.io.FileNotFoundException;

public class Book extends Document{
    public Book(String title, String author, int year, String path) throws YearException, FileNotFoundException {
        super(title, author, year, path);
    }
}
