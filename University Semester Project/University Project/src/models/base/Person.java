package models.base;
import java.io.Serializable;

public abstract class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected String personID;
    protected String name;
    protected String email;
    protected String password;
    protected String phoneNo;

    public Person(String personID,String name,String email,String password,String phoneNo )
    {
        this.personID=personID;
        this.name=name;
        this.email=email;
        this.password=password;
        this.phoneNo=phoneNo;

    }
    public String getPersonID()
    {

        return personID;
    }
    public String getName()
    {

        return name;
    }
    public String getEmail()
    {

        return email;
    }
    public String getPassword()
    {

        return password;
    }
    public String getPhoneNo()
    {

        return phoneNo;
    }

    public abstract String getRole();
    @Override
    public String toString()
    {
        return "ID: " + personID + " | Name: " + name + " | Email: " + email + " | Role: " + getRole();
    }

}
