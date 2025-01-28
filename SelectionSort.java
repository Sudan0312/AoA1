public class SelectionSort {
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) minIndex = j;
            }
            // Swap in one line
            int temp = A[i]; 
            A[i] = A[minIndex];
             A[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,4,3};
        for (int num : arr) System.out.print(num + " ");
        selectionSort(arr);
        System.out.println();
        for (int num : arr) System.out.print(num + " ");
    }
}
