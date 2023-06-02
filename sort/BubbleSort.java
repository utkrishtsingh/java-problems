public class BubbleSort {
    public static void main(String... args) {
        int[] arr = new int[]{10, 9, 8, 1, 3, 4, 6};
        arr = bubbleSort(arr);
        printIntArray(arr);
    }

    private static int[] bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int swapValue = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swapValue;
                }
            }
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