package models.base;
import java.io.Serializable;
public abstract class CampusEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected String entityID;
    protected String name;
    protected String location;

    public CampusEntity(String entityID, String name, String location)
    {
        this.entityID = entityID;
        this.name = name;
        this.location = location;
    }

    public String getEntityID()
    {
        return entityID;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public abstract double calculateOperationalCost();
    @Override
    public String toString()
    {

        return "Entity ID: " + entityID + " | Name: " + name + " | Location: " + location;
    }
}
