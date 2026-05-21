package models.facility;

import java.io.Serializable;

public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookID, String title, String author)
    {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getBookID()
    {

        return bookID;
    }
    public String getTitle()
    {

        return title;
    }
    public String getAuthor()
    {

        return author;
    }
    public boolean isAvailable()
    {

        return isAvailable;
    }

    public void setAvailable(boolean available)
    {

        isAvailable = available;
    }

    @Override
    public String toString()
    {
        return "Book ID: " + bookID + " | Title: " + title + " | Author: " + author + " | Available: " + isAvailable;
    }
}

