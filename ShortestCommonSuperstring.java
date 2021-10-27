import java.util.Random;
import java.util.ArrayList;
public class ShortestCommonSuperstring
{
    public static void main(String[] args)
    {
        if(args.length == 2)
        {
            try 
            {
                Integer.parseInt(args[0]);  
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
                System.exit(0);
            }
            try 
            {
                Integer.parseInt(args[1]);  
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("FEHLER: Der Seed Parameter konnte nicht gelesen werden.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
                System.exit(0);
            }
            int n = Integer.parseInt(args[0]);
            if(n<=1)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
                System.exit(0);
            }
            int seed = Integer.parseInt(args[1]);
            String[] arr = new String[n];
            java.util.Random numberGenerator = new java.util.Random(seed);
            for(int i = 0; i<n; i++)
            {
                arr[i] = generateRandomString(numberGenerator);
                arr[i].toUpperCase();
            }
            computeShortestCommonSuperString(arr);
        }
        else if(args.length == 1)
        {
            try 
            {
                Integer.parseInt(args[0]);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
                System.exit(0);
            }
            int n = Integer.parseInt(args[0]);
            if(n<=1)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
                System.exit(0);
            }
            int seed = 6521;
            String[] arr = new String[n];
            java.util.Random numberGenerator = new java.util.Random(seed);
            for(int i = 0; i<n; i++)
            {
                arr[i] = generateRandomString(numberGenerator);
                arr[i].toUpperCase();
            }
            computeShortestCommonSuperString(arr);
        }
        else if(args.length >2)
        {
            for(int i = 0;i<args.length;i++)
            {
                if(args[i].length() <2)
                {
                    System.out.println("FEHLER: Uebergebene Strings muessen mindestens Laenge 2 haben.");
                    System.out.println("Aufruf des Programms mit:");
                    System.out.println("- java ShortestCommonSuperstring n [seed]");
                    System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
                    System.exit(0);
                }
                args[i].toUpperCase();
            }
            computeShortestCommonSuperString(args);
        }
        else
        {
            System.out.println("FEHLER: Es wurde kein Parameter übergeben.");
            System.out.println("Aufruf des Programms mit:");
            System.out.println("- java ShortestCommonSuperstring n [seed]");
            System.out.println("- java ShortestCommonSuperstring str1 str2 str 3 [str4 ...]");
            System.exit(0);
        }
    }

    public static String generateRandomString(Random numberGenerator)
    {
        String alphabet = "AEIOU";
        StringBuilder builder = new StringBuilder();
        int length = 3 + numberGenerator.nextInt(4);
        while (length-- > 0) {
        int randomIdx = numberGenerator.nextInt(alphabet.length());
        builder.append(alphabet.charAt(randomIdx));
        }
        return builder.toString();
    }

    public static int StringOverlap(String A, String B)
    {
        int max = 0;
        int m = A.length();
        int n = B.length();
        if(m<n)
        {
            for(int i = 1; i<m; i++)
            {
                if(A.substring(m-i, m).equals(B.substring(0,i)))
                {
                    max = i;
                }
            }
        }
        else
        {
            for(int i = 1; i<n; i++)
            {
                if(A.substring(m-i, m).equals(B.substring(0,i)))
                {
                    max = i;
                }
            }
        }
        return max;
    }

    public static void computeShortestCommonSuperString(String[] arr) //Methode zur Berechnung des kuerzesten SuperStrings eines Arrays
    {
        ArrayList<String> temp = new ArrayList<String>(arr.length);
        for(int i = 0; i<arr.length; i++)
        {
            temp.add(arr[i]);       //Eine Liste erstellen mit den Strings des uebergebenen arrays
        }
        String superString = "";
        while(temp.size()!=1)
        {
            int max = Integer.MIN_VALUE;;
            int maxX = 0;
            int maxY = 0;
            for(int x = 0; x<temp.size();x++)
            {
                for(int y = 0; y<temp.size(); y++)
                {
                    if(x!=y)   //wenn x = y ware wuerde man den String mit sich selbst vergleichen
                    {
                        int tmp = StringOverlap(temp.get(x),temp.get(y));
                        if(max < tmp)
                        {
                            max = tmp;  //der groeste overlap wird rausgesucht und die Indexe werden gespeichert
                            maxX = x;   //Index des ersten Strings
                            maxY = y;   //Index des zweiten Strings
                        }
                        
                    }
                }
            }
            if(max == 0)
            {
                maxX=0;
                maxY=temp.size()-1;
            }
            superString = temp.get(maxX) + temp.get(maxY).substring(StringOverlap(temp.get(maxX),temp.get(maxY)),temp.get(maxY).length());   //Berechnung des Superstrings der beiden Strings mit dem groessten Overlap
            if(arr.length <= 10)        //Ausgabe, falls weniger als 11 Strings uebergeben werden
            {
                for(int k = 0; k<temp.size();k++)
                {
                    System.out.print(temp.get(k) + " ");
                }
                System.out.println("");
                System.out.println("Ersetze " + temp.get(maxX) + " und " + temp.get(maxY) + " durch " + superString);
            }
            String str1 = temp.get(maxX);       //Setzen der beiden Strings mithilfe der gespeicherten Indexe
            String str2 = temp.get(maxY);
            temp.remove(str1);                  //Entfernen der beiden Strings und hinzufuegen des Superstrings in die Liste
            temp.remove(str2);
            temp.add(superString);     
        }
        System.out.println("Superstring " + superString + " mit Laenge " + superString.length() + " gefunden.");
        
    }
        
}