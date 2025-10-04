package Library;

public class Book {
    private String bookId;
    private String title;
    private Author author;
    private int stock;

    public Book(String bookId, String title, Author author, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public boolean borrowCopy() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }

    public void returnCopy() {
        stock++;
    }



    @Override
    public String toString() {
        return "Book[ID=" + bookId + ", Title=" + title + ", Author=" + author + ", Stock=" + stock + "]";
    }
}
