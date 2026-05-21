package models.people;

import java.io.Serializable;
import models.base.Person;

public class Student extends Person implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String semester;
    private double gpa;
    private String department;

    private static int totalStudents = 0;

    public Student(String personID, String name, String email, String password, String phoneNo, String semester, double gpa, String department)
    {
        super(personID, name, email, password, phoneNo);

        this.semester = semester;
        this.gpa = gpa;
        this.department = department;

        totalStudents++;
    }

    public String getSemester()
    {
        return semester;
    }

    public double getGpa()
    {
        return gpa;
    }

    public String getDepartment()
    {
        return department;
    }

    @Override
    public String getRole()
    {
        return "Student";
    }

    public static int getTotalStudents()
    {
        return totalStudents;
    }



    public void setSemester(String semester)
    {
        this.semester = semester;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }



    @Override
public String toString()
{
    return super.toString()
            + " | Semester: " + semester
            + " | GPA: " + gpa
            + " | Department: " + department
            + " | Total Students: " + totalStudents;
}
}