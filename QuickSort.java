public class QuickSort
{
    static java.util.Random rng = new java.util.Random(1337);
    static int count = 0;
    public static void main(String[] args)
    {
        int n = args.length;
        if(n==0)
        {
            System.out.println("FEHLER: Es wurden keine Argumente uebergeben.");
            System.exit(0);
        }
        try 
        {
            for (int i = 0; i<args.length; i++)
            {
                Integer.parseInt(args[i]);
            }
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("FEHLER: Es koennen nur ganze Zahlen sortiert werden.");
            System.exit(0);
        }
        int[] tmpArray = new int[n];
        for (int i = 0; i<n; i++)
        {
            tmpArray[i]=Integer.parseInt(args[i]);
        }
        quickSort(tmpArray);
        for(int i = 0; i<n; i++)
        {
            System.out.print(tmpArray[i]);
            if(i != n-1) System.out.print(", ");
        }
        System.out.println("");
        System.out.println(count);

    }

    public static void quickSort(int[] A)
    {
        quickSort(A, 0, A.length-1);
    }

    public static void quickSort(int[] A, int p, int r)
    {
        if(p<r)
        {
            int q = partition(A,p,r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
    }

    public static int partition(int[] A, int p, int r)
    {
        count++;
        int z = rng.nextInt((r-p)+1) + p;
        swap(A,z,r);
        int pivot = A[r];
        int i = p;
        int j = r-1;
        while(i<j)
        {
            while(A[i] > pivot)
            {
                i++;
            }
            while(i<j && A[j] <= pivot)
            {
                j--;
            }
            if(i<j)
            {
                swap(A,i,j);
            }
        }
        if(A[i]<A[r])
        {
            swap(A,i,r);
        }
        return i; 
    }

    public static void swap(int[] A, int i, int j)
    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}