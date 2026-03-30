// Leetcode 912

/*
    1 <= nums.length <= 5 * 10 to the power 4
    -5 * 10 power 4 <= nums <= 5 * 10 power 4

    From looking at the constraints answer must be less than n*n 
    we can devise the solution in nlogn
    we could use some sorting techniques - quickSort, mergeSort

    What i am also thinking it using a treemap to map the frequency maybe
    in a HashMap or TreeMap, HashMap doesn't store in sorted order if we knew
    its only positive we could use a hashmap but it also contains negative so we have no idea
    how to track and put it in the answer array. Even if we knew all are positive problem doesn't say
    that all numbers are consecutive like 2 after 1 and 3 after 2.

    We could use a TreeMap which will sort the keys and give the answer or maybe use sorting techniques
    such as mergeSort, quickSort

    Another approach is we could also use a min Heap with [key,frequency] array as input in a heap
*/

import java.util.TreeMap;

public class SortAnArray{

    // TreeMap Solution

    public int[] TreeMapSolution(int[] nums) {
        int ans[] = new int[nums.length];
        int index = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            for(int i=0; i<map.get(key); i++){
                ans[index++] = key;
            }
        }

        return ans;
    }


}