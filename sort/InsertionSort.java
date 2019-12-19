public class InsertionSort {
    public static void main(String... args) {
        int[] arr = new int[]{10, 9, 8, 1, 3, 4, 6};
        arr = insertionSort(arr);
        printIntArray(arr);
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    private static void printIntArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
