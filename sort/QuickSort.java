public class QuickSort {
    public static void main(String... args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        arr = quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static int[] quickSort(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex <  endIndex) {
            int q = partition(arr, beginIndex, endIndex);
            arr = quickSort(arr, beginIndex, q - 1);
            arr = quickSort(arr, q + 1, endIndex);
        }
        return arr;
    }

    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (arr[j] < x) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[r] = arr[i + 1];
        arr[i + 1] = x;

        return i + 1;
    }

    private static void printArray(int[] arr) {
        for(int number: arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
