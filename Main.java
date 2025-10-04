package Library;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Members");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: addBook(sc, library); break;
                case 2: addMember(sc, library); break;
                case 3: borrowBook(sc, library); break;
                case 4: returnBook(sc, library); break;
                case 5: library.displayBooks(); break;
                case 6: library.displayMembers(); break;
                case 7: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void addBook(Scanner sc, Library library) {
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String authorName = sc.nextLine();
        System.out.print("Enter Stock: ");
        int stock = sc.nextInt(); sc.nextLine();






        Author author = new Author(authorName);
        Book book = new Book(bookId, title, author, stock);
        library.addBook(book);
        System.out.println("Book added!");
    }

    private static void addMember(Scanner sc, Library library) {
        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Premium Member? (y/n): ");
        String isPremium = sc.nextLine();

        Member member;
        if (isPremium.equalsIgnoreCase("y")) member = new PremiumMember(memberId, name);
        else member = new Member(memberId, name);

        library.addMember(member);
        System.out.println("Member added!");
    }

    private static void borrowBook(Scanner sc, Library library) {
        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        Member member = library.findMember(memberId);
        Book book = library.findBook(bookId);
        if (member != null && book != null) member.borrowBook(book);
        else System.out.println("Invalid Member or Book.");
    }

    private static void returnBook(Scanner sc, Library library) {
        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = sc.nextLine();

        Member member = library.findMember(memberId);
        Book book = library.findBook(bookId);
        if (member != null && book != null) member.returnBook(book);
        else System.out.println("Invalid Member or Book.");
    }
}
