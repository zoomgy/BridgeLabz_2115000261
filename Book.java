import java.util.ArrayList;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}

class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien");

        Library libraryA = new Library();
        Library libraryB = new Library();

        libraryA.addBook(book1);
        libraryA.addBook(book2);
        libraryB.addBook(book1); // Same book in multiple libraries

        libraryA.listBooks();
        libraryB.listBooks();
    }
}