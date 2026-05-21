package models.service;

import interfaces.Notifiable;

public class SecurityService extends ServiceUnit implements Notifiable
{
    private static final long serialVersionUID = 1L;
    private int totalGuards;
    private String securityLevel;

    public SecurityService(String entityID, String name, String location, double serviceHours, int staffCount, int totalGuards, String securityLevel)
    {
        super(entityID, name, location, serviceHours, staffCount);
        this.totalGuards = totalGuards;
        this.securityLevel = securityLevel;
    }

    public int getTotalGuards()
    {
        return totalGuards;
    }
    public String getSecurityLevel()
    {
        return securityLevel;
    }

    @Override
    public double calculateOperationalCost()
    {
        return staffCount * serviceHours * 150.0;
    }

    @Override
    public void sendNotification(String message)
    {
        System.out.println("SECURITY ALERT: " + message);
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Guards: " + totalGuards + " | Security Level: " + securityLevel;
    }
}