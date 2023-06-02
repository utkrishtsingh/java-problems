public class ReverseArray {
    public static void main(String... args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        arr = reverseArray(0, arr.length, arr);
        for (int number : arr) {
            System.out.println(number);
        }
    }

    private static int[] reverseArray(int beginIndex, int endIndex, int[] arr) {
        int l = beginIndex, r = endIndex - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }
}

