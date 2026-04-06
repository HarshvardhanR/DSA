import java.util.ArrayList;
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


    public int[] naiveTopK(int[] nums, int k){
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer> unique = new ArrayList<>(map.keySet());

        Collections.sort(unique, (a,b) -> map.get(a) - map.get(b));
        
        int ans[] = new int[k];
        for(int i=unique.size() - 1; i>=0 && k>0; i--){
            ans[k - 1] = unique.get(i);
            k--;
        }
        
        return ans;
        
    }

    public int[] priorityQueueTopK(int[] nums, int k){
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
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

    public int[] bucketTopK(int [] nums, int k){
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int num : map.keySet()){
            if(buckets[map.get(num)]==null){
                buckets[map.get(num)] = new ArrayList<>();
            }
            buckets[map.get(num)].add(num);
        }

        int ans[] = new int[k];
        for(int i=buckets.length - 1; i>=0 && k>0; i--){
            if(buckets[i]!=null){
                for(int num : buckets[i]){
                    ans[k - 1] = num;
                    k--;
                    if(k==0) break;
                }
            }
        }

        return ans;
    }

    public int[] quickSelectTopK(int[] nums, int k){
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer> unique = new ArrayList<>(map.keySet());

        quickSelect(unique, 0, unique.size() - 1, k);

        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = unique.get(i);
        }

        return ans;
    }

    public void quickSelect(List<Integer> unique, int i, int j, int k){
        if(i>=j) return;

        int p = partition(unique, i, j);

        if(p==k) return;
        else if(p>k) quickSelect(unique, i, p - 1, k);
        else quickSelect(unique, p+1, j, k);
    }

    public int partition(List<Integer> unique, int left, int right){
        int i = left;

        for(int j=left; j<right; j++){
            if(map.get(unique.get(j)) > map.get(unique.get(right))){
                Collections.swap(unique, i, j);
                i++;
            }
        }

        Collections.swap(unique, i, right);

        return i;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,1,2,1,3};
        int k = 2;

        TopKFrequentElements tk = new TopKFrequentElements();
        tk.arrayPrinter(tk.bucketTopK(nums, k));
        tk.arrayPrinter(tk.naiveTopK(nums, k));
        tk.arrayPrinter(tk.priorityQueueTopK(nums, k));
        tk.arrayPrinter(tk.quickSelectTopK(nums, k));
    }

    public void arrayPrinter(int[] nums){
        System.out.print("[ ");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }
}
