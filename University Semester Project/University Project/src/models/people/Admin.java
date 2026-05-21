package models.people;
import interfaces.Notifiable;
import models.base.Person;
import java.io.Serializable;
public class Admin extends Person implements Serializable, Notifiable
{
    private static final long serialVersionUID = 1L;
    private String adminLevel;
    private String department;
    private static int totalAdmins = 0;

    public Admin(String personID, String name, String email, String password, String phoneNo, String adminLevel, String department)
    {
        super(personID, name, email, password, phoneNo);
        this.adminLevel = adminLevel;
        this.department = department;

        totalAdmins++;

    }

    public String getAdminLevel()
    {
        return adminLevel;
    }

    public String getDepartment()
    {
        return department;
    }

    @Override
    public String getRole()
    {
        return "Admin";
    }

    public static int getTotalAdmins()
    {
        return totalAdmins;
    }

    @Override
    public void sendNotification(String message)
    {
        System.out.println("[NOTIFICATION from " + name + "]: " + message);
    }


    @Override
    public String toString()
    {
        return super.toString() + " | Admin Level: " + adminLevel + " | Department: " + department;

    }
}


