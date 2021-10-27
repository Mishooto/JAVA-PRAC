import java.lang.Math;
import java.lang.StringBuilder;
import java.util.Locale;
public class Application
{
    public static void main(String[] args)
    {
        if(args.length == 2)
        {
            try 
            {
                Integer.parseInt(args[0]);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Falscher Parameter! Nur Integer groesser 2 sind erlaubt.");
                System.out.println("Aufruf mit : java Application numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                System.out.println("Bsp: java Application 100 1337");
                System.exit(0);
            }
            try 
            {
                Integer.parseInt(args[1]);    
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Falscher Parameter! Als Seed sind nur Integer erlaubt.");
                System.out.println("Aufruf mit : java Application numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                System.out.println("Bsp: java Application 100 1337");
                System.exit(0);
            }
            int n = Integer.parseInt(args[0]);
            if(n < 3)
            {
                System.out.println("Anzahl der Punkte muss groesser als 2 sein.");
                System.out.println("Aufruf mit : java Application numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                System.out.println("Bsp: java Application 100 1337");
                System.exit(0);
            }
            int s = Integer.parseInt(args[1]);
            PointsGenerator pGen = new PointsGenerator(0, 100, s);
            Point[] coords = new Point[n];
            coords = pGen.generate(n);
            sideOfLine(coords);
        }
        else if(args.length >=6 && args.length % 2 == 0)
        {
            try 
            {
                for(int i = 0; i<args.length; i++)
                {
                    Double.parseDouble(args[i]);
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Es war nicht moeglich, alle Punkte einzulesen.");
                System.out.println("Aufruf mit : java Application numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                System.out.println("Bsp: java Application 100 1337");
                System.exit(0);
            }
            int n = args.length;
            double[] temp = new double[n];
            for(int i = 0; i<args.length; i++)
            {
                temp[i] = Double.parseDouble(args[i]);
            }
            Point[] coords = new Point[n/2];
            int j = 0;
            for(int i = 0; i<n; i++)
            {
                coords[j] = new Point(temp[i], temp[i+1]);
                j++;
                i++;
                
            }
            sideOfLine(coords);

        }
        else
        {
            System.out.println("Falsche Parameteranzahl!");
            System.out.println("Aufruf mit : java Application numberOfPoints seed");
            System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
            System.out.println("Bsp: java Application 100 1337");
            System.exit(0);
        }
    }

    public static void sideOfLine(Point[] arr)
    {
        int side;
        Line startLine = new Line(arr[0], arr[1]);
        System.out.println("Vergleiche Punkte mit der Geraden " + startLine.toString());
        for(int i = 2; i < arr.length; i++)
        {
            System.out.print("Punkt " + arr[i].toString());
            side = startLine.side(arr[i]);
            if(side == 0) System.out.println(" liegt auf der Linie.");
            else if(side == 1) System.out.println(" liegt links der Linie.");
            else if(side == -1) System.out.println(" liegt rechts der Linie.");
            if(isBetween(arr[0], arr[1], arr[i]))
            {
                System.out.println("Punkt " + arr[i].toString() + " liegt zwischen " + arr[0].toString() + " und " + arr[1].toString());
            }
        }
    }

    public static boolean isBetween(Point i, Point j, Point k)
    {
        double iX = i.get(0);
        double iY = i.get(1);
        double jX = j.get(0);
        double jY = j.get(1);
        double kX = k.get(0);
        double kY = k.get(1);
        double vecIJX = jX-iX;
        double vecIJY = jY-iY;
        double distIJ = Math.hypot(vecIJX, vecIJY);
        double vecKJX = jX-kX;
        double vecKJY = jY-kY;
        double distKJ = Math.hypot(vecKJX, vecKJY);
        double vecIKX = kX-iX;
        double vecIKY = kY-iY;
        double distIK = Math.hypot(vecIKX, vecIKY);
        if(distIJ == distKJ + distIK)
        {
            return true;
        }
        return false;
    }
}
class Line
{
    Point start;
    Point end;
    Line(Point s, Point e)
    {
        start = s;
        end = e;
    }

    public int side(Point p)
    {
        double pos = ((end.get(0)- start.get(0)) * (p.get(1) - start.get(1)) - (end.get(1)-start.get(1)) * (p.get(0)-start.get(0)) );
        if(pos > 0) return 1;           //Punkt liegt links von der Geraden
        else if(pos < 0) return -1;     //Punkt liegt rechts von der Geraden
        return 0;                       //Punkt liegt auf der Geraden
    }

    public void invertDirection()
    {
        Point tmp = start;
        start = end;
        end = tmp;
    }

    public String toString()
    {
        String tmp ="";
        tmp = start.toString() + " -- " + end.toString();
        return tmp;
    }
}
class Point
{
    int n;
    double[] coordinates; 
    public Point(double... x)
    {
        n = x.length;
        coordinates = new double[n];
        for(int i = 0; i<n; i++)
        {
            coordinates[i] = x[i];  //Speichern der übergebenen Parameter als Koordinaten
        }
    }
    public String toString()    //Methode für die Ausgabe der Koordinaten als String
    {
        Locale en = new Locale("en");
        String temp = "(";
        if(n>0)
        {
            for(int i=0; i<n; i++)
            {
                temp += String.format(en, "%.2f",coordinates[i]);
                if(i!=n-1) temp += ", ";
            }
        }
        temp += ")";
        return temp;
    }
    public double get(int i)    //Methode um die Koordinaten in der i-ten Dim. zu erhalten
    {
        if(n>0)
        {
            return coordinates[i];
        }
        return 0;
    }
    public int getDim()
    {
        return n;
    }
}
class PointsGenerator
{
    double min;
    double max;
    int seed;
    java.util.Random rng;
    PointsGenerator(double minimum, double maximum, int s)
    {
        min = minimum;
        max = maximum;
        seed = s;
        rng = new java.util.Random(s);
    }

    public Point[] generate(int n)
    {
        Point[] points = new Point[n];
        for(int i = 0; i<n; i++)
        {
            double coord1 =  (rng.nextDouble() * (max - min) + min);
            double coord2 =  (rng.nextDouble() * (max - min) + min);
            points[i] = new Point(coord1, coord2);
        }
        return points;
    }
}