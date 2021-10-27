public class mcdeloba {

    public static boolean isSquare(int[][] Array) {
        int entries = 0;
        int spalte = 0;
        for (int[] arr : Array) {
            spalte++;
            for (int metaarr : arr) {
                entries++;
            }
        }
        int zeile = entries/spalte;
        System.out.println(zeile +" zeile und "+spalte+" spalten.");
        return (spalte==zeile);
    }
    public static int Grosste(int i) {

        int biggest = 0;
        for (int n = 1; n < i; n++) {
            if (i % n == 0 && n != i) {
                biggest = n;
            }
        }
        return biggest;
    }

  public static void printEveryEntryOf2DMatrix( int[][] List){
      for (int i = 0;i<List.length;i++){
          for (int j =0; j<List[i].length;j++){
              System.out.println(List[i][j]);
          } } }
  // ეს მეთოდი აბრუნებს [[I@4dd8dc3 ასეთ რაღაცეებს, მგონი ფოინთერებია? რატო არ ცვლის თვითონ ენთრის უგჰჰჰ
  public static int[][] scalarMult( int[][] matrix, int k ){
          for ( int i = 0; i < matrix.length; i++)
          {
              for ( int j = 0; j < matrix[i].length; j++ )
              {
                  matrix[i][j] *= k;
                  System.out.println(matrix);
              }
          }
          return matrix;
      }

    public static void main(String[] args) {
        int bsp1 = 12;
        int bsp2 = 100;
        int[][] bsp3 = {{1,2,3,},{4,5,6},{7,8,9}};


        //System.out.println("Beispiel 1: " + Grosste(bsp1));
        //System.out.println("Beispiel 2: " + Grosste(bsp2));
        //System.out.println("Beispiel : " + scalarMult(bsp3,2));
        scalarMult(bsp3,2);
    }
}


/*public class mcdeloba
{

    public static int countPairs(int [] arr)
    {
        int count=0;
        for (int i = 1; i < arr.length; i++ )
        {
            if ( arr[i-1] == arr[i] )
            {
                count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String [] args)
    {
        int[] bsp1 = {1,1,3,3,1,2,2,2,1};
        int[] bsp2 = {1,3,3,3,3,2,2,5,5};

        System.out.println( "Beispiel 1: " + countPairs(bsp1) );
        System.out.println( "Beispiel 2: " + countPairs(bsp2) );
    }

}
*/

/*
ჩემი მცდელობა:
    public static int Grosste(int i){

        int biggest = 0;
        for (int n =0; n<i;n++){
            if ( i%n==0 && n != i ){
                biggest = n;
            }
        }
        return biggest;
    }
    public static void main(String[] args){
        System.out.println(Grosste(12));
        System.out.print(Grosste(24));
    }
}

სწორი: public class Aufgabe_2_1
{
    public static int greatestProperDivisor( int n )
    {
        if ( n < 0 )
        {
            n = -n;
        }

        for ( int i=2; i < n/2; i++ )
        {
            if ( n%i == 0 )
            {
                return n/i;
            }
        }
        return 1;
    }
}
*/