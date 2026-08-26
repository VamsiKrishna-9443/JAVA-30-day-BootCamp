package service;

import model.Book;
import model.Member;

public interface LibraryOperations
{
        //Book Operations
        void addBook(Book book);
        void removeBook(int  bookId);
        Book searchBook(int bookId);
        void displayBooks();

        //Member Operations
        void addMember(Member member);
        void removeMember(int memberId);
        void displayMembers();

        //Transaction Operations
        void issueBook(int memberId,int bookId);
        void returnBook(int memberId, int bookId);
        void displayTransactions();
}
