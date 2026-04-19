class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0, end = n-1;
        if (arr[start] <= arr[end]) return arr[0];
        int res = 1001;
        while (start <= end) {
            int mid = start + (end - start)/2;
            // System.out.println("start:" + start + ", mid:" + mid + ", arr[mid]:" + arr[mid] + ", end:" + end);
            if (arr[(mid - 1 + n) % n] > arr[mid] && arr[(mid + 1) % n] > arr[mid]) {
                res = arr[mid];
                break;
            } else if (arr[0] > arr[mid]) { // The array to the left is unsorted
                end = mid - 1;
            } else if (arr[mid] > arr[n-1]) { // The array to the right is unsorted
                start = mid + 1;
            }
        }
        return res;
    }
}