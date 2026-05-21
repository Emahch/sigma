import java.io.*;
import java.util.StringTokenizer;

public class I {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {

        int n = in.nextInt();

        while(n-- > 0){
            String line = in.nextLine();

            if(line.charAt(0) == ' ' || line.charAt(line.length() - 1) == ' '){
                out.println("Validation failed");
                return;
            }

            String[] line2 = line.split(" ");

            for (int i = 0; i < line2.length; i++) {
                String w = line2[i];

                if(!cumpleRegex(w)){
                    out.println("Validation failed");
                    return;
                }
            }
        }

        out.println("Ok");

        out.flush();
    }

    static boolean cumpleRegex(String w){
        if(w.matches("[a-zA-Z0-1]\\^\{}")){
            return true;
        }else{
            return false;
        }
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
