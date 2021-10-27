/* Hinweise zu dieser Aufgabe 
 * 
 * Uebersicht:
 * [10 Punkte] Geben Sie unten jeweils fuer jeden Aufruf der Methode  apply  an,
 * welche Signatur der Methode  apply  der Compiler für die Ausführung festlegt und
 * in welcher Klasse die ausgeführte Implementierung von  apply  vereinbart ist.  
 * 
 */


class Polymorphism {

    private static class All { /* ... */ }
    private static class Most extends All { /* ... */ }
    private static class Many extends Most { /* ... */ }
    private static class Some extends Many { /* ... */ }

    private static class Top {
        public void apply( All p ) { /* ... */ }
    }

    private static class Center extends Top {
        public void apply( Most p ) { /* ... */ }

        public void apply( Some p ) { /* ... */ }
    }

    private static class Bottom extends Center {
        public void apply( All p ) { /* ... */ }

        public void apply( Many p ) { /* ... */ }
    }

    public static void run() 
    {
        All  all  = new All();
        Most most = new Most();
        Many many = new Many();
        Some some = new Some();

        Top    t = new Center();
        Center c = new Bottom();
        Bottom b = new Bottom();

        t.apply( many );
        /* 
         * --- hier bitte ergaenzen ---
         * vom Compiler gewaehlte Signatur der Methode  apply: apply (all p)
         * Klasse, deren Implementierung von  apply  ausgefuehrt wird: TOP
        */


        t.apply( most );
        /* 
         * --- hier bitte ergaenzen ---         
         * vom Compiler gewaehlte Signatur der Methode  apply:  apply(all p)
         * Klasse, deren Implementierung von  apply  ausgefuehrt wird: TOP
        */
       

        c.apply( some );
        /* 
         * --- hier bitte ergaenzen ---
         * vom Compiler gewaehlte Signatur der Methode  apply:   apply (some p)
         * Klasse, deren Implementierung von  apply  ausgefuehrt wird:CENTER
        */
       

        c.apply( many );        
        /* 
         * --- hier bitte ergaenzen ---
         * vom Compiler gewaehlte Signatur der Methode  apply:   apply (most p)
         * Klasse, deren Implementierung von  apply  ausgefuehrt wird: CENTER
        */
       
        b.apply( most );        
        /* 
         * --- hier bitte ergaenzen ---
         * vom Compiler gewaehlte Signatur der Methode  apply:   apply (most p)
         * Klasse, deren Implementierung von  apply  ausgefuehrt wird: CENTER
        */
    }   
    
}