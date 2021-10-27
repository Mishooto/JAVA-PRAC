// პრინტ Box.attribute მაინც პრინტავს მიუხედავად იმისა რო privateზე აყენია. ზუსტად იგივეს პრინტავს Box.Getattribute()
public class Bocks{
    private double Hoehe;
    private double Tiefe;
    private double Breite;
    public Bocks(double height,double depth,double length){
        Hoehe = height;
        Tiefe = depth;
        Breite = length;
    }
    public double GetHoehe(){
        return Hoehe;
    }
    public double GetTiefe(){
        return Tiefe;
    }
    public double GetBreite(){
        return Breite;
    }
    public double GetVolumeGroese(){
        return Hoehe*Tiefe*Breite;
    }
    public double GetAreaSize(){
        double pirveliori = 2*Hoehe*Tiefe;
        double meoreori = 2*Hoehe*Breite;
        double mesameori = 2*Breite*Tiefe;
        return pirveliori+meoreori+mesameori;
        //alternate way: return 2 * (width * height + width * depth + height * depth);
    }
    public double GetEdgeSize(){
        return 4 * (Hoehe + Tiefe + Breite);
    }
    public boolean isCube(){
        return( Hoehe==Tiefe && Hoehe ==Breite);
        //პასუხში ასეა: return (width == height) && (width == depth);
    }
    public int compareTo( Bocks x){
        if(GetVolumeGroese() > x.GetVolumeGroese()){
            return 1;
        }
        if(GetVolumeGroese() == x.GetVolumeGroese()){
            return 0;
        }
        if(GetVolumeGroese() < x.GetVolumeGroese()){
            return -1;
        }
        return 69;
    }

    public static void main(String[] args) {
        Bocks boux = new Bocks(5,6,7);
        Bocks bouxorilike = new Bocks(3,3,3);
        System.out.println(boux.GetBreite());
        //System.out.println(boux.Tiefe);
        System.out.println(boux.Hoehe);
        System.out.println(boux.GetHoehe());
        System.out.println(bouxorilike.GetVolumeGroese());
        System.out.println(boux.compareTo(bouxorilike));
        System.out.println(bouxorilike.compareTo(boux));
    }
}