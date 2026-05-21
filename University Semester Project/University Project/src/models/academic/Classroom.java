package models.academic;
import java.io.Serializable;
public  class Classroom extends AcademicUnit
{
    private static final long serialVersionUID = 1L;
    private int capacity;
    private String classroomType;
 private boolean isAvailable;

    public Classroom(String entityID, String name, String location, int numberOfStudents,int numberOfStaff,int capacity,String classroomType)
    {
        super( entityID,  name,  location,  numberOfStudents, numberOfStaff);
        this.capacity=capacity;
        this.classroomType=classroomType;
        isAvailable=true;
    }

    @Override
    public double calculateOperationalCost()
    {
        return capacity * 100.0 + numberOfStaff * 800.0;
    }


    public int getCapacity()
    {

        return capacity;
    }
    public String getClassroomType()
    {
        return classroomType;
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
        return super.toString() + " | Capacity: " + capacity + " | Type: " + classroomType + " | Available: " + isAvailable;
    }
}

