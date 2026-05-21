import java.io.*;
import java.util.*;

public class D {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = in.nextInt();
        long x1, y1, r1, x2, y2, r2, k;
        while(T-- > 0){
            x1 =  in.nextLong();
            y1 =  in.nextLong();
            r1 =  in.nextLong();
            x2 =  in.nextLong();
            y2 =  in.nextLong();
            r2 =  in.nextLong();
            k =  in.nextLong();

            if(k <= 2*r1 || k <= 2*r2){
                out.println("YES");
                continue;
            }

            if(distancia(x1, x2, y1, y2) > r1 + r2){
                out.println("NO");
                continue;
            }



            double maxLength = 0;

            if(r2 <= r1){
                if(r2 + distancia(x1, x2, y1, y2) < r1){
                    maxLength = 2 * r1;
                }else{
                    maxLength = r1 + r2 + distancia(x1, x2, y1, y2);
                }
            }else{
                if(r1 + distancia(x1, x2, y1, y2) < r2){
                    maxLength = 2 * r2;
                }else{
                    maxLength = r1 + r2 + distancia(x1, x2, y1, y2);
                }
            }

            if(maxLength >= k){
                out.println("YES");
            }else{
                out.println("NO");
            }

        }

        out.flush();
    }

    static double distancia(long x0, long x1, long y0, long y1){
        return Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
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
