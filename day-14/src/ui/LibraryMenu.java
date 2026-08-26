package ui;

import exception.LibraryException;
import model.Book;
import model.Member;
import service.LibraryService;

import java.util.Scanner;

public class LibraryMenu {

    private LibraryService service;
    private Scanner sc;

    // Constructor
    public LibraryMenu(LibraryService service) {
        this.service = service;
        this.sc = new Scanner(System.in);
    }

    // Starts the library application
    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Add Member");
            System.out.println("6. Remove Member");
            System.out.println("7. Display All Members");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Transactions");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume Enter key

            try {

                switch (choice) {

                    case 1:
                        addBook();
                        break;

                    case 2:
                        removeBook();
                        break;

                    case 3:
                        searchBook();
                        break;

                    case 4:
                        service.displayBooks();
                        break;

                    case 5:
                        addMember();
                        break;

                    case 6:
                        removeMember();
                        break;

                    case 7:
                        service.displayMembers();
                        break;

                    case 8:
                        issueBook();
                        break;

                    case 9:
                        returnBook();
                        break;

                    case 10:
                        service.displayTransactions();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Thank you for using Library Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (LibraryException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    // =========================
    // BOOK OPERATIONS
    // =========================

    private void addBook() {

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Book book = new Book(
                bookId,
                title,
                author,
                category,
                isbn,
                quantity,
                quantity
        );

        service.addBook(book);
    }


    private void removeBook() {

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        service.removeBook(bookId);

    }


    private void searchBook() {

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        Book book = service.searchBook(bookId);

        System.out.println(book);
    }


    // =========================
    // MEMBER OPERATIONS
    // =========================

    private void addMember() {

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        // Create Member Object
        Member member = new Member(memberId,name,email,phone,address);

        // Send  member  to LibraryService
        service.addMember(member);
    }


    private void removeMember() {

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        service.removeMember(memberId);

    }


    // =========================
    // TRANSACTION OPERATIONS
    // =========================

    private void issueBook() {

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        service.issueBook(memberId, bookId);

    }


    private void returnBook() {

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        service.returnBook(memberId, bookId);

    }
}