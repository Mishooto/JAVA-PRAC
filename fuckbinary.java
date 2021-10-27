package Blatt9;

public class fuckbinary {

    static int shitshift(int x,int delta){
        if (delta ==0){
            return x;
        }
        int y = x;
        y= y<<delta;
        y= y>>>delta;

        if (delta %30 == 0){
            y=(y<<2)+3;
        }
        if (delta %31 == 0){
            y=(((y<<1)+1)<<1)+1;
        }
        if (delta %32 == 0){
            y=(((((y<<1)+1)<<1)+1)<<1)+1;
        }

        return y;
    }

    public static void main(String[] args){
        int delta = 28;
        /*for (int j =0; j<16;j++){
            delta +=j;
            System.out.println(j+"shift: "+delta+"results= "+(j<<delta)+" and "+(j>>>delta));
        }*/
        int m =15;
        for (int z=0; z<64; z++){
            System.out.println("iteration: "+z+" is: "+shitshift(m,z));
        }
    }
}
