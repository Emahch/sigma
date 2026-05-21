import java.io.*;
import java.util.*;

public class L {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
            int Q = in.nextInt();

        for (int i = 0; i < Q; i++) {
            int current = in.nextInt();

            ArrayList<Integer> fnums = new ArrayList<>();
            int count = 0;
            for (int j = 1; j <= current; j++) {
                fnums.add((j * j) + 1);
            }

            for(int n : fnums){
                if(isPrime(n)) count++;
            }
            out.println(count);
        }
            out.flush();
    }

//    static boolean[] sieve(int n){
//        boolean[] isPrime = new boolean[n+1];
//        Arrays.fill(isPrime, true);
//
//        if(n >= 0) isPrime[0] = false;
//        if(n >= 1) isPrime[1] = false;
//
//        for (int i = 2; i*i <= n; i++) {
//            if(isPrime[i]){
//                for (int j = i*i; j <= n ; j+=i) {
//                    isPrime[j] = false;
//                }
//            }
//        }
//
//        return isPrime;
//    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
                if (num %i == 0) {
                    return false;
                }
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next() throws IOException {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine() throws IOException { return br.readLine();}
        public int nextInt() throws IOException { return Integer.parseInt(next()); }
        public long nextLong() throws IOException { return Long.parseLong(next()); }
        public double nextDouble() throws IOException { return Double.parseDouble(next()); }
    }
}
