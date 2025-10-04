package Library;

import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addMember(Member member) { members.add(member); }

    public Member findMember(String memberId) {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) return m;
        }
        return null;
    }

    public Book findBook(String bookId) {
        for (Book b : books) {
            if (b.getBookId().equals(bookId)) return b;
        }
        return null;
    }

    public void displayBooks() {
        for (Book b : books) System.out.println(b);
    }

    public void displayMembers() {
        for (Member m : members) System.out.println(m);
    }
}
