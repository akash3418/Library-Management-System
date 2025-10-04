package Library;

import java.util.*;

public class Member {
    private String memberId;
    private String name;
    protected List<BorrowTransaction> borrowedBooks = new ArrayList<>();




    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public int getBorrowLimit() { return 3; }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < getBorrowLimit() && book.borrowCopy()) {
            BorrowTransaction tx = new BorrowTransaction(UUID.randomUUID().toString(), this, book, new Date());
            borrowedBooks.add(tx);
            System.out.println("Borrowed: " + book.getTitle());
        } else {
            System.out.println("Cannot borrow more books or book unavailable.");
        }
    }

    public void returnBook(Book book) {
        BorrowTransaction toReturn = null;
        for (BorrowTransaction tx : borrowedBooks) {
            if (tx.getBook().equals(book)) {
                toReturn = tx;
                break;
            }
        }
        if (toReturn != null) {
            ReturnTransaction rt = new ReturnTransaction(UUID.randomUUID().toString(), toReturn, new Date());
            rt.processReturn();
            borrowedBooks.remove(toReturn);
            System.out.println("Returned: " + book.getTitle() + " | Fine: ₹" + rt.getFine());
        } else {
            System.out.println("This book was not borrowed by you.");
        }
    }

    @Override
    public String toString() {
        return name + " (" + memberId + ")";
    }
}
