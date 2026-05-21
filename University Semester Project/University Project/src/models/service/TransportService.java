package models.service;

import interfaces.Schedulable;

public class TransportService extends ServiceUnit implements Schedulable
{
    private static final long serialVersionUID = 1L;
    private int totalRoutes;
    private int totalVehicles;
    private String scheduleType;

    public TransportService(String entityID, String name, String location, double serviceHours, int staffCount, int totalRoutes, int totalVehicles, String scheduleType)
    {
        super(entityID, name, location, serviceHours, staffCount);
        this.totalRoutes = totalRoutes;
        this.totalVehicles = totalVehicles;
        this.scheduleType = scheduleType;
    }

    public int getTotalRoutes()
    {

        return totalRoutes;
    }
    public int getTotalVehicles()
    {
        return totalVehicles;
    }
    public String getScheduleType()
    {

        return scheduleType;
    }

    @Override
    public double calculateOperationalCost()
    {

        return serviceHours * staffCount * 100.0 + totalVehicles * 500.0;
    }

    @Override
    public String generateSchedule()
    {
        return "Route: " + totalRoutes + " | Vehicles: " + totalVehicles + " | Type: " + scheduleType;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Routes: " + totalRoutes + " | Vehicles: " + totalVehicles + " | Schedule: " + scheduleType;
    }
}