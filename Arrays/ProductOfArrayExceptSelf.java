public class ProductOfArrayExceptSelf {

    public int[] productExceptTheRequired(int[] nums){

        int [] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int [] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;

        for(int i=nums.length - 2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        
        return ans;

    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();

        int nums[] = {1, 2, 4, 6};

        int[] productExceptSelf = p.productExceptTheRequired(nums);

        System.out.print("[ ");
        for(int i=0; i<productExceptSelf.length; i++){
            System.out.print(productExceptSelf[i] + " ");
        }
        System.out.print("]");

    }
}
