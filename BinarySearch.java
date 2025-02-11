public class BinarySearch {
    public static void binarySearch(int arr[], int low, int high, int key){
        int mid =(low+high)/2;
        while(low <= high){
            if(arr[mid] == key){
                low=mid+1;
            }
            else if(arr[mid] < key){
                System.out.println("Element is Found at Index:- "+mid);
                break;
            }
            else{
                high=mid-1;
            }
            mid =(low+high)/2;            
        }
        if(low > high){
            System.out.println("Element not Found at index!");
        }
    }
    public static void main(String[] args) {
        int arr[] = {11, 22, 33, 44, 55, 66, 77, 88};
        int key = 55;
        int last = arr.length-1;
        binarySearch(arr, 0, last, key);
    }
}
