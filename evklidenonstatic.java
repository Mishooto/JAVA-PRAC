public class evklidenonstatic {

    public static void main(String[] args){
        evklidenonstatic evklide = new evklidenonstatic();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(evklide.recurse(a,b));
    }

    int recurse(int a, int b){
        if (b==0) {
            return a;
        }
        return recurse(b,a%b);
    }
}
