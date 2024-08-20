public class QuickSort {
    public static void quickSort(int[] inputArray, int low, int high) {
        if (low < high) {
            int index = partition(inputArray, low, high);

            quickSort(inputArray, low, index - 1);
            quickSort(inputArray, index + 1, high);
        }
    }

    private static int partition(int[] inputArray, int low, int high) {
        int pivot = inputArray[high];
        int lowestIndex = (low - 1);

        for (int j = low; j < high; j++) {
            if (inputArray[j] <= pivot) {
                lowestIndex++;

                int tempArray = inputArray[lowestIndex];
                inputArray[lowestIndex] = inputArray[j];
                inputArray[j] = tempArray;
            }
        }

        int tempArray = inputArray[lowestIndex + 1];
        inputArray[lowestIndex + 1] = inputArray[high];
        inputArray[high] = tempArray;

        return lowestIndex + 1;
    }
}