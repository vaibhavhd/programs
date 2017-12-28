class Solution {
    public int[] nums;
    public int findKthLargest(int[] nums, int k) {
        if ( nums.length == 0 ) return -1;
        this.nums = nums;
        quickSort(0, nums.length - 1);
        /*for( int i = 0 ; i < nums.length ; i++ ) {
            System.out.println(nums[i]);
        }*/
        return this.nums[nums.length  - k];
    }
    
    public void quickSort(int low, int high) {
        if(low >= high)
            return;
        int index = partition(low, high);
        quickSort(low, index - 1);
        quickSort(index + 1, high);
        return;
    }
    
    public int partition(int low, int high) {
        int pivot = nums[high];
        int k = low - 1;
        for(int i = low ; i <= high - 1 ; i++) {
            if(nums[i] <= pivot) {
                k++;
                swap(k, i);
            }
        }
        swap(k+1, high);
        return k+1;
    }
    
    public void swap(int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
