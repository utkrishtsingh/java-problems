import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.function.Consumer;

public class Rotate1DArray {
	public static void main (String[] args) {
		//code
		FastReader reader = new FastReader();
		
		int t = reader.nextInt();
		
		int n, d;
		
		for (int i = 0; i < t; i++) {
		    n = reader.nextInt();
		    d = reader.nextInt();
		    
		    int[] arr = new int[n];
		    for (int j = 0; j < n; j++) {
		        arr[j] = reader.nextInt();
		    }
		    
		    // Call the method for output here
		    arr = rotate1DArrayLeft(arr, d);
		    printArray(arr, System.out::print);
		}
	}
	
	private static int[] rotate1DArrayLeft(int[] arr, int d) {
	    arr = reverseArray(arr, 0, d);
	    arr = reverseArray(arr, d, arr.length);
	    arr = reverseArray(arr, 0, arr.length);
	    return arr;
	}
	
	private static int[] reverseArray(int[] arr, int beginIndex, int endIndex) {
	    int start = beginIndex, end = endIndex - 1;
	    int temp;
	    
	    while (start < end) {
	        temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;
	        
	        start++;
	        end--;
	    }
	    
	    return arr;
	}
	
	private static void printArray(int[] arr, Consumer<String> output) {
	    for(int number: arr) {
	        output.accept(number + " ");
	    }
	    output.accept("\n");
	}
}

class FastReader {
    private StringTokenizer tokenizer;
    private BufferedReader reader;
    
    public FastReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() {
        while(tokenizer == null || !tokenizer.hasMoreElements()) {
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
}

