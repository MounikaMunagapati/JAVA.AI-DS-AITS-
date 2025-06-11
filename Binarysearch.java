import java.util.*;
public class BinarySearch{
	int BinarySearch(int[] arr,int key){
		int low = 0,high = arr.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] < key){
				low = mid+1;
			}
			else if(arr[mid] > key){
				high = mid-1;
			}
			else{
				return -1;
			}
		}
		return 0;
	}
	public static void main(String[] args){
		BinarySearch bs = new BinarySearch();
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int key = 6;
		int Result = bs.BinarySearch(arr,key);
		if(Result == -1){
			System.out.println("Target is not found!");
		}
		else{
			System.out.println("Element is found at index: "+Result);
		}
	}
}