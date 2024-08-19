import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayFunctions {
    public static int[] reverse(int[] array){
        for(int i = 0; i < array.length / 2; i++) {
            int j = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = j;
        }
        return array;
    }

    public static int[] getArray(String array){
        array = array.replaceAll("\\[", "").replaceAll("\\]", "");
        String[] stringNumbers = array.split(",");
        boolean nonValidArray = false;
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            if(isValidNumber(stringNumbers[i].trim())){
                numbers[i] = Integer.parseInt(stringNumbers[i].trim());
            }
            else{
                nonValidArray = true;
                break;
            }
        }
        if (nonValidArray) return new int[0];
        else return numbers;
    }

    public static boolean isValidNumber(String str) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static int getMinimumChange(int[] coins) {
        int minChange = 1;

        for (int coin : coins) {
            if (coin > minChange) {
                break;
            }
            minChange += coin;
        }
        return minChange;
    }

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

    public static void printArray(int[] a, int n) {
        System.out.print("[ ");
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
        System.out.print("]");
    }

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
