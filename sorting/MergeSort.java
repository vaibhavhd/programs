class Solution {
    public int[] nums;
    public int findKthLargest(int[] nums, int k) {
        if ( nums.length == 0 ) return -1;
        this.nums = nums;
        mergeSort(0, nums.length -1);
        //quickSort(0, nums.length - 1);
        /*for( int i = 0 ; i < nums.length ; i++ ) {
            System.out.println(nums[i]);
        }*/
        return this.nums[nums.length  - k];
    }
   
    public void mergeSort(int left, int right) {
        if(left == right)
            return;

        int mid = left + (right - left)/2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        
        merge(left, mid, mid+1, right);
        return;
    }
    
    public void merge(int l1, int r1, int l2, int r2) {
        int[] res = new int[r2 - l1 + 1];
        int i,j,k;
        i = l1;
        j = l2;
        k = 0;
        
        while (i <= r1 && j <= r2) {
            if(nums[i] > nums[j]) {
                res[k++] = nums[j++];     
            } else {
                res[k++] = nums[i++];     
            }
        }
        
        while(i <= r1) {
            res[k++] = nums[i++];
        }
        
        while(j <= r2) {
            res[k++] = nums[j++];
        }
        
        for ( int p = 0, q = l1 ; p < res.length ; p++, q++ ) {
            nums[q] = res[p];
        }
    }
}
