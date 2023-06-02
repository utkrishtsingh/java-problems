public class SelectionSort {
    public static void main(String... args) {
        int[] arr = new int[]{10, 9, 8, 1, 3, 4, 6};
        arr = selectionSort(arr);
        printIntArray(arr);
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int minValue = arr[min];
            arr[min] = arr[i];
            arr[i] = minValue;
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