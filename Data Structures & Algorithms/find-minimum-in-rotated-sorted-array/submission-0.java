class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0, end = n-1;
        int res = 1001;
        while (start <= end) {
            int mid = start + (end - start)/2;
            // System.out.println("start:" + start + ", mid:" + mid + ", arr[mid]:" + arr[mid] + ", end:" + end);
            if (arr[(mid - 1 + n) % n] > arr[mid] && arr[(mid + 1 + n) % n] > arr[mid]) {
                res = arr[mid];
                break;
            } else if (arr[0] > arr[mid]) {
                end = mid - 1;
            } else if (arr[mid] > arr[n-1]) {
                start = mid + 1;
            } else {
                res = arr[start];
                break;
            }
        }
        return res;
    }
}