package model;

import java.util.ArrayList;
import java.util.List;

public class Member
{
    private int memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;


    // Stores the books currently borrowed by this member
    private List<Book> borrowBooks;

    public Member()
    {
        borrowBooks = new ArrayList<>();
    }

    // Constructor for Creating a new Member
    public Member(String name ,String email ,String phoneNumber,String address)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber  = phoneNumber;
        this.address = address;
        this.borrowBooks = new ArrayList<>();
    }

    // Constructor for an existing member with ID
    public Member(int memberId,String name ,String email ,String phoneNumber,String address)
    {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber  = phoneNumber;
        this.address = address;
        this.borrowBooks = new ArrayList<>();
    }

    public int getMemberId()
    {
        return memberId;
    }
    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public String getName()
    {
        return  name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }
    public  void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return  phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }
    public void setAddress()
    {
        this.address = address;
    }

    public List<Book> getBorrowBooks()
    {
        return borrowBooks;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId
                + ", Name: " + name
                + ", Email: " + email
                + ", Phone: " + phoneNumber
                + ", Address: " + address
                + ", Borrowed Books: " + borrowBooks.size();
    }
}
