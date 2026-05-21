package repository;

import java.util.ArrayList;
import java.io.Serializable;

public class CampusRepository<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private ArrayList<T> items = new ArrayList<>();

    public void add(T item)
    {
        items.add(item);
    }

    public void remove(T item)
    {
        items.remove(item);
    }

    public T get(int index)
    {
        return items.get(index);
    }

    public ArrayList<T> getAll()
    {
        return items;
    }

    public int getSize()
    {
        return items.size();
    }

    public void clear()
    {
        items.clear();
    }
}