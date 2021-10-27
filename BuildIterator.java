/*
        * Uebersicht:
        * [10 Punkte] Implementieren Sie eine passende innere Klasse in der Klasse  BuildIterator.
        * Die erwarteten Eigenschaften der Klasse finden Sie als Kommentar in der Klasse  BuildIterator.*/

import java.util.;
public class BuildIterator<T> implements Iterable<T>
{
    private Iterable<T> part1, part2;

    public BuildIterator( Iterable<T> p1, Iterable<T> p2 )
    {
        part1 = p1;
        part2 = p2;
    }

    public Iterator<T> iterator()
    {
        return new PartsIterator();
    }

    /* Aufgabe:
     * Vervollstaendigen Sie die Klasse  PartsIterator  derart,
     * dass der Iterator zuerst jeden der Inhalte  aus  part1  und anschliessend
     * jeden der Inhalte aus  part2  zurueckgibt. Falls keine weiteren Inhalte
     * vorhanden sind, soll  next  den Wert  null  zurueckgeben.
     */


    private class PartsIterator implements Iterator<T>
    {
        Iterator<T> erste = part1.iterator();
        Iterator<T> zweite = part2.iterator();


        public T returnvonerste(){

            if (erste.hasNext()){
                while (erste.hasNext()){
                    return erste.next();
                }
            }
        }
        public T returnage(){
            while (erste.hasNext()){
                return erste.next();
            }
            while (zweite.hasNext()){
                return zweite.next();
            }
        }

    }

}
/*
        private Iterator it1;
        private Iterator it2;

        public PartsIterator(){
            it1 = part1.iterator();
            it2 = part2.iterator();
        }

        @SuppressWarnings("unchecked")
        public T next(){
            if(it1.hasNext()){
                return (T) it1.next();
            }
            if(it2.hasNext()){
                return (T) it2.next();
            }
            return null;
        }

        public boolean hasNext(){
            return it1.hasNext() || it2.hasNext();
        }
 */