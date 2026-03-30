/*
    We are given nums array, we have to check if its sorted or not
    Elements are considered sorted if they are equal
    If there is only one elments than we know its sorted.

*/



public class IsSorted {
    public boolean sorted(int[] nums){
        int i=0;
        int j=nums.length - 1;
        while(i!=j){
            if(i>0 && j<nums.length - 1){
                if(nums[i]<nums[i-1]) return false;
                if(nums[j]>nums[j+1]) return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]){
        IsSorted s = new IsSorted();
        int nums[] = {20,10,30,40,50};
        System.out.println(s.sorted(nums));
    }
}
