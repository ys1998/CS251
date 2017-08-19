
import java.util.Random;
import java.util.Arrays;

class Add implements Runnable {

    int[] a, b, res;

    public Add(int[] x, int[] y) {
        a = Arrays.copyOf(x, x.length);
        b = Arrays.copyOf(y, y.length);
        res = new int[a.length];
    }

    @Override
    public void run() {
        for (int i = 0; i < a.length; ++i) {
            res[i] = a[i] + b[i];
        }
    }
}

class Multiply implements Runnable {

    int[] a, b, res;

    public Multiply(int[] x, int[] y) {
        a = Arrays.copyOf(x, x.length);
        b = Arrays.copyOf(y, y.length);
        res = new int[a.length];
    }

    @Override
    public void run() {
        for (int i = 0; i < a.length; ++i) {
            res[i] = a[i] * b[i];
        }
    }

}

public class Problem2 {
    // The length of each array is taken to be 5000

    private static int[] a = new int[5000];
    private static int[] b = new int[5000];

    // main function
    public static void main(String[] args) {
        // variables to store time of execution
        long st,end;
        // initialize 'a' and 'b' with random integers from 0 to 99
        Random r = new Random();
        for (int i = 0; i < 5000; ++i) {
            a[i] = r.nextInt(100);
            b[i] = r.nextInt(100);
        }
        // make objects
        Add sum = new Add(a, b);
        Multiply product = new Multiply(a, b);

        // Execution using threads
        st=System.nanoTime();
        Thread t1 = new Thread(sum);
        Thread t2 = new Thread(product);
        t1.start();
        t2.start();
        end=System.nanoTime();
        System.out.println("Threading time (ns) : "+(end-st));

        // Sequential execution
        int[] s = new int[5000];
        int[] p = new int[5000];
        st=System.nanoTime();
        for (int i = 0; i < 5000; ++i) {
            s[i] = a[i] + b[i];
        }

        for (int i = 0; i < 5000; ++i) {
            p[i] = a[i] * b[i];
        }
        end=System.nanoTime();
        System.out.println("Sequential time (ns) : "+(end-st));
    }
    // EXPLANATION :
    // Single thread turns out to be efficient as compared to using two threads 
    // because the operation performed in the threads is trivial (adding and 
    // multiplying numbers) and so, the cost of creating and maintaining threads
    // dominates over operation cost. Thus, using a single thread turns out to 
    // be more efficient
}
