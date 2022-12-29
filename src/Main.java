import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int[] RandomValuesArray()
    {
        String isSort;
        Random rand = new Random();
        Scanner key = new Scanner(System.in);
        Scanner decision = new Scanner(System.in);
        int elementsQuantity = Integer.parseInt(
                getUserInput("How many numbers to generate: ")
        );
        int value1;//Set the origin of the array value
        int value2;//Set the bound of the array value
        int[] numbers = new int[elementsQuantity];
        print("Choose the origin of the array value:");
        value1 = key.nextInt();
        print("Now choose the bound of the array value:");
        value2 = key.nextInt();
        print("So you want to generate " + elementsQuantity + " numbers from " + value1 + " to " + value2 + "\nHere you go!");
        for (int i = 0; i < elementsQuantity; ++i) {
            numbers[i] = rand.nextInt(value1, value2);
            System.out.println(numbers[i]);
        }
        System.out.println("Do you want to bubble sort the numbers? Y/N");
        isSort = decision.nextLine();
        if(isSort.equalsIgnoreCase("Y"))
        {
            bubbleSort(numbers);
            System.out.println("Here you go!");
            for (int i = 0; i < elementsQuantity; ++i) {
                System.out.println(numbers[i]);
            }
        }
        else
        {
            System.out.println("Well, I am not supposed to force you.");
        }
        return numbers;
    }
    public static int[] CustomArrayInput()
    {
        String isSort;
        Scanner decision = new Scanner(System.in);
        int arrayLength = Integer.parseInt(
                getUserInput("How many numbers to add: ")
        );
        int[] numbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; ++i) {
            numbers[i] = Integer.parseInt(
                    getUserInput("number " + (i + 1) + ": ")
            );
        }
        System.out.println("Do you want to bubble sort your elements? Y/N");
        isSort = decision.nextLine();
        if(isSort.equalsIgnoreCase("Y"))
        {
            bubbleSort(numbers);
            System.out.println("Here you go!");
        }
        else
        {
            System.out.println("Okay. Here is your array:");
        }
        for (int j = 0; j < arrayLength; ++j) {
            System.out.println(numbers[j]);
        }
        return numbers;
    }
    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
    public static String getUserInput(String prompt) {
        print(prompt);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim().toLowerCase();
    }

    public static void printArray()
    {
        int[] arr;
        int option;
        Scanner choice = new Scanner(System.in);
        do {
            System.out.println("Welcome to the Adder programme. Type a number to choose an option;\n1 - add custom values\n2 - generate random values");
            option = choice.nextInt();
            if (option == 1)
            {
                arr = CustomArrayInput();
            }
            else if (option == 2)
            {
                arr = RandomValuesArray();
            }
            else if (option < 1)
            {
                print("All numbers, which are smaller than 1 will be turned into 1.");
                arr = CustomArrayInput();
            }
            else
            {
                print("All numbers, which are greater than 2 will be turned into 2.");
                arr = RandomValuesArray();
            }
        }
        while(isContinue());
    }
    public static boolean isContinue() {
        String userInput = getUserInput("Do you want to repeat the operation? (Y/N)\n");
        return userInput.equalsIgnoreCase("Y");
    }
    public static void bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }
        public static void main (String[]args)
        {
            printArray();
        }
    }