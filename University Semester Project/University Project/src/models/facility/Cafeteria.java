package models.facility;

public class Cafeteria extends Facility
{
    private static final long serialVersionUID = 1L;
    private int seatingCapacity;
    private String menuType;


    public Cafeteria(String entityID, String name, String location, double maintenanceCost, int usageFrequency, int seatingCapacity, String menuType)
    {
        super(entityID, name, location, maintenanceCost, usageFrequency);
        this.seatingCapacity = seatingCapacity;
        this.menuType = menuType;
        totalFacilityUsage++;
    }

    public int getSeatingCapacity()
    {

        return seatingCapacity;
    }
    public String getMenuType()
    {

        return menuType;
    }

    @Override
    public double calculateOperationalCost()
    {
        return maintenanceCost + seatingCapacity * 50.0;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Seating: " + seatingCapacity + " | Menu: " + menuType;
    }
}