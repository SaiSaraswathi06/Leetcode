class Solution {
    public boolean search(int[] nums, int target) {
        int pivotIndex = findPivotWithDuplicate(nums);
        if (pivotIndex == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[pivotIndex] == target)
            return true;
        else if (nums[0] <= target)
            return binarySearch(nums, target, 0, pivotIndex - 1);
        else
            return binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
    }

    static int findPivotWithDuplicate(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (mid>start && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                if(mid<end && arr[end]<arr[end-1]){
                    return end-1;
                }

                end--;
            } else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else
                end = mid - 1;
        }

        return -1;
    }

    static boolean binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}