public class BinarySearch {
    public static void main(String... args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 20, 21, 22, 23, 24, 25};
        int index = binarySearch(arr, 1);
        System.out.println(index);
    }

    // Returns non-negative integer representing index if element is found; -1 otherwise
    private static int binarySearch(Integer[] arr, Integer element) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (int) Math.floor((l + r) / 2);
            if (element == arr[m]) {
                return m;
            } else if (element < arr[m]) {
                r = m - 1;
            } else if (element > arr[m]) {
                l = m + 1;
            }
        }

        return -1;
    }
}
