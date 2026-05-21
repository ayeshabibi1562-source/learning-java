package models.academic;
import java.io.Serializable;
public  class Lab extends AcademicUnit
{
    private static final long serialVersionUID = 1L;
    private String labType;
    private int numberOfComputers;
    private double equipmentCost;

    public Lab(String entityID, String name, String location, int numberOfStudents,int numberOfStaff,String  labType,int numberOfComputers,double equipmentCost)
    {
        super( entityID,  name,  location,  numberOfStudents, numberOfStaff);
        this.labType=labType;
        this.numberOfComputers=numberOfComputers;
        this.equipmentCost=equipmentCost;
    }

    @Override
    public double calculateOperationalCost()
    {
        return equipmentCost + numberOfStudents * 300.0;
    }

    public String getLabType()
    {
        return labType;
    }

    public int getNumberOfComputers()
    {
        return numberOfComputers;
    }

    public double getEquipmentCost()
    {
        return equipmentCost;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Lab Type: " + labType + " | Computers: " + numberOfComputers + " | Equipment Cost: " + equipmentCost;
    }
}

