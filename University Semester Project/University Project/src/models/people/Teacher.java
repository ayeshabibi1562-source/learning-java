package models.people;
import models.base.Person;
import java.io.Serializable;
public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String specialization;
    private String designation;
    private double salary;
    private static int totalTeachers = 0;

    public Teacher(String personID, String name, String email, String password, String phoneNo, String specialization, String designation, double salary) {
        super(personID, name, email, password, phoneNo);
        this.specialization = specialization;
        this.designation = designation;
        this.salary = salary;
        totalTeachers++;

    }

    public String getSpecialization()
    {
        return specialization;
    }

    public String getDesignation()
    {
        return designation;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String getRole()
    {
        return "Teacher";
    }

    public static int getTotalTeachers()
    {
        return totalTeachers;
    }


    @Override
    public String toString()
    {
        return super.toString() + " | Specialization: " + specialization + " | Designation: " + designation + " | Salary: " + salary;

    }
}
