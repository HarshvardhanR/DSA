import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    /*
        The problem says to find the longest Consecutive Subsequence

        Ex [1,2,4,67,43,3,5,7,9,8,6]

        The problem says elements doesnt have have to consequent in the array itself as we can see 9
        is before 8 but still part of the subsequence

        So it becomes 1,2,3,4,5,6,7,8 

        So what are we thinking first we need some kind of ordering lets say get each number 
        and start looking for its next number we might do some n2 ordering but as elements are not contiguous
        it will be hard to keep track

        As mentioned we need lookup we can check the number existent + 1 to the current number

        Now we have the table, would it be nice to look for all numbers and keep looking for next number

        Lets take below example 
        [9,8,7,6,5,4,3,2,1]  answer is 9

        if i start with 9 
        then 8 -> 9
        then 7 -> 8 -> 9

        We might end up solving n + (n-1) + (n-2) which is bad ordering

        Why not we look up for n -1 exists if it doesn't then and then we start iterating
    */

    public int findlongest(int[] nums){

        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            if(set.contains(num - 1)) continue;

            int current = num;
            int currMax = 1;
            while(set.contains(current + 1)){
                currMax++;
                current = current + 1;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }
    public static void main(String[] args) {
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        
    }
}
