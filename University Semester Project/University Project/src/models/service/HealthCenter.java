package models.service;

import interfaces.Notifiable;

public class HealthCenter extends ServiceUnit implements Notifiable
{
    private static final long serialVersionUID = 1L;
    private int totalDoctors;
    private int totalBeds;
    private String centerType;

    public HealthCenter(String entityID, String name, String location, double serviceHours, int staffCount, int totalDoctors, int totalBeds, String centerType)
    {
        super(entityID, name, location, serviceHours, staffCount);
        this.totalDoctors = totalDoctors;
        this.totalBeds = totalBeds;
        this.centerType = centerType;
    }

    public int getTotalDoctors()
    {

        return totalDoctors;
    }
    public int getTotalBeds()
    {

        return totalBeds;
    }
    public String getCenterType()
    {

        return centerType;
    }

    @Override
    public double calculateOperationalCost()
    {

        return staffCount * serviceHours * 200.0 + totalBeds * 300.0;
    }

    @Override
    public void sendNotification(String message)
    {
        System.out.println("HEALTH ALERT from " + name + ": " + message);
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Doctors: " + totalDoctors + " | Beds: " + totalBeds + " | Type: " + centerType;
    }
}
