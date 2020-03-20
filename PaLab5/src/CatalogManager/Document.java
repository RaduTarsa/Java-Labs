package CatalogManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.Desktop;

public abstract class Document implements Serializable {
    String title;
    String author;
    int year;
    String path;

    public Document(String title , String author , int year , String path) throws YearException, FileNotFoundException {
        if( year > Calendar.getInstance().get(Calendar.YEAR))
            throw new YearException("We are not there yet!\n");
        if( !new File(path).exists())
            throw new FileNotFoundException("Calea " + path + " este invalida");
        this.title = title;
        this.author = author;
        this.year = year;
        this.path = path;
    }

    public class YearException extends Exception {
        public YearException( String s) {
            super(s);
        }
    }

    public void open() throws IOException {
        Desktop.getDesktop().open(new File(path));
    }

}
