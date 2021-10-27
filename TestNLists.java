public class TestNLists
{
    public static void main( String[] args )
    {
        NLists<Integer> nl = new NLists<>( 5 );
        nl.add(0,1);
        nl.add(0,2);
        nl.add(0,3);
        nl.add(1,4);
        nl.add(1,5);
        nl.add(2,6);
        nl.add(4,7);
        nl.add(4,8);
        nl.add(4,9);
        nl.add(4,10);
        Iterator<Integer> it = nl.iterator();
        while ( it.hasNext() )
        {  
            System.out.print( it.next() + " " );
        }
    }
}
