abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();
}

// Book subclass
class Book extends LibraryItem {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }
}

// Main Class to Test
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem book = new Book(1, "Java Programming", "James Gosling");
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");
    }
}
