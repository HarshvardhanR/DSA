/*
    The problem says to sort colors where colors are mapped to 0,1,2
    We could use any merge sort, quick sort or any kind of sorting technique
    But as it says 0,1,2 there must be way to solve in O(n) time.

    One naive way would be count all occurences, then rewrite all the indexes in second pass

    So i know 0 must be at start and 2 must be at end so two pointers to track 1 i will take mid pointer
    Now we don't know where is 1, so we will keep it at 1

    start, mid = nums[0]
    end = nums[n - 1];

    From what we see is the mid is the manipulative point so we should always move according to mid

    start = 1, mid = 1, end = 2

*/

public class SortColors{

    public void sort(int nums[]){
        int n = nums.length;

        int start = 0;
        int mid = 0;
        int end = n - 1;

        while(mid<=end){
            if(nums[mid]==0){
                swap(mid, start, nums);
                mid++;
                start++;
            }
            else if(nums[mid]==2){
                swap(mid, end, nums);
                end--;
            }
            else if(nums[mid]==1){
                mid++;
            }
            
        }
    }

    public void swap(int i, int j, int nums[]){
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
    }
    public static void main(String args[]){

    }
} 

