package models.academic;
import java.io.Serializable;

public class Assignment implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String assignmentID;
    private String title;
    private String description;
    private String dueDate;
    private int totalMarks;

    public Assignment(String assignmentID, String title, String description, String dueDate, int totalMarks)
    {
        this.assignmentID = assignmentID;
        this.title        = title;
        this.description  = description;
        this.dueDate      = dueDate;
        this.totalMarks   = totalMarks;
    }

    public String getAssignmentID()
    {

        return assignmentID;
    }
    public String getTitle()
    {

        return title;
    }
    public String getDescription()
    {
        return description;
    }
    public String getDueDate()
    {
        return dueDate;
    }
    public int getTotalMarks()
    {
        return totalMarks;
    }

    @Override
    public String toString()
    {
        return "Assignment ID: " + assignmentID + " | Title: " + title + " | Due: " + dueDate + " | Marks: " + totalMarks;
    }
}