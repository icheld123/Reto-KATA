public class Square {
    public static int[] getSquare(int[] arr, int S) {
        S = S * 11;
        int counter = 0;

        int[] temp = new int[arr.length];

        for (int num : arr) {
            int result = num * num;
            if (result < S) {
                temp[counter] = result;
                counter++;
            }
        }
        return java.util.Arrays.copyOf(temp, counter);
    }
}