public class RadixSort {
    public static int getMax(int a[], int n) {
        int max = a[0];
        for(int i = 1; i<n; i++) {
            if(a[i] > max) max = a[i];
        }
        return max;
    }

    public static void countingSort(int a[], int n, int place){
        int[] output = new int[n+1];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(a[i] / place) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(a[i] / place) % 10] - 1] = a[i];
            count[(a[i] / place) % 10]--;
        }

        for (int i = 0; i < n; i++)
            a[i] = output[i];
    }

    // function to implement radix sort
    public static void radixsort(int a[], int n) {
        int max = getMax(a, n);

        for (int place = 1; max / place > 0; place *= 10)
            countingSort(a, n, place);
    }

}