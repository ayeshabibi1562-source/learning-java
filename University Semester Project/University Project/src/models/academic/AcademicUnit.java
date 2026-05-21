package models.academic;
import models.base.CampusEntity;
import java.io.Serializable;

public abstract class AcademicUnit extends CampusEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected int numberOfStudents;
    protected int numberOfStaff;

    public AcademicUnit(String entityID, String name, String location,int numberOfStudents,int numberOfStaff)
    {
        super(entityID,  name, location);
        this.numberOfStudents=numberOfStudents;
        this.numberOfStaff=numberOfStaff;
    }
    public int getNumberOfStudents()
    {

        return numberOfStudents;
    }

    public int getNumberOfStaff()
    {

        return numberOfStaff;
    }
    @Override
    public String toString()
    {
        return super.toString() + " | Students: " + numberOfStudents + " | Staff: " + numberOfStaff;
    }
}
