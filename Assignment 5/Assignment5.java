abstract class Convert 
{
    double val1;
    double val2;

    Convert(double v1, double v2) 
    {
        val1 = v1;
        val2 = v2;
    }

    abstract double compute();
}


class LtoG extends Convert 
{

    LtoG(double v1) 
    {
        super(v1, 0);
    }

    public double compute() 
    {
        val2 = val1 * 0.264172;
        return val2;
    }
}


class FtoC extends Convert 
{

    FtoC(double v1) 
    {
        super(v1, 0);
    }

    public double compute() 
    {
        val2 = (val1 - 32) * 5 / 9;
        return val2;
    }
}


class FtoM extends Convert 
{

    FtoM(double v1) 
    {
        super(v1, 0);
    }

    public double compute() 
    {
        val2 = val1 * 0.3048;
        return val2;
    }
}

public class Assignment5
{
    public static void main(String[] args) 
    {

        Convert c;
        c = new LtoG(10);
        System.out.println("Liters to Gallons: " + c.compute());

        c = new FtoC(100);
        System.out.println("Fahrenheit to Celsius: " + c.compute());

        c = new FtoM(50);
        System.out.println("Feet to Meters: " + c.compute());
    }
}