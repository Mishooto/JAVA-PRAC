public class Sortierung
{
    static int vergleiche = 0;
    public static void main(String[] args)
    {
        java.util.Random numberGenerator = new java.util.Random(951);  //Generator für Zufallszahlen
        if(args.length >= 1 && args.length <= 3)					//Gueltige Eingaben bestehen aus 1 bis 3 Argumenten
        {
            try
            {
                Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e)							//Fehlermeldung wenn ein nicht in integer ueberfuehrbarer string angegeben wird
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
                System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                System.out.println("Beispiel: java Sortierung 10000 merge rand");
                System.exit(0);
            }
            int n = Integer.parseInt(args[0]);
            if(n<=0)												//Fehlermeldung, falls eine Feldgröße <= 0 angegeben wird
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
                System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                System.out.println("Beispiel: java Sortierung 10000 merge rand");                
                System.exit(0);
            }
            int[] arr = new int[n];
            if(args.length == 1)									//Generieren des Arrays ohne zweiten Parameter
            {
                for(int i = 0; i < n; i++)
                {
                    arr[i] = numberGenerator.nextInt();
                }
                if(n<=100)												//Abfrage ob Unsortierter Array ausgegeben werden soll
                {
                    for(int i = 0; i<n; i++)							//Ausgabe des Unsortierten Arrays
                    {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println("");
                }
                mergeSort(arr);
                    if(n<=100)												//Abfrage ob Sortierter Array ausgegeben werden soll
                    {
                        for(int j = 0; j<n; j++)
                        {
                            System.out.print(arr[j] + " ");
                        }
                        System.out.println("");
                    }
                    if(isSorted(arr))										//Ausgabe ob Feld sortiert ist
                    {  
                        System.out.println("Feld ist sortiert!");
                        System.out.println("Das Sortieren des Arrays hat " + vergleiche + " Vergleiche benoetigt.");
                    }
                    else
                    {
                        System.out.println("FEHLER: Feld ist NICHT sortiert!");
                    }
                System.exit(0);
            }
            if(args.length == 3)
            {
                if(args[2].equals("auf"))							//Generieren mit Parameter "auf"
                {
                    for(int i = 0; i < n; i++)
                    {
                        arr[i] = i+1;
                    }	
                }
                else if(args[2].equals("ab"))						//Generieren mit Parameter "ab"
                {	
                    for(int i = 0; i < n; i++)
                    {
                        arr[i] = n-i;
                    }
                }
                else if(args[2].equals("rand"))						//Generieren mit Parameter "rand"
                {
                    for(int i = 0; i < n; i++)
                    {
                        arr[i] = numberGenerator.nextInt();
                    }
                }
                else												//Fehlermeldung, falls kein Gueltiger Parameter, an dritter Stelle, übergeben wird
                {
                    System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: " + args[2]);
                    System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                    System.out.println("Beispiel: java Sortierung 10000 merge rand");
                    System.exit(0);
                }
            }
            if(args[1].equals("insert"))							//Abfrage ob InsertionSort oder MergeSort verwendet werden soll
                {
                    if(n<=100)
                    {
                        for(int i = 0; i<n; i++)							//Ausgabe des Unsortierten Arrays
                        {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println("");
                    }
                    insertionSort(arr);
                }
            else if(args[1].equals("merge") || args.length == 1)
                {
                    if(n<=100)
                    {
                        for(int i = 0; i<n; i++)							//Ausgabe des Unsortierten Arrays
                        {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println("");
                    }
                    mergeSort(arr);
                }           
            else													//Fehlermeldung, falls keine gueltige Eingabe für die SortierArt getätigt wurde
                {
                    System.out.println("FEHLER: Unbekanntes Sortierverfahren: " + args[1]);
                    System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                    System.out.println("Beispiel: java Sortierung 10000 merge rand");
                    System.exit(0);
                }
                assert isSorted(arr): "FEHLER: Feld ist NICHT sortiert!";
            
            if(n<=100)												//Abfrage ob Sortierter Array ausgegeben werden soll
            {
                for(int i = 0; i<n; i++)
                {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("");
            }
            if(isSorted(arr))										//Ausgabe ob Feld sortiert ist
            {
                System.out.println("Feld ist sortiert!");
                System.out.println("Das Sortieren des Arrays hat " + vergleiche + " Vergleiche benoetigt.");
            }
            else
            {
                System.out.println("FEHLER: Feld ist NICHT sortiert!");
                System.exit(0);
            }
        }		
        else														//Fehlermeldung bei falscher Eingabe
        {
            System.out.println("FEHLER: Es muessen zwischen 1 und 3 Parameter angegeben werden.");
            System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
            System.out.println("Beispiel: java Sortierung 10000 merge rand");
            System.exit(0);
        }
    }

    public static void mergeSort(int[] array) 
    { 
        int[] tmpArray = new int[array.length]; 
        mergeSort(array, tmpArray, 0, array.length-1);
        assert isSorted(array); 
    }

    public static void mergeSort(int[] array, int[] tmpArray, int left, int right) //Aufsteigendes Sortieren mit MergeSort
    {
        if(left < right)
        {
            int mid = (left + right)/2;	
            mergeSort(array,tmpArray,left,mid);			//Sortieren linke Haelfte
            mergeSort(array,tmpArray,mid+1,right);		//Sortieren rechte Haelfte
            merge(array,left,mid,right);				//Zusammenfügen der Haelften
        }
    }

    public static void merge(int[]array, int left, int mid, int right)	//Zusammenfuegen der beiden MergeSort Haelften
    {
        int size1 = mid - left + 1;			//Groessen von zwei "Teilarrays"
        int size2 = right - mid;
        int[] leftArray = new int[size1];		//Erstellen von zwei temporaeren Arrays
        int[] rightArray = new int[size2];
        for(int i=0; i<size1; i++)				//Befuellen der linken Haelfte
        {
            leftArray[i] = array[left+i]; 
        }
        for(int j=0; j<size2; j++)				//Befuellen der rechten Haelfte
        {
            rightArray[j] = array[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while(i<size1 && j<size2)			//Zusammenfuegen des linken und des rechten Arrays
        {
            vergleiche++;
            if(leftArray[i] > rightArray[j])
            {
                array[k] = rightArray[j];
                j++;
            }
            else
            {
                array[k] = leftArray[i];
                i++;
            }
            k++;
        }
        while(i<size1)					//"Ueberbleibsel" an den Array anhaengen
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<size2)
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void insertionSort(int[] array)					//Aufsteigendes Sortieren mit InsertionSort
    {
        int n = array.length;
        for(int i=1; i<n; i++)
        {
            int j = i-1;
            int temp = array[i];
            while(j>=0 && array[j] > temp)
            {
                vergleiche++;
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    public static boolean isSorted(int[] array)						//Methode zur Überprüfung, ob das Feld sortiert ist
    {
        int n = array.length;
        for(int i=0; i<n-1; i++)
        {
            if(array[i] > array[i+1])
            {
                return false;
            }
        }
        return true;
    }
}