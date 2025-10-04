package Library;
import java.util.*;
public class BorrowTransaction {
    private String transactionId;
    private Member member;
    private Book book;
    private Date borrowDate;

    public BorrowTransaction(String transactionId, Member member, Book book, Date borrowDate) {
        this.transactionId = transactionId;
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Book getBook() { return book; }
    public Date getBorrowDate() { return borrowDate; }
}

ReturnTransaction.JAVA
package Library;

import java.util.*;

public class ReturnTransaction {
    private String transactionId;
    private BorrowTransaction borrowTransaction;
    private Date returnDate;
    private double fine;

    public ReturnTransaction(String transactionId, BorrowTransaction borrowTransaction, Date returnDate) {
        this.transactionId = transactionId;
        this.borrowTransaction = borrowTransaction;
        this.returnDate = returnDate;
    }

    public void processReturn() {
        borrowTransaction.getBook().returnCopy();
        // simple fine calculation (₹10 per day after 7 days)
        long diff = returnDate.getTime() - borrowTransaction.getBorrowDate().getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        if (days > 7) fine = (days - 7) * 10;


        else fine = 0;
    }


    public double getFine() { return fine; }
}
