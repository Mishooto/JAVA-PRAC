/* Hinweise zu dieser Aufgabe 
 * 
 * Uebersicht:
 * [12 Punkte] Ergaenzen Sie in drei Methodenaufrufen jeweils Lambda-Ausdruecke als 
 * Argumente derart, dass die unten als Kommentar angegebene Funktionalitaet
 * realisiert wird. 
 * 
 */

public class LambdaExpressions
{                           

    public interface BiIntFunction
    {
        int apply( int p1, int p2 );
    }

    private int[] values;
    private int val;

    public LambdaExpressions( int[] p ) 
    { 
        values = p; 
    }

    public int compute( BiIntFunction calculate, BiIntFunction set )
    {
        int result = 0;
        int intermediate = 0;
        if ( values.length > 0 )
        {
            for ( int i = 0; i < values.length; i++ )
            {
                intermediate  = calculate.apply( i, values[i] );
                result = set.apply( intermediate, result );
            }
        }
        return result;
    }

    public static void apply( int[] init )
    {
        LambdaExpressions id = new LambdaExpressions( init );
            int outcome = 0;

        /* Aufgabe 1:
         * Ergaenzen Sie Lambda-Ausdruecke als Argumente derart, dass 
         * in der Variablen  outcome  die Summe der Inhalte aus dem Attribut  values
         * abgelegt wird, die an ungeraden Indizes stehen.  
         */

            outcome = id.compute(x->{if(x%2!=0){return 1;},(x->0;));

        
        /* Aufgabe 2:
         * Ergaenzen Sie Lambda-Ausdruecke als Argumente derart, dass 
         * in der Variablen  outcome  der Wert  von  values[1]  abgelegt  
         * wird, falls gilt:  values.length>1
         * Sonst soll der Wert  0  abgelegt werden.
         */

            outcome = id.compute(x -> {if (values.length > 1){return values[1];}}, x->{return 0;});
        
        /* Aufgabe 3:
         * Ergaenzen Sie Lambda-Ausdruecke als Argumente derart, dass 
         * in der Variablen  outcome  der groesste positive Wert abgelegt wird, 
         * der in  values  vorkommt. Gibt es keinen positiven Wert in  values, soll der 
         * Wert  0  abgelegt werden.
         */

            outcome = id.compute( x->{int max = values[0]; for (int i =0; i<values.length;i++){if (values[i]>max){max=values[i];}}}
                                 ,x->0);
    }
}