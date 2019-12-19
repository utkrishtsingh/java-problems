import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class FastReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String line = "";

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
