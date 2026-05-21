package models.facility;
import models.service.ServiceUnit;
import java.io.Serializable;
import java.util.ArrayList;

public class CampusZone implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String zoneID;
    private String zoneName;


    private ArrayList<Facility> facilities = new ArrayList<>();
    private ArrayList<ServiceUnit> serviceUnits = new ArrayList<>();

    public CampusZone(String zoneID, String zoneName)
    {
        this.zoneID   = zoneID;
        this.zoneName = zoneName;
    }


    public void addFacility(Facility facility)
    {
        facilities.add(facility);

    }

    public void removeFacility(Facility facility)
    {
        facilities.remove(facility);
    }

    public ArrayList<Facility> getFacilities()
    {
        return facilities;
    }


    public void addServiceUnit(ServiceUnit serviceUnit)
    {
        serviceUnits.add(serviceUnit);
    }

    public void removeServiceUnit(ServiceUnit serviceUnit)
    {
        serviceUnits.remove(serviceUnit);
    }

    public ArrayList<ServiceUnit> getServiceUnits()
    {
        return serviceUnits;
    }


    public String getZoneID()
    {
        return zoneID;
    }
    public String getZoneName()
    {
        return zoneName;
    }


    public String getZoneReport()
    {
        return "Zone: " + zoneName + " | Facilities: " + facilities.size() + " | Services: " + serviceUnits.size();
    }

    @Override
    public String toString()
    {
        return "Zone ID: " + zoneID + " | Zone Name: " + zoneName + " | Total Facilities: " + facilities.size() + " | Total Services: " + serviceUnits.size();
    }
}
