package CatalogManager;

import java.io.FileNotFoundException;

public class Article extends Document{
    public Article(String title, String author, int year, String path) throws YearException, FileNotFoundException {
        super(title, author, year, path);
    }
}
