public class RadixSort {
    public static int getMax(int[] inputArray) {
        int max = inputArray[0];
        for(int i = 1; i<inputArray.length; i++) {
            if(inputArray[i] > max) max = inputArray[i];
        }
        return max;
    }

    public static void countingSort(int[] inputArray, int place){
        int[] output = new int[inputArray.length+1];
        int[] count = new int[10];

        for (int j : inputArray) count[(j / place) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = inputArray.length - 1; i >= 0; i--) {
            output[count[(inputArray[i] / place) % 10] - 1] = inputArray[i];
            count[(inputArray[i] / place) % 10]--;
        }

        System.arraycopy(output, 0, inputArray, 0, inputArray.length);
    }

    public static void radixSort(int[] inputArray) {
        int max = getMax(inputArray);

        for (int place = 1; max / place > 0; place *= 10)
            countingSort(inputArray, place);
    }

}