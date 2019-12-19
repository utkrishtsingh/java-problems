import java.util.Arrays;

public class MergeSort {
    public static void main(String... args) {
        int[] unsorted = new int[]{10, 9, 8, 1, 3, 4, 6};
        int[] sorted = mergeSort(unsorted);
        printIntArray(sorted);
    }

    private static int[] mergeSort(int[] unsorted) {
        // True in the trivial case, i.e. when unsorted only has one element; updated otherwise
        int[] sorted = unsorted;

        if (unsorted.length > 1) {
            // copy and get first half
            int[] firstHalf = Arrays.copyOfRange(unsorted, 0, (int) Math.floor(unsorted.length / 2));

            //copy and get second half
            int[] secondHalf = Arrays.copyOfRange(unsorted, (int) Math.floor(unsorted.length / 2), unsorted.length);

            // mergesort recursive call on first half
            int[] firstHalfSorted = mergeSort(firstHalf);

            //mergesort recursive call on second half
            int[] secondHalfSorted = mergeSort(secondHalf);

            //merge the first and second sorted halves
            sorted = merge(firstHalfSorted, secondHalfSorted);
        }

        return sorted;
    }

    private static int[] merge(int[] firstHalfSorted, int[] secondHalfSorted) {
        int[] merged = new int[firstHalfSorted.length + secondHalfSorted.length];

        int i = 0, j = 0, k = 0;
        while (i < firstHalfSorted.length && j < secondHalfSorted.length) {
            if (firstHalfSorted[i] <= secondHalfSorted[j]) {
                merged[k] = firstHalfSorted[i];
                i++;
            } else if (firstHalfSorted[i] > secondHalfSorted[j]) {
                merged[k] = secondHalfSorted[j];
                j++;
            }
            k++;
        }

        // firstHalf copied completely but secondHalf is left
        if (i == firstHalfSorted.length) {
            for (int q = j; q < secondHalfSorted.length; q++, k++) {
                merged[k] = secondHalfSorted[q];
            }
        } // secondHalf copied completely but firstHalf is left
        else if (j == secondHalfSorted.length) {
            for (int p = i; p < firstHalfSorted.length; p++, k++) {
                merged[k] = firstHalfSorted[p];
            }
        }

        return merged;
    }

    private static void printIntArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
