import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayFunctions {
    public static int[] reverse(int[] inputArray){
        for(int i = 0; i < inputArray.length / 2; i++) {
            int j = inputArray[i];
            inputArray[i] = inputArray[inputArray.length - i - 1];
            inputArray[inputArray.length - i - 1] = j;
        }
        return inputArray;
    }

    public static int[] getArray(String inputArray){
        inputArray = inputArray.replaceAll("\\[", "").replaceAll("]", "");
        String[] stringNumbers = inputArray.split(",");
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

    public static int[] getSquareAndDelete(int[] inputArray, int S) {
        S = S * 11;
        int counter = 0;

        int[] tempArray = new int[inputArray.length];

        for (int num : inputArray) {
            int result = num * num;
            if (result < S) {
                tempArray[counter] = result;
                counter++;
            }
        }
        return java.util.Arrays.copyOf(tempArray, counter);
    }

    public static void printArray(int[] inputArray) {
        System.out.print("[ ");
        for (int j : inputArray) System.out.print(j + " ");
        System.out.print("]");
    }

    public static int[] removeElements(int[] inputArray, int S) {
        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int num = inputArray[i];
            int result = 0;
            int factor = 1;
            boolean numberRemoved = num != 0;

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
                inputArray[counter++] = result;
            }
        }
        return java.util.Arrays.copyOf(inputArray, counter);
    }
}
