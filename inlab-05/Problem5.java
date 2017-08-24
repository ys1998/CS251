import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem5 {
        public static void main(String args[]) throws Exception{
                ArrayList<String> arr = new ArrayList<String> ();             

                try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                                line = line.replaceAll("[\n\r]", "");
                                String[] result = line.split("\\p{Punct}|\\s+");
                                for (String S : result){
                                        S = S.toLowerCase();
                                        if(S.trim().equals("") || S.equals("and") || S.equals("the") || S.equals("or")
|| S.equals("is") || S.equals("in") || S.equals("at") || S.equals("of") ||
S.equals("her") || S.equals("him") || S.equals("his"))        continue;
                                        //System.out.println(S);
                                        arr.add(S);
                                }        
                        }
                }
                Collections.sort(arr);
                SortedSet<String> uniq = new TreeSet<String>(arr);
                //for(String S : arr){
                for(String S : uniq){
                        //if(S.trim().equals("")) continue;                
                //for(String S : count)
                        
                        System.out.println(S + " " + Collections.frequency(arr, S) );
                }
        }
}
