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
