package service;

import exception.*;
import model.Book;
import model.Member;
import model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService implements LibraryOperations {

    // Stores books using bookId as the key
    private Map<Integer, Book> books;

    // Stores members using memberId as the key
    private Map<Integer, Member> members;

    // Stores all library transactions
    private List<Transaction> transactions;

    private int nextTransactionId = 1;
    // Constructor
    public LibraryService() {
        books = new HashMap<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
    }

    // =========================
    // BOOK OPERATIONS
    // =========================

    @Override
    public void addBook(Book book)  {

        int bookId = book.getBookId();

        if (books.containsKey(bookId)) {
            throw new BookAlreadyExistsException("Book with ID " + bookId + " already exists.");
        }

        books.put(bookId, book);

        System.out.println("Book added successfully.");
    }

    @Override
    public void removeBook(int bookId) {

        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book with ID: " + bookId + " not found ");
        }

        books.remove(bookId);

        System.out.println("Book removed successfully.");
    }

    @Override
    public Book searchBook(int bookId) {
        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book with ID: " + bookId + " not found ");
        }
        return books.get(bookId);
    }

    @Override
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // =========================
    // MEMBER OPERATIONS
    // =========================

    @Override
    public void addMember(Member member) {
        int memberId = member.getMemberId();
        if (members.containsKey(memberId)) {
            throw new MemberAlreadyExistsException("Member with ID: " + memberId + " already exists ");
        }
        members.put(memberId, member);
        System.out.println("Member added successfully.");
    }

    @Override
    public void removeMember(int memberId) {

        if (!members.containsKey(memberId)) {
            throw new MemberNotFoundException("Member with ID: " + memberId + " not found ");
        }
        members.remove(memberId);
        System.out.println("Member removed successfully.");
    }

    @Override
    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }

    // =========================
    // TRANSACTION OPERATIONS
    // =========================

    @Override
    public void issueBook(int memberId, int bookId) {
        Member member = members.get(memberId);

        if(member == null)
        {
            throw new MemberNotFoundException("Member with ID: " + memberId + " not found ");
        }

        Book book = books.get(bookId);

        if(book == null)
        {
            throw  new BookNotFoundException("Book with ID: " + bookId + " not found ");
        }

        if(book.getAvailableQuantity() <= 0)
        {
            throw  new BookNotFoundException("Book with ID: " + bookId + " is not currently available ");
        }

        if(member.getBorrowBooks().contains(book))
        {
            throw new LibraryException("Member Already Borrowed this book");
        }

        book.setAvailableQuantity(book.getAvailableQuantity() - 1);

        member.getBorrowBooks().add(book);

        Transaction transaction = new Transaction(nextTransactionId++,book ,member,java.time.LocalDate.now());
        transactions.add(transaction);
        System.out.println("Book Issued Successfully");
    }

    @Override
    public void returnBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        if(member == null)
        {
            throw new MemberNotFoundException("Member with ID: " + memberId + " not found ");
        }

        Book book = books.get(bookId);
        if(book == null)
        {
            throw  new BookNotFoundException("Book with ID: " + bookId + " is not currently available ");
        }

        if(!member.getBorrowBooks().contains(book))
        {
            throw  new BookNotBorrowedException("Member with ID :" + memberId + " has not borrowed with ID " + bookId + ".");
        }
        member.getBorrowBooks().remove(book);

        book.setAvailableQuantity(book.getAvailableQuantity() + 1);

        //Find the corresponding issued transaction
        for (Transaction transaction : transactions) {
            if (transaction.getBook() == book
                    && transaction.getMember() == member
                    && transaction.getStatus().equals("ISSUED")) {

                // Update transaction
                transaction.setReturnDate(
                        java.time.LocalDate.now()
                );
                transaction.setStatus("RETURNED");
                break;
            }
        }
        System.out.println("BOOK Returned Successfully");
    }

    @Override
    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}