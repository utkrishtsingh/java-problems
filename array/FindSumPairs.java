import java.util.Map;
import java.util.HashMap;

// Input: arr -> an array of positive integers, sum -> the sum to be found
// Output: All pairs of indexes i, j such that arr[i] + arr[j] = sum
public class FindSumPairs {
    public static void main(String... args) {
        int[] arr = new int[]{1, 3, 6, 8, 2, 4};
        int sum = 5;
        Map<Integer, Integer> result = findSumPairs(arr, sum);
        result.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }

    private static Map<Integer, Integer> findSumPairs(int[] arr, int sum) {
        Map<Integer, Integer> sumPairs = new HashMap<>();
        Map<Integer, Integer> elements = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (elements.containsKey(sum - arr[i])) sumPairs.put(elements.get(sum - arr[i]), i);

            elements.put(arr[i], i);
        }

        return sumPairs;
    }
}
