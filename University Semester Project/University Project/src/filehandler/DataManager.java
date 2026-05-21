package filehandler;
import java.io.*;

public class DataManager
{
    public static void saveData(String filename, Object data)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream write = new ObjectOutputStream(file);
            write.writeObject(data);
            write.close();
            file.close();
            System.out.println("Main file saved: " + filename);
        }
        catch(IOException e)
        {
            System.out.println("Error saving main file: " + e.getMessage());
        }

        String backupFilename = filename.replace(".dat", "_backup.dat");

        try
        {
            FileOutputStream file2 = new FileOutputStream(backupFilename);
            ObjectOutputStream write2 = new ObjectOutputStream(file2);
            write2.writeObject(data);
            write2.close();
            file2.close();
            System.out.println("Backup saved: " + backupFilename);
        }
        catch(IOException e)
        {
            System.out.println("Error saving backup: " + e.getMessage());
        }
    }

    public static Object loadData(String filename)
    {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream read = new ObjectInputStream(file);
            Object data = read.readObject();
            read.close();
            file.close();
            System.out.println("Data loaded from main file: " + filename);
            return data;
        }
        catch (IOException e)
        {
            System.out.println("Main file failed: " + e.getMessage());
            System.out.println("Trying backup file...");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found in main file: " + e.getMessage());
            System.out.println("Trying backup file...");
        }

        String backupFilename = filename.replace(".dat", "_backup.dat");

        try {
            FileInputStream file = new FileInputStream(backupFilename);
            ObjectInputStream ois = new ObjectInputStream(file);
            Object data = ois.readObject();
            ois.close();
            file.close();
            System.out.println("Data loaded from BACKUP: " + backupFilename);
            return data;
        }
        catch (IOException e)
        {
            System.out.println("Backup file also failed: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found in backup: " + e.getMessage());
        }
        System.out.println("Both main and backup files failed!");
        return null;

    }
}