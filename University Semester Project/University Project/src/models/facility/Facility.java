package models.facility;
import java.io.Serializable;
import models.base.CampusEntity;

public abstract class Facility extends CampusEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected double maintenanceCost;
    protected int usageFrequency;
    protected static int totalFacilityUsage = 0;
    public Facility(String entityID, String name, String location, double maintenanceCost, int usageFrequency)
    {
        super(entityID, name, location);
        this.maintenanceCost = maintenanceCost;
        this.usageFrequency = usageFrequency;
    }

    public static int getTotalFacilityUsage()
    {
        return totalFacilityUsage;
    }

    public double getMaintenanceCost()
    {

        return maintenanceCost;
    }

    public int getUsageFrequency()
    {

        return usageFrequency;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Maintenance Cost: " + maintenanceCost + " | Usage Frequency: " + usageFrequency;
    }

}
