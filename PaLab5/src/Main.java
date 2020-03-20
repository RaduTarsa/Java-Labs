import CatalogManager.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        //Break with Ctrl+C
//        while (true) {
//            //read the command
//            System.out.print("input > ");
//            commandLine = console.readLine();
//
//            //if just a return, loop
//            if (commandLine.equals(""))
//                continue;
//
//            // create new Catalog
//            if (commandLine.matches("(new).[A-Za-z]*")) {
//                String[] values = commandLine.split(" ");
//                Catalog catalog = new Catalog();
//                continue;
//            }
//
//            // add to catalog
//            if (commandLine.matches("(add)\\s(book).*")) {
//                if (commandLine.matches("(add)\\s(book)(\\s\"[^\"]*\"){2}\\s(\\d){4}(\\s\"[^\"]*\")*")) {
//                    AddCommand addCommand = new AddCommand(Type.book);
//                    String[] values = commandLine.split("( \\\")|(\\\" )(?=\\d)|(\\\" \\\")|(\\\")");
//                    for (String i : values)
//                        System.out.println(i);
//                } else {
//                    System.out.println("Formatul nu este corect: add book \"Titlu\" \"Autor\" An \"Path\"");
//                }
//                continue;
//            }
//
//            if (commandLine.equals("exit")) {
//                System.out.println(".\n..\n...\nGood bye!");
//                System.exit(0);
//                continue;
//            }
//
//            System.out.println("Commanda nu exista !");
//        }
        try {
            Catalog catalog1 = new Catalog();
            catalog1.add(new Book("O carte faina", "Un autor", 1999, "C:\\Users\\Radu\\IdeaProjects\\PaLab5\\resources\\book.txt"));
            catalog1.add(new Article("Un articol fain", "Alt autor", 1997, "C:\\Users\\Radu\\IdeaProjects\\PaLab5\\resources\\article.txt"));
            catalog1.save("C:\\Users\\Radu\\IdeaProjects\\PaLab5\\resources\\catalog.dat");
            catalog1.list();
            Catalog catalog2 = new Catalog();
            catalog2.list();
            catalog2.load("C:\\Users\\Radu\\IdeaProjects\\PaLab5\\resources\\catalog.dat");
            catalog2.list();
            catalog1.open(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Document.YearException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

