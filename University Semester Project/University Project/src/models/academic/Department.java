package models.academic;
import interfaces.Reportable;
import java.io.Serializable;
import java.util.ArrayList;

public class Department extends AcademicUnit implements Reportable
{
    private static final long serialVersionUID = 1L;
    private String departmentCode;
    private String hodName;
    private double budget;
    private ArrayList<Course> courses = new ArrayList<>();


    public Department(String entityID, String name, String location, int numberOfStudents, int numberOfStaff, String departmentCode, String hodName, double budget)
    {
        super(entityID, name, location, numberOfStudents, numberOfStaff);
        this.departmentCode = departmentCode;
        this.hodName = hodName;
        this.budget = budget;
    }


    public void addCourse(Course course)
    {
        courses.add(course);

    }

    public void removeCourse(Course course)
    {
        courses.remove(course);

    }

    public ArrayList<Course> getCourses()
    {
        return courses;

    }

    public int getCourseCount()
    {
        return courses.size();

    }


    public String getDepartmentCode()
    {
        return departmentCode;
    }
    public String getHodName()
    {
        return hodName;
    }
    public double getBudget()
    {
        return budget;
    }


    @Override
    public double calculateOperationalCost()
    {
        return numberOfStudents * 500.0 + numberOfStaff * 1000.0;
    }


    @Override
    public String generateReport()
    {
        return "[DEPARTMENT REPORT for " + name + "]" + "\nCode: " + departmentCode + "\nHOD: " + hodName + "\nBudget: " + budget + "\nTotal Courses: " + courses.size() + "\nOperational Cost: " + calculateOperationalCost();

    }

    @Override
    public String toString()
    {
        return super.toString() + " | Code: " + departmentCode + " | HOD: " + hodName + " | Budget: " + budget + " | Courses: " + courses.size();

    }
}