        package sorting;
        import java.util.Arrays;
        import java.util.Random;
        import java.util.Scanner;

        public class Sorting {
           // Method to generate an array of random integers with the specified size.
            public static int [] GenerateRandomArray(int size){
            int[]array=new int [size];
            Random random= new Random();
            for(int i=0;i<size;i++){
                array[i]=random.nextInt(10000);
            }
            return array;
        }
            // Method to generate a sorted array in ascending order.
            public static int[] GenerateSortedArray(int size){
                int []array =new int [size];
                for (int i=0;i<size;i++){
                    array[i]=i+1;
               }
            return array;
        }
            // Method to generate an inversely sorted array in descending order.
                public static int [] GenerateInverselySortedArray(int size){
                int []array =new int [size];
                for (int i=0;i<size;i++){
                    array[i]=size-i-1;
                }     
                return array;
        }
       // Method to implement the Bubble Sort algorithm and count comparisons and interchanges.
     
                public static void bubblesort(int[] array) {
                 // Get the length of the array
                int n = array.length;
    
               // Flag to track whether any swaps were made in the current pass
               boolean swapped;
    
               // Array to store counters: Index 0 for comparisons, Index 1 for interchanges
               int[] counters = new int[2];

               // Repeat the process until no more swaps are needed
               do {
               swapped = false;

               // Traverse the array and compare adjacent elements
               for (int i = 1; i < n; i++) {
               counters[0]++; // Increment the counter for each comparison

            // If the current element is greater than the previous one, swap them
               if (array[i - 1] > array[i]) {
                int temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
                swapped = true;
                counters[1]++; // Increment the counter for each interchange
            }
        }
    } while (swapped); // Continue as long as swaps are made in the current pass

    // Print the number of comparisons and interchanges for Bubble Sort
    System.out.println("Number of comparisons for bubblesort: " + counters[0]);
    System.out.println("Number of interchanges for bubblesort: " + counters[1]);
}

        // Method to implement the Quicksort algorithm and count comparisons and interchanges.
public static void quicksort(int[] array) {
    // Create an array to store counters: Index 0 for comparisons, Index 1 for interchanges
    int[] counters = new int[2];
    
    // Call the helper method to perform Quicksort and update counters
    quicksortHelper(array, 0, array.length - 1, counters);

    // Print the number of comparisons and interchanges for Quicksort
    System.out.println("Number of comparisons for quicksort: " + counters[0]);
    System.out.println("Number of interchanges for quicksort: " + counters[1]);
}

// Helper method for Quicksort algorithm to partition the array.
private static void quicksortHelper(int[] array, int low, int high, int[] counters) {
    // Base case: if low is less than high, continue sorting
    if (low < high) {
        // Get partition information from the partition method
        int[] partitionInfo = partition(array, low, high, counters);
        int pivotIndex = partitionInfo[0];

        // Recursively sort the elements before and after the pivot
        quicksortHelper(array, low, pivotIndex - 1, counters);
        quicksortHelper(array, pivotIndex + 1, high, counters);
    }
}

// Helper method to perform partitioning for Quicksort.
private static int[] partition(int[] array, int low, int high, int[] counters) {
    // Choose the pivot element (in this case, the rightmost element)
    int pivot = array[high];
    
    // Initialize the index of the smaller element
    int i = low - 1;

    // Traverse the array and rearrange elements around the pivot
    for (int j = low; j < high; j++) {
        counters[0]++; // Increment the counter for each comparison

        if (array[j] <= pivot) {
            i++;
            // Swap array[i] and array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            counters[1]++; // Increment the counter for each interchange
        }
    }

    // Swap the pivot element to its correct position
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    // Return the index of the pivot element after partitioning
    return new int[]{i + 1};
}
// Method to implement Counting Sort algorithm and count comparisons and interchanges.
public static void countingSort(int[] array) {
    // Find the maximum and minimum values in the array
    int max = Arrays.stream(array).max().orElse(0);
    int min = Arrays.stream(array).min().orElse(0);

    // Calculate the range of values in the array
    int range = max - min + 1;

    // Create an array to store the count of occurrences for each value in the range
    int[] count = new int[range];

    // Create an array to store the sorted output
    int[] output = new int[array.length];

    // Initialize counters for comparisons and interchanges
    int comparisons = 0;
    int interchanges = 0;

    // Count occurrences of each element in the original array
    for (int i = 0; i < array.length; i++) {
        count[array[i] - min]++;
    }

    // Calculate cumulative counts to determine the position of each element in the output array
    for (int i = 1; i < range; i++) {
        count[i] += count[i - 1];
    }

    // Populate the output array and track auxiliary operations
    for (int i = array.length - 1; i >= 0; i--) {
        output[count[array[i] - min] - 1] = array[i];
        count[array[i] - min]--;
        interchanges++;
    }

    // Copy the sorted elements back to the original array
    for (int i = 0; i < array.length; i++) {
        array[i] = output[i];
        comparisons++; // Consider this an auxiliary operation for comparison purposes
    }

    // Print the sorted array and counters
    System.out.println("Sorted array: " + Arrays.toString(array));
    System.out.println("Number of comparisons for counting sort: " + comparisons);
    System.out.println("Number of interchanges for counting sort: " + interchanges);
}



            public static void main(String[] args) {
               Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Random Array");
                    System.out.println("2. Sorted Array");
                    System.out.println("3. Inversely Sorted Array");
                    System.out.println("4. Quit");

                    System.out.print("Enter your choice (1-4): ");
                    int choice = scanner.nextInt();

                    if (choice == 4) {
                        System.out.println("Goodbye!");
                        break;
                    } else if (choice >= 1 && choice <= 3) {
                        System.out.print("Enter the size of the array (up to 10,000): ");
                        int size = scanner.nextInt();
                        if (size <= 0 || size > 10000) {
                            System.out.println("Invalid size. Please enter a size between 1 and 10,000.");
                            continue;
                        }

                        int[] generatedArray;
                        switch (choice) {
                            case 1:
                                generatedArray = GenerateRandomArray(size);
                                break;
                            case 2:
                                generatedArray = GenerateSortedArray(size);
                                break;
                            case 3:
                                generatedArray = GenerateInverselySortedArray(size);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + choice);
                        }
                        System.out.println("Generated array of size " + size + ": " + Arrays.toString(generatedArray));

                        System.out.println("Choose a sorting algorithm:");
                        System.out.println("1. Quicksort");
                        System.out.println("2. Bubblesort");
                        System.out.println("3. Counting Sort");


                        System.out.print("Enter your choice (1-3): ");
                        int sortChoice = scanner.nextInt();

                        long startTime = System.currentTimeMillis();

                        switch (sortChoice) {
                            case 1:
                                quicksort(generatedArray);
                                break;
                            case 2:
                                bubblesort(generatedArray);
                                break;
                            case 3:
                                 countingSort(generatedArray);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + sortChoice);
                        }

                         long endTime = System.currentTimeMillis(); 
                         long duration = endTime - startTime;

                        System.out.println("Sorted array: " + Arrays.toString(generatedArray));
                        System.out.println("Time complexity: " + duration + " milliseconds");
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                }
            }  
         }
