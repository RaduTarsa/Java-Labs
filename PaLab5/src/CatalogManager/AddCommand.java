package CatalogManager;

public class AddCommand extends Command {

    Type type;
    String title;
    String author;
    Integer year;
    String path;

    public AddCommand(Type type) {
        this.type = type;
    }

    AddCommand(Type type, String title, String path, Integer year, String author) {
        this.type = type;
        this.title = title;
        this.author = author;
        this.year = year;
        this.path = path;
        //Document()
    }

    @Override
    void implementCommand() {
        if (type.toString() == "book") {
            addBook();
        }

    }

    private void addBook() {

    }
}
