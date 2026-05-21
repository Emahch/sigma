
import java.io.*;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class B {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(in.nextLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] tokens = line.split(" ");
            for(String token : tokens){
                if(token.endsWith("0000") && token.matches("[0-9]+")){
                    sb.append(rule(token)).append(" ");

                }else{
                    sb.append(token).append(" ");
                }

            }
            String temp = sb.toString().trim();
            sb.setLength(0);
            sb.append(temp);
            sb.append("\n");
        }

        out.print(sb.toString());
        out.flush();
    }

    static String rule (String token){
        int counter = 0;
        boolean interrupted = false;
        if(token.matches("[1][0]+")){
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                if(c == '0') counter++;
            }
            return "10^{" + counter + "}";
        }else{
            for (int i = token.length() - 1; i > 0; i--) {
                char c = token.charAt(i);
                if(c == '0' && !interrupted){
                    counter++;
                }else{
                    interrupted = true;
                }
            }

            String base = token.charAt(0) + "." + token.substring(1, token.length() - counter);
            if(base.endsWith(".")){
                return token.charAt(0) + "\\cdot10^{" + (token.length() - 1) + "}";
            }else{
                return base + "\\cdot10^{" + (token.length() - 1) + "}";
            }


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
