public class Testat
{
    /*DAFAILEBULI PIRVELI ravi TXUTMETI MCDELOBA!
     Für alle i mit 0<=i<arr.length soll die Methode apply im Bereich von
einschließlich arr[0] bis einschließlich arr[i] die Anzahl derjenigen Brüche bestimmen,
deren Werte zwischen einschließlich 0 und einschließlich 1 liegen.
Die ermittelte Anzahl soll als Bruch zurückgegeben werden.
• Für alle Werte von i, die außerhalb des Bereichs 0<=i<arr.length liegen,
soll die Methode apply einen Bruch mit demWert -1 zurückgeben.
     */
    /*public static Fraction apply(Fraction[] arr, int i )
    {
        int counter = 0;
        if ( i<0 || i>=arr.length )
        {
            return new Fraction(-1);
        }
        if (arr[i].toDouble()>= 0 || arr[i].toDouble() <= 1){
             counter++;
        }
        return new Fraction(counter).add(apply(arr,i-1));

        }
    }*/
    /* SOLUTION IYO RO AR MECADA RAME ELEGANTURI ONE SIZE FITS ALL SOLUTIONIS POVNA, ARAMED ROGORC TVITON LOSUNGEBSHIA
    RO GAMOMEYO CALCALKE CASEBI (BASE CASE, ERROR CASE, SATISFACTORY CASE, DA RETURNEBIS MESHVEOBIT YVELA SHEMEERTEBINA,
    VAFSHE SAERTOD AR DAMCHIRDA INT COUNTER VARIABLE ROMELSAC MERE FRACTIONAD GADAVAQCEVDI, I STAY WINNING PURR */
    public static Fraction apply (Fraction[] arr, int i){
        if (i<0 || i>=arr.length){
            return new Fraction(-1);
        }
        //tu iteration gvinda pirveli 0 elementistvis anu mxolod pirveli elementistvis
        if (i==0){
            //vamowmeb eg ertaderti elementi rac mainteresebs aris tuara intervalshi [0;1]
            if (arr[0].toDouble()>=0 && arr[0].toDouble() <= 1){
                return new Fraction(1);
            }
            //anu ar yofila eg elem intervalshi anu nuls vamrbunebt
            return new Fraction(0);
        }
        //if (arr[i].toDouble() >=0 && arr[i].toDouble() <= 1){
            return new Fraction(1).add(apply(arr,i-1));
        }
        //return apply(arr,i-1);
    }
    /*public static void main(String[] args){
        Fraction[] arr1 = { new Fraction(0,1), new Fraction(1,5), new Fraction(11,6), new Fraction(1,5), new Fraction(1,10), new Fraction(1,1) };
        System.out.println(apply(arr1,3));
    }*/
//}