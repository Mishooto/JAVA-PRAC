
public class Shape {

	public void draw()
	{
		System.out.println("Drawing Shape");
	}


	public static boolean ispali(String text) {
		int lengs = text.length() - 1;
		System.out.println(lengs);
		for (int i = 0; i < lengs; i++) {
			if (text.charAt(i) != text.charAt(lengs - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean decreasing (int[] arr){
		for (int i=0;i< arr.length-1;i++){
			if(arr[i]<arr[i+1]){
				return false;
			}
		}
		return true;
	}
	public static int countmin( int[] arr){
		int minimum = arr[0];
		for (int num:arr){
			if(num < minimum){
				minimum = num;
			}
		}
		int counter = 0;
		for (int elem:arr){
			if (elem == minimum){
				counter ++;
			}
		}
		return counter;
	}

    public static void main (String[] args){
	/*int i = 12;
	while (i > 0){
	    System.out.print(i+"bitches \n");
	    //System.out.println("bitches \n");
	    i--;
    }
		int[] shouldbefalse = {1,2,3,4,5,6,7};
		int[] shouldbetrue = {7,6,5,2,0};
		int[] countminexamp ={900,234,69,12,45,12,3,76,3,84,3,199};
		System.out.println(ispali("EVE"));
		System.out.println(decreasing(shouldbefalse));
		System.out.println(decreasing(shouldbetrue));
		System.out.println(countmin(countminexamp));
		*/
		Shape s=new Rectangle();
		s.draw();

		s=new Circle();
		s.draw();
    }
}

class Rectangle extends Shape
{
	public void draw()
	{
		System.out.println("Drawing Rectangle");
	}
}

class Circle extends Shape
{
	public void draw()
	{
		System.out.println("Drawing Circle");
	}
}
