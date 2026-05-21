
package models.facility;

import interfaces.Reportable;
import java.io.Serializable;
import java.util.ArrayList;

public class Library extends Facility  implements Reportable, Serializable
{

    private static final long serialVersionUID = 1L;

    private int totalBooks;

    private int totalMembers;

    private ArrayList<Book> books =new ArrayList<>();





    public Library(
            String entityID,
            String name,
            String location,
            double maintenanceCost,
            int usageFrequency,
            int totalBooks,
            int totalMembers
    )
    {

        super(
                entityID,
                name,
                location,
                maintenanceCost,
                usageFrequency
        );

        this.totalBooks = totalBooks;

        this.totalMembers = totalMembers;
    }



    public void addBook(Book book)
    {

        books.add(book);
    }



    public void removeBook(Book book)
    {

        books.remove(book);
    }



    public ArrayList<Book> getBooks()
    {

        return books;
    }



    public int getBookCount()
    {

        return books.size();
    }



    public int getTotalBooks()
    {

        return totalBooks;
    }



    public int getTotalMembers()
    {

        return totalMembers;
    }


    public void setTotalBooks(int totalBooks)
    {

        this.totalBooks = totalBooks;
    }



    public void setTotalMembers(int totalMembers)
    {

        this.totalMembers = totalMembers;
    }



    @Override

    public double calculateOperationalCost()
    {

        return (maintenanceCost * usageFrequency)
                + (totalBooks * 10.0);
    }



    @Override

    public String generateReport()
    {

        return
                " LIBRARY REPORT "
                + "\nLibrary Name: " + name
                + "\nLocation: " + location
                + "\nTotal Books: " + totalBooks
                + "\nTotal Members: " + totalMembers
                + "\nBooks In Collection: " + books.size()
                + "\nMaintenance Cost: " + maintenanceCost
                + "\nUsage Frequency: " + usageFrequency
                + "\nOperational Cost: "
                + calculateOperationalCost();
    }



    public static int getTotalFacilityUsage()
    {

        return totalFacilityUsage;
    }





    @Override

    public String toString()
    {

        return
                "Library ID: " + entityID
                + " | Name: " + name
                + " | Location: " + location
                + " | Maintenance: " + maintenanceCost
                + " | Usage: " + usageFrequency
                + " | Books: " + totalBooks
                + " | Members: " + totalMembers
                + " | Collection: " + books.size();
    }
}

