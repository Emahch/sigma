
import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {

        int n = in.nextInt();
        int m = in.nextInt();

        boolean[][] matriz = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            matriz[a][b] = true;
            matriz[b][a] = true;
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    if (j == k) matriz[j][k] = true;
                    if (!matriz[j][k]) {
                        if (matriz[j][i]) {
                            matriz[j][k] = matriz[i][k];
                        }
                    }
                }
            }
        }

        int count = 0;
        boolean[] busy = new boolean[n];
        ArrayList<String> results = new ArrayList<>();
        for (int i = n - 1; i >= 0 ; i--) {
            if (!busy[i]) {
            for (int j = n-1; j >= 0; j--) {
                if (!matriz[i][j] && !busy[j]) {
                    busy[j] = true;
                    busy[i] = true;
                    results.add(j + " " + i);
                    count++;
                    break;
                }
            }
            }
        }
        out.println(count);
        for (String result : results) {
            out.println(result);
        }

        out.flush();
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
