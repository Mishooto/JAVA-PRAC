public class pregamocda{

    public static void main(String[] args)
    {
        Top tt = new Top();
        Top tm = new Middle();
        Top tb = new Bottom();
        Middle mb = new Bottom();
        Bottom bb = new Bottom();
        Bottom uu = new Bottom();
        //tm.f( tm );
        //tm.f( tt );
        //tb.f( tt );
        tb.f( tm );
        mb.f( bb );
        //mb.f( mb );
        //mb.f( new Middle() );
        System.out.println("EXPEriMENtiNG");
        //new Bottom().f( mb );
        //new Bottom().f(new Middle());
        //tb.f(tt);
        tt.f(tb);
        tt.f(mb);
        tt.f(bb);
        tm.f(tb);
        tm.f(mb);
        tm.f(bb);
        //bb.f(tm);
    }
}

class Top
{
    public void f( Top p ) { System.out.print("Y "); }
    public void f( Middle p ) { System.out.print("Z "); }
    public void f( Bottom p ) { System.out.print("Mishospecial "); }
}

class Middle extends Top
{
    public void f( Top p ) { System.out.print("C "); }
    public void f( Middle p ) { System.out.print("D "); }
    public void f( Bottom p ) { System.out.print("E "); }
}
class Bottom extends Middle
{
    public void f( Object p ){ System.out.print("L "); }
    public void f( Bottom p ) { System.out.print("M "); }
}

