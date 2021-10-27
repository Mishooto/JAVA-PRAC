
public class InsertionSort {

	public static void main(String[] args)
	{
		if(args.length == 1)
		{
			if(check2(args))
			{
				if(Integer.parseInt(args[0])<= 100)
				{
					InsertionSort test1 = new InsertionSort(Integer.parseInt(args[0]));
					test1.show();
					InsertionSort.insertionSort(test1.arg);
					test1.show();
					
					if(InsertionSort.isSorted(test1.getarg()))
					{
					 System.out.println("Feld ist sortiert!");
					 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
					 
					}
					else
					{
						 System.out.println("Feld ist Nicht sortiert!");
						 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
					}
					
				}else
				{
					InsertionSort test1 = new InsertionSort(Integer.parseInt(args[0]));
					
					InsertionSort.insertionSort(test1.arg);
					
					
					if(InsertionSort.isSorted(test1.getarg()))
					{
					 System.out.println("Feld ist sortiert!");
					 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
					 
					}
					else
					{
						 System.out.println("Feld ist Nicht sortiert!");
						 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
					}
				}
			}
		}else if(check(args))
		{
			if(Integer.parseInt(args[0])<= 100)
			{
				InsertionSort test1 = new InsertionSort(Integer.parseInt(args[0]),args[1]);
				test1.show();
				InsertionSort.insertionSort(test1.arg);
				test1.show();
				
				if(InsertionSort.isSorted(test1.getarg()))
				{
				 System.out.println("Feld ist sortiert!");
				 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
				 
				}
				else
				{
					 System.out.println("Feld ist Nicht sortiert!");
					 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
				}
				
			}else
			{
				InsertionSort test1 = new InsertionSort(Integer.parseInt(args[0]),args[1]);
				
				InsertionSort.insertionSort(test1.arg);
				
				
				if(InsertionSort.isSorted(test1.getarg()))
				{
				 System.out.println("Feld ist sortiert!");
				 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
				 
				}
				else
				{
					 System.out.println("Feld ist Nicht sortiert!");
					 System.out.println("Das Sortieren des Arrays hat"+" "+test1.getcount()+" "+"Vergleiche benoetigt.");
				}
			}
		}
		
		
		
		
	}
	
	private int[] arg;
	private static int count = 0; 
	
	
	
	private int getcount()
	{
		return InsertionSort.count;
	}
	private int [] getarg()
	{
		return this.arg;
	}
	public InsertionSort(int a)
	{
		arg = new int [a];
		java.util.Random numberGenerator = new java.util.Random();
		numberGenerator.setSeed(951);
		
		for(int i = 0; i< arg.length; i++)
		{
			int randomNumber = numberGenerator.nextInt();
			arg[i] = randomNumber;
		}
	}
	
	public InsertionSort(int a , String g)
	{
		arg = new int [a];
		
		if(g.equals("auf"))
		{
			for(int i = 0; i< arg.length; i++)
			{
				arg[i] = i+1;
			}
		}
		else if(g.equals("ab"))
		{
			for(int i = 0; i< arg.length; i++)
			{
				arg[i] = arg.length-i;
			}
		}
		
		else if(g.equals("rand"))
		{
			java.util.Random numberGenerator = new java.util.Random();
			numberGenerator.setSeed(951);
			
			for(int i = 0; i< arg.length; i++)
			{
				int randomNumber = numberGenerator.nextInt();
				arg[i] = randomNumber;
			}
		}
		
	}
	
	public void show()
	{
		for(int i = 0; i<arg.length; i++)
		{
			System.out.print(arg[i] + "  "); 
		}
		System.out.println(); // Die println ausgabe ist nur dazu da um eine neue zeile zu beginnen
	}
	
	public static void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++)
		{
			count++;
			int x = array[i];
			int j = i;
			
			while(j > 0 && array[j-1]> x)
			{
				if(j== 1)
				{
					count--;
				}
				count++;
				array[j] = array[j-1];
				j = j-1;
				
					
			}
			array[j] = x;
			
		}
	}
	public static boolean isSorted(int[] array)
	{
		if(array.length==0)
		{
			return true;
		}
			
		for(int i = 0; i<array.length-1; i++)
		{
			
			if(array[i+1]<array[i])
			{
				
				return false;
			}
		}

		if(array[array.length-1]<array[array.length-2])
		{
			return false;
		}
		return true;
	}
	
	public static boolean check (String[] q)
	{
		
		
		if(q.length > 2 || q.length < 1)
		{
			System.out.println("FEHLER: Es muessen zwischen 1 und 2 Parameter angegeben werden.\nAufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");
			return false;
		}
		else if(Checksort(q))
		{
			String Eingabe = q[1];
			System.out.println("FEHLER: Unbekanntes Vorsortierverfahren:"+" " + Eingabe);
			System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");
            return false;
		}
		
		else if(CheckInt(q))
		{
			if(Integer.parseInt(q[0])<0)
			{
				System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.\nAufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");
return false;
			}
			else
			{
				return true;
			}
			
		}
		else {
			System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.\nAufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");

			return false;
		}
			
	}
	public static boolean check2 (String[] q) // die gleiche Methode wie Check nur fuer einen Parameter
	{
		
		if(q.length > 2 || q.length < 1)
		{
			System.out.println("FEHLER: Es muessen zwischen 1 und 2 Parameter angegeben werden.\nAufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");
			return false;
		}
		
		else if(CheckInt(q)&&Integer.parseInt(q[0])>=0)
		{
			if(Integer.parseInt(q[0])<0)
			{
				System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.\nAufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");
return false;
			}
			else
			{
				return true;
			}
		}
		else {
			System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.\nAufruf mit: java InsertionSort n [auf|ab|rand]\nBeispiel: java InsertionSort 10000 rand");

			return false;
		}
			
	}
	
	public static boolean Checksort(String[] q)
	{
		if(q[1].equals("auf"))      // die methode gibt false zurueck wenn ein key word 
			                 // gefunden wurden ist. Dies tut es weil in der if
			                 // der die ausgabe ist falls etwas anderes eingeben wurden ist. 
		{
			return false;
		}else if(q[1].equals("ab"))
		{
			return false;
			
		}else if(q[1].equals("rand"))
		{
			return false;
		}
		return true;
	}
	
	public static boolean  CheckInt(String[] q)
	{
		try {
			
			
			Integer.parseInt(q[0]);
				
				
			
			
			
		}catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
}
