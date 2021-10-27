public class NLists<T>
{
    DoublyLinkedList<DoublyLinkedList<T>> lists;

    public NLists( int n ) 
    {
        lists = new DoublyLinkedList<DoublyLinkedList<T>>();
        for ( int i = 0; i < n; i++ ) 
        { 
            lists.add( new DoublyLinkedList<T>() ); 
        }
    }

    public void add( int listNo, T content ) 
    {
        lists.get( listNo ).add( content );
    }

    public Iterator<T> iterator() 
    {
        return new NListsIterator();
    }
    private class NListsIterator extends Iterator<T> 
    {
        Iterator<T> currentIterator;  // kann den Iterator einer Liste referenzieren
        int currentListNo;            // kann eine der Listen identifizieren

        public NListsIterator() 
        {
            currentListNo = 0;
            currentIterator = null;
            if ( lists.size() > 0 ) 
            {
                currentIterator =lists.get(0).iterator();
            } 
        }

        public boolean hasNext() 
        {
            while ( currentListNo < lists.size() ) {
                if ( currentIterator.hasNext() ) {
                    return true;
                } 
                else 
                {
                    currentListNo++;
                    if ( currentListNo < lists.size() ) {
                        currentIterator = lists.get(currentListNo).iterator();
                    }
                }
            }
            return false;
        }

        public T next() 
        {
            if ( hasNext() ) {
                return currentIterator.next();
            } else {
                throw new IllegalStateException();
            }
        }
    }
}