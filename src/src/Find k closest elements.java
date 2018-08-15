public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<Integer>();
    if (arr == null || arr.length == 0 || k == 0) {return result;}
    int start = 0, end = arr.length - 1;
    int closest;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        // there may be duplicate, cannot break when found x
        if (arr[mid] <= x) {start = mid;}
        else {end = mid;}
    }
    if (Math.abs(x - arr[start]) <= Math.abs(arr[end] - x)) {closest = start;}
    else {closest = end;}
    int left = closest - 1, right = closest + 1;
    int count = k - 1;
    while (left >= 0 && right <= arr.length - 1 && count > 0) {
        if (Math.abs(x - arr[left]) <= Math.abs(arr[right] - x)) {left--; count--;}
        else {right++; count--;}
    }
    while (count > 0 && left >= 0) {
        left--;
        count--;
    }
    while (count > 0 && right <= arr.length - 1) {
        right++;
        count--;
    }
    for (int i = left + 1; i <= right - 1; i++) {
        result.add(arr[i]);
    }
    return result;
}