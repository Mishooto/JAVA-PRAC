public class Search
{
    static long x;
    public static void main (String[] args)
    {
        if(args.length != 1) 
        {
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
            System.exit(0);
        }
        try
        {
            Long.parseLong(args[0]);
        }
        catch (Exception e)
        {
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
            System.exit(0);
        }
        x = Long.parseLong(args[0]);
        if(x<=0)
        {
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
            System.exit(0);    
        }
        long m = exponentialSearch(x);
        long l = ternarySearch(x, m/2, m);
        System.out.println("Ergebnis: T(" + l + ") = " + T(l));
    }

    public static long exponentialSearch(long x)
    {
        long m = 1;
        while(x>=T(m))
        {
            m *=2;
        }
        return m;
    }

    public static long ternarySearch(long x, long l, long r)
    {
        System.out.println("links: T(" + l + ") = " + T(l) + ", rechts: T(" + r + ") = " + T(r) );
        if(l == r-1)
        {
            return l;
        } 
        long s1 = l + ((r-l)/3);
        long s2 = l + (2*(r-l)/3);
        long tS1 = T(s1);
        long tS2 = T(s2);
        if(tS1 <= x && tS2 > x)
        {
            return ternarySearch(x, s1, s2);
        }
        else if(tS1 > x)
        {
            return ternarySearch(x, l, s1);
        }
        else
        {
            return ternarySearch(x, s2, r);
        }
    }

    public static long T(long m)
    {
        return (((3*m) * m + 7*m -10)/2);
    }
}