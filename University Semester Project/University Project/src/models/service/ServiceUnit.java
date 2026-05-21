package models.service;

import models.base.CampusEntity;

import java.io.Serializable;

public abstract class ServiceUnit extends CampusEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected double serviceHours;
    protected int staffCount;

    public ServiceUnit(String entityID, String name, String location,double serviceHours,int staffCount)
    {
        super(entityID, name, location);
        this.serviceHours=serviceHours;
        this.staffCount=staffCount;
    }

    public double getServiceHours()
    {

        return serviceHours;
    }

    public int getStaffCount()
    {

        return staffCount;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Service Hours: " + serviceHours + " | Staff Count: " + staffCount;
    }
}
