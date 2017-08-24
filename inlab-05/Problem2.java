import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Problem2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        Random rand = new Random();
        double mean = 0;
        for(int j=0;j<num;j++){
            int  n = rand.nextInt(10000) + 1;
            list.add(n);
            mean = mean + n;
        }
        mean = mean / num;
        double std = 0;
        for(int j=0;j<num;j++){
            std = std + (list.get(j) - mean) * (list.get(j) - mean);
            //System.out.println( j + ", " + list.get(j) );
        }
        std =std / (num - 1) ;
        std = Math.sqrt(std) ;
        System.out.println("Mean " + mean);
        System.out.println("Standard deviation " + std);
    }
}
