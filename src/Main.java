import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int S = 7;
        Scanner myObj = new Scanner(System.in);
        String opt;

        while(true){
            System.out.print("\nSelect an option or press any other key to leave:\n-> Challenge 1.\n-> Challenge 2.\n-> Challenge 3.\nYour option: ");
            opt = myObj.nextLine();

            if (!opt.equals("1") && !opt.equals("2") && !opt.equals("3")) {
                break;
            }

            System.out.println("Enter all numbers at once, separating each one of them with inputArray comma. E.g: 1,2,3.");
            String array = myObj.nextLine();
            int[] inputArray = ArrayFunctions.getArray(array);
            int[] resultArray;

            while (inputArray.length==0){
                System.out.println("Invalid input. Please enter numbers separated by commas.");
                array = myObj.nextLine();
                inputArray = ArrayFunctions.getArray(array);
            }
            System.out.print("The array given is: \n");
            ArrayFunctions.printArray(inputArray);

            switch (opt){
                case "1":
                    resultArray = ArrayFunctions.reverse(inputArray);
                    System.out.print("\n\nAfter applying sort, the array elements are - \n");
                    ArrayFunctions.printArray(resultArray);
                    System.out.print("\n\nAfter applying elimination of S = "+S+", the array elements are - \n");
                    resultArray = ArrayFunctions.removeElements(resultArray,S);
                    ArrayFunctions.printArray(resultArray);
                    break;
                case "2":
                    resultArray = inputArray;
                    System.out.print("\n\nAfter applying sort, the array elements are:\n");
                    RadixSort.radixSort(resultArray);
                    ArrayFunctions.printArray(resultArray);
                    System.out.print("\n\nAfter applying square function to every array elements and eliminating every S = "+S*11+" element:\n");
                    resultArray = ArrayFunctions.getSquareAndDelete(resultArray,S);
                    ArrayFunctions.printArray(resultArray);
                    break;
                case "3":
                    int minChange = ArrayFunctions.getMinimumChange(inputArray);
                    System.out.print("\n\nThe minimum amount of change is: "+minChange+"\n");
                    break;
            }
        }
    }
}