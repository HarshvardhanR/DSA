import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    /*
        We are supposed to find the top k frequent elments

        For ex [1,1,1,2,2,3]  top 1 = [1]
                              top 2 = [1,2]
                              top 3 = [1,2,3]

        From looking at the problem it can be done in multiple ways

        1. One very naive would be sort the array according to custom sorting sort in terms of their frequency
           You typically would use a hashmap and then loop from behind.

        2. Another way would be to have a hashmap with frequencies stored and then use a min heap to get the top
           k elements. This approach uses nlogk TC

        3. A better approach would using a buckets to store frequencies of any number according to the bucket index
           This is O(n) approach
  
        4. A QuickSelect algoruthm which usually yiels O(n) average case if pivot is good and could result into 
           O(n2) if pivot is bad
    */ 

    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));


    public int[] naiveTopK(Integer[] nums, int k){
        
        for(int num: nums){
            map.getOrDefault(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer> unique = new ArrayList<>(map.keySet());

        Collections.sort(unique, (a,b) -> map.get(a) - map.get(b));
        
        int ans[] = new int[k];
        for(int i=unique.size() - 1; i>=0 && k>0; i--){
            ans[k--] = unique.get(i);
        }
        
        return ans;
        
    }

    public int[] priorityQueueTopK(int[] nums, int k){
        
        for(int num: nums){
            map.getOrDefault(num, map.getOrDefault(num,0) + 1);
        }

        for(int num : map.keySet()){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }
        
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
