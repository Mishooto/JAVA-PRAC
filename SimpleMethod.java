/* Hinweise zu dieser Aufgabe 
 * 
 * Uebersicht:
 * [12 Punkte] Vervollstaendigen Sie eine Methode. Die erwartete Funktionalitaet der Methode
 * finden Sie als Kommentar in der Klasse  SimpleMethod.
 * 
 * [4 Punkte] Erklaeren Sie zusaetzlich den Ablauf des Ihrer Implementierung der Methode 
 * zugrundeliegenden Algorithmus durch eine kurze textuelle Beschreibung.
 * 
 */

public class SimpleMethod
{

    /* Aufgabe:
     * Die Methode  maxOnlyInArr  soll eine Referenz auf ein  Integer-Objekt zurueckgeben, 
     * das den groessten  int-Wert enthaelt, der nur in dem Feld  arr  und  nicht in dem
     * Feld  check  vorkommt.
     * Gibt es keinen solchen Wert, soll  null  zurueckgegeben werden.
     * Vergleiche koennen mit  equals  oder  compareTo vorgenommen werden.
    */


    public static Integer maxOnlyInArr( Integer[] arr, Integer[] check ) 
    {
    // --- bitte hier ergaenzen ---
        Integer maxfromarr = arr[0];
        for(int i =0; i< arr.length;i++){
            if (arr[i].compareTo(maxfromarr) == 1){
                maxfromarr = arr[i];
            }

        }
        for (int j=0; j<check.length;j++){
            if (!check[j].equals(maxfromarr)){
                return maxfromarr;
            }
        }
        return null;
    }
    
    
    /* --- hier bitte Beschreibung ergaenzen ---

     */
    
}