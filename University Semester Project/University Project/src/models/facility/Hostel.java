package models.facility;

public class Hostel extends Facility
{
    private static final long serialVersionUID = 1L;
    private int totalRooms;
    private int occupiedRooms;
    private String hostelType;


    public Hostel(String entityID, String name, String location, double maintenanceCost, int usageFrequency, int totalRooms, int occupiedRooms, String hostelType)
    {
        super(entityID, name, location, maintenanceCost, usageFrequency);
        this.totalRooms = totalRooms;
        this.occupiedRooms = occupiedRooms;
        this.hostelType = hostelType;
        totalFacilityUsage++;
    }

    public int getTotalRooms()
    {

        return totalRooms;
    }
    public int getOccupiedRooms()
    {

        return occupiedRooms;
    }
    public String getHostelType()
    {

        return hostelType;
    }


    @Override
    public double calculateOperationalCost()
    {

        return maintenanceCost + occupiedRooms * 200.0;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Total Rooms: " + totalRooms + " | Occupied: " + occupiedRooms + " | Type: " + hostelType;
    }
}

