public class fibonacci {

    public static int fib(int n){
        if (n==0){
            return 0;
        }
        int a = 0;
        int b = 1;
        for (int i=1; i<n;i++){
            int c = a+b;
            a=b;
            b=c;
        }
        return b;
    }



    public static int fibby(int n){
        if (n==0){
            return 0;
        }
        int a = 0;
        int b = 1;
        for (int i=1; i<n;i++){
            int c = a+b;
            a=b;
            b=c;
        }
        return b;
    }
    public static void main(String[] args){
        for (int k=0; k<48;k++){
            System.out.println("number "+k);
            System.out.print(fib(k)+"\n");
        }

            //System.out.println("iteration "+j+"\n");
            //System.out.print(fib(j)+"\n");
        //System.out.print(fibby(2));
        }
    }