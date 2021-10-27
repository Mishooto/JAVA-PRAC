public class chemievklide {

    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(recurse(a,b));
    }

     static int recurse(int a, int b){
        if (b==0) {
            return a;
        }
        return recurse(b,a%b);
    }
}
