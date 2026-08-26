package model;

import java.time.LocalDate;

public class Transaction
{
    private int transactionId;
    private Book book;
    private  Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String status;

    //Default Constructor
    public Transaction()
    {
    }

    //Constructor for creating a new transaction
    public Transaction(int transactionId,Book book ,Member member,LocalDate issueDate)
    {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.status = "ISSUED";
    }

    // Constructor for exsisting Transaction
    public Transaction(int transactionId,Book book ,Member member,LocalDate issueDate,LocalDate returnDate, String status)
    {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.returnDate  = returnDate;
        this.status = status;
    }

    public  int getTransactionId()
    {
        return transactionId;
    }
    public  void setTransactionId(int transactionId)
    {
        this.transactionId = transactionId;
    }

    public Book getBook()
    {
        return book;
    }
    public void setBook(Book book)
    {
        this.book = book;
    }

    public  Member getMember()
    {
        return member;
    }
    public  void setMember(Member member)
    {
        this.member = member;
    }

    public LocalDate getIssueDate()
    {
        return issueDate;
    }
    public  void setIssueDate(LocalDate issueDate)
    {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate()
    {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate)
    {
        this.returnDate = returnDate;
    }

    public String getStatus()
    {
        return  status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return  "Transaction ID: " + transactionId
                +", Book: " + book.getTitle()
                + ", Member: " + member.getName()
                + ", IssueDate: " + issueDate
                + ", returnDate: " + returnDate
                +", Status: " + status;
    }
}
