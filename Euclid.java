
public class Euclid {

	public static void main(String[] args) {
		if(check(args))
		{
			Euclid obj = new Euclid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			obj.TrueGGT();
		}
		

	}

	
	
	private int a; // Max Zahl
	private int b; // Kleinere Zahl
	private int errorcount = 0;

	public static boolean check (String[] q)
	{
		
		if(q.length != 2||q.length<1)
		{
			System.out.println("Falsche Parameteranzahl!\nAufruf mit: java Euclid a b\nDabei muessen a und b natuerliche Zahlen groesser 0 sein.\nBeispiel: java Euclid 24 896");
			return false;
		}
		else if(CheckInt(q))
		{
			return true;
		}
		else {
			System.out.println("Falscher Parameter - Nur Zahlen sind erlaubt!\nAufruf mit: java Euclid a b\nDabei muessen a und b natuerliche Zahlen groesser 0 sein.\nBeispiel: java Euclid 24 896");

			return false;
		}
			
	}
	
	public static boolean  CheckInt(String[] q)
	{
		try {
			
			
			Integer.parseInt(q[0]);
				Integer.parseInt(q[1]);
				
			
			
			
		}catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	
	Euclid(int a, int b) {
		try {
			
				if (a <= 0 || b <= 0) {
					System.out.println(
							"Durch Null Geteilt!\nAufruf mit: java Euclid a b\nDabei muessen a und b natuerliche Zahlen groesser 0 sein\nBeispiel: java Euclid 24 896");
					errorcount++;
				}
			if (a > b) {
				this.a = a;
				this.b = b;
			} else {
				this.a = b;
				this.b = a;
			}
		} catch (Exception e) {
			

		}
	}

	public boolean error() {
		if (errorcount == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void TrueGGT() {
		System.out.println(GGT(this.a, this.b));
	}

	public int GGT(int a, int b) {
		try {
			if (a % b == 0) {
				return b;
			} else {
				int x = b;
				int y = a % b;
				return GGT(x, y);
			}
		}catch(ArithmeticException e)
		{
			
		}
		return 0;
	}

}
