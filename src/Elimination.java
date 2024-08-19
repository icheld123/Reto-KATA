public class Elimination {
    public static int[] removeElements(int[] arr, int S) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int result = 0;
            int factor = 1;
            boolean numberRemoved = true;

            if (num == 0){
                numberRemoved = false;
            }

            while (num > 0) {
                int digit = num % 10;
                if (digit < S) {
                    result += digit * factor;
                    factor *= 10;
                    numberRemoved = false;
                }
                num /= 10;
            }

            if (!numberRemoved) {
                arr[counter++] = result;
            }
        }
        return java.util.Arrays.copyOf(arr, counter);
    }
}
